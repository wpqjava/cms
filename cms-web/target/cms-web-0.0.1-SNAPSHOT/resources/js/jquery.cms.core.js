(function($){
	//一个标准的表格样式
	$.fn.setTableStyle = function(opts){
		var settings = $.extend({
			oddTrClass:"oddTr",
			trHoverClass:"tablestyle-hover"
		},opts?(opts||{}):{});
		this.find("tbody tr:odd").addClass(settings.oddTrClass)
		this.find("tbody tr").on("mouseenter mouseleave",function(){
			$(this).toggleClass(settings.trHoverClass);
		});
		$(this).find(".stopBtn").on("click",function(event){
			if(!confirm("确认停用该用户")){
				event.preventDefault();
			}
		});
		$(this).find(".delete").on("click",function(event){
			if(!confirm("确认删除,该过程不可逆")){
				event.preventDefault();
			}
		});
		$(this).find(".deleteGroup").on("click",function(event){
			if(!confirm("确认删除该组,该过程会删除组内所有用户关联")){
				event.preventDefault();
			}
		});
		return this;
	};
	//一个统一表格变色
	$.fn.setTableMouseStyle = function(opts){
		var settings = $.extend({
			trHoverClass:"tablestyle-hover"
		},opts?(opts||{}):{});
		this.find("tbody tr").on("mouseenter mouseleave",function(){
			$(this).toggleClass(settings.trHoverClass);
		});
		return this;
	};
	
	//类似jqueryUI accordion
	$.fn.myAccordion = function(opts) {
		var settings = $.extend({
			headClass:"accordion-header",
			headHoverClass:"accordion-header-hover",
			headSelectedClas:"accordion-header-selected"
		},opts?(opts||{}):{});
		this.find("h3").addClass(settings.headClass).hover(function(){
				$(this).toggleClass(settings.headHoverClass);
			},function(){
				$(this).toggleClass(settings.headHoverClass);
			}).click(function(){
				//比较粗糙的效果
				/*$(this).siblings().removeClass("accordion-header-selected")
				.end().addClass("accordion-header-selected").next("ul").siblings("ul").css("display","none")
				.end().show("blind");*/
				//比较精细的效果
				$(this).data("select","true");
				var prevH3 = null;
				var nextH3 = null;
				$(this).prevAll("h3").each(function(){
					if($(this).data("select")=="true"){
						prevH3 = $(this);
					}
				});
				if(!prevH3){
					$(this).nextAll("h3").each(function(){
						if($(this).data("select")=="true"){
							nextH3 = $(this);
						}
					});
				}
				if(prevH3){
					var nul = prevH3.data("select","false").removeClass(settings.headSelectedClas).next("ul");
					nul.css("display","none");
					$(this).addClass(settings.headSelectedClas).next("ul").show("blind",{direction:"down"});
					nul.css("display","block").hide("blind")
				}else if(nextH3){
					nextH3.data("select","false").removeClass(settings.headSelectedClas).next("ul").hide("blind",{direction:"down"});
					$(this).addClass(settings.headSelectedClas).next("ul").show("blind");
				}else{
					$(this).addClass(settings.headSelectedClas).next("ul").show("blind");
				}
				
			});
		
		this.find("h3:first").data("select","true").addClass(settings.headSelectedClas).next("ul").css("display","block");
		
		this.find("ul").addClass("accordion-content accordion-content-hover").find("li").addClass("accordion-content-li");
		return this;
	};
	
	//处理文本长度
	$.fn.setTopicLength = function(options){
		var settings = $.extend({
			length:8,
			fill:".",
			fillLength:3}
		, options||{});
		this.each(function(){
			var str = $(this).html();
			if(str.length>settings.length){
				var fs = "";
				for(var i=0;i<settings.fillLength;i++){
					fs+=settings.fill;
				}
				str = str.substr(0,settings.length-settings.fillLength+2)+fs;
				$(this).html(str);
			}
		});
		return this;
	};
	//显示树
	$.fn.mytree = function(opts){
		var setting = $.extend({
				async: {
					enable: true,
					url: opts?(opts.url||"treeAll"):"treeAll"
					
				},
				data:{
					simpleData:{
						enable:true,
						idKey:"id",
						pIdKey:"pid",
						rootPId:-1
					}
				},
				view:{
					dblClickExpand:false,
					selectMulti:false
				},
				defaultSetting:{
					isClick:opts?(opts.isClick||1):1
				},
				callback:{
					onClick:setClick,
					onAsyncSuccess:function(){
						if(opts&&opts.extendAll){
							treeObj.expandAll(true);
						}
					}
				}
			},opts?(opts||{}):{});
			var treeObj = $.fn.zTree.init(this, setting);
			function setClick(event,treeId,treeNode){
				if(setting.defaultSetting.isClick){
					$("#treeIframe").attr("src","channels/"+treeNode.id);
				}
			}
			return treeObj;
	}
	//一个可拖动的样式
	$.fn.mysortable = function(opts){
		var _tbody = this.find("tbody")
		var _that = this;
		var isSort = false;
		var settings = $.extend({
			sortOpts:{
				axis:"y",
				helper:function(event,element){
					var _ori = element.children();
					var _helper = element.clone();
					_helper.children().each(function(index){
						$(this).width(_ori.eq(index).width());
					});
					_helper.css("background","#eef");
					return _helper;
				}
				,update:function(e,ui){
					setOrders();
				}
			},
			beginButton:"#beginOrder",
			saveButton:"#saveOrder"
		},opts?(opts||{}):{});
		_tbody.sortable(settings.sortOpts);
		_tbody.sortable("disable");
		$(settings.beginButton).click(function(event){
			if(!isSort){
				_tbody.sortable("enable");
				_that.find("tr").each(function(index){
					if(index==0){
						$(this).append("<td>序号</td>");
					}else if(index==$("table tr").length-1){
						$(this).append("<td>拖动排序</td>");
					}else{
						$(this).append("<td>"+index+"</td>");
					}
				});
				isSort = true;
			}else{
				alert("已经是排序状态!");
			}
		});
		$(settings.saveButton).click(function(event){
			if(isSort){
				var idSorts = _tbody.sortable("serialize",{key:"ids"});
				$.post("updateSorts?"+idSorts,function(data){
					if(data.result){
						_tbody.sortable("disable");
						_that.find("tr").each(function(index){
							$(this).find("td:last").remove();
						});
						isSort = false;
						parent.refreshTree();
					}else{
						alert(data.message)
					}
				})
			}else{
				alert("请先开始排序!");
			}
		});
		function setOrders(ele){
			_tbody.find("tr").each(function(index){
				$(this).find("td:last").html(index+1);
			});
		}
		return this;
	}
	//通过AJAX设置树
	$.fn.setTree = function(opts){
		var ctx = $("#ctx").val();
		var settings = $.extend({
				async: {
					enable: true,
					url: opts?(opts.treePath?$(treePath).val():$("#treePath").val()):$("#treePath").val()
					
				},
				data:{
					simpleData:{
						enable:true,
						idKey:"id",
						pIdKey:"pid",
						rootPId:-1
					}
				},
				view:{
					dblClickExpand:false,
					selectMulti:false
				},
				callback:{
					onAsyncSuccess:initTree,
					beforeCheck:function(treeId,treeNode) {
						//做删除操作
						if(treeNode.checked){
							 var deleteNodes = new Array();
							 getDeCs(treeNode,deleteNodes);
							 getDePs(treeNode,deleteNodes);
							 deleteNodes.push(treeNode);
							 deleteGroupChannel(deleteNodes);
						}
						//做添加操作
						if(!treeNode.checked){
							 var addNodes = new Array();
							 getAddCs(treeNode,addNodes);
							 getAddPs(treeNode,addNodes);
							 addNodes.push(treeNode);
							 addGroupChannel(addNodes);
						}
					}
				},
				defaultSetting:{
					gid:"#gid",
					cids:"input[name='cids']"
				},
				check:{
					enable:true
				}
			},opts?(opts||{}):{});
		var treeObj = $.fn.zTree.init(this, settings);
		function deleteGroupChannel(cs){
			var param = {};
			var gid = $(settings.defaultSetting.gid).val();
			var url = ctx+"/admin/channel/deleteGroupChannel";
			param.gid = gid;
			for(var i=0;i<cs.length;i++){
				var c = cs[i];
				param.cid = c.id;
				if(c.id>0){
					$.post(url,param,function(data){
						if(data.result==0){
							alert(data.message);
						}
					});
				}
			}
		}
		function addGroupChannel(cs){
			var param = {};
			var gid = $(settings.defaultSetting.gid).val();
			var url = ctx+"/admin/channel/addGroupChannel";
			param.gid = gid;
			for(var i=0;i<cs.length;i++){
				var c = cs[i];
				param.cid = c.id;
				if(c.id>0){
					$.post(url,param,function(data){
						if(data.result==0){
							alert(data.message);
						}
					});
				}
			}
		}
		function getDePs(treeNode,w4dps){
			var _treeNode = treeNode;
			var node;
			var hasCheckedBro = 0;
			while((node=treeNode.getNextNode())){
				if(node.checked) hasCheckedBro = 1;
				treeNode = node;
			}
			if(!hasCheckedBro){
				while((node=_treeNode.getPreNode())){
					if(node.checked) hasCheckedBro = 1;
					_treeNode = node;
				}
			}
			if(!hasCheckedBro){
				var pps;
				if((pps= treeNode.getParentNode())){
					w4dps.push(pps)
					getDePs(pps,w4dps)
				}
			}
		}
		function getAddPs(treeNode,w4aps){
			var node;
			while((node = treeNode.getParentNode())){
				if(!node.checked)w4aps.push(node);
				treeNode= node;
			}
		}
		function getDeCs(treeNode,w4dcs){
			var ccs;
			if((ccs=treeNode.children)) {
				for(var i=0;i<ccs.length;i++) {
					var c = ccs[i];
					if(c.checked) {
						w4dcs.push(c);
					}
					getDeCs(c,w4dcs);
				}
			}
		}
		function getAddCs(treeNode,w4acs){
			var ccs;
			if((ccs=treeNode.children)) {
				for(var i=0;i<ccs.length;i++) {
					var c = ccs[i];
					if(!c.checked) {
						w4acs.push(c);
					}
					getAddCs(c,w4acs);
				}
			}
		}
		function initTree() {
			treeObj.expandAll(true);
			var cids = $(settings.defaultSetting.cids);
			for(var i=0;i<cids.length;i++) {
				var cid = cids[i].value;
				var n = treeObj.getNodeByParam("id",cid);
				treeObj.checkNode(n,true,true);
			}
		}
		return this;
	}
	//关键字插件
	$.fn.setKeyword = function(opts){
		var _this = this;
		var settings = $.extend({
			msg:"请输入关键字,用回车分隔。"
		},opts?(opts||{}):{});
		init();
		_this.keydown(function(event){
			if(event.keyCode==13){
				var c = _this.val();
				if(c!=""){
					if($("input[name='aks']").length>2){
						alert("最多添加3个关键字");
						event.preventDefault();
						return false;
					}
					var aks = $("input[name='aks']");
					for(var i=0;i<aks.length;i++) {
						if($(aks[i]).val()==c) {
							alert("不能添加重复的关键字");
							event.preventDefault();
							return false;
						}
					}
					var ki = createKeyword(c);
					$("#keyword-wrap").append(ki);
					$(this).val("");
				}
				event.preventDefault();
				return false;
			}
		})
		$("#keyword-wrap").on("click","a.keyword-shut",function(event){
			$(this).parent(".keyword-in").remove();
			event.preventDefault();
		});
		function createKeyword(val) {
			return "<div class='keyword-in'><span>"+val
			+"</span><a href='#' class='keyword-shut'>×</a><input type='hidden' name='aks' value='"+val+"'/></div>";
		}
		function init(){
			_this.val(settings.msg).addClass("keyword-default-text");
			_this.wrap("<div id='keyword-container'></div>")
			.after("<div id='keyword-wrap'></div>");
			_this.focus(function(){_this.val("")})
			_this.blur(function(){_this.val(settings.msg)})
		}
	}
})(jQuery)