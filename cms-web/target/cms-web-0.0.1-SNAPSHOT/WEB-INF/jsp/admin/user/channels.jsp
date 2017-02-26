<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/zTreeStyle.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
	var myTree;
	$(function(){
		treeObj = $("#group-channel-tree").mytree({url:$("#userChannelTreePath").val(),extendAll:true,isClick:false});
	})
</script>
</head>
<body>
<div class="top_bar">
			<jsp:include page="inc.jsp"/>
</div>
<div class="channel-container">
	<input type="hidden" id="userChannelTreePath" value="<%=request.getContextPath()%>/admin/channel/userChannelTree/${user.id}"/>
	<div id="group-channel-tree" class="ztree"></div>
</div>

</body>
</html>