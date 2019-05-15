<%@page import="com.java.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.java.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%-- 6. Markup (HTML) : JSTL, EL  --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원리스트</title>
	</head>
	<body>
		<button type="button"  onclick="regist_go();">회원등록</button>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
			
			<c:forEach items="${memberList }" var="member">
				<tr>
					<td><a href="detail?id=${member.id }">${member.id }</a></td>
					<td>${member.pwd }</td>
					<td>${member.phone }</td>
					<td>${member.email }</td>
				</tr>	
			</c:forEach>			
		</table>
		
	<script>
		function regist_go(){
			location.href="regist";
		}
	</script>	
	</body>
</html>






