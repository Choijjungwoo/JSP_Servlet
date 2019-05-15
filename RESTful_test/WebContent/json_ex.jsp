<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<button type="button" id="jsonBtn">JSON 가져오기</button>
		<hr/>
		<div id="display"></div>
	</body>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$('#jsonBtn').on('click',function(e){
			//alert("json btn click");
			$.ajax({
				//가져올 data의 url
				//url:"data/member.jsp",
				url:"member",
				
				
				//data:보낼 data,
				
				//dataType:받는 data의 형식 ex) application/json
				
				//contentType:보내는 data의 형식 지정.
				
				type:'get', //method 방식 결정
				success:function(data){ //콜백함수:요청이 성공하면 data를 받음.
					
					var input1=
					$('<input>').attr({"type":"text","value":data.id,"name":data.id});
					var input2=
					$('<input>').attr({"type":"password","value":data.pwd,"name":data.pwd});
					var input3=
					$('<input>').attr({"type":"text","value":data.email,"name":data.email});
					var input4=
					$('<input>').attr({"type":"text","value":data.phone,"name":data.phone});
					$('#display').append(input1).append(input2).append(input3).append(input4);						
					
				},
				error:function(error){ //콜백함수 :요청/응답이 실패 error를 받음.
					
				}
				
			});
		});
		
		/* var member={
					"id":"mimi",
					"pwd":"mimi",
					"email":"mimi@naver.com",
					"phone":"01056854578"
				} */
				
		/* alert(member.id);
		
		member.id="kkk";
		alert(member.id);
		
		member.address="대전광역시";
		alert(memebr.address); */
		
		
		
	</script>
</html>








