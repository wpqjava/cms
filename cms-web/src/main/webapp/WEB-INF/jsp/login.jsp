<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理登录</title>
<link href="<%=request.getContextPath() %>/resources/img/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/login.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.wpq.validate.js"></script>
<script type="text/javascript">
	function reCheckcode(img) {
		img.src="drawCheckCode?"+Math.random();
	}
	$(function(){
		$("#loginForm").myValidate({
			rules:{
				username:"required",
				validation:"required",
				password:"required"
			},
			messages:{
				username:"用户名不能为空",
				validation:"验证码不能为空",
				password:"密码不能为空"
			}
		});
		$("#inputDiv").css("opacity",0.7);
		$("#username").val("请输入用户名").css("color","#bbb").focus(function(){
			$(this).val(null);
			$(this).css("color","#000");
		})
		
	})
</script>
</head>
<body>
	<div id="content">
		<div id="top">
			<div id="logo">
				
			</div>
		</div>
		<div id="intro">
			<span>欢迎光临F1赛车世界后台管理,今天是<%=new SimpleDateFormat(""+"yyyy年MM月dd日"+"").format(Calendar.getInstance().getTime())  
			%></span>
		</div>
		<div id="container">
			<div id="inputDiv">
				
			</div>
			<form method="post" action="login" id="loginForm">
					username:<br/>
					<input id="username" type="text" name="username"/><br/>
					password:<br/>
					<input id="password" type="password" name="password"/><br/>
					validation:<br/>
					<input id="validation" type="text" name="validation"/>
					<span>
					<img src="drawCheckCode" onclick="reCheckcode(this)"/></span>
					<br/>
					<span class="errorMessage">${error }</span><br/>
					<input id="" type="submit" value="登录"/>&nbsp;
					<input id="" type="reset" /><br/>
			</form>
		</div>
	</div>
</body>
</html>