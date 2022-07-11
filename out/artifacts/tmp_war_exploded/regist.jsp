<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/7
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:9000/tmp/registServlet" method="post">

    用户名:<input type="text" name="username" ><br/>
    验证码:<input type="text"style="width: 80px;" name="code"><img src="http://localhost:9000/tmp/kaptcha.jpg" style="width: 80px;"><br/>
    <input type="submit" value="登录">

</form>

</body>
</html>
