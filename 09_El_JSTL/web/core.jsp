<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/5/1
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
i.<c.set/>
  作用：set标签可以向域中保存数据
  域对象.setAttribute(key,value)
  scope 属性设置保存到哪个域  page表示pageContext域
 var属性设置key是多少
  value属性设置值
--%>
保存之前：${requestScope.abc}

<c:set scope="request" var="abc" value="abcvalue"/>
保存之后：${requestScope.abc}



<%---

ii.<c:if/>
if标签用来做if判断
test属性表示判断的条件（使用EL表达式输出）
--%>
<c:if test="${12==12}">
    <h1>12等于12</h1>
</c:if>


<%--
<c:choose> <c:when> <c:otherwise>标签
作用：多路判断  跟 switch...case...default非常接近
choose标签开始选择判断
when标签表示每一种判断情况
  test属性表示当前这种判断情况的值
--%>
<%
    request.setAttribute("height",181);
%>
<c:choose>
    <c:when test="${requestScope.height>190}">
        <h2>小巨人</h2>
    </c:when><c:when test="${requestScope.height>180}">
        <h2>很高</h2>
    </c:when><c:when test="${requestScope.height>170}">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
        <h2>剩下的情况</h2>
    </c:otherwise>
</c:choose>



</body>
</html>
