<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:9000/09_El/uploadServlet" method="post" enctype="multipart/form-data">
    <input type="text" name="username"><br/>
    <input type="file" name="photo"><br/>
    <input type="submit" value="上传">


</form>

</body>
</html>
