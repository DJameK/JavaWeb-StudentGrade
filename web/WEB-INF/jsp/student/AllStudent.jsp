<%--
  Created by IntelliJ IDEA.
  User: 12517
  Date: 2021/6/18
  Time: 14:44
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
            <h1 class="page-header">学生列表 —— 显示所有学生</h1>

            <h2 class="sub-header">查询列表</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>班级</th>
                        <th>学号</th>
                        <th>名字</th>
                        <th>性别</th>
                        <th>手机</th>
                        <th><a class="btn btn-primary" href="${pageContext.request.contextPath}/student/toAddStudent">新增</a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${requestScope.get('list')}">
                        <tr>
                            <td>${student.getClass_name()}</td>
                            <td>${student.getStu_id()}</td>
                            <td>${student.getStu_name()}</td>
                            <td>${student.getStu_gender()}</td>
                            <td>${student.getTelephone()}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/student/toUpdateStudent/${student.getStu_id()}">更改</a> |
                                <a href="${pageContext.request.contextPath}/student/del/${student.getStu_id()}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>