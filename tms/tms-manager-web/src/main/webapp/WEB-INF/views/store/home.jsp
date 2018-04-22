<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点管理</title>
    <%@include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="ticket_store"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div>
                <c:if test="${not empty message}">
                    <div class="alert alert-success">${message}</div>
                </c:if>
            </div>

            <div class="box">

                <div class="box-body">
                    <form method="get" class="form-inline">
                        <input type="text" name="stroeName" class="form-control" placeholder="售票点名称" value="${param.stroeName}">
                        <input type="text" name="stroeMobile" class="form-control" placeholder="电话" value="${param.stroeMobile}">
                        <input type="text" name="stroeManager" class="form-control" placeholder="联系人" value="${param.stroeManager}">
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>

                <div class="box-header">
                    <h3 class="box-title">销售点列表</h3>
                    <div class="box-tools">
                        <a href="/ticketstore/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增销售点</a>
                    </div>
                </div>
                <div class="box-body">

                    <table class="table">
                        <thead>
                        <tr>
                            <th>销售点名称</th>
                            <th>联系人</th>
                            <th>联系电话</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${pageInfo.list}" var="ticketStroe">
                                <tr>
                                    <td><a href="/ticketstore/${ticketStroe.id}">${ticketStroe.stroeName}</a></td>
                                    <td>${ticketStroe.stroeManager}</td>
                                    <td>${ticketStroe.stroeMobile}</td>
                                   <%-- <td>
                                            &lt;%&ndash;<shiro:hasPermission name="permission:edit">&ndash;%&gt;
                                        <a class="edit" href="javascript:;" rel="${ticketStroe.id}">修改</a>
                                            &lt;%&ndash;</shiro:hasPermission>&ndash;%&gt;
                                            &lt;%&ndash;<shiro:hasPermission name="permission:delete">&ndash;%&gt;
                                        <a class="del" href="javascript:;" rel="${ticketStroe.id}">删除</a>
                                            &lt;%&ndash;</shiro:hasPermission>&ndash;%&gt;
                                    </td>--%>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <ul id="pagination-demo" class="pagination pull-right"></ul>
        <!-- /.content -->
    </div>

    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>

<script src="/static/bootstrap/js/jquery.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<%--分页插件若出问题修改为twbsPagination.min.js--%>
<script src="/static/bootstrap/js/jquery.twbsPagination.js"></script>
<script src="/static/bootstrap/js/layer.js"></script>

<script>

    $(function () {

        /*分页*/
        $('#pagination-demo').twbsPagination({
            totalPages: ${pageInfo.pages},
            visiblePages: 10,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?stroeName="+encodeURIComponent('${param.stroeName}')+"&p={{number}}"
        });


        $(".del").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要删除么？",function (index) {
                layer.close(index);
                $.get("/ticketstore/"+id+"/del").done(function (result) {
                    if(result.status == 'success') {
                        history.go(0);
                    } else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                });
                })
            })
        $(".edit").click(function () {
            var id = $(this).attr("rel");
            window.location.href="/ticketstore/"+id+"/edit";
        })

    });

</script>

</body>
</html>