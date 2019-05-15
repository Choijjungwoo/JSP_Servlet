<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>내부 오류가 발생했습니다.</h1>
		<div>
			<p>exception.getMessage():::<%=exception.getMessage() %></p>
			<p>exception.toString():::<%=exception.toString() %></p>
			<p>exception.printStackTrace():::
			<% exception.printStackTrace(new java.io.PrintWriter(out)); %></p>
		</div>
	</body>
</html>