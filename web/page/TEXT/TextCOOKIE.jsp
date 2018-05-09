<%@ page import="javax.swing.tree.DefaultTreeCellEditor" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    String s=(String)session.getAttribute("date");
    if(s==null){
        s="";
    }
%>
<form action="/ServletCookie2" method="post">
    用户名：<input type="text" name="name">
    <input type="submit"value="comm">
    <h1><%=s%></h1>
</form>
</body>
</html>
