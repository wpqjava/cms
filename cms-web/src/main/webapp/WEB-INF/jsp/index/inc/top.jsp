<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
		<input type="hidden" value="<%=request.getContextPath() %>" name="ctx"/>
		<div id="header_top">
			<div id="header_top_center">
				<div id="logo"></div>
				<ul>
					<li><a href="<%=request.getContextPath() %>/index">网站首页</a></li>
					<li><a href="<%=request.getContextPath() %>/admin/">后台管理</a></li>
				</ul>
				<div id="search">
					<form action="">
						<input type="text" id="textInput" />
						<input type="submit" value="Search" id="textButton" />
					</form>
				</div>
			</div>
		</div>
		<div id="header_bottom">
			<ul>
					<li class="li_first"><a href="<%=request.getContextPath() %>/schedule">赛程预览</a></li>
					<li class="li_first"><a href="<%=request.getContextPath() %>/teams">车队介绍</a></li>
					<li class="li_last"><a href="<%=request.getContextPath() %>/racer">车手信息</a></li>
			</ul>
		</div>
	</div>
	