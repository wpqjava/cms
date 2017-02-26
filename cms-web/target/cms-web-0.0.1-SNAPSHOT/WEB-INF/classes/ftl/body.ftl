<#macro setTitleLength str len=9>
	<#if str?length gt len>
		${str?substring(0,len-2)}...
	<#else>
		${str}
	</#if>
</#macro>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="intro">
		<div class="prev"></div>
		<div class="next"></div>
		<div id="intro_img">
			<div id="cp" class="cycle-pager"></div>
			<#list intro as i >
				<a href="<%=request.getContextPath() %>/topic/${i.topic.id}"><img src="<%=request.getContextPath() %>/resources/upload/${i.newName}" data-cycle-hash="${i.topic.id}"/></a>
			</#list>
		</div>
	</div>
	<div id="container01">
		<div id="container01_top">
			<h2><span>F1专题</span></p></h2>
		</div>
		<div id="container01_bottom">
			<ul>
				<#list special as s>
					<li><a href="<%=request.getContextPath() %>/topic/${s.topic.id}"><img src="<%=request.getContextPath() %>/resources/img/channel/sub/${s.newName}" alt=""/><span class="cbs cbs${s_index+1}">
					<@setTitleLength str=s.topic.title len=15/>
					</span></a></li>
				</#list>
			</ul>
		</div>
	</div>
	<div id="container02">
		<div id="container02_top">
			<div class="container02_topL">
				<div class="top_title">
					<h2><span>热点话题</span></h2>
				</div>
				<div class="top_content">
					<ul>
						<#list hotspot as a>
							<li>
								<span class="img_span"><img src="<%=request.getContextPath() %>/resources/upload/thum/${a.newName}" width="100px" height="100px"/></span>
								<span class="date_span"><em>${a.topic.summary}</em><span class="date">${a.topic.publishDate?string("yyyy-MM-dd")}</span></span>
								<span class="a_span"><a href="<%=request.getContextPath() %>/hotspot/${a.topic.id}"><@setTitleLength str=a.topic.title len=30/></a></span>
							</li>
						</#list>
					</ul>
				</div>
				<div class="top_more">
					<ul>
						<li><a href="<%=request.getContextPath() %>/hotspot">More</a></li>
					</ul>
				</div>
			</div>
			<div class="container02_topL container02_topR">
				<div class="top_title">
					<h2><span>前沿赛况</span></h2>
				</div>
				<div class="top_content">
					<ul>
						<#list competition as a>
							<li>
								<span class="img_span"><img src="<%=request.getContextPath() %>/resources/upload/thum/${a.newName}" width="100px" height="100px"/></span>
								<span class="date_span"><em>${a.topic.summary}</em><span class="date">${a.topic.publishDate?string("yyyy-MM-dd")}</span></span>
								<span class="a_span"><a href="<%=request.getContextPath() %>/competition/${a.topic.id}"><@setTitleLength str=a.topic.title len=30/></a></span>
							</li>
						</#list>
					</ul>
				</div>
				<div class="top_more">
					<ul>
						<li><a href="<%=request.getContextPath() %>/competition">More</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="container02_bottom">
			<ul>
				<li><a href="http://www.fia.com/" target="_blank"><img src="<%=request.getContextPath() %>/resources/css//index/img/container-bar01.jpg" alt=""/></a></li>
				<li><a href="https://www.formula1.com/" target="_blank"><img src="<%=request.getContextPath() %>/resources/css//index/img/container-bar02.jpg" alt=""/></a></li>
				<li><a href="http://www.rolex.com/rolex-and-sports/motor-sports.html?cmpid=dw_F1_201609319" target="_blank"><img src="<%=request.getContextPath() %>/resources/css//index/img/container-bar03.jpg" alt=""/></a></li>
				<li><a href="http://www.fiawec.com/" target="_blank"><img src="<%=request.getContextPath() %>/resources/css//index/img/container-bar04.jpg" alt=""/></a></li>
			</ul>
		</div>
	</div>