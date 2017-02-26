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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
	$(function(){
		if($("input[type='hidden']").val()){
			parent.refreshTree();
		}
		$(".channel-child-table").mysortable();
	})
</script>
</head>
<body>
	<div class="cc_top_bar">
	<jsp:include page="child_inc.jsp"/>
	</div>
	<input type="hidden" value="${refresh }"/>
	<table class="channel-child-table" cellspacing="0" cellPadding="0" >
		<thead>
		<tr>
			<td>栏目名称</td>
			<td>栏目类型</td>
			<td>是否推荐</td>
			<td>是否导航</td>
			<td>栏目状态</td>
			<Td>操作</Td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${childChannels }" var="c">
			<tr id="id_${c.id }">
				<td>
				${c.name }
				&nbsp;</td>
				<td class="">${c.channelType.name }</td>
				<td>
				<c:if test="${c.isRecommend eq 0 }"><span class="emp">不推荐</span></c:if>
				<c:if test="${c.isRecommend eq 1 }">推荐</c:if>
				&nbsp;</td>
				<td>
				<c:if test="${c.isNav eq 0 }"><span class="emp">否</span></c:if>
				<c:if test="${c.isNav eq 1 }">是</c:if>
				&nbsp;</td>
				<td><c:if test="${c.status eq 0 }">停用</c:if>
				<c:if test="${c.status eq 1 }"><span class="emp">启用</span></c:if>
				&nbsp;</td>
				<td class="centerTd">
					<a href="<%=request.getContextPath() %>/admin/channel/channels/${c.id }" >
					<input type="button" value="详情" onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/channels/${c.id }'"/></a>
					<c:if test="${isAdmin eq 1}">
					<a href="<%=request.getContextPath() %>/admin/channel/update/${pid },${c.id}" >
					<input type="button" value="更新" onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/update/${pid },${c.id}'"/></a>
					<a href="<%=request.getContextPath() %>/admin/channel/delete/${pid },${c.id}"  class="delete">
					<input type="button" value="删除" onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/delete/${pid },${c.id}'"/></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<c:if test="${isAdmin eq 1}">
		<tr>
		<td colspan="6" class=""><a id="beginOrder" href="#" title="#" class="list_op">开始排序</a>
				&nbsp;<a id="saveOrder" href="#" title="#" class="list_op">存储排序</a>&nbsp;</td>
		</tr>
		</c:if>
		</tfoot>
	</table>

</body>
</html>