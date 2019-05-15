<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<head>
	<style>
		table th,td{
			text-align:center;
		}
	</style>
</head>	
	

  <c:set var="pageMaker" value="${dataMap.pageMaker }" />	
  	
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        자유게시판
        <small>List</small>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button id='newBtn' class="btn btn-primary"
        	    onclick="javascript:location.href='regist';">글등록</button>
      </h1>
      <ol class="breadcrumb">
        <li><a href="list"><i class="fa fa-dashboard"></i>자유게시판</a></li>
        <li class="active">목록</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
		<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">Board List all page</h3>						
					</div>
					<div class="box-body">
						<table class="table table-bordered">
							<tr>
								<th class="col-sm-1">번 호</th>
								<th class="col-sm-6">제 목</th>
								<th class="col-sm-2">작성자</th>
								<th class="col-sm-2">등록일</th>
								<th class="col-sm-1">조회수</th>
							</tr>							
							<c:forEach items="${dataMap.boardList }" var="board">
								<tr>
									<td>${board.bno }</td>
									<td style="text-align:left;">
									<a href="detail${pageMaker.makeQuery(pageMaker.cri.page) }&bno=${board.bno }">${board.title }</a>
									</td>
									<td>${board.writer }</td>
									<td>${board.regDate }</td>
									<td><span class="badge bg-red">${board.viewcnt }</span></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="box-footer">
						<div class="text-center">
							<ul class="pagination">
									
								<li><a href="${pageMaker.makeQuery(1)}">&lt;&lt;</a>						
								<li>
									<a href="listCri
									<c:if test="${pageMaker.prev }">
										${pageMaker.makeQuery(pageMaker.startPage-1) }
									</c:if>
									">&lt;</a>
								</li>
								
								<c:forEach begin="${pageMaker.startPage }" 
								           end="${pageMaker.endPage }" var="pageNum">
								<li <c:out value="${pageMaker.cri.page == pageNum?'class =active':''}"/>>
									<a href="listCri${pageMaker.makeQuery(pageNum) }" >${pageNum }</a></li>
								</c:forEach>
								<li><a href="listCri
								<c:if test="${pageMaker.next }">
									${pageMaker.makeQuery(pageMaker.endPage+1) }
								</c:if>
								<c:if test="${!pageMaker.next }">
									${pageMaker.makeQuery(pageMaker.cri.page) }
								</c:if>
								">&gt;</a></li>
								<li><a href="listCri${pageMaker.makeQuery(pageMaker.realEndPage) }">&gt;&gt;</a>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>







  