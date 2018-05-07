<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title></title>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/AdminLTE.min.css">

</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>凯盛软件</b></a>
    </div>
        <div class="login-box-body">
            <p class="login-box-msg"></p>
            <div class="alert alert-danger" hidden id="message"></div>
                <form id="loginForm" method="post" action="/account/login">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" id="username" name="mobile" value="${username}" placeholder="电话号码">
                        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" id="password" name="password" value="" placeholder="密码">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"  name="remember"
                                    <c:if test="${not empty username}"> checked</c:if>
                                           value="remember" id="remember"> 记住账号
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

        <script src="/static/bootstrap/js/jquery.min.js"></script>
        <script src="/static/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/bootstrap/js/jquery.twbsPagination.js"></script>
        <script src="/static/bootstrap/js/layer.js"></script>

    <script>
        $(function(){
            var callback = "${param.callback}";

            $(document).keydown(function(event){
                if(event.keyCode == 13) {
                    $("#loginForm").submit();
                }
            })

            $("#loginBtn").click(function(){
                $("#loginForm").submit();

            });

            /*$("#loginForm").validate({
                errorClass : 'text-danger',
                errorElement : 'span',
                rules : {
                    username :{
                        "required" : true
                    },
                    password : {
                        "required" : true
                    }
                },
                messages :{
                    username :{
                        "required" : "请输入用户名"
                    },
                    password : {
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
                           window.location.href = "/account/home";
                        },
                        error : function(){
                            alert("系统异常");
                        },
                        complete : function(){
                            $("#loginBtn").text("登录").removeAttr("disabled");
                        }
                    });
                }

            });*/
        })
    </script>

</body>
</html>