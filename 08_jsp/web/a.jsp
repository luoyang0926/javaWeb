<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/4/30
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--1.声明类属性--%>
<%!
    private Integer id;
    private String name;
    private Map<String, Object> map;
%>
<%--2.声明static静态代码  块--%>
<%!
    static {
      // map = new HashMap<String, Object>();
   }
%>
<%--3.声明类方法--%>
<%!
    public int abc() {
        return 12;
    }
%>
<%--4.声明内部类--%>
<%!
    public static class A{
        private Integer id;
        private  String  name;
    }
%>

<%--1 输出整形--%>
<%=12%><br/>
<%--2 输出浮点型--%>
<%=12.21%>
<%--3 输出字符串--%>
<%="hello world"%>
<%--4 输出对象--%>
<%=map%>

<%--1.代码脚本  if语句--%>
 <%
     int i=12;
     if (i == 12) {
         System.out.println("对的");
     } else {
         System.out.println("错误");
     }

 %>
<%--2.代码脚本  for循环语句--%>
<%
    for (int j = 0; j < 10; j++) {
        System.out.println(j);

    }
%>

<%--翻译后java文件中_jspservice方法内的代码都可以用--%>
<%
    String username = request.getParameter("username");
    System.out.println(username);
%>

</body>
</html>
