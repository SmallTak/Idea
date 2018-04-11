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

        <div class="well-sm">
            <form class="form-inline form-group-sm  pull-right">

                <input type="text" name="productName" class="form-control" placeholder="商品名称" value="${param.productName}"/>
                <input type="text" name="place" class="form-control" placeholder="产地" value="${param.place}"/>
                <input type="text" name="minPrice" class="form-control" placeholder="最低价格" value="${param.minPrice}">
                <input type="text" name="maxPrice" class="form-control" placeholder="最高价格" value="${param.maxPrice}">
                <select name="typeId" class="form-control">
                    <option value="">所属分类</option>
                    <c:forEach items="${typeList}" var="type">
                        <option value="${type.id}" >${type.typeName}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-default btn-sm ">搜索</button>
            </form>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品市场价</th>
                    <th>产地</th>
                    <th>所属分类</th>
                    <a href="/product/new" class="btn btn-red pull-lift small" style="text-decoration:none">添加商品</a>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productPageInfo.list}" var="product">
                    <tr>
                        <td><a href="/product/${product.id}" style="text-decoration:none">${product.productName}</a></td>
                        <td>${product.price}</td>
                        <td>${product.marketPrice}</td>
                        <td>${product.place}</td>
                        <td>${product.productType.typeName}</td>
                        <td>
                            <a href="/product/${product.id}/edit" style="text-decoration:none">编辑</a>
                            <a href="javascript:;" class="delLink" rel="${product.id}" style="text-decoration:none">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1 class="small">共${productPageInfo.total}条数据</h1>
        <%--分页--%>
        <ul id="pagination-demo" class="pagination pull-right"></ul>
    </div>

    <script src="/static/bootstrap/js/jquery.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <%--分页插件若出问题修改为twbsPagination.min.js--%>
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
                href:"?productName="+encodeURIComponent('${param.productName}')+"&place="+encodeURIComponent('${param.place}')+"&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}&typeId=${param.typeId}&p={{number}}"
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