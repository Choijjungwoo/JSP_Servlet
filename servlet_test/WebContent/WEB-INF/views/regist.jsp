<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css"/>				
	</head>
	<body>
		<div class="wrap">
			<div class="content-header">
				<h1>회원가입</h1>
				<hr/>
			</div><!-- end content-header -->
			<div class="content-body">				
				<table >
					<form role="form"> 
					<tr>
						<td>아이디</td>
						<td>
							<input role="text" type="text" name="id" />
							<button class="btn btn-warnning" type="button" id="idCheckBtn">중복확인</button>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input role="text" type="password" name="pwd" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input role="text" type="email" name="email" /></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					
					<tr>
						<td>전화번호</td>
						<td>
							<select name="phone">
								<option value="">-선택-</option>
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="012">012</option>								
							</select>
							-
							<input role="phone" type="text" name="phone" />
							-
							<input role="phone" type="text" name="phone" />
						</td>
					</tr>
					<tr>
						<td>														
						</td>
						<td>							
						</td>
					</tr>
					</form>
				</table>
				<ul class="btnArea">
					<li>
						<button style="width:180px;height:50px;line-height:50px;font-size:1.5em;"class="btn btn-confirm" type="button" id="registBtn">가입하기</button>
					</li>
					<li>
						<button style="width:180px;height:50px;line-height:50px;font-size:1.5em;" class="btn btn-primary" type="button" id="cancelBtn">취&nbsp;&nbsp;소 </button>
					</li>					
				</ul>
			</div><!-- end content-body -->
		</div><!-- end wrap -->
		
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$('#idCheckBtn').click(function(){
			alert("중복확인");
		});
		$('#registBtn').on('click',function(e){
			var form=$('form[role="form"]');
			
			//유효성 처리
			
			
			form.attr("action","regist");
			form.attr("method","post");
			form.submit();
		});
		$('#cancelBtn').on('click',function(e){
			alert("취 소");
		});
	</script>
	
		
	</body>
</html>





