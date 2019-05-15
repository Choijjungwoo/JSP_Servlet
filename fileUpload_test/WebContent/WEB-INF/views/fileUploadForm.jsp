<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일업로드하기</title>
	</head>
	<body>		
        <form method="post" action="upload" enctype="multipart/form-data">
        	<input type="hidden" name="pno" value="17461" />
        	제목 : <input type="text" name="title" /><br/>        	        	
        	작성자 : <input type="text" name="writer" value="mimi"/><br/>
        	내용 : <textArea name="content" cols="40" rows="10"></textArea>
        	<hr/>       	
        	        
            Select file to upload: <button type="button" id="addFileBtn">Add File</button>
            
            <div class="fileInput">
            	
            </div>            
            <br/><br/>
            <input type="submit" value="글등록" />
        </form>      
   	
	</body>
	
	
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <script>
  	$('#addFileBtn').on('click',function(event){
  		//alert("add File btn click");
  		
  		if($('input[name="uploadFile"]').length >=5){
  			alert("파일추가는 5개까지만 가능합니다.");
  			return;
  		}
  		
  		var input=$('<input>').attr({"type":"file",
  									 "name":"uploadFile",
  									});  		
		var div=$('<div>').addClass("inputRow");
  		div.append(input).append("<button type='button'>X</button");
  		div.appendTo('.fileInput');
  	});
  	
  	$('.fileInput').on('change','input[type="file"]',function(event){
  		if(this.files[0].size>1024*1024*40){
			alert("파일 용량이 40MB를 초과하였습니다.");
			this.value="";  				
			return false;
		} 
  	});  	
  	
  	$(document).on('submit',function(event){
  		//event.preventDefault();
  		
  		var files = $('input[name="uploadFile"]');
  		
  		for(var file of files){
  			console.log(file.name+" : "+file.value);
  			if(file.value==""){
  				alert("파일을 선택하세요.");
  				file.focus();
  				return false;
  			}
  		}
  	});
  	
  	$('div.fileInput').on('click','div.inputRow > button',
  			function(event){  		
  		//alert("X btn click;");
  		$(this).parent('div.inputRow').remove();
  		
  	});
  	
  </script>	
	
</html>










