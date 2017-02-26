<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<span class="default-span">
<c:if test="${isAdmin eq 1}">
<a href="<%=request.getContextPath() %>/admin/user/add">添加用户</a>
</c:if>
<a href="<%=request.getContextPath() %>/admin/user/users">用户列表</a>
</span>