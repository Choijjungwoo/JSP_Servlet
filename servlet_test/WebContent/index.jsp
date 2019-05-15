<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button type="button" id="loginBtn">로그인</button>
	
	<script>
		var loginBtn=document.getElementById("loginBtn");
		
		loginBtn.onclick=function(){
			//alert("login button click");
			location.href="/login";
		};
	</script>
</body>
</html>






