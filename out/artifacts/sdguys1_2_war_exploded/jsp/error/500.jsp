<%--管理员登录页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>404</title>
    <link rel="shortcut icon" href="img/douban.ico" type="image/x-icon"/>

    <!-- MDB -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/mdb.min.js"></script>
</head>
<body style="background-color: #f2f2f2">
<div class="container">
    <div class="ml-auto text-center" style="margin-top: 70px">
        <img src="/img/500.png">
        <h4> 内部服务器错误!</h4>
        <a class="btn btn-sm btn-outline-light-green" type="button" href="jsp/user/login.jsp">返回首页</a>
    </div>
</div>

<%@include file="/jsp/footer.jsp"%>
</body>
</html>
