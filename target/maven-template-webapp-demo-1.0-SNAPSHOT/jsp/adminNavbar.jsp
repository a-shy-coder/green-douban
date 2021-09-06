<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页尾</title>
</head>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-expand-lg navbar-dark green scrolling-navbar fixed-top">
    <a class="navbar-brand" href="accountManagementInfoServlet">山洞后台管理系统</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav mr-auto">
        </ul>
        <ul class="navbar-nav ml-auto nav-flex-icons">
            <li class="nav-item dropdown">

                <a class="nav-link dropdown-toggle" data-toggle="dropdown">
                    <span id="userName">${sessionScope.adminUserName}</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-default">
                    <a class="dropdown-item" href="adminLogoutServlet">退出登录</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
