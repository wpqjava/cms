<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv=X-UA-Compatible content=IE=EmulateIE7>
<title>文章详情</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/content.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/jquery-ui.min.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/xhed/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/xhed/xheditor_lang/zh-cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.cms.core.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#eee;z-index: 999;border:1px solid #999">
		<ul id="mytree" class="ztree" style="margin-top:0;"></ul>
	</div>
	<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="sessionId" value="<%=session.getId()%>"/>
	<div id="content_add">
		<table class="cc-addTable" cellspacing="0" cellPadding="0">
			<thead><tr><td colspan="2">文章详情</td></tr></thead>
			<tr>
				<td class="leftTd topic-show" >文章标题:</td>
				<td class="rightTd">${topic.title }</td>
			</tr>
			<tr>
				<td class="leftTd topic-show">关键字:</td>
				<td class="rightTd">${topic.keyword }&nbsp;</td>
			</tr>
			<tr>
				<td class="leftTd topic-show">摘要:</td>
				<td>${topic.summary }&nbsp;</td>
			</tr>
			<tr>
				<td class="leftTd topic-show">所在栏目:</td>
				<td>${topic.channel.name }</td>
			</tr>
			<tr>
				<td class="leftTd topic-show">是否推荐:</td>
				<td>
				<c:if test="${topic.recommend eq 0 }">否</c:if>
				<c:if test="${topic.recommend eq 1 }">是</c:if>
				</td>
			</tr>
			<tr>
				<td class="leftTd topic-show">创建时间:</td>
				<td>
				<fmt:formatDate value="${topic.createDate }" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td class="leftTd topic-show">发布时间:</td>
				<td>
				<fmt:formatDate value="${topic.publishDate }" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
			<td colspan="2">附件</td>
			</tr>
			<tr>
			<td colspan="2">
			<table id="ok_attach" width="890px" style="text-align: center" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
					<Td>文件名缩略图</Td>
					<td width="180">文件名</td>
					<td>文件大小</td>
					<td>主页图片</td>
					<td>专题图片</td>
					<td>主页展示</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${attaches }" var="a">
				<tr>
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
					<td>
					<c:if test="${a.isIntroPic eq 0 }">否</c:if>
					<c:if test="${a.isIntroPic eq 1 }">是</c:if>
					</td>
					<td>
					<c:if test="${a.isSpePic eq 0 }">否</c:if>
					<c:if test="${a.isSpePic eq 1 }">是</c:if>
					</td>
					<td>
					<c:if test="${a.isShowPic eq 0 }">否</c:if>
					<c:if test="${a.isShowPic eq 1 }">是</c:if>
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
				<td colspan="2">${topic.content }</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center"><input type="button" onclick="window.close()"  value="关闭窗口"/></td>
			</tr>
		</table>
	</div>
</body>
</html>