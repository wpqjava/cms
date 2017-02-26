<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="nav_container nav_container_01">
		<div id="nav_container_inner01">
			<ul>
				<#list album as a>
					<li><a href="<%=request.getContextPath() %>/album/${a.id}">${a.title}</a></li>
				</#list>
			</ul>
		</div>
	</div>
	<div class="nav_container nav_container_02">
		<div id="nav_container_inner02">
			<ul>
				<#list news as n>
					<li><a href="<%=request.getContextPath() %>/news/${n.id}">${n.title}</a></li>
				</#list>
			</ul>
		</div>
	</div>
	<div class="nav_container nav_container_03">
		<div id="nav_container_inner03">
			<ul>
				<#list gossip as g>
					<li><a href="<%=request.getContextPath() %>/gossip/${g.id}">${g.title}</a></li>
				</#list>
			</ul>
		</div>
	</div>