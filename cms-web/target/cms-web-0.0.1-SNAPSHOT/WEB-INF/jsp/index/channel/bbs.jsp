<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/resources/img/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/index/sub.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<title>互动论坛</title>
</head>
<body>
	<jsp:include page="../inc/top.jsp"></jsp:include>
	<div id="nav">
		<div id="nav_list">
			<ul>
				<li class="nav_li_first"><a href="<%=request.getContextPath() %>/album">精彩图集</a></li>
				<li class="nav_li_first "><a href="<%=request.getContextPath() %>/news">赛事新闻</a></li>
				<li class="nav_li_first "><a href="<%=request.getContextPath() %>/gossip">围场八卦</a></li>
				<li class="nav_li_first nav_li_last li_selected"><a href="<%=request.getContextPath() %>/bbs">互动论坛</a></li>
			</ul>
		</div>
	</div>
	<jsp:include page="../inc/nav.jsp"></jsp:include>
	<div id="bbs">
	</div>
	<jsp:include page="../inc/foot.jsp"></jsp:include>
</body>
</html>