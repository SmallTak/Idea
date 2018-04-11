<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/bootstrap/css/AdminLTE.min.css">
    <title></title>
</head>
<body >
    <div class="login-box">
        <div class="login-box-body">
            <p class="login-box-msg"></p>
            <div class="alert alert-danger" hidden id="message"></div>
            <form id="loginForm" method="post" action="/account/edit">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" id="username" name="mobile" value="${username}" placeholder="电话号码">
                    <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" id="password" name="password" value="" placeholder="密码">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>

                <button type="button" id="loginBtn" class="btn btn-default btn-block btn-flat">提交</button>

            </form>

        </div>
    </div>

    <script src="/static/bootstrap/js/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/bootstrap/js/jquery.twbsPagination.js"></script>
    <script src="/static/bootstrap/js/layer.js"></script>

    <script>

       $(function () {
           $(document).keydown(function(event){
               if(event.keyCode == 13) {
                   $("#loginForm").submit();
               }
           })

           $("#loginBtn").click(function(){
               $("#loginForm").submit();
           });
       })

    </script>
</body>
</html>