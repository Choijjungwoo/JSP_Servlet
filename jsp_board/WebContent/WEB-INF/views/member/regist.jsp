<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<body>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        회원등록
        <small>Regist</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="list"><i class="fa fa-dashboard"></i> 회원관리</a></li>
        <li class="active">등록</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <!--------------------------
        | Your Page Content Here |
        -------------------------->
       
		<div class="register-box"> 
            <!-- form start -->
            <form role="form" class="form-horizontal" action="regist" method="post">
              <div class="register-box-body" style="margin-bottom:0px;">
                <div class="form-group">
                  <label for="id" class="col-sm-3 control-label">아이디</label>

                  <div class="col-sm-9">
                    <input name="id" type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
                  </div>
                </div>
                <div class="form-group">
                  <label for="pwd" class="col-sm-3 control-label">패스워드</label>

                  <div class="col-sm-9">
                    <input name="pwd" type="password" class="form-control" id="pwd" placeholder="20글자 영문자,숫자,특수문자 조합">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="email" class="col-sm-3 control-label">이메일</label>

                  <div class="col-sm-9">
                    <input name="email" type="email" class="form-control" id="email" placeholder="example@naver.com">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="phone" class="col-sm-3 control-label">전화번호</label>
                  <div class="col-sm-9">   
                  	<div class="col-sm-4" style="padding:0;">               
	                  <select name="phone" id="phone" class="form-control" >
	                    <option value="">-선택-</option>
	                    <option value="010">010</option>
	                    <option value="011">011</option>
	                    <option value="017">017</option>
	                    <option value="018">018</option>
	                  </select>
	                 </div>
	                 <div class="col-sm-4" style="padding:0;">
	                  <label class="col-sm-3"style="padding:0;text-align:center;">-</label>
	                  <div class="col-sm-9" style="padding:0;">
	                 	<input name="phone" type="text" class="form-control"/>
	                  </div> 
	                 </div>               	 
	                 <div class="col-sm-4" style="padding:0;">
	                  <label class="col-sm-3"style="padding:0;text-align:center;">-</label>
	                  <div class="col-sm-9" style="padding:0;">
	                 	<input name="phone" type="text" class="form-control"/>
	                  </div> 
	                 </div>
                  </div>                  
                </div>               
              </div>            
	          <div class="box-footer login-box" style="margin-top:0;border-top:none;" >
	          	<button type="button" id="registBtn" class="btn btn-info col-sm-3">가입하기</button>
	            <button type="button" id="cancelBtn" class="btn btn-default pull-right col-sm-3">취 소</button>
	      	  </div>
      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
   
<script>
	$('#registBtn').on('click',function(e){
		var form=$('form[role="form"]');
		form.submit();
	});	
	$('#cancelBtn').on('click',function(e){
		location.href="list";
	});
</script>
   
</body>






  
  