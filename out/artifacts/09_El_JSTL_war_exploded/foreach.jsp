<%@ page import="com.sun.javafx.collections.MappingChange" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
1.遍历1到10，输出
     begin属性设置开始的索引
     end属性设置结束的索引
     var属性设置表示循环的变量
--%>
<table border="1px" cellspacing="0">
    <c:forEach begin="1" end="10" var="i">
    <tr>
        <td>第${i}行</td>
    </tr>
    </c:forEach>
</table>

<hr>

<%--2.遍历object数组
items 表示遍历的数据源（遍历的集合）
 var 表示当前遍历到的数据
--%>
<%
    request.setAttribute("arr",new String[]{"12334345","123345657","123657356"});
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item}
</c:forEach>

<%
    Map<String,Object> map=new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    map.put("key5", "value5");
    request.setAttribute("map",map);
%>
    <c:forEach items="${requestScope.map}" var="enty">

        ${enty}
    </c:forEach>


<%
    List<Person> list=new ArrayList<Person>();
    list.add(new Person(1, "老八", "123", 18, "12345445"));
    list.add(new Person(2, "老就", "1234", 12, "12345345"));
    list.add(new Person(3, "老十", "1233", 14, "12345555"));
    list.add(new Person(4, "老六", "1232", 15, "123443455"));
    list.add(new Person(5, "老四", "1233", 12, "12243455"));

   request.setAttribute("student",list);
%>
<c:forEach items="${requestScope.student}" var="li">

   <br/> ${li}<br/>
</c:forEach>
</body>
</html>
