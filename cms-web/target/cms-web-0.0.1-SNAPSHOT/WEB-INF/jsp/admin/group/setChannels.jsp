<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/zTreeStyle.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
	$(function(){
		$("#group-channel-tree").setTree();
	})
</script>
</head>
<body>
<div class="top_bar">
			<jsp:include page="inc.jsp"/>
</div>
<div class="channel-container">
		<c:forEach items="${cids }" var="cid">
			<input type="hidden" name="cids" value="${cid }">
		</c:forEach>
		<input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
		<input type="hidden" id="treePath" value="<%=request.getContextPath()%>/admin/channel/treeAll"/>
		<input type="hidden" id="gid" value="${group.id }"/>
	<input type="hidden" id="groupChannelTreePath" value="<%=request.getContextPath()%>/admin/channel/groupChannelTree/${group.id}"/>
	<div id="group-channel-tree" class="ztree"></div>
</div>

</body>
</html>