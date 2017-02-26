<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
	$("#addForm").myValidate();
})
</script>
</head>
<body>
	<div id="content_add">
		<div class="top_bar">
			<jsp:include page="inc.jsp"/>
		</div>
		<sf:form method="post" modelAttribute="user" id="addForm">
		<sf:hidden path="id"/>
		<sf:hidden path="username"/>
			<table cellspacing="0" cellPadding="0" id="addTable">
				<thead><tr><td colspan="2">用户更新</td></tr></thead>
				<tr>
					<td class="leftTd">用户名:</td>
					<td class="rightTd">${user.username }</td>
				</tr>
				<tr>
					<td class="leftTd">昵称:</td>
					<td class="rightTd"><sf:input path="nickname" size="30"/></td>
				</tr>
				<tr>
					<td class="leftTd">联系电话:</td>
					<td class="rightTd"><sf:input path="phone" size="30"/></td>
				</tr>
				<tr>
					<td class="leftTd">电子邮件:</td>
					<td class="rightTd"><sf:input path="email" size="30"/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd"><input type="submit" value="更新"/>&nbsp;<input type="reset"/></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>