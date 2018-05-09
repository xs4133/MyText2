<%@ page import="Pojo.USER" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/personal.css">

    <!--引用外部js文件-->
    <script src="../js/personal.js"></script>
</head>
<body>
<%
    //requeset只能用于转发
//    String name=request.getParameter("name");
    //session用于重定向和转发
//    String name=(String) session.getAttribute("err");

    USER user=(USER)session.getAttribute("user");
    //防止非法访问
    if(user==null)
    {
        response.sendRedirect("/page/Login.jsp");
        return;
    }
%>
<header>
    <div class="header-inner">
        <div>
            <img src="../images/logo.png" alt="" width="64" height="29">
        </div>
        <div class="menu">
            <a href="#">首页</a>
            <a href="#">发现</a>
            <a href="#">话题</a>
        </div>
        <div class="search">
            <input class="search-input1" type="text" placeholder="搜索你感兴趣的内容..."/>
            <div class="search-input2"></div>
        </div>

        <!--点击提问按钮时产生单击事件，调用quiz函数-->
        <div class="btnwen" onclick="quiz()">提问</div>

        <div class="info">
            <a href="#" class="userinfo">
                <img src="../images/userinfoes.jpg"/>
            </a>
        </div>
        <div>
            <a href="#" class="userquit">退出</a>
        </div>
    </div>
</header>

<div class="main">
    <div class="cover">
        <div class="usercover"></div>
        <div class="editusercover"></div>
    </div> 编辑封面图片

    <div class="personalinfo">
        <div class="photo"></div>
        <div class="intruduce">
            <h2><%=user.getUSER_NAME()%>
                <span class="intrspan"><%=user.getUSER_CONTENT()%></span>
            </h2>
            <div id="bian" style="height:50px; overflow:hidden;">
                <div class="zhuanye"><%=user.getUSER_INDUSTRY()%></div>
                <div class="xueli"><%=user.getUSER_EDUCATION()%>|<%=user.getUSER_EDUCATION()%></div>
            </div>
            <div class="detail">
                <span class="view">查看详细资料</span>
            </div>
        </div>
        <div class="editinfo">编辑个人资料</div>
    </div>

    <div class="column">
        <ul class="tabs">
            <li class="active">动态</li>
            <li>回答</li>
            <li>分享</li>
            <li>提问</li>
            <li>收藏</li>
            <li>关注</li>
        </ul>
        <div class="dongtai">
            <h4>我的动态</h4>
        </div>
    </div>
</div>

<!-- ----- 提问的弹出框 ----- -->
<div class="Modal-wrapper" id="Modal-wrapper">
    <div class="Modal-backdrop"></div>
    <div class="Modal-large">
        <div class="Modal-inner">

            <!-- 点击关闭按钮，调用hideModel函数 -->
            <span class="guanbi" onclick="quit()">X</span>

            <h3 class="Modal-title">写下你的问题</h3>
            <div class="Modal-subtitle">描述精确的问题更易得到解答</div>
            <div class="Modal-content">
                <div class="askquestion">
                    <form action="">
                        <div class="QuestionAsk-section">
                            <div class="asktitle">
                                <textarea required="required" rows="2" class="Input" placeholder="问题标题"></textarea>
                            </div>
                        </div>
                        <div class="QuestionAsk-section">
                            <div class="asktitle">
                                <input class="Input" type="text" placeholder="添加话题"/><span class="icon-search"></span>
                            </div>
                        </div>
                        <div class="QuestionAsk-section">
                            <div class="askhead">问题描述(可选)：</div>
                            <div class="asktitle">
                                <textarea required="required" rows="2" class="Input" placeholder="问题背景、条件等详细信息"></textarea>
                            </div>
                        </div>
                        <div class="QuestionAsk-section">
                            <div class="chec"><input type="checkbox" class="checkbox"/>匿名提问</div>
                        </div>
                        <div class="tijiao">
                            <button class="tijiaobtn">提交问题</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 提问的弹出框结束 -->

</body>
</html>
