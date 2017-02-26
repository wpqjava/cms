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
		$("#search").click(function(){
			var con = $("input[name='con']").val();
			var cid = $("select").val();
			var status = $("input[type='hidden']").val();
			window.location.href = "topics?con="+con+"&cid="+cid+"&status="+status;
			
		})
	})
</script>
</head>
<body>
	<div id="content">
		<div class="top_bar">
			<jsp:include page="inc.jsp"/>
		</div>
		<input type="hidden" value="${status }"/>
		<table cellspacing="0" cellPadding="0" id="listTable">
			<thead>
			<tr>
				<td colspan="6" style="text-align: left">
				<span>搜索文章:</span>
				<input type="text" name="con" value="${con }"/>
				<select style="height:23px">
					<option value="0" label="请选择">
					<c:forEach items="${channels }" var="channel">
					<c:choose>
						<c:when test="${cid eq channel.id }">
						<option value="${channel.id }" label="${channel.name }" selected="selected">
						</c:when>
						<c:otherwise>
						<option value="${channel.id }" label="${channel.name }">
						</c:otherwise>
					</c:choose>
					
					</c:forEach>				
				</select>
				<input id="search" type="button" value="搜索"/>
				</td>
			</tr>
			<tr>
				<td>文章标题</td>
				<td>作者</td>
				<td>推荐</td>
				<td>所属频道</td>
				<td>状态</td>
				<td>操作</td>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${pager.datas }" var="topic">
				<tr>
					<td><a href="javascript:window.openWin('<%=request.getContextPath() %>/admin/topic/show/${topic.id }')" class="table-a-default">${topic.title }</a></td>
					<td>${topic.author }</td>
					<td>
					<c:if test="${topic.recommend eq 0 }">
					不推荐
					</c:if>
					<c:if test="${topic.recommend eq 1 }">
					<span class="emp">推荐</span>
					</c:if>
					</td>
					<td>${topic.channel.name }</td>
					<td>
					<c:if test="${topic.status eq 0 }">
					未发布
					</c:if>
					<c:if test="${topic.status eq 1 }">
					<span class="emp">已发布</span>
					</c:if>
					</td>
					<td>
						<%-- <a href="javascript:window.openWin('<%=request.getContextPath() %>/admin/topic/update/${topic.id }')"> --%>
						<input type="button" value="修改" onclick="javascript:window.openWin('<%=request.getContextPath() %>/admin/topic/update/${topic.id }')"/>
						<c:if test="${topic.status eq 0 }">
						<a href="updateStatus/${topic.id },${topic.status}">
						<input type="button" value="发布" onclick="window.location.href='updateStatus/${topic.id },${topic.status}'"/>
						</a>
						</c:if>
						<c:if test="${topic.status eq 1 }">
						<a href="updateStatus/${topic.id },${topic.status}">
						<input type="button" value="取消发布" onclick="window.location.href='updateStatus/${topic.id },${topic.status}'"/>
						</a>
						</c:if>
						<a href="delete/${topic.id }" class="delete">
						<input type="button" value="删除" onclick="window.location.href='delete/${topic.id }'"/>
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
					<jsp:param value="${pager.totalRecord }" name="tr"/>
					<jsp:param value="users" name="url"/>
				</jsp:include>
				</td>
			</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>