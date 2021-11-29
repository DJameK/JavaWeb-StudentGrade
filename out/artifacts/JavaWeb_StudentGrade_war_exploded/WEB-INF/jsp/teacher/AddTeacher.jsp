<%--
  Created by IntelliJ IDEA.
  User: 12517
  Date: 2021/6/15
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/dashboard/">

    <title>学生成绩管理系统-管理员端</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/examples/dashboard/dashboard.css" rel="stylesheet">
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
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:#7466ff;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: white">学生成绩管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/loginPage/logOut" style="color: white">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="${pageContext.request.contextPath}/admin/MainPage">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/queryAllTeacher">教师信息管理</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/queryAllStudent">学生信息管理</a></li>
                <li><a href="${pageContext.request.contextPath}/course/queryAllCourse">课程信息管理</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/toUpdatePwd">修改密码</a></li>

            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <form class="form-signin" action="${pageContext.request.contextPath}/teacher/addATeacher" method="post">
                <h1 class="page-header">新增教师</h1>
                <input type="text" name="t_id" class="form-control" placeholder="教职工号" required>
                <input type="text" name="t_name" class="form-control" placeholder="名字" required>
                <input type="hidden" name="t_pwd"  class="form-control" value="00000000" required>
                <input type="text" name="telephone"  class="form-control" placeholder="手机" required>
                性别:<div class="radio">
                <label><input type="radio" name="t_gender" value="男" checked="true">男</label>
                <label><input type="radio" name="t_gender" value="女" >女</label>
            </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">添加</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>