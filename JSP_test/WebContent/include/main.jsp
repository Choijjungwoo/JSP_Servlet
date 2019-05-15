<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<% int k=1000; %>
<% pageContext.setAttribute("papa", "papa"); %>

<%
	request.setAttribute("k", k);
	request.setAttribute("papa",pageContext.getAttribute("papa"));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>main.jsp AAA</h1>
		<h1>request param:${param.name }</h1>
		<h1>int k = <%=k %></h1>
		<h1>pageContext papa: ${papa }</h1>
		<hr/>
		<jsp:include page="/include/sub.jsp" />
		<%-- <%@ include file="/include/sub.jsp" %> --%>
		<hr/>
		<h1>main.jsp CCC</h1>
	</body>
</html>




