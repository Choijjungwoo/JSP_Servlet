<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<%
	Cookie cookie=new Cookie("writer","mimi");
	response.addCookie(cookie);
%>