<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册登录</title>
    <script src="https://cdn.staticfile.org/react/16.4.0/umd/react.development.js"></script>
    <script src="https://cdn.staticfile.org/react-dom/16.4.0/umd/react-dom.development.js"></script>
    <script src="https://cdn.staticfile.org/babel-standalone/6.26.0/babel.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>
<div id="title"></div>
<div id="login">
    <form action="login" method="post">
        <div id="login1"></div>
<%--        <input type="button" onclick="button1()" value="使用邮箱登录"><input type="button" onclick="button2()" value="使用手机号登录"><br/>--%>
        <span id="loginemail">邮箱：<input type="text"  name="email"><br/></span>
        <span id="logincellphone">手机号：<input type="text"  name="cellphone"><br/></span>
        <span>密码：<input type="password" name="password"> <br/></span>
        <input style="display: none;" id="num" name="num" value="1">
        <input type="submit" value="登录">
    </form>
</div>
<div id="registered">
    <form action="registered" method="post">
        <div id="registered1"></div>
<%--        <input type="button" onclick="button3()" value="使用邮箱注册"><input type="button" onclick="button4()" value="使用手机号注册"><br/>--%>
        <span id="id"> 用户id：<input type="text"  name="userid"><br/></span>
        <span id="name"> 用户名：<input type="text"  name="username"><br/></span>
        <span id="registeredemail"> 邮箱：<input type="text"  name="email"><br/></span>
        <span id="registeredcellphone"> 手机号：<input type="text" name="cellphone"><br/></span>
        <span> 密码：<input type="password" name="password"><br/></span>
        <input type="submit" value="注册">
    </form>
</div>
<script type="text/babel"  language="javascript" charset="utf-8" src="/resources/js/index.js"></script>
</body>
<script>
</script>
<script>
    $("#registered").hide();

    function login() {
        $("#login").show();
        $("#registered").hide();
    }

    function registered() {
        $("#registered").show();
        $("#login").hide();
    }
    $("#logincellphone").hide();

    function button1() {
        $("#loginemail").show();
        $("#logincellphone").hide();
        $("#num").val("1");
    }

    function button2() {
        $("#loginemail").hide();
        $("#logincellphone").show();
        $("#num").val("2");
    }
    $("#registeredcellphone").hide();

    function button3() {
        $("#registeredemail").show();
        $("#registeredcellphone").hide();
    }

    function button4() {
        $("#registeredemail").hide();
        $("#registeredcellphone").show();
    }
</script>

</html>