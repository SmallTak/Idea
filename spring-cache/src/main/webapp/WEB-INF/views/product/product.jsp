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
</head>
<body>

   <div class="container">
       <h3>${product.productName}</h3>
       <ul class="list-group">
           <li class="list-group-item">
               价格：${product.price}
           </li>
           <li class="list-group-item">
               市场价格：${product.marketPrice}
           </li>
           <li class="list-group-item">
               产地：${product.place}
           </li>
           <li class="list-group-item">
               <a style="text-decoration:none" href="/product"><i class="fa fa-arrow-left"></i> 返回列表</a>
           </li>

       </ul>

   </div>
</body>
</html>