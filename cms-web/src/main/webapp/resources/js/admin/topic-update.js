$(function(){
	//文件上传
	var uploadPath = $("#ctx").val()+"/resources/upload/";
	var sPath = "/resources/upload/";
	$("#file_upload").uploadify({
		swf:$("#ctx").val()+"/resources/uploadify/uploadify.swf",
		uploader:$("#ctx").val()+"/admin/topic/upload",
		fileObjName:"attach",
		auto:false,
		formData:{"sessionId":$("#sessionId").val()},
		fileTypeExts:"*.jpg;*.gif;*.png;*.doc;*.docx;*.txt;*.xls;*.xlsx;*.rar;*.zip;*.pdf;*.flv;*.swf",
		onUploadSuccess:function(file, data, response) {
			var ao = $.parseJSON(data);
			if(ao.result){
				$("#ok_attach").find("tbody").append(createNode(ao.obj));
			}else{
				alert("上传失败,请检查文件格式");
			}
			function createNode(attach) {
				var cid = $("#cid").val();
				var node = "<tr class='temp-insert-att'>";
				if(attach.isImg) {
					node+="<td><img src='"+uploadPath+"thum/"+attach.newName+"'/></td>";
				} else {
					node+="<td>普通类型附件</td>";
				}
				node+="<td>"+attach.oldName+"</td>";
				node+="<td>"+Math.round(attach.size/1024)+"K</td>";
				if(cid==3){
					if(attach.isImg) {
						node+="<td><input type='checkbox' value='"+attach.id+"' name='introPic'></td>"
						+"<td><input type='checkbox' value='"+attach.id+"' name='showPic'></td>";
					} else {
						node+="<td>&nbsp;</td>";
					}
				}else if(cid==4){
					if(attach.isImg) {
						node+="<td><input type='checkbox' value='"+attach.id+"' name='spePic'></td>"
						+"<td><input type='checkbox' value='"+attach.id+"' name='showPic'></td>";
					} else {
						node+="<td>&nbsp;</td>";
					}
				}else{
					if(attach.isImg) {
						node+="<td><input type='checkbox' value='"+attach.id+"' name='showPic'></td>";
					} else {
						node+="<td>&nbsp;</td>";
					}
				}
				node+="<input type='hidden' name='aids' value='"+attach.id+"'/></td>" +
						"<td><a href='#' class='list_op insertAttach' title='"+attach.id+"' isImg='"+attach.isImg+"' name='"+attach.newName+"' oldName='"+attach.oldName+"'>插入附件</a>&nbsp;<a href='#' title='"+attach.id+"' class='list_op deleteAttach delete'>删除附件</a></td>";
				node+="</tr>";
				return node;
			}
			
		}
	});
	function mySimpleAjax(url,param){
		var _param ={};
		var _url =  $("#ctx").val()+"/admin/topic";
		_url += url; 
		_param.aid = param;
		$.post(_url,_param,function(data){
			if(data.result==0){
				alert(data.message);
			}
		});
	}
	var editor = $(".xheditor").xheditor({tools:"full"});
	$("#ok_attach").on("click","input[name='indexPic']",function(){
		mySimpleAjax("/updateIntroPic",$(this).val());
	});
	$("#ok_attach").on("click","input[name='spePic']",function(){
		mySimpleAjax("/updateSpePic",$(this).val());
	});
	$("#ok_attach").on("click","input[name='showPic']",function(){
		mySimpleAjax("/updateShowPic",$(this).val());
	});
	$("#ok_attach").on("click",".deleteAttach",function(){
		if(confirm("确认删除附件？")){
			$(this).parent("td").parent("tr").remove();
			var id = $(this).attr("title");
			var _param ={};
			_param.id = id;
			$.post($("#ctx").val()+"/admin/topic/deleteAttach",_param,function(data){
				if(data.result==1){
					$("#xhe0_iframe").contents().find("#attach_"+id).remove();
				}else{
					alert(data.message);
				}
			})
		}
	});
	$("#ok_attach").on("click",".insertAttach",function(){
		if($(this).attr("isImg")==1){
			editor.pasteHTML("<img id='attach_"+$(this).attr("title")+"' src="+sPath+$(this).attr("name")+">");
		}else{
			editor.pasteHTML("<a id='attach_"+$(this).attr("title")+"' href="+sPath+$(this).attr("name")+">"+$(this).attr("oldName")+"</a>");
		}
	});
	$("#uploadFile").click(function() {
		$("#file_upload").uploadify("upload","*");
	})
	//自动补全
	$("#keyword").autocomplete({
	      source: $("#ctx").val()+"/admin/topic/getKeywords",
	      minLength: 2
	});
	//日期
	$( "#publishDate" ).datepicker({
		dateFormat:"yy-mm-dd",//设置日期的格式
		maxDate:0,//最大日期为1年后（2013-2-2具体日期）
		changeMonth:true,//可以选择一个月份
		changeYear:true//可以选择一个年份
	});
	//栏目树
	$("#addForm").myValidate({
		rules:{
			title:"required",
			cname:"required",
			publishDate:{
				required:true,
				dateISO:true
			}
		},
		messages:{
			title:"文章标题不能为空",
			cname:"栏目不能为空",
			publishDate:{
				required:"发布日期不能为空",
				dateISO:"请输入有效的日期 (YYYY-MM-DD)"
			}
		}
	});
	var treeObj = $("#mytree").mytree({
		url:$("#ctx").val()+"/admin/topic/tree",
		extendAll:1,
		callback:{
			onAsyncSuccess:function(){
				treeObj.expandAll(true);
			},
			beforeClick:beforeChoice,
			onClick:choice
		}
	});
	$("#cname").click(showMenu);
	function choice(event,treeId,treeNode) {
		$("#cname").val(treeNode.name);
		$("#cid").val(treeNode.id);
		setAttachNode(treeNode.id);
		hideMenu();
	}
	function beforeChoice(treeId,treeNode) {
		var check = (treeNode && !treeNode.isParent);
		if (!check) return check;
		if($(".temp-insert-att").length>0){
			alert("请先删除已上传的附件再重新选择栏目");
			return false;
		}
	}
	function showMenu() {
		$("#mytree").width($(this).width()-9);
		var cObj = $("#cname");
		var cOffset = $("#cname").offset();
		$("#menuContent").css({left:cOffset.left + "px", top:cOffset.top + cObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function setAttachNode(cid){
		$(".temp-frame-att").remove();
		if(cid==3){
			//首页推荐滚动大图
			$('#tr-attach').after("<tr class='temp-frame-att'><td colspan='2' class='emp'>请上传一张尺寸大于1280*500的图片并勾选<主页图片>作为首页推荐滚动图片。</td></tr><tr class='temp-frame-att'><td colspan='2'>" +
					"<table id='ok_attach' style='text-align:center' width='890px' cellpadding='0' cellspacing='0'>" +
					"<thead><tr><Td>文件名缩略图</Td><td width='180'>文件名</td><td>文件大小</td>" +
					"<td>主页图片</td><td>展示图</td><td width='160'>操作</td>" +
					"</tr></thead><tbody></tbody></table></td></tr>");
		}else if(cid==4){
			//F1专题大图
			$('#tr-attach').after("<tr class='temp-frame-att'><td colspan='2' class='emp'>请上传一张尺寸大于290*185的图片并勾选<专题图片>作为专题封面。</td></tr><tr class='temp-frame-att'><td colspan='2'>" +
					"<table id='ok_attach' style='text-align:center' width='890px' cellpadding='0' cellspacing='0'>" +
					"<thead><tr><Td>文件名缩略图</Td><td width='180'>文件名</td><td>文件大小</td>" +
					"<td>专题图片</td><td>展示图</td><td width='160'>操作</td>" +
					"</tr></thead><tbody></tbody></table></td></tr>");
		}else{
			$('#tr-attach').after("<tr class='temp-frame-att'><td colspan='2'>已传附件</td></tr><tr class='temp-frame-att'><td colspan='2'>" +
					"<table id='ok_attach' style='text-align:center' width='890px' cellpadding='0' cellspacing='0'>" +
					"<thead><tr><Td>文件名缩略图</Td><td width='180'>文件名</td><td>文件大小</td>" +
					"<td>展示图</td><td width='160'>操作</td>" +
					"</tr></thead><tbody></tbody></table></td></tr>");
		}
	}
	//关键字
	$("#keyword").setKeyword();
	initExistKeys();
	function initExistKeys() {
		$(".eks").each(function(){
			var c = "<div class='keyword-in'><span>"+$(this).val()+
			"</span><a href='#' class='keyword-shut'>×</a><input type='hidden' name='aks' value='"+$(this).val()+"'/></div>";
			$("#keyword-wrap").append(c)
		})
	}
})