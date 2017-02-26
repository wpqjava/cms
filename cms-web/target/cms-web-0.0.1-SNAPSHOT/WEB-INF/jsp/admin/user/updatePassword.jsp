<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.wpq.validate.js"></script>
<script type="text/javascript">
$(function(){
	$("#addForm").myValidate({
		rules:{
			confirm:{
				required: true,
				equalTo: "#addPassword"
			},
			password:"required"
		},
		messages:{
			confirm:{
				required: "请重复密码",
				equalTo: "必须和密码相同"
			},
			password:"密码不能为空"
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
		<sf:form method="post" modelAttribute="passwordDto" id="addForm">
		<sf:hidden path="id"/>
			<table cellspacing="0" cellPadding="0" id="addTable">
				<thead><tr><td colspan="2">修改密码</td></tr></thead>
				<tr>
					<td class="leftTd">用户名:</td>
					<td class="rightTd">${loginUser.username }</td>
				</tr>
				<tr>
					<td class="leftTd">原密码:</td>
					<td class="rightTd"><sf:password path="opassword" size="30"/><span style="color:red">${error }</span></td>
				</tr>
				<tr>
					<td class="leftTd">新密码:</td>
					<td class="rightTd"><sf:password path="password" size="30" id="addPassword"/></td>
				</tr>
				<tr>
					<td class="leftTd">确认密码:</td>
					<td class="rightTd"><input type="password" id="confirm" name="confirm" size="30"/></td>
				</tr>
				<tr>
					<td colspan="2" class="centerTd"><input type="submit" value="更新"/>&nbsp;<input type="reset"/></td>
				</tr>
			</table>
		</sf:form>
	</div>
</body>
</html>