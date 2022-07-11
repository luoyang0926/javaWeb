<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
     //pageContext.setAttribute("key", "pageContext");
     request.setAttribute("key", "request");
     session.setAttribute("key", "session");
     application.setAttribute("key", "application");
 %>
${key}
</body>
</html>
