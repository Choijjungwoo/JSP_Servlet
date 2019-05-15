<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!-- HTML 주석 -->

<%--
<% %> : 자바문법 (스크립틀릿)

<% out.print(""); %> : <%= 값 %> : 표현식

<%! %> : 선언식 : 본 JSP 의 .java 
클래스의 멤버로 내장객체 사용불가

 --%>  
 
<% 	
	// 스크립틀릿 : _jspService(req,resp) 안에 들어감
	
	int k=1;
	String str="안녕하세요<br/>";
	System.out.print(k);
	
%> 

<%=str %> <%--out.print() 대체, _jspService(req,resp) 안에 들어감 --%>

<%! 
	//선언자 : 클래스 필드 영역
	private int y=1; 
	{
		System.out.println(y);
	} 

	public void setY(int y){
		this.y=y;
	}
%>

<h1>구구단</h1>

<%
	for(int dan=2;dan<10;dan++){
		%>
		<h3><%=dan %>단 입니다.</h3>
		<%
		for(int gop=1;gop<10;gop++){
		%>
		<li><%=dan %> * <%=gop %> = <%=dan*gop %></li>
		<%	
		}
		%>
		<br/>
		<%
	}
%> 
 

 
 
 
 
 
 
 