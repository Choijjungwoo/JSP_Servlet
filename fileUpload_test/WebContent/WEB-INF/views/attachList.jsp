<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<table>
			<tr>
				<th>번호</th>
				<th>파일명</th>
				<th>등록자</th>
				<th>등록일</th>
				<th>구분</th>
			</tr>
			<c:forEach var="attach" items="${attachList }">
				<tr>
					<td>${attach.ano }</td>
					<td>
						<a href="<%=request.getContextPath() %>/attach/get?ano=${attach.ano}">
							${attach.fileName }
						</a>
					</td>
					<td>${attach.attacher }</td>
					<td>
						<fmt:formatDate value="${attach.regDate }"
						  pattern="yyyy-MM-dd"/>
					</td>
					<td>
						<button type="button" 
						onclick="location.href='remove?pno=${param.pno }&ano=${attach.ano }';">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>






