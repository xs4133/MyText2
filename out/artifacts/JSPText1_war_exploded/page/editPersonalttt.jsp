<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/26
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <meta charset="utf-8">
    <title>编辑个人资料-知乎</title>

    <!-- rel="icon"	在sheet页中显示图标。-->
    <link rel="icon" href="../images/logo.jpg" type="image/x-icon">

    <script src="../js/editPersonal.js"></script>
    <link rel="stylesheet" href="../css/editPersonalttt%20.css">

</head>
<body>
<%
    String user=(String)session.getAttribute("user");
%>
<header>
    <div class="header-inner">
        <div class="peologo"></div>
        <div class="menu">
            <a href="#">首页</a>
            <a href="#">发现</a>
            <a href="topicdynamics.html">话题</a>
        </div>
        <div class="search">
            <form action="">
                <input class="search-input" type="text" placeholder="搜索你感兴趣的内容..."/>
                <div class="searbtn"></div>
            </form>
        </div>
        <div class="btnwen" onclick="quiz()">提问</div>
        <div class="info">
            <a href="#" class="userinfo">
                <span class="icon-bell-alt icon-large"></span>
            </a>
            <a href="#" class="userinfo">
                <span class="icon-comments icon-large"></span>
            </a>
            <a href="personal.html" class="userinfo"><img src="../images/userinfosmall.jpg"/></a>
            <a href="#" onclick="logout()" class="userinfo">退出</a>
        </div>
    </div>
</header>
<!-- 知乎头部开始 -->
<div class="header" hidden>
    <div class="wrap">
        <div class="col-2">
            <div class="logo"></div>
        </div>
        <div class="col-6">
            <div class="search">
                <form action="">
                    <input class="search-input" type="text" placeholder="搜索你感兴趣的内容"/>
                    <div class="searbtn"></div>
                </form>
            </div>
        </div>
        <div class="col-2">
            <div class="menu">
                <ul>
                    <li><a href="#">首页</a></li>
                    <li><a href="topicdynamics.html">话题</a></li>
                    <li><a href="#">发现</a></li>
                    <li><a href="#">消息</a></li>
                    <li><a href="#">我</a></li>
                </ul>
            </div>
        </div>

        <input type="tel">asdfas

        <div class="info">
            <a href="#" class="userinfo">
                <span><%=user%></span>
                <img src="../images/userinfosmall.jpg" alt="故事里的77"/>
            </a>
            <ul class="down">
                <li><a href="#">我的主页</a></li>
                <li><a href="#">私信</a></li>
                <li><a href="#">设置</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
        <div class="btnwen btn" onclick="quiz()">提问</div>
    </div>
</div>
<!-- 知乎头部结束 -->
<div class="main">
    <div class="card">
        <div class="usercover">
            <button class="icon-camera"> 编辑封面图片</button>
        </div>
        <div class="peopleinfo">
            <div class="photo"><span class="icon-camera xiugai"></span><span class="xiugaizi">修改我的头像</span></div>
            <h1 class="mar-zuo">故事里的77 <a href="personal.html" class="back">返回我的主页 <span
                    class="icon-angle-right"></span></a></h1>

            <!-- 点击修改按钮后，内容可以修改 -->

            <!-- 处理思路：去掉所有个人信息中的disabled和readonly属性 -->
            <button class="modify1" onclick="modify()">
            <span class="icon-edit" onclick="save()" >保存</span>
            </button>
            <button class="modify" onclick="modify()">
                <span class="icon-edit">修改</span>
            </button>

        </div>
        <form action="/ServletEdit" method="post" name="form1">
            <div class="intruduce">
                <div class="xinxi">

                    <div class="fild">
                        <h3 class="fildlabel">性别</h3>
                        <div class="fildcontent" >
                            <input type="radio" name="sex"  checked="checked" value="0"/>女
                            <input type="radio" name="sex" class="fildtext" id="m1" disabled value="1"/>男
                        </div>
                    </div>

                    <div class="fild">
                        <h3 class="fildlabel">居住地</h3>
                        <div class="fildcontent">

                            <!-- 省市二级连动 -->
                            <!-- 处理思路：通过select标记的onchange事件，根据省名添加市名的option选项 -->
                            <select name="province" id="province" class="select fildtext"
                                    disabled="disabled"
                                    onchange="shengshi()">
                                <option value="" selected>请选择</option>
                                <option value="辽宁省">辽宁省</option>
                                <option value="吉林省">吉林省</option>
                            </select>

                            <select name="province" id="city" class="select fildtext" disabled="disabled">
                                <option value="">请选择</option>
                            </select>
                        </div>
                    </div>
                    <div class="fild">
                        <h3 class="fildlabel">所在行业</h3>
                        <div class="fildcontent">
                            <input class="fildtext" id="job"name="hy"readonly="true" value="计算机"/>
                        </div>
                    </div>
                    <div class="fild">
                        <h3 class="fildlabel">邮箱</h3>
                        <div class="fildcontent">
                            <input class="fildtext" id="email" name="email"readonly="true" value="5588@163.com"/>
                        </div>
                    </div>
                    <div class="fild">
                        <h3 class="fildlabel">教育经历</h3>
                        <div class="fildcontent">
                            <input class="fildtext" id="education"name="education" readonly="true" value="本科"/>
                        </div>
                    </div>
                    <div class="fild">
                        <h3 class="fildlabel">出生年月</h3>
                        <div class="fildcontent">
                            <input type="date" id="birthday"name="birthday" readonly="true" class="fildtext"/>
                        </div>
                    </div>
                    <div class="fild">
                        <h3 class="fildlabel">电话</h3>
                        <div class="fildcontent">
                            <input class="fildtext" id="phone" name="phone"readonly="true" value="13945697894"/>
                        </div>
                    </div>
                    <div class="fild">
                        <h3 class="fildlabel">个人简介</h3>
                        <div class="fildcontent">
                            <textarea class="fildtext" id="introduce"name="introduce" readonly="true" rows="3" cols="30">没啥可说的</textarea>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="save-btn">
            <button class="save" id="save" hidden onclick="save()">保存</button>
        </div>
    </div>

</div>

</body>
</body>
</html>
