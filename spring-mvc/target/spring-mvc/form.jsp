<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-12-04
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        第一个名字: <input type="text" name="userList[0].username" ><br>
        第一个年龄:<input type="text" name="userList[0].age" ><br>
        第二个名字: <input type="text" name="userList[1].username" ><br>
        第二个年龄:<input type="text" name="userList[1].age" ><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
