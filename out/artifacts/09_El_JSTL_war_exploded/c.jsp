<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student student=new Student();
    student.setName("老八");
    student.setPhones( new String[] {"123214","123345","1343456"});
    List<String> cities = new ArrayList<String>();
    cities.add("北京");
    cities.add("南京");
    cities.add("上海");
    cities.add("新疆");
    student.setCities(cities);

    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    student.setMap(map);

    pageContext.setAttribute("student",student);
%>

${student}
${student.name}
</body>
</html>
