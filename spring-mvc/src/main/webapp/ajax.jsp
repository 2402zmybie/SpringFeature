<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-12-04
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"/>
    <script>
        console.log("${pageContext.request.contextPath}/js/jquery-3.3.1.js")
        var userList = new Array();
        userList.push({username: "张三", age: 18})
        userList.push({username: "李四", age: 28})
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/quick15",
            data: JSON.stringify(userList),
            contentType: "application/json;charset=utf-8"
        })
    </script>
</head>
<body>

</body>
</html>
