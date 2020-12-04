<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-12-04
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    单文件上传:
    <form method="post" action="${pageContext.request.contextPath}/user/quick22" enctype="multipart/form-data">
        名称: <input type="text" name="username"><br>
        文件: <input type="file" name="file"><br>
        <input type="submit" value="提交">
    </form>


    <br>
    <br>
    <br>
    <br>
    <br>
    多文件上传:
    <form method="post" action="${pageContext.request.contextPath}/user/quick23" enctype="multipart/form-data">
        名称: <input type="text" name="username"><br>
        文件: <input type="file" name="files"><br>
        文件: <input type="file" name="files"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
