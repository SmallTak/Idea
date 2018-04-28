<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 年票办理</title>
    <%@include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <style>
        .form-control {
            width: 300px;
        }
        .photo {
            height: 250px;
            border: 2px dashed #ccc;
        }
    </style>
</head>
<body class="hold-transition skin-black-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhead.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="ticket_sales_new"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">年票办理</h3>
                </div>
                <div class="box-body">
                    <form method="post">
                        <div class="form-group">
                            <label>姓名</label>
                            <input type="text" name="customerName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>年龄</label>
                            <input type="text" name="customerAge" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <select name="customerSex" class="form-control">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>联系电话</label>
                            <input type="text" name="customerMobile" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>住址</label>
                            <input type="text" name="customerAddress" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>身份证号</label>
                            <input type="text" name="customerIdCard" class="form-control">
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div id="picker">选择文件</div>
                                <div class="photo"></div>
                            </div>
                            <div class="col-md-4">
                                <div class="photo"></div>
                            </div>
                            <div class="col-md-4">
                                <div class="photo"></div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button id="saveForm" class="btn btn-primary pull-right">保存</button>
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
        $(".saveForm").click(function () {
            location.href="/ticket/storage";
        });

        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',

            // 文件接收服务端。
            server: '192.168.142.12:22122',
            fileVar:'file',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        //文件上传进度条
        var index = -1;
        uploader.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });

    })

</script>

</body>
</html>