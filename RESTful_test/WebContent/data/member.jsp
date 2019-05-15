<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%--
{
	"id":"kim",
	"pwd":"kim12345",
	"email":"kim1234@naver.com",
	"phone":"01012345678"
}
--%>

{
	"id":"${member.id}",
	"pwd":"${member.pwd}",
	"email":"${member.email}",
	"phone":"${member.phone}"
}





