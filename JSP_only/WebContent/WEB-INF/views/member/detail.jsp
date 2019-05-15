<%@page import="com.java.dao.MemberDAO"%>
<%@page import="com.java.dto.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원상세</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>${member.id }</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>${member.pwd }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.email }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${member.phone }</td>
			</tr>
		</table>
		<button type="button" id="modifyBtn" >수 정</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="removeBtn">삭 제</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="listBtn">목 차</button>
		
		
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script>
			$('#modifyBtn').on('click',function(e){
				location.href="modify?id=${member.id}";
			});
			$('#removeBtn').on('click',function(e){
				location.href="remove?id=${member.id}";
			});
			$('#listBtn').on('click',function(e){
				alert('목록 버튼을 클릭했습니다.');
			});
		</script>
		
	</body>
</html>





