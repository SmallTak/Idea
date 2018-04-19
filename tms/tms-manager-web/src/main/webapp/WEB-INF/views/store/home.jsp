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
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">销售点列表</h3>
                    <div class="box-tools">
                        <a href="/ticketstore/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增销售点</a>
                    </div>
                </div>
                <div class="box-body">

                    <c:if test="${not empty message}">
                        <div class="alert alert-success">${message}</div>
                    </c:if>

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
                            <tr>
                                <c:forEach items="${ticketStroeList}" var="ticketStroe">
                                    <td>${ticketStroe.stroeName}</td>
                                    <td>${ticketStroe.stroeManager}</td>
                                    <td>${ticketStroe.stroeMobile}</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                            <%--<shiro:hasPermission name="permission:edit">--%>
                                        <a class="edit" href="javascript:;" rel="${ticketStroe.id}">修改</a>
                                            <%--</shiro:hasPermission>--%>
                                            <%--<shiro:hasPermission name="permission:delete">--%>
                                        <a class="del" href="javascript:;" rel="${ticketStroe.id}">删除</a>
                                            <%--</shiro:hasPermission>--%>
                                    </td>
                                </c:forEach>

                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script type="text/javascript" src="/static/plugins/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/layer/layer.js"></script>

<script>

    $(function () {

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