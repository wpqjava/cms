/**
 * @author Administrator
 */
$(function(){
	$("#nav_list li:nth-child(1)").add(".nav_container_01").hover(function(){
		displayNav(".nav_container_01");
	},function(){
		displayNav(".nav_container_01");
	});
	$(".nav_container_01").hover(function(){
		$("#nav_list li:nth-child(1)").toggleClass("nav_li_a_hover");
	},function(){
		$("#nav_list li:nth-child(1)").toggleClass("nav_li_a_hover");
	});
	
	$("#nav_list li:nth-child(2)").add(".nav_container_02").hover(function(){
		displayNav(".nav_container_02");
	},function(){
		displayNav(".nav_container_02");
	});
	$(".nav_container_02").hover(function(){
		$("#nav_list li:nth-child(2)").toggleClass("nav_li_a_hover");
	},function(){
		$("#nav_list li:nth-child(2)").toggleClass("nav_li_a_hover");
	});
	
	$("#nav_list li:nth-child(3)").add(".nav_container_03").hover(function(){
		displayNav(".nav_container_03");
	},function(){
		displayNav(".nav_container_03");
	});
	$(".nav_container_03").hover(function(){
		$("#nav_list li:nth-child(3)").toggleClass("nav_li_a_hover");
	},function(){
		$("#nav_list li:nth-child(3)").toggleClass("nav_li_a_hover");
		});
		
	
	function displayNav(node){
		$(node).toggleClass("nav_container_show");
	}
	$(".container02_inner_text").each(function(){
		if($(this).find("span").text().length>15){
			var str = $(this).find("span").text().substring(0,13)+"...";
			$(this).find("span").text(str);
		}
	})
	
	$("#textButton").click(function(){
		var v = $(this).prev("input").val();
		if(v){
			url = $("input[name='ctx']").val()+"/search/"+v;
			window.location.href=url;
			event.preventDefault();
		}
	});
});
