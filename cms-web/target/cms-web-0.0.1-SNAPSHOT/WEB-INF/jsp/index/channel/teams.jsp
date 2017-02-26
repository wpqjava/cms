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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/sub.js"></script>
<title>车队介绍</title>
</head>
<body>
	<jsp:include page="../inc/top.jsp"/>
	<jsp:include page="../inc/navbar.jsp"/>
	<jsp:include page="../inc/nav.jsp"/>
	<div id="intro05">
		<span class="intro-span">Teams</span>
	</div>
	<div id="intro_nav">
		<a href="<%=request.getContextPath() %>">首页</a>
		<span>&nbsp;> 车队介绍</span>
	</div>
	<div id="container02">
		<c:if test="${isList eq 1 }">
			<div id="container02_inner_block">
				<c:forEach items="${datas }" var="a">
					<div class="container02_inner_pic">
					<a href="<%=request.getContextPath() %>/teams/${a.topic.id}" class="container02_inner_p"><img width="100px" height="100px" src="<%=request.getContextPath() %>/resources/upload/thum/${a.newName}"></a>
					<a href="<%=request.getContextPath() %>/teams/${a.topic.id}" class="container02_inner_text"><span>${a.topic.title }</span></a>
				</div>
				</c:forEach>
			</div>
		</c:if>
		<c:if test="${isList eq 0 }">
			<div id="container02_inner">
				<div id="topic-title">
				<span>${topic.title }</span>
				</div>
				<div id="topic-content">
				<span>${topic.content }</span>
				</div>
			</div>
		</c:if>
		<div id="container02_bottom">
			<ul>
				<li><a href="http://www.fia.com/" target="_blank"><img src="<%=request.getContextPath() %>/resources/css/index/img/container-bar01.jpg" alt=""/></a></li>
				<li><a href="https://www.formula1.com/" target="_blank"><img src="<%=request.getContextPath() %>/resources/css/index/img/container-bar02.jpg" alt=""/></a></li>
				<li><a href="http://www.rolex.com/rolex-and-sports/motor-sports.html?cmpid=dw_F1_201609319" target="_blank"><img src="<%=request.getContextPath() %>/resources/css/index/img/container-bar03.jpg" alt=""/></a></li>
				<li><a href="http://www.fiawec.com/" target="_blank"><img src="<%=request.getContextPath() %>/resources/css/index/img/container-bar04.jpg" alt=""/></a></li>
			</ul>
		</div>
	</div>
	<jsp:include page="../inc/foot.jsp"></jsp:include>
</body>
</html>