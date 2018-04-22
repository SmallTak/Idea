<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 权限管理</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="manage_permission"/>
    </jsp:include>

    <!-- =============================================== -->
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
               <h2> 权限管理</h2>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3>
                        权限列表
                        <small>权限列表页</small>
                    </h3>
                    <div class="box-tools">
                        <shiro:hasPermission name="permission:new">
                            <a href="/manage/permission/new" class="btn btn-default btn-sm"><i class="fa fa-plus"> </i> 新增权限</a>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body">

                    <c:if test="${not empty message}">
                        <div class="alert alert-success">${message}</div>
                    </c:if>

                    <table class="table tree">
                        <thead>
                        <tr>
                            <th>权限名称</th>
                            <th>权限代号</th>
                            <th>资源URL</th>
                            <th>类型</th>
                            <th>##</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${permissionList}" var="permission">
                                <c:choose>
                                    <c:when test="${permission.parentId==0}">
                                        <tr class="treegrid-${permission.id} treegrid-expanded">
                                            <td>${permission.permissionName}</td>
                                            <td>${permission.permissionCode}</td>
                                            <td>${permission.url}</td>
                                            <td>${permission.permissionType}</td>
                                            <td>
                                                <%--<shiro:hasPermission name="permission:edit">--%>
                                                    <a class="edit" href="javascript:;" re="${permission.id}">修改</a>
                                                <%--</shiro:hasPermission>--%>
                                                <shiro:hasPermission name="permission:delete">
                                                    <a class="del" href="javascript:;" rel="${permission.id}">删除</a>
                                                </shiro:hasPermission>
                                            </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="treegrid-${permission.id} treegrid-expanded treegrid-parent-${permission.parentId}">
                                            <td>${permission.permissionName}</td>
                                            <td>${permission.permissionCode}</td>
                                            <td>${permission.url}</td>
                                            <td>${permission.permissionType}</td>
                                            <td>
                                                <a class="edit" href="javascript:;" re="${permission.id}">修改</a>
                                                <a class="del" href="javascript:;" rel="${permission.id}">删除</a>
                                            </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
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
<%@include file="../../include/js.jsp"%>
<script type="text/javascript" src="/static/plugins/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>

    $(function () {
        $('.tree').treegrid();

        $(".del").click(function () {

            var id = $(this).attr("rel");
            layer.confirm("确定要删除么",function (index) {
                layer.close(index);
                $.get("/manage/permission/"+id+"/del").done(function (result) {
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
            var id = $(this).attr("re");
            // window.location.href="/manage/permission/edit";
           window.location.href="/manage/permission/"+id+"/edit";
            // if(result.status == 'success') {
            //     history.go(0);
            // } else {
            //     layer.msg(result.message);
            // }
            // $.get("/manage/permission/"+id+"/edit").done(function (result) {
            //     if(result.status == 'success') {
            //         history.go(0);
            //     } else {
            //         layer.msg(result.message);
            //     }
            // })

        })

    })

</script>


</body>
</html>