<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="flag" value="true" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<c:choose>
			<c:when test="${flag }">
				<h1>flag는 참입니다.</h1>
			</c:when>
			<c:otherwise>
				<h1>flag는 거짓입니다.</h1>
			</c:otherwise>
		</c:choose>
	</body>
</html>




