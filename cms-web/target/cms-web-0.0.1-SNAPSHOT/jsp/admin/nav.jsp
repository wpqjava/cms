<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/nav.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
	$(function(){
		$("#leftNav").myAccordion();
	})
</script>
</head>
<body>
	<div id="leftNav">
			<c:if test="${isAdmin eq 1 }">
			<h3><span>用户管理</span></h3>
			<ul>
				<li><a href="<%=request.getContextPath() %>/admin/user/users" target="admin_content">用户列表管理</a></li>
			    <li><a href="<%=request.getContextPath() %>/admin/group/groups" target="admin_content">组列表管理</a></li>
				<li><a href="<%=request.getContextPath() %>/admin/role/roles" target="admin_content">角色列表管理</a></li>
			</ul>
			</c:if>
			<h3><span>文章管理</span></h3>
			<ul>
				<li><a href="<%=request.getContextPath() %>/admin/channel/channels" target="admin_content">栏目列表</a></li>
				<li><a href="<%=request.getContextPath() %>/admin/topic/topics" target="admin_content">文章列表</a></li>
			</ul>
			<c:if test="${isAdmin eq 1 }">
			<h3><span>系统配置</span></h3>
			<ul>
				<li><a href="<%=request.getContextPath() %>/admin/system/show" target="admin_content">网站信息管理</a></li>
				<li><a href="<%=request.getContextPath() %>/admin/system/clean" target="admin_content">系统清理管理</a></li>
			</ul>
			</c:if>
	</div>
</body>
</html>