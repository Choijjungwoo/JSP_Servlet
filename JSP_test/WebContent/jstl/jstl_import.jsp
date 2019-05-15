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
		<h1>
		<c:url value="/jstl/jstl_forEach.jsp" />
		</h1>
		<div style="width:500px;height:400px;">
			<c:import url="/jstl/jstl_forEach.jsp" var="forEach" />				
		</div>
		<div style="width:500px;height:400px;overflow:scroll;">
			<c:import url="https://www.naver.com" ></c:import>
		</div>
		
		<span>${forEach }</span>
	</body>
</html>





