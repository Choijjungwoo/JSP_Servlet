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
		<%-- 단순 반복문 --%>
		<%
			int sum=0;
			for(int i=1;i<11;i++){
				sum+=i;
			}
			out.println("<h1>합계 : "+sum+"</h1>");
		%>
		<c:set var="sum" value="0" />
		<c:forEach var="i" begin="1" end="10" step="1" >
			<c:set var="sum" value="${sum+i }"/>
		</c:forEach>
		<h1>합계 : ${sum }</h1>
		<h1>합계 : <c:out value="${sum}" /></h1>
		
		
		<%-- 집합체 반복문 --%>
		<%
			String[] names={"Kim","Lee","Park"};
			for(String name : names){
				out.print(name+" ");				
			}
		%>
		<br/>
		<c:forEach var="name" items="<%=names %>" varStatus="status">
			${status.count }-${name }&nbsp;
		</c:forEach>				
	</body>
</html>
















