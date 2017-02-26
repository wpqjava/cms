<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/header.css" />
</head>
<body>
	<div id="header">
		<div id="top">
			<div id="logo">
				
			</div>
			<ul class="header_ul">
				<li class="header_li"><a href="<%=request.getContextPath()%>/index" target="_blank">网站首页</a></li>
				<li class="header_li"><a href="<%=request.getContextPath()%>/admin/user/updateSelf/${loginUser.id}" target="admin_content">更新信息</a></li>
				<li class="header_li"><a href="<%=request.getContextPath()%>/admin/user/updatePassword/${loginUser.id}" target="admin_content">修改密码</a></li>
				<li class="header_li li_last"><a href="<%=request.getContextPath()%>/logout"  target="_top">退出登录</a></li>
			</ul>
		</div>
		<div id="intro">
			<span>欢迎【${loginUser.nickname }】光临F1赛车世界后台管理,今天是
			<%=new SimpleDateFormat(""+"yyyy年MM月dd日"+"").format(Calendar.getInstance().getTime())  
			%>
</span>
		</div>
	</div>
</body>
</html>