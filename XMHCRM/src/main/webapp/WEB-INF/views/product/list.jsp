<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <title>客户列表</title>

</head>
<body>

    <div class="container col-md-push-7">

        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <div class="well-sm">
            <button id="settings" class="btn btn-default btn-sm pull-right">个人设置</button>
            <form class="form-inline form-group-sm  pull-left">

                <input type="text" name="mobile" class="form-control" placeholder="客户手机号" value="${param.mobile}"/>
                <button class="btn btn-default btn-sm ">搜索</button>
            </form>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>客户姓名</th>
                    <th>手机号</th>
                    <th>客户首次来访</th>
                    <th>客户上次来访时间</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productPageInfo.list}" var="customer">
                    <tr>
                        <td><a href="/product/${customer.id}" style="text-decoration:none">${customer.custName}</a></td>
                        <td>${customer.mobile}</td>
                        <td><fmt:formatDate value="${customer.createTime}"  pattern='yyyy年MM月dd日'></fmt:formatDate></td>
                        <td><fmt:formatDate value="${customer.updateTime}"  pattern='yyyy年MM月dd日'></fmt:formatDate></td>
                        <td>
                            <a href="/product/${customer.id}/edit" style="text-decoration:none">编辑</a>
                            <a href="javascript:;" class="delLink" rel="${customer.id}" style="text-decoration:none">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h1 class="small">共${productPageInfo.total}条数据</h1>
        <%--分页--%>
        <ul id="pagination-demo" class="pagination small pull-right"></ul>
        <a href="/product/new" class="btn btn-default btn-sm" style="text-decoration:none">添加客户</a>
        <a class="btn btn-default btn-sm" href="/product"><i class="fa fa-arrow-left"></i> 返回列表</a>

    </div>

    <div class="con " style="poestion:absolute">

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
                href:"?productName="+encodeURIComponent('${param.custName}')+"&p={{number}}"
            });

            $(".delLink").click(function(){
               var id = $(this).attr("rel");
               if (confirm("确定要删除么？")){
                   window.location.href="/product/" + id + "/del";
               }
            });

            $("#settings").click(function () {
                window.location.href="/account/edit";
            });
        })

    </script>

</body>
</html>