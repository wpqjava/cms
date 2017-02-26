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
				<td>id</td>
				<td>用户名</td>
				<td>用户昵称</td>
				<td>用户手机</td>
				<td>用户邮箱</td>
				<td>用户状态</td>
				<td>用户操作</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${datas.datas }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td><a class="table-a-default" href="show/${user.id }">${user.nickname }</a></td>
					<td>${user.phone }</td>
					<td>
						<a href="#" class="list_link">${user.email }</a>
						&nbsp;
					</td>
					<td>
						<c:if test="${user.status eq 0 }">
							<span class="emp">停用</span>
							<c:if test="${isAdmin eq 1}">
								<a href="updateStatus/${user.id },${user.status}"  >
								<input type="button" value="启用" onclick="window.location.href='updateStatus/${user.id },${user.status}'"/>
								</a>
							</c:if>
							
						</c:if>
						<c:if test="${user.status eq 1 }">
							<span>启用</span>
							<c:if test="${isAdmin eq 1}">
								<a href="updateStatus/${user.id },${user.status}" class="stopBtn" >
								<input type="button" value="停用" onclick="window.location.href='updateStatus/${user.id },${user.status}'"/>
								</a>
							</c:if>
						</c:if>
						&nbsp;
					</td>
					<td>
						<a href="show/${user.id }">
						<input type="button" value="详情" onclick="window.location.href='show/${user.id }'"/>
						</a>
						<c:if test="${isAdmin eq 1}">
						<a href="update/${user.id }">
						<input type="button" value="更新" onclick="window.location.href='update/${user.id }'"/>
						</a>
						<a href="delete/${user.id }" class="delete">
						<input type="button" value="删除" onclick="window.location.href='delete/${user.id }'"/>
						</a>
						</c:if>
						<a href="<%=request.getContextPath() %>/admin/channel/userChannels/${user.id }">
						<input onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/userChannels/${user.id }'" type="button" value="查看管理栏目"/>
						</a>
					&nbsp;
					</td>
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
			<tr>
				<td colspan="7" style="text-align:right;margin-right:10px;">
				<jsp:include page="/jsp/pager.jsp">
					<jsp:param value="${datas.totalRecord }" name="tr"/>
					<jsp:param value="users" name="url"/>
				</jsp:include>
				</td>
			</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>