<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<span class="topic-inc-span">
<a href="javascript:window.openWin('<%=request.getContextPath() %>/admin/topic/add')">添加文章</a>
<a href="<%=request.getContextPath() %>/admin/topic/topics?status=1">已发布列表</a>
<a href="<%=request.getContextPath() %>/admin/topic/topics?status=0">未发布列表</a>
</span>