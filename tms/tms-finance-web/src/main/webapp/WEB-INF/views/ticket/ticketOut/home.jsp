<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 年票下发</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="ticket_out"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票下发
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <c:if test="${not empty message}">
                    <div class="alert alert-danger">${message}</div>
                </c:if>
                <div class="box-header">
                    <h3 class="box-title">下发列表</h3>
                    <div class="box-tools">
                        <a href="/ticket/storage/ticketOut/new" class="btn btn-sm btn-success"><i class="fa fa-plus"> 新增下发</i></a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>下发时间</th>
                            <th>下发网点</th>
                            <th>内容</th>
                            <th>起始票号</th>
                            <th>截至票号</th>
                            <th>数量</th>
                            <th>单价</th>
                            <th>总价</th>
                            <th>下发人</th>
                            <th>状态</th>
                            <th>收款人</th>
                            <th>支付方式</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ticketOutRecordList.list}" var="ticketOutList">
                                <tr style="color: #006633">
                                    <td><fmt:formatDate value="${ticketOutList.createTime}"></fmt:formatDate></td>
                                    <td>${ticketOutList.ticketStoreAccountname}</td>
                                    <td>${ticketOutList.content}</td>
                                    <%--placeholder="账号 或 手机号码"--%>
                                    <td>${ticketOutList.beginTicketNum}</td>
                                    <td>${ticketOutList.endTicketNum}</td>
                                    <td>${ticketOutList.ticketNum}</td>
                                    <td>${ticketOutList.ticketPrice}</td>
                                    <td>${ticketOutList.ticketTotalPrice}</td>
                                    <td>${ticketOutList.ticketOutAccountName}</td>
                                    <td>
                                        <span class="label ${ticketOutList.ticketState == '未支付' ? 'label-danger' : 'label-success'}">${ticketOutList.ticketState}</span>
                                    </td>
                                    <td>${ticketOutList.paymentMethod}</td>
                                    <td>${ticketOutList.financeAccountName}</td>
                                    <td>
                                        <c:if test="${ticketOutList.ticketState == '未支付'}">
                                            <a href="javascript:;" rel="${ticketOutList.id}" class="delLink" title="取消"><i class="fa fa-trash text-danger"></i></a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${ticketOutRecordList.pages>1}">
                        <ul id="pagination-demo" class="pagination pull-right"></ul>
                    </c:if>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/jQuery/jquery.twbsPagination.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        $('#pagination-demo').twbsPagination({
            totalPages: ${ticketOutRecordList.pages},
            visiblePages: 10,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?p={{number}}"
        });

        $('.delLink').click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要取消么？",function (index) {
                layer.close(index);
                $.get("/ticket/storage/ticketOut/"+id+"/del").done(function (result) {
                    if (result.status == 'success'){
                        history.go(0);
                    }else{
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                })
            })

        })
    });
</script>
</body>
</html>