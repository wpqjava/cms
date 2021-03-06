<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改文章</title>
<link href="<%=request.getContextPath() %>/resources/img/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/zTreeStyle.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/jquery-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/uploadify/uploadify.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/xhed/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/xhed/xheditor_lang/zh-cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/uploadify/jQuery.uploadify3.1.fixed.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.wpq.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/topic-update.js"></script>
</head>
<body>
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#eee;z-index: 999;border:1px solid #999">
		<ul id="mytree" class="ztree" style="margin-top:0;"></ul>
	</div>
	<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="sessionId" value="<%=session.getId()%>"/>
	<div id="content_add">
		<sf:form method="post" modelAttribute="topicDto" id="addForm">
		<table class="cc-addTable" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">修改文章</td></tr></thead>
			<tr>
				<td class="leftTd" >文章标题:</td>
				<td class="rightTd"><sf:input path="title" size="50"/></td>
			</tr>
			<tr>
				<td class="leftTd">关键字:</td>
				<td class="rightTd">
					<sf:input path="keyword" size="50"/>
					<c:forEach items="${ekeys }" var="k">
					<input type="hidden" class="eks" value="${k}">
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="leftTd">摘要:</td>
				<td>
				<sf:input path="summary" size="50"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd">所在栏目:</td>
				<td>
				<input type="text" readonly="readonly" name="cname" id="cname" value="${topic.channel.name }"/>
				<input type="hidden" readonly="readonly" id="cid" name="cid" value="${topicDto.channelId }"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd">是否推荐:</td>
				<td>
				<sf:radiobutton path="recommend" value="0"/>否
				<sf:radiobutton path="recommend" value="1"/>是
				</td>
			</tr>
			<tr>
				<td class="leftTd">发布时间:</td>
				<td>
				<sf:input path="publishDate" value="${topicDto.publishDate }"/>
				</td>
			</tr>
			<tr id="tr-attach">
			<td class="leftTd">文章附件</td>
			<td class="rightTd">
				<div id="attachs"></div>
				<input type="file" name="file_upload" id="file_upload" />
				<input type="button" id="uploadFile" value="上传文件"/>
			</td>
			</tr>
			<tr class="temp-frame-att">
			<td colspan="2">已传附件</td>
			</tr>
			<tr class="temp-frame-att">
			<td colspan="2">
			<table id="ok_attach" style="text-align: center" width="890px" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
					<Td>文件名缩略图</Td>
					<td width="180">文件名</td>
					<td>文件大小</td>
					<c:choose>
						<c:when test="${topicDto.channelId eq 3 }">
						<td>主页图片</td>
						</c:when>
						<c:when test="${topicDto.channelId eq 4 }">
						<td>专题图片</td>
						</c:when>
					</c:choose>
					<td>展示图</td>
					<td width="160">操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${attaches }" var="a">
				<tr class="temp-insert-att">
					<td>
						<c:if test="${a.isImg eq 0 }">
						普通附件
						</c:if>
						<c:if test="${a.isImg eq 1 }">
						<img src="<%=request.getContextPath()%>/resources/upload/thum/${a.newName}">
						</c:if>
					</td>
					<td width="180">${a.oldName }</td>
					<td><fmt:formatNumber value="${a.size/1024 }" pattern="#"/>k</td>
					<c:if test="${a.isImg eq 1 }">
						<c:choose>
							<c:when test="${topicDto.channelId eq 3}">
								<c:if test="${a.isIntroPic eq 1 }">
									<td><input type="checkbox" value="${a.id }" name="introPic" checked="checked"></td>
								</c:if>
								<c:if test="${a.isIntroPic eq 0 }">
									<td><input type="checkbox" value="${a.id }" name="introPic"></td>
								</c:if>
							</c:when>
							<c:when test="${topicDto.channelId eq 4}">
								<c:if test="${a.isSpePic eq 1 }">
									<td><input type="checkbox" value="${a.id }" name="spePic"checked="checked"></td>
								</c:if>
								<c:if test="${a.isSpePic eq 0 }">
									<td><input type="checkbox" value="${a.id }" name="spePic"></td>
								</c:if>
							</c:when>
						</c:choose>
						<c:if test="${a.isShowPic eq 1 }">
							<td><input type="checkbox" value="${a.id }" name="showPic" checked="checked"></td>
						</c:if>
						<c:if test="${a.isShowPic eq 0 }">
							<td><input type="checkbox" value="${a.id }" name="showPic" ></td>
						</c:if>
					</c:if>
					<c:if test="${a.isImg eq 0 }">	
						<c:choose>
							<c:when test="${topicDto.channelId eq 3 || topicDto.channelId eq 4}">
								<td></td><td></td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>	
					</c:if>
					<td>
						<input type="hidden" name="aids" value="${a.id }"/>
						<a href='#' class='list_op insertAttach' title="${a.id }" isImg="${a.isImg }" name="${a.newName }" oldName="${a.oldName }">插入附件</a>&nbsp;
						<a href='#' title="${a.id }" class="list_op deleteAttach delete">删除附件</a>
					</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2" >内容:</td>
			</tr>
			<tr>
				<td colspan="2"><sf:textarea path="content" cols="125" rows="20" class="xheditor"></sf:textarea></td>
			</tr>
			<tr>
				<td colspan="2" class="centerTd"><input type="submit" value="更新"/>&nbsp;<input type="reset"/></td>
			</tr>
		</table>
		</sf:form>
	</div>
</body>
</html>