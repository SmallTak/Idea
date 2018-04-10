 	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>StakCRM</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
  
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/static/dist/css/skins/_all-skins.min.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
  <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Stak</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg"></p>
	<div class="alert alert-danger" hidden id="message"></div>
    <form id="loginForm" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" id="username" name="username" value="${username }" placeholder="请输入用户名手机号">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" id="password" name="password" value="${password}" placeholder="请输入密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox">
		   <%-- <c:choose>
			   	<c:when test="${not empty username}">  <!-- username表示cook里的username -->
			     	 <input type="checkbox" name="remember" checked value="remember" id="remember"> 记住账户
			   	</c:when>
			   	<c:otherwise>
		   		</c:otherwise>
		   </c:choose>  --%>
		    <label>
		    <input type="hidden" name="callback" value="${callback }">
		    	<!-- input框内c:if贼他么精妙 -->
		   		<input type="checkbox" name="remember"  <c:if test="${not empty username}">checked</c:if> value="remember" id="remember"> 记住账户
		    </label>
		  </div>
        </div>
        <!-- /.col -->
        <div class="col-offset-8 col-xs-4">
          <button type="button" id="loginBtn" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
	
		<!-- jQuery 2.2.3 -->
	<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
	<script src="/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="/static/dist/js/jquery.validate.min.js"></script>
	<script>
		$(function(){
			var callback = "${param.callback}";
			$(document).keydown(function(event){
				if(event.keyCode == 13) {
					$("#loginForm").submit();
				}
			});
			$("#loginBtn").click(function(){
				$("#loginForm").submit();		
			});
			$("#loginForm").validate({
				errorClass:'text-danger',
				errorElement:'span',
				rules:{
					username : {
						"required" : true
					},
					password : {
						"required" : true
						}
				},
				messages:{
					username:{
						"required" : "请输入手机号"
					},
					password:{
						"required" : "请输入密码"
					}
				},
				submitHandler : function(form){
					$.ajax({
						url:'/login',
						type:'post',
						data:$("#loginForm").serialize(),
						beforeSend : function(){
							$("#loginBtn").text("登录中...").attr("disabled","disabled");
						},
						success : function(data){
							if(data.state == 'success') {
								if(callback){
									window.location.href = callback;
								}else {
									window.location.href = "/home";
								}
							} else {
								$("#message").text(data.message).show();
							}
						},
						/* 该错误是再系统异常的时候菜执行的，并不是账户密码不匹配的时候执行的 */
						error : function(){
							alert("系统异常");
						},
						complete : function(){
							$("#loginBtn").text("登录").removeAttr("disabled");
						}
					});
				}
			});
		});	
	</script>
</body>
</html>
