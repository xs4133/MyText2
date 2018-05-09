<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <title>注册</title>
    <link rel="stylesheet" href="../css/login.css">
    <link rel="stylesheet" href="../css/index.css">
    <script src="/js/Reg.js"></script>
</head>
<body>
<%--<%--%>
    <%--String err=(String)session.getAttribute("err");--%>
    <%--if(err==null){--%>
        <%--err="";--%>
    <%--}--%>
<%--%>--%>
<div id="particles"></div>
<div class="form">
    <table class="main-container">
        <tr>
            <td colspan="2">
                <h1 class="logo-big">知乎</h1>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <h2 class="subtitle">与世界分享你的知识、经验和见解</h2>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <form action="/ServletRegister" method="post" id="form1">
                    <div class="group-inputs">
                        <input type="text" class="input-wrapper"
                               name="name" id="d1"
                               placeholder="手机号或邮箱"
                               required>
                        <span style="position:absolute; top:9px;left:300px;width:120px">${err}</span>
                        <input type="text" class="input-wrapper border"
                               name="password"
                               placeholder="密码">
                        <input type="text" class="input-wrapper border"
                               name="password"
                               placeholder="确认密码">
                        <input type="text" class="input-wrapper border no-border-b"
                               name="truename"
                               placeholder="姓名">
                    </div>
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" class="sign" form="form1">注册知乎</button>
            </td>
        </tr>
        <tr>
            <td>
                <a href="/page/login.jsp" class="nav-slider right-side">登录</a>
            </td>
            <td>
                <a href="#" class="nav-slider left-side">修改密码</a>
            </td>
        </tr>
    </table>
    </form>
    <footer>
        <span>© 2017 知乎</span>
    </footer>
</div>
</body>
</html>
