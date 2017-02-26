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
			<thead><tr><td colspan="2">用户信息</td></tr></thead>
			<tr>
				<td class="leftTd">用户名:</td>
				<td class="rightTd">${userDto.username }</td>
			</tr>
			<tr>
				<td class="leftTd">昵称:</td>
				<td class="rightTd">${userDto.nickname }</td>
			</tr>
			<tr>
				<td class="leftTd">联系电话:</td>
				<td class="rightTd">${userDto.phone }</td>
			</tr>
			<tr>
				<td class="leftTd">电子邮件:</td>
				<td class="rightTd">${userDto.email }</td>
			</tr>
			<tr>
				<td class="leftTd">创建时间:</td>
				<td class="rightTd" >
				<%-- jstl的日期格式化标签 --%>
				<fmt:formatDate value="${userDto.createDate}" pattern="yyyy年MM月dd日 E"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd">状态:</td>
				<td class="rightTd">
				<c:if test="${userDto.status == 1 }"><span>启用</span></c:if>
				<c:if test="${userDto.status == 0 }"><span style="color:red">停用</span></c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd">用户组:</td>
				<td class="rightTd">
				
				<c:forEach items="${groups }" var="group">
					<%-- jstl的函数调用 --%>
					<c:set var="isContain" value="${fn:contains(userDto.groupNames,group.name)}" />
					<c:choose>  
					   <c:when test="${isContain}"> 
					   <input type="checkbox" checked="checked" onclick="return false"/>
					   <a href="<%=request.getContextPath()%>/admin/group/show/${group.id}" class="list_op">${group.name }</a>
					   </c:when>  
					   <c:otherwise>  
					   <input type="checkbox" onclick="return false"/>
					   <a href="<%=request.getContextPath()%>/admin/group/show/${group.id}" class="list_op">${group.name }</a>
					   </c:otherwise>  
					</c:choose>  
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="leftTd">用户职责:</td>
				<td class="rightTd">
				<c:forEach items="${roles }" var="role">
					<c:set var="isContain" value="${fn:contains(userDto.roleNames,role.name)}" />
					<c:choose>  
					   <c:when test="${isContain}"> 
					   <input type="checkbox" id="groupId:${role.id }" checked="checked" onclick="return false"/>
					   <a href="<%=request.getContextPath()%>/admin/role/show/${role.id}" class="list_op">${role.name }</a>
					   </c:when>  
					   <c:otherwise>  
					   <input type="checkbox" id="groupId:${role.id }" onclick="return false"/>
					   <a href="<%=request.getContextPath()%>/admin/role/show/${role.id}" class="list_op">${role.name }</a>
					   </c:otherwise>  
					</c:choose>  
				</c:forEach>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>