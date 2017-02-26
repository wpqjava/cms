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
	$("#addForm").myValidate({
		rules:{
			name:"required"
		},
		messages:{
			name:"组名称不能为空"
		}
	});
})
</script>
</head>
<body>
	<div id="content_add">
		<div class="top_bar">
			<jsp:include page="inc.jsp"/>
		</div>
		<sf:form method="post" modelAttribute="group" id="addForm">
			<table cellspacing="0" cellPadding="0" id="addTable">
				<thead><tr><td colspan="2">组添加</td></tr></thead>
				<tr>
					<td class="leftTd">组名称:</td>
					<td class="rightTd"><sf:input path="name" size="30"/><span id="errorC"></span></td>
				</tr>
				<tr>
					<td class="leftTd">组描述:</td>
					<td class="rightTd"><sf:textarea cols="60" rows="5" path="descri" size="30"/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd"><input type="submit" value="添加"/>&nbsp;<input type="reset"/></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>