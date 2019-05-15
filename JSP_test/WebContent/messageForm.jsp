<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ include file="/include/header.jsp" %>

		<form action="param" method="post">
			<!-- <input type="text" name="name" /> -->
			<textArea name="name" rows="10" cols="50"></textArea>
			<input type="submit" value="전송"/>
		</form>
		
<%@ include file="/include/footer.jsp" %>