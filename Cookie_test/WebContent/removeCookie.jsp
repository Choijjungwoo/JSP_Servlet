<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<% 
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (int i = 0 ; i < cookies.length ; i++) {	
			if(cookies[i].getName().equals("writer")){
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	}

%>