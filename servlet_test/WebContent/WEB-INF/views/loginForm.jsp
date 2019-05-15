<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
		
		<style>
			.content-body{
				width:640px;
			}
		</style>
	</head>
	<body>
		<div class="wrap">
			<div class="content-header">
				<h1>로그인</h1>
				<hr/>
			</div><!-- end content-header  -->
			<div class="content-body">	
				<table>
				<form action="login" method="post">
					<tr>
						<td>아이디</td>
						<td>
							<input role="text" type='text' name="id" value="${param.id }"/>
						</td>
					</tr>
					<tr style="height:10px;"></tr>
					<tr>
						<td>패스워드</td>
						<td>
							<input role="text" type="password" name="pwd" value="${param.pwd }"/>
						</td>					
					</tr>
					<tr style="height:50px;">
						<td style="height:50px;" colspan="2">
							<input style="height:50px;margin-top:30px;width:100%;" class="btn" type="submit" value="로그인" />
						</td>
					</tr>
				</form>				 
				</table>
						
			</div><!-- end content-body -->
		</div><!-- end wrap -->	
		
		<script>
			var message="${message}";
			if(message!=""){
				alert(message);
			}
		</script>
	</body>
</html>






