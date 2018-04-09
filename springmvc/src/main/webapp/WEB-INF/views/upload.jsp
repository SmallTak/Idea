<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10483
  Date: 2018/4/9
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <c:if test="${not empty message}">
        <div style="color: #00FF66">${message}</div>
    </c:if>

    <form method="post" enctype="multipart/form-data">
        <input type="text" name="name" autofocus><br>
        <input type="file" name="file"><br>
        <button>fileUpload</button>
    </form>

</body>
</html>
