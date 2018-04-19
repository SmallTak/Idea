<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 角色管理</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="manage_roles"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->


        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <section class="content-header">
                    <h2> 角色管理</h2>
                </section>
                    <div class="box-tools">
                        <shiro:hasPermission name="roles:new">
                            <a href="/manage/roles/new" class="btn btn-default btn-sm"><i class="fa fa-plus"> </i> 新增角色</a>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table tree">
                        <tbody>
                            <c:forEach items="${rolesList}" var="roles">
                                <tr class="bg-gray-active">
                                    <td>角色名称：${roles.rolesName}
                                        <span class="pull-right">
                                           <%--<shiro:hasPermission name="roles:edit">--%>
                                               <a href="/manage/roles/${roles.id}/edit">编辑</a>
                                           <%--</shiro:hasPermission>--%>
                                            <shiro:hasPermission name="roles:delete">
                                            <a class="delLink" rel="${roles.id}" href="javascript:;">删除</a>
                                            </shiro:hasPermission>
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <c:forEach items="${roles.permissionList}" var="per">
                                           <i class="fa fa-circle"></i> ${per.permissionName}
                                        </c:forEach>
                                    </td>
                                </tr>
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
        
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要删除么？",function (index) {
                layer.close(index);
                $.get("/manage/roles/" + id + "/del").done(function (result) {
                    if (result.status == 'success'){
                        history.go(0);
                    }else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器繁忙。");
                })
            })
        })
    })

</script>


</body>
</html>