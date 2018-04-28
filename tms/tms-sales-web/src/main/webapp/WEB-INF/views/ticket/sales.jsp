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
            width: 400px;
        }
        .photo {
            width: 100%;
            height: 250px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 250px;
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
                    <c:if test="${not empty message}">
                        <div class="alert alert-info">${message}</div>
                    </c:if>
                    <form method="post">
                        <input type="hidden" name="customerCardPositive" id="customerCardPositive">
                        <input type="hidden" name="customerCardCounter" id="customerCardCounter">
                        <input type="hidden" name="customerPhoto" id="customerPhoto">
                        <div class="form-group">
                            <label>年票号</label>
                            <input type="text" name="ticketNum" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>年票价格</label>
                            <input type="text" name="ticketPrice" class="form-control">
                        </div>
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
                                <div id="picker">身份证正面照</div>
                                <div class="photo" id="CardPositive"></div>
                            </div>
                            <div class="col-md-4">
                                <div id="picker2">身份证反面照</div>
                                <div class="photo" id="CardCounter"></div>
                            </div>
                            <div class="col-md-4">
                                <div id="picker3">客户一寸免冠照</div>
                                <div class="photo" id="custPhoto"></div>
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

        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',

            // 文件接收服务端。
            server: '/file/upload',
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
        var index = -1;
        uploader.on( 'uploadStart', function( file) {
            index = layer.load(1);
        });

        uploader.on( 'uploadSuccess', function( file, response ) {
            $("#CardPositive").html("");
            if (response.status == 'success'){

                var fileName = response.data;

                var $img = $("<img>").attr("src","/file/download?fileId="+fileName).attr("width","200");
                $img.appendTo($("#CardPositive"));

                //将文件key值防御到隐藏域中去
                $("#customerCardPositive").val(fileName);

                layer.msg("证件上传成功");
            }else {
                layer.msg(response.message)
            }

        });

        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常")
        });

        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index)
        });

        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',

            // 文件接收服务端。
            server: '/file/upload',
            fileVar:'file',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker2',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        var index = -1;
        uploader.on( 'uploadStart', function( file) {
            index = layer.load(1);
        });

        uploader.on( 'uploadSuccess', function( file, response ) {
            $("#CardCounter").html("");
            if (response.status = 'success'){
                var fileName = response.data;
                var $img = $("<img>").attr("src","/file/download?fileId="+fileName).attr("width","200");
                $img.appendTo("#CardCounter");

                $("#customerCardCounter").val(fileName)
                layer.msg("证件上传成功")
            }else {
                layer.msg(response.message)
            }

        });

        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常")
        });

        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index)
        });

        var uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: true,

            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',

            // 文件接收服务端。
            server: '/file/upload',
            fileVar:'file',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker3',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        var index = -1;
        uploader.on( 'uploadStart', function( file) {
            index = layer.load(1);
        });

        uploader.on( 'uploadSuccess', function( file, response ) {
            $("#custPhoto").html("");
            if (response.status = 'success'){
                var fileName = response.data;
                var $img = $("<img>").attr("src","/file/download?fileId="+fileName).attr("width","200");
                $img.appendTo($("#custPhoto"));
                $("#customerPhoto").val(fileName);
                layer.msg("证件上传成功");

            }else{
               layer.msg(response.message);
            }
        });
        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常")
        });
        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index)
        });

    })
    
</script>

</body>
</html>