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
		<div id="display">
			<!-- <table border="" id="memberTable">
				<tr>
					<th>아이디</th>
					<th>패스워드</th>
					<th>전화번호</th>
					<th>이메일</th>
				</tr>
				
			</table> -->
		</div>
	</body>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>	
<script>
	$('#jsonBtn').on('click',function(e){
		//alert('btn click');
		$.ajax({
			url:"listJson",
			type:"get",
			contentType:"application/json",
			success:function(data){
				//alert(data);
				var table=$('<table>').attr("border","1");
				var tr=$('<tr>');
				var td1=$('<td>').text("아이디");
				var td2=$('<td>').text("패스워드");
				var td3=$('<td>').text("전화번호");
				var td4=$('<td>').text("이메일");
				tr.append(td1).append(td2).append(td3).append(td4);
				table.append(tr);
				for(var member of data.memberList){
					tr=$('<tr>');
					td1=$('<td>').text(member.id);
					td2=$('<td>').text(member.pwd);
					td3=$('<td>').text(member.phone);
					td4=$('<td>').text(member.email);
					tr.append(td1).append(td2).append(td3).append(td4);
					table.append(tr);
				}		
				$('#display').html(table);
			},
			error:function(error){}
		});
	});
</script>	
</html>









