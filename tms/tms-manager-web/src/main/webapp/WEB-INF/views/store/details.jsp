<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点详情</title>
    <%@include file="../include/css.jsp"%>
    <style>
        .photo {
            width: 100%;
            height: 320px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 320px;
        }
    </style>
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
                售票点详情
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-tools">

                </div>
                <div class="box-header">

                    <h3 class="box-title">售票点信息</h3>

                    <div class="box-tools">
                        <a href="/ticketstore" class="btn btn-default btn-sm">返回</a>
                        <a href="/ticketstore/${ticketStroe.id}/edit" class="btn btn-default btn-sm"><i class="fa fa-pencil"></i> 编辑</a>
                        <a href="javascript:;" id="del" rel="${ticketStroe.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> 删除</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tbody>
                        <tr style="color: #006600">
                            <td class="text-muted">售票点名称</td>
                            <td >${ticketStroe.stroeName}</td>
                            <td class="text-muted">联系人</td>
                            <td >${ticketStroe.stroeManager}</td>
                            <td class="text-muted">联系电话</td>
                            <td >${ticketStroe.stroeMobile}</td>
                        </tr>
                        <tr style="color: #006600">
                            <td class="text-muted">地址</td>
                            <td colspan="3" >${ticketStroe.stroeAddress}</td>
                            <td class="text-muted">创建时间</td>
                            <td ><fmt:formatDate value="${ticketStroe.createTime}"/></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">关联账号</h3>
                    <div class="box-tools">

                        <c:choose>
                            <c:when test="${stroeAccount.stroeState == '禁用'}">
                                <a href="javascript:;" id="enable" rel="${ticketStroe.id}" class="btn btn-success btn-sm"><i class="fa fa-key"></i> 启用账户</a>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:;" hidden id="prohibited" rel="${ticketStroe.id}" class="btn btn-danger btn-sm"><i class="fa fa-ban"></i> 禁用账户</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <tr style="color: #006600">
                            <td class="text-muted">账号</td>
                            <td >${stroeAccount.stroeAccount}</td>
                            <td class="text-muted">状态</td>
                            <td >${stroeAccount.stroeState}</td>
                            <td class="text-muted">创建时间</td>
                            <td><fmt:formatDate value="${stroeAccount.createTime}"/></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">关联资质</h3>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="photo">
                                <img src="http://p7iva9054.bkt.clouddn.com/${ticketStroe.stroeManagerAttachment}-save" alt="">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="photo">
                                <img src="http://p7iva9054.bkt.clouddn.com/${ticketStroe.stroeAttachment}-save" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        
        $("#del").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要删除么？",function (index) {
                layer.close(index);
                $.get("/ticketstore/"+ id +"/del").done(function (result) {
                    if(result.status == 'success') {
                        history.back();
                    } else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                });
            })
        })
        
        $("#enable").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要启用么？",function (index) {
                layer.close(index);
                $.get("/ticketstore/"+id+"/prohibited").done(function (result) {
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

        $("#prohibited").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要禁用么？",function (index) {
                layer.close(index);
                $.get("/ticketstore/"+id+"/prohibited").done(function (result) {
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
        
    });
</script>
</body>
</html>