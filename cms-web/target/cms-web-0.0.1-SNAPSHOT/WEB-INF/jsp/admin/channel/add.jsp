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
		<sf:form method="post" modelAttribute="channel" id="addForm">
		<table class="cc-addTable" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">添加[${parentChannel.name}]子栏目功能</td></tr></thead>
			<tr>
				<td class="leftTd" >栏目名称:</td>
				<td class="rightTd"><sf:input path="name" size="30"/></td>
			</tr>
			<tr>
				<td class="leftTd">是否指定链接</td>
				<td class="rightTd">
					<sf:radiobutton path="customLink" value="0"/>不指定
					<sf:radiobutton path="customLink" value="1"/>指定
				</td>
			</tr>
			<tr>
				<td class="leftTd">链接地址:</td>
				<td><sf:input path="customLinkUrl" size="50"/></td>
			</tr>
			<tr>
				<td class="leftTd">栏目类型:</td>
				<td>
				<sf:select path="channelType">
					<sf:options items="${types}"/>
				</sf:select>
				</td>
			</tr>
			<tr>
				<td class="leftTd">是否主页介绍:</td>
				<td>
				<sf:radiobutton path="isTopIntro" value="0"/>否
				<sf:radiobutton path="isTopIntro" value="1"/>是
				</td>
			</tr>
			<tr>
				<td class="leftTd">导航顶部栏目:</td>
				<td><sf:radiobutton path="isNav" value="0"/>不是
					<sf:radiobutton path="isNav" value="1"/>是</td>
			</tr>
			<tr>
				<td class="leftTd">是否是推荐栏目:</td>
				<td><sf:radiobutton path="isRecommend" value="0"/>不是
					<sf:radiobutton path="isRecommend" value="1"/>是</td>
			</tr>
			<tr>
				<td class="leftTd">状态:</td>
				<td>
					<sf:radiobutton path="status" value="0"/>停用
					<sf:radiobutton path="status" value="1"/>启用
				</td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd"><input type="submit" value="添加栏目"/><input type="reset"/></td>
			</tr>
		</table>
		</sf:form>
	</div>
</body>
</html>