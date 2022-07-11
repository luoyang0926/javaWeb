<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope2页面</h1>
pageContext域是否有值：<%=pageContext.getAttribute("key")%> <br/>
request域是否有值：<%=pageContext.getAttribute("key")%> <br/>
session域是否有值：<%=pageContext.getAttribute("key")%> <br/>
application域是否有值：<%=pageContext.getAttribute("key")%> <br/>

</body>
</html>
