<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
</head>
<body>

   <div class="container">
       <h3>${customer.custName}</h3>
       <ul class="list-group">
           <li class="list-group-item">
               手机号：${customer.mobile}
           </li>
           <li class="list-group-item">
               上次来访时间:
               <fmt:formatDate value="${customer.updateTime}"  pattern='yyyy年MM月dd日'></fmt:formatDate>
           </li>
           <li class="list-group-item">
               客户备注:
               <textarea class="form-control" onresize="true" name="custText" style="resize: none ">
                   ${customer.custText}</textarea>
           </li>
           <li class="list-group-item">
               <a style="text-decoration:none" href="/product"><i class="fa fa-arrow-left"></i> 返回列表</a>
           </li>

       </ul>

   </div>
</body>
</html>