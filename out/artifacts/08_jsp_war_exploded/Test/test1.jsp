<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    for (int i = 1; i <=9 ; i++) {
        for (int j = 1; j <=i; j++) {
%>
          <%=j+"x"+i+"="+(i*j)%>

<%
        }
        %>
<br/>
<%
    }
%>
</body>
</html>
