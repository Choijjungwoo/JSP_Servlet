<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>메인입니다.</h1>
		<form action="<%=request.getContextPath() %>/commons/logout"
		      method="post">
			<input type="submit" value="로그아웃" />      
		</form>
	</body>
</html>