//非widget方法的继承
(function($){
	var __validate = $.fn.validate;
	$.fn.myValidate = function(opts){
		var __rules = $.extend({
			username: {
				required: true,
				rangelength: [2,8]
				//remote:"remote.do"//基于ajax的验证返回值必须为true or false
			},
			nickname: {
				required: true,
				rangelength: [2,8]
			},
			password: {
				required: true,
				rangelength: [2,8]
			},
			confirm: {
				required: true,
				equalTo: "#addPassword"
			},
			phone: {
				required: true,
				number:true,
				rangelength: [11,11]
			},
			email: {
				required: true,
				email: true
			}
		},opts?(opts.rules||{}):{});//注意判断opts是否为空
		var __messages = $.extend({
			username: {
				required: "用户名不能为空",
				rangelength: "用户名长度必须在2-8之间",
				remote:"用户名已经存在"
			},
			password: {
				required: "密码不能为空",
				rangelength: "密码长度必须在2-8之间"
			},
			nickname: {
				required: "昵称不能为空",
				rangelength: "密码长度必须在2-8之间"
			},
			confirm: {
				required: "请重复密码",
				equalTo: "必须和密码相同"
			},
			phone: {
				required: "电话不能为空",
				number:"电话必须为数字",
				rangelength: "电话长度不正确"
			},
			email: {
				required: "EMAIL不能为空",
				email: "EMAIL格式不正确"
			}
		},opts?(opts.messages||{}):{});
		var _opts = {
				errorClass:opts?(opts.errorClass||"errorMessage"):"errorMessage",
				//设置单个按键不验证(源代码中按键和失去焦点都验证)
				onkeyup:false,
				rules: __rules,
				messages: __messages
		}
		$.extend(_opts,opts);
		$.extend($.fn.validate.prototype,_opts);
		__validate.call(this,$.fn.validate.prototype);
	} 
})(jQuery)