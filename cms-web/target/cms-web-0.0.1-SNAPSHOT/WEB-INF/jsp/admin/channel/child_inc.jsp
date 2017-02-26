<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<span style="color:#fff">
<c:if test="${isAdmin eq 1}">
<a href="<%=request.getContextPath() %>/admin/channel/add/${pid}">添加子栏目</a>
</c:if>
<a href="${pid}">栏目列表</a>
</span>