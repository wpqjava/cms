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
	function refreshTree(){
		treeObj.reAsyncChildNodes(null, "refresh");
	}
	$(function(){
		treeObj = $("#tree").mytree({extendAll:1});
	})
</script>
</head>
<body>
<div class="top_bar">
			<jsp:include page="inc.jsp"/>
</div>
<div class="channel-container">
	<div id="tree" class="ztree"></div>
	<div id="treeContent">
		<IFRAME ID="treeIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO></IFRAME>
	</div>
</div>

</body>
</html>