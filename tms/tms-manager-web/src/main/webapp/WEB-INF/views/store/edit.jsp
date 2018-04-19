<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 新增售票点</title>
    <%@include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <style>
        .photo {
            width: 100%;
            height: 300px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 300px;
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
                新增售票点
            </h1>
        </section>

        <div class="box-header">
            <div class="box-tools">
                <a href="/ticketstore" class="btn btn-default btn-sm">返回</a>
            </div>
        </div>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <input type="hidden" id="storeManagerAttachment" name="storeManagerAttachment">
                        <input type="hidden" id="storeAttachment" name="storeAttachment">
                        <div class="form-group">
                            <label>售票点名称</label>
                            <input type="text" class="form-control" name="stroeName" value="${ticketStroe.stroeName}">
                        </div>
                        <div class="form-group">
                            <label>售票点地址</label>
                            <input type="text" class="form-control" name="stroeAddress" value="${ticketStroe.stroeAddress}">
                        </div>
                        <div class="form-group">
                            <label>联系人</label>
                            <input type="text" class="form-control" name="stroeManager" value="${ticketStroe.stroeManager}">
                        </div>
                        <div class="form-group">
                            <label>联系电话</label>
                            <input type="text" class="form-control" name="stroeMobile" value="${ticketStroe.stroeMobile}">
                        </div>
                        <div class="box-footer">
                            <button class="btn btn-primary pull-right" id="saveBtn">保存</button>
                        </div>
                    </form>
                </div>

            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/uploader/webuploader.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>


<script>

    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
    })

</script>


</body>
</html>