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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/inc.js"></script>
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
			<td>未使用的垃圾附件</td>
			<td>${unusedAtts }</td>
			<td>
			<input type="button" value="查看" onclick="javascript:window.openWin('<%=request.getContextPath() %>/admin/system/showGabage')"/>
			<a href="clearGabage">
			<input type="button" value="清理" onclick="window.location.href='clearGabage'"/>
			</a>&nbsp;
			</td>
		</tr>
		</thead>
		<tbody>
		</tbody>
		</table>
	</div>
</body>
</html>