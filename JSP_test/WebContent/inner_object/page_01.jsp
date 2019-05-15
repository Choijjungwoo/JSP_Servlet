<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	pageContext.setAttribute("page1", "비가와요!!!");
	request.setAttribute("req", "우산은 챙기셨나요?");
	session.setAttribute("ses", "산성비는 탈모의 치명적!!");
	application.setAttribute("app","동동주의 파전~~!! 고!!!");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		pageContext : ${page1 }<br/>
		request : ${req }<br/>
		session : ${ses}<br/>
		application : ${app }<br/>
		<br />
		<button type="button" onclick="next_go();">다음페이지</button>
		
		<script>
			function next_go(){
				location.href="page_02.jsp";				
			}
		</script> 
		<script>
			alert("다음페이지로 이동합니다.");
		</script>
	</body>
</html>


<%
	request.getRequestDispatcher("/inner_object/page_02.jsp").forward(request,response);
%>




