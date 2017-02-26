<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/resources/img/favicon.ico" rel="shortcut icon">
<title>赛车世界后台管理</title>
</head>
	<frameset cols="*,1200,*" frameborder="no">
		<frame/>
		<frameset rows="121,*">
			<frame src="<%=request.getContextPath() %>/jsp/admin/header.jsp"/>
			<frameset cols="203,*">
				<frame src="<%=request.getContextPath() %>/jsp/admin/nav.jsp"/>
				<frame id="admin_content" name="admin_content" src="<%=request.getContextPath() %>/jsp/admin/default.jsp" />
			</frameset>
		</frameset>
		<frame />
	</frameset>
</html>