<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 售票点缴费</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="finance_ticket"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点缴费
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <%--<div class="box">
                <div class="box-body">
                    <form class="form-inline">
                        <select name="state" class="form-control">
                            <option ${param.state == '未支付' ? 'selected' : ''} value="未支付">未支付</option>
                            <option ${param.state == '已支付' ? 'selected' : ''} value="已支付">已支付</option>
                        </select>
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>--%>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">缴费列表</h3>
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
                            <th>支付方式</th>
                            <th>下发人</th>
                            <th>状态</th>
                            <th>收款人</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty pageInfo.list}">
                                <tr>
                                    <td colspan="13">暂无记录</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${pageInfo.list}" var="record">
                                <tr>
                                    <td><fmt:formatDate value="${record.createTime}"/></td>
                                    <td>${record.ticketStoreAccountname}</td>
                                    <td>${record.content}</td>
                                    <td>${record.beginTicketNum}</td>
                                    <td>${record.endTicketNum}</td>
                                    <td>${record.ticketNum}</td>
                                    <td>${record.ticketPrice}</td>
                                    <td>${record.ticketTotalPrice}</td>
                                    <td>${record.paymentMethod}</td>
                                    <td>${record.ticketOutAccountName}</td>
                                    <td>
                                        <span class="label ${record.ticketState == '未支付' ? 'label-danger' : 'label-success'}">${record.ticketState}</span>
                                    </td>
                                    <td>${record.financeAccountName}</td>
                                    <td>
                                        <c:if test="${record.ticketState == '未支付'}">
                                            <a href="/finance/ticket/${record.id}/pay" class="btn btn-sm btn-success">支付</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${pageInfo.pages > 1}">
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
            totalPages: ${pageInfo.pages},
            visiblePages: 10,
            first:'首页',
            last:'末页',
            prev:'上一页',
            next:'下一页',
            href:"?p={{number}}"
        });
    });
</script>
</body>
</html>