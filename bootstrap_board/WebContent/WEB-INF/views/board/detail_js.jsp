<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>

var formObj = $("form[role='form']");
	console.log(formObj);
	$("#modifyBtn").on("click", function(){		
		formObj.attr("action", "modify");
		formObj.submit();
	});
	$("#removeBtn").on("click", function(){
		formObj.attr("action", "remove");
		formObj.attr("method", "post");
		formObj.submit();
	});
	$("#listBtn").on("click", function(){
		formObj.attr("action", "listSearch");
		formObj.submit();
	});

</script>