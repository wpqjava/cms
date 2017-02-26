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
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
$(function(){
	$("table").setTableMouseStyle({trHoverClass:"channel-hover"});
})
</script>
</head>
<body>
	<div id="content">
		<table class="cc-addTable cc-show" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">显示[${channel.name}]栏目详情</td></tr></thead>
			<tr>
				<td class="leftTd" >栏目名称:</td>
				<td class="rightTd">${channel.name }</td>
			</tr>
			<tr>
				<td class="leftTd">是否指定链接</td>
				<td class="rightTd">
					<c:if test="${channel.customLink eq 0 }">不指定</c:if>
					<c:if test="${channel.customLink eq 1 }">指定</c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd">链接地址:</td>
				<td>${channel.customLinkUrl }</td>
			</tr>
			<tr>
				<td class="leftTd">栏目类型:</td>
				<td>${channel.channelType }</td>
			</tr>
			<tr>
				<td class="leftTd">是否主页介绍:</td>
				<td>
				<c:if test="${channel.isTopIntro eq 0 }">否</c:if>
				<c:if test="${channel.isTopIntro eq 1 }">是</c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd">导航顶部栏目:</td>
				<td>
				<c:if test="${channel.isNav eq 0 }">否</c:if>
				<c:if test="${channel.isNav eq 1 }">是</c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd">是否是推荐栏目:</td>
				<td>
				<c:if test="${channel.isRecommend eq 0 }">否</c:if>
				<c:if test="${channel.isRecommend eq 1 }">是</c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd">状态:</td>
				<td>
				<c:if test="${channel.status eq 0 }">停用</c:if>
				<c:if test="${channel.status eq 1 }">启用</c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd" colspan="2"><a href="<%=request.getContextPath() %>/admin/channel/add/${channel.id}">
				<input type="button" value="添加子栏目" onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/add/${channel.id}'"/></a></td>
			</tr>
		</table>
	</div>
</body>
</html>