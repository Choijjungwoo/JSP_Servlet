<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="k" value="kkk" />


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<c:if test="${k eq '1' }">
			<h1>k는 1입니다.</h1>
		</c:if>
		<c:if test="${param.name eq 'admin' }">
			<h1>name parameter : ${param.name }</h1>
		</c:if>
	</body>
</html>





