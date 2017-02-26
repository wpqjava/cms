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
			name:"required",
			recordCode:"required",
			email:"required"
		},
		message:{
			name:"网站名不能为空",
			recordCode:"备案号不能为空",
			email:"电子邮件不能为空"
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
		<sf:form method="post" modelAttribute="baseInfo" id="addForm">
			<table cellspacing="0" cellPadding="0" id="addTable">
				<thead><tr><td colspan="2">网站基本信息更新</td></tr></thead>
				<tr>
					<td class="leftTd">网站名:</td>
					<td class="rightTd"><sf:input path="name" size="30"/></td>
				</tr>
				<tr>
					<td class="leftTd">备案号:</td>
					<td class="rightTd"><sf:input path="recordCode" size="30"/></td>
				</tr>
				<tr>
					<td class="leftTd">电子邮件:</td>
					<td class="rightTd"><sf:input path="email" size="30"/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd"><input onclick="confirm('确认修改网站信息并重启服务器吗？')" type="submit" value="更新网站基本信息"/>&nbsp;<input type="reset"/></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>