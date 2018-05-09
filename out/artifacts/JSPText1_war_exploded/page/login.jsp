<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/login.css">
    <!--引用外部js文件-->
</head>
<body>
<%--//使用request共享数据--%/
<%--<%--%>
    <%--String err=(String)request.getAttribute("err");--%>
    <%--if(err==null){--%>
       <%--err=" ";--%>
    <%--}--%>
<%--%>--%>
    <%--//使用session共享数据--%>
<%
    String err=(String)session.getAttribute("err");
    if(err==null)
    {
        err=" ";
    }
%>

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
            <div class="group-inputs">

                <!--添加表单标记-->
                <form action="/ServletLogin" name="userinfo" id="userinfo" method="post" onsubmit="return checkErr()">
                    <input type="text" name="name"
                           class="input-wrapper" id="username"
                           placeholder="手机号或邮箱" autofocus
                          onblur=nameErrTips()
                           required
                           onfocus = clearErrTips()>

                    <div class="usernametips" id="nametips"><%=err%></div>

                    <input type="password" name="password"
                           class="input-wrapper border" id="password"
                           placeholder="密码" required
                           onblur = "passErrTips()"
                           onfocus="clearPsErrTips()">

                    <div class="passwordtips" id="passtips"></div>

                    <input type="text" name="captcha"
                           class="input-wrapper border no-border-b" id="captcha"
                           placeholder="验证码">
                    <!--添加校验事件-->

                    <!--添加提示文字-->

                    <img src="../images/captcha.gif" alt="验证码" class="captcha" style="margin-top: -28px" width="100" height="38">

                    <!--添加表单标记-->
                </form>
            </div>
        </td>
    </tr>

    <tr>
        <td colspan="2">
            <!-- 点击登录按钮时，提交表单 -->
            <button type="submit" class="sign" form="userinfo">登录</button>

            <!--其他提交方式-->
            <!--<input type="submit" value="登录" class="sign" >-->
            <!--button标记不加type属性，默认提交表单-->
            <!--<button class="sign" form="userinfo">登录</button>-->
        </td>
    </tr>

    <tr>
        <td>
            <a href="/page/register.jsp" class="nav-slider right-side">注册</a>
        </td>
        <td>
            <a href="#" class="nav-slider left-side">修改密码</a>
        </td>
    </tr>
</table>
<footer>
    <span>© 2017 知乎</span>
</footer>
</div>
</body>
</html>
