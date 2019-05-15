<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>회원수정</title>
<body>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        회원수정
        <small>Modify</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="list"><i class="fa fa-dashboard"></i> 회원관리</a></li>
        <li class="active">수정</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
       
		<div class="register-box"> 
            <!-- form start -->
            <form role="form" class="form-horizontal" action="modify" method="post">
              <div class="register-box-body" style="margin-bottom:0px;">
                <div class="form-group">
                  <label for="id" class="col-sm-3 control-label" >아이디</label>

                  <div class="col-sm-9">
                    <input readonly value="${member.id }" name="id" type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
                  </div>
                </div>
                <div class="form-group">
                  <label for="pwd" class="col-sm-3 control-label">패스워드</label>

                  <div class="col-sm-9">
                    <input value="${member.pwd }" name="pwd" type="password" class="form-control" id="pwd" placeholder="20글자 영문자,숫자,특수문자 조합">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="email" class="col-sm-3 control-label">이메일</label>

                  <div class="col-sm-9">
                    <input value="${member.email }" name="email" type="email" class="form-control" id="email" placeholder="example@naver.com">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="phone" class="col-sm-3 control-label">전화번호</label>
                  <div class="col-sm-9">   
                  	 <input value="${member.phone }" name="phone" type="text" class="form-control" id="phone" placeholder="- 없이 ex)01012345678" >	                 
                  </div>                  
                </div>               
              </div>            
	          <div class="box-footer login-box" style="margin-top:0;border-top:none;" >
	          	<button type="button" id="modifyBtn" class="btn btn-warning col-sm-3">수정하기</button>
	            <button type="button" id="cancelBtn" class="btn btn-default pull-right col-sm-3">취 소</button>
	      	  </div>
      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
   
<script>
	$('#modifyBtn').on('click',function(e){
		var form=$('form[role="form"]');
		form.submit();
	});	
	$('#cancelBtn').on('click',function(e){
		location.href="detail?id=${member.id}";
	});
</script>
   
</body>






  
  