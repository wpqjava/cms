<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<td>文件名缩略图</td>
			<td>附件原名</td>
			<td>附件新名</td>
			<td>附件大小</td>
			<td>是否首页图片</td>
			<td>是否专题图片</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${gabages }" var="g">
		<tr>
			<td>
			<c:if test="${g.isImg eq 1 }">
			<img src="<%=request.getContextPath()%>/resources/upload/thum/${g.newName}"/>
			</c:if>
			<c:if test="${g.isImg eq 0 }">
			普通附件
			</c:if>
			</td>
			<td>${g.oldName }</td>
			<td>${g.newName }</td>
			<td><fmt:formatNumber value="${g.size/1024 }" pattern="#"/>k</td>
			<td>
			<c:if test="${g.isIndexPic eq 0 }">否</c:if>
			<c:if test="${g.isIndexPic eq 1 }">是</c:if>
			</td>
			<td>
			<c:if test="${g.isAttach eq 0 }">否</c:if>
			<c:if test="${g.isAttach eq 1 }">是</c:if>
			</td>
		</tr>
		</c:forEach>
		<tr><td colspan="6"><input type="button" value="关闭窗口" onclick="window.close()"></td></tr>
		</tbody>
		</table>
	</div>
</body>
</html>