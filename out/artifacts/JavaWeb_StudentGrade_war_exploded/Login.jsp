<%--
  Created by IntelliJ IDEA.
  User: 12517
  Date: 2021/6/20
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <style>
        body{padding: 0px;margin: 0px;}
        #header{width: auto;min-height: 70px;line-height: 70px;background-color: #7466ff;}
        #header{border-bottom: medium solid #7466ff;}
        .header_title{font-style: normal;font-size: 1.2em;font-weight:800 ;color: white;padding-left: 1em;}
    </style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/signin/">

    <title>登录到学生成绩管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body style="margin: 0px;padding: 0px">
<div id="header">
    <div class="header_title">
        <span class="header_title">学生成绩管理系统</span>
    </div>
</div>
<div class="container" >

    <form class="form-signin" action="${pageContext.request.contextPath}/loginPage" method="post">
        <h2 class="form-signin-heading">欢迎登录成绩系统</h2>
        <input type="text" name="username" class="form-control" placeholder="学号/教职工号/管理员号" required autofocus>
        <input type="password" name="pwd" class="form-control" placeholder="密码" required>
        <div class="radio">
            <label><input type="radio" name="identity" value="Student" checked="true"/>学生</label>
            <label><input type="radio" name="identity" value="Teacher" />教师</label>
            <label><input type="radio" name="identity" value="Admin" />管理员</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
