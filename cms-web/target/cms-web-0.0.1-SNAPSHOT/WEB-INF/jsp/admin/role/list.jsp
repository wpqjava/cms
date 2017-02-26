<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
	$(function(){
		$("table").setTableStyle();
	})
</script>
</head>
<body>
	<div id="content">
		<div class="top_bar">
			<jsp:include page="inc.jsp"/>
		</div>
		<table cellspacing="0" cellPadding="0" id="listTable">
			<thead>
			<tr>
				<td>id</td>
				<td>角色名称</td>
				<td>角色类型</td>
				<td>操作</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles }" var="role">
				<tr>
					<td>${role.id }</td>
					<td><a class="table-a-default" href="show/${role.id }">${role.name }</a></td>
					<td>${role.roleType }</td>
					<td>
						<a href="show/${role.id }" title="${role.id }">
						<input type="button" value="详情" onclick="window.location.href='show/${role.id }'"/></a>
						
					&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>