<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.wpq.validate.js"></script>
<script type="text/javascript">
$(function(){
})
</script>
</head>
<body>
	<div id="content_add">
		<div class="top_bar">
			<jsp:include page="inc.jsp"/>
		</div>
		<table cellspacing="0" cellPadding="0" id="addTable">
			<thead><tr><td colspan="2">角色信息</td></tr></thead>
				<tr>
					<td class="leftTd">角色名称:</td>
					<td class="rightTd"><span>${role.name }</span></td>
				</tr>
				<tr>
					<td class="leftTd">角色类型:</td>
					<td class="rightTd"><span>${role.roleType }</span></td>
				</tr>
				<tr>
					<td class="leftTd">角色成员:</td>
					<td class="rightTd">
					<c:forEach items="${users}" var="user">
					<a href="<%=request.getContextPath() %>/admin/user/show/${user.id}" class="list_op">${user.nickname }</a>
					</c:forEach>
					</td>
				</tr>
		</table>
	</div>
</body>
</html>