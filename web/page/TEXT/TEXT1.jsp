<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="/page/erropage.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int[]a={1,2,3};
    a[5]=6;
%>
<form action="/ServletDome2">
    <input type="submit" value="text">
</form>
</body>
</html>
