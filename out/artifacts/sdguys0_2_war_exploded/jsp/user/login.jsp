<%--用户登录页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <base href="<%=request.getContextPath()%>/">
        <title>登录</title>
        <link rel="shortcut icon" href="img/douban.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>

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
            <form class="text-center p-5" action="#!">
                <p class="h4 mb-4">登录</p>
                <input type="email" id="email" class="form-control mb-4" placeholder="邮箱">
                <input type="password" id="password" class="form-control mb-4" placeholder="password">
                <div>
                    <div>
                        <div>
                            <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                            <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                        </div>
                    </div>
                    <div>
                        <a href="">Forgot password?</a>
                    </div>
                </div>
                <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>
                <p>Not a member?
                    <a href="">Register</a>
                </p>
            </form>
        </div>

    </body>
</html>
