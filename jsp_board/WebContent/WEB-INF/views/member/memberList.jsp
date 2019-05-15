<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
	<title>회원목록</title>
	<style>
		table th,td{
			text-align:center;
		}
	</style>
</head>

<body>
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        회원리스트
        <small>List</small>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-primary" id="registBtn">회원등록</button>
      </h1>
      <ol class="breadcrumb">
        <li><a href="list"><i class="fa fa-dashboard"></i> 회원관리</a></li>
        <li class="active">리스트</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
	<div class="box">
		<div class="box-body">            
             <div class="row">
             <div class="col-sm-12">
             <table class="table table-bordered">
                <thead>
                <tr role="row">
                	<th class="col-sm-1" >순번</th>
                	<th class="col-sm-2" >아이디</th>
                	<th class="col-sm-3" >패스워드</th>
                	<th class="col-sm-4" >이메일</th>
                	<th class="col-sm-2" >전화번호</th>
               	</tr>
                </thead>
                <c:forEach var="member" items="${memberList}" varStatus="status">
                	<tr>
                		<td>${status.count }</td>
                		<td>
                			<a href="detail?id=${member.id }">${member.id }</a>
                		</td>
                		<td>${member.pwd }</td>
                		<td>${member.email }</td>
                		<td>${member.phone }</td>
                	</tr>
                </c:forEach>               
              </table>
             </div>
            </div>            
           </div>
           <div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
						</ul>
					</div>
			</div>
			<!-- /.box-footer-->
       </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <script>
  	$('#registBtn').on('click',function(e){
  		location.href="regist";
  	});
  </script>	
</body>


