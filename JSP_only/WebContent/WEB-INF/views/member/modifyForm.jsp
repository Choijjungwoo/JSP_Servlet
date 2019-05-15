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
		<title>회원수정</title>
	</head>
	<body>
		<form action="modify" method="post">
			아이디 : <input value="${member.id }" readonly type="text" name="id" /><br/>
			패스워드 : <input value="${member.pwd }" type="password" name="pwd" /><br/>
			이메일 : <input value="${member.email }" type="email" name="email" /><br/>
			전화번호 : <input value="${member.phone }" type="text" name="phone" /><br/>
			<input type="button" id="modifyBtn" value="수정하기" />
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" id="cancelBtn" value="취소하기" />
		</form>	
		
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script>
			$('#modifyBtn').on('click',function(e){
				$('form[action="modify"]').submit();
			});
			$('#cancelBtn').on('click',function(e){
				location.href="detail.jsp?id=${member.id}";
			});
		</script>
				
	</body>
</html>






