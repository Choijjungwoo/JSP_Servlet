<%@page import="com.java.dao.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	<c:choose>
		<c:when test="${!empty deleted_id}">
			alert("${deleted_id}님을 삭제했습니다.");	
		</c:when>
		<c:otherwise>
			alert("${param.id}님 삭제를 실패했습니다.");
		</c:otherwise>
	</c:choose>
	location.href="list";
</script>



