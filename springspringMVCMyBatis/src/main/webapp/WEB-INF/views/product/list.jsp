<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <title>商品列表</title>
</head>
<body>

    <div class="container col-md-push-7">
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <a href="/product/new" class="btn btn-default pull-right">添加商品</a>
        <table class="table">
            <thead>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品市场价</th>
                    <th>产地</th>
                    <th>所属分类</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productPageInfo.list}" var="product">
                    <tr>
                        <td><a href="/product/${product.id}">${product.productName}</a></td>
                        <td>${product.price}</td>
                        <td>${product.marketPrice}</td>
                        <td>${product.place}</td>
                        <td>${product.productType.typeName}</td>
                        <td>
                            <a href="/product/${product.id}/edit">编辑</a>
                            <a href="javascript:;" class="delLink" rel="${product.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%--分页--%>
        <ul id="pagination-demo" class="pagination pull-right"></ul>
    </div>

    <script src="/static/bootstrap/js/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/bootstrap/js/jquery.twbsPagination.js"></script>
    <script src="/static/bootstrap/js/layer.js"></script>

    <script>

        $(function () {
            /*分页*/
            $('#pagination-demo').twbsPagination({
                totalPages: ${productPageInfo.pages},
                visiblePages: 10,
                first:'首页',
                last:'末页',
                prev:'上一页',
                next:'下一页',
                href:"?p={{number}}"
            });

            $(".delLink").click(function(){
               var id = $(this).attr("rel");
               if (confirm("确定要删除么？")){
                   window.location.href="/product/" + id + "/del";
               }
            });
        })

    </script>

</body>
</html>