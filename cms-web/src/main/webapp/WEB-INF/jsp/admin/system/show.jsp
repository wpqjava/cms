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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
$(function(){
	$("table").setTableMouseStyle({trHoverClass:"channel-hover"});
})
</script>
</head>
<body>
	<div id="content">
		<div class="top_bar">
			<jsp:include page="inc.jsp"/>
		</div>
		<table cellspacing="0" cellPadding="0" id="addTable">
			<thead><tr><td colspan="2">网站基本信息</td></tr></thead>
			<tr>
				<td class="leftTd">网站名称:</td>
				<td class="rightTd">${baseInfo.name }</td>
			</tr>
			<tr>
				<td class="leftTd">备案号:</td>
				<td class="rightTd">${baseInfo.recordCode }</td>
			</tr>
			<tr>
				<td class="leftTd">电子邮件:</td>
				<td class="rightTd">${baseInfo.email }</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
				<a href="update">
				<input type="button" value="更新" onclick="window.location.href='update'"/>
				</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>