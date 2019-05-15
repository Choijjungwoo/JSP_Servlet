<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<c:set var="names" value="Kim,Lee,Park" />
		<c:forTokens var="name" items="${names}" delims="," varStatus="status">
			<h1>${status.count}-${name }</h1>
		</c:forTokens>
		
	</body>
</html>






