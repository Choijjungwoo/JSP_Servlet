<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <% pageContext.setAttribute("name", "kim"); %> --%>

<%-- <% String kkk="Park"; %>
 --%>
<c:set var="name" value="pageContext" />
<c:set var="name" value="request" scope="request" />
<c:set var="name" value="session" scope="session" />
<c:set var="name" value="application" scope="application" />

<c:remove var="name" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>${name }님 환영합니다.</h1>
	</body>
</html>



