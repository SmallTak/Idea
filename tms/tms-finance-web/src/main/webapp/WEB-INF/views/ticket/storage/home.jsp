<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 年票入库</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="ticket_storage"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票入库
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <c:if test="${not empty message}">
                    <div class="alert alert-danger">${message}</div>
                </c:if>
                <div class="box-header">
                    <h3 class="box-title">入库列表</h3>
                    <div class="box-tools">
                        <a href="/ticket/storage/new" class="btn btn-sm btn-success"><i class="fa fa-plus"></i> 新增入库</a>
                    </div>

                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>入库时间</th>
                            <th>内容</th>
                            <th>起始票号</th>
                            <th>截至票号</th>
                            <th>数量</th>
                            <th>入库人</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ticketInRecordList}" var="list">
                                <tr style="color: #006600">
                                    <td><fmt:formatDate value="${list.createTime}"/></td>
                                    <td>${list.content}</td>
                                    <td>${list.beginTicketNum}</td>
                                    <td>${list.endTicketNum}</td>
                                    <td>${list.totalNum}</td>
                                    <td>${list.accountName}</td>
                                    <td>
                                        <a class="delLink" rel="${list.id}" href="javascript:;">删除</a>
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
<script src="/static/plugins/layer/layer.js"></script>
   <script>

       $(function () {
           $(".edit").click(function () {
                var id = $(this).attr("rel");
               window.location.href = "/ticket/storage/"+id+"/edit"
           })

           $(".delLink").click(function () {
               var id = $(this).attr("rel");
               layer.confirm("确定眼删除么？",function (index) {
                   layer.close(index);
                   $.get("/ticket/storage/"+id+"/del").done(function (result) {
                       if (result.status == 'success'){
                           history.go(0);
                       }else{
                           layer.msg(result.message);
                       }
                   }).error(function () {
                       layer.msg("服务器忙");
                   })
               });
           })
       })

   </script>

</body>
</html>