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
		$(".descri").setTopicLength({length:30});
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
				<td>组名称</td>
				<td>组介绍</td>
				<td>组操作</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${groups }" var="group">
				<tr>
					<td>${group.id }&nbsp;</td>
					<td><a class="table-a-default" href="show/${group.id }">${group.name }&nbsp;</a></td>
					<td style="text-align: left"><div class="descri">${group.descri }&nbsp;</div></td>
					<td>
						<a href="show/${group.id }" title="${group.id }" >
						<input type="button" value="详情" onclick="window.location.href='show/${group.id }'"/>
						</a>
						<c:if test="${isAdmin eq 1}">
						<a href="delete/${group.id }" title="${group.id }" class="deleteGroup">
						<input type="button" value="删除" onclick="window.location.href='delete/${group.id }'"/>
						</a>
						<a href="update/${group.id }" >
						<input type="button" value="更新" onclick="window.location.href='update/${group.id }'"/>
						</a>
						</c:if>
						<a href="<%=request.getContextPath() %>/admin/channel/groupChannels/${group.id }" >
						<input type="button" value="查看管理栏目" onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/groupChannels/${group.id }'"/>
						</a>
						<c:if test="${isAdmin eq 1}">
						<a href="<%=request.getContextPath() %>/admin/channel/setChannels/${group.id }">
						<input type="button" value="设置管理栏目" onclick="window.location.href='<%=request.getContextPath() %>/admin/channel/setChannels/${group.id }'"/>
						</a>
						</c:if>
					&nbsp;
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>