<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改商品</title>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container col-xs-push-12">
    <div class="row">
        <div class="col-md-6">
            <form method="post">
                <legend>修改客户</legend>

                <div class="form-group">
                    <label>客户名称</label>
                    <input type="text" class="form-control" name="custName" value="${customer.custName}">
                </div>
                <div class="form-group">
                    <label>客户手机号</label>
                    <input type="text" class="form-control" name="mobile" value="${customer.mobile}">
                </div>
                <div class="form-group">
                    <label>客户备注</label>
                    <textarea class="form-control" onresize="true" name="custText" style="resize: none">${customer.custText}</textarea>
                </div>

                <div class="form-group">
                    <button class="btn btn-default btn-sm">提交</button>
                    <a class="btn btn-default btn-sm" href="/product"><i class="fa fa-arrow-left"></i> 返回列表</a>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>