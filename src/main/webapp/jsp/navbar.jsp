<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页尾</title>
</head>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-expand-lg navbar-dark green scrolling-navbar fixed-top">
    <a class="navbar-brand" href="#">绿豆芽</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">首页 </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">电影</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">图书</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">社区</a>
            </li>
        </ul>
        <form class="form-inline mb-0 ml-auto" method="get">
            <div class="md-form my-0">
                <input id="search" class="form-control" type="text" placeholder="搜索您感兴趣的内容" aria-label="Search">
            </div>
            <button class="btn btn-outline-white btn-md my-0 ml-sm-2" type="submit">搜索</button>
        </form>
        <ul class="navbar-nav ml-auto nav-flex-icons">
            <li class="nav-item dropdown">

                <a class="nav-link dropdown-toggle" data-toggle="dropdown">
                    <img src="${sessionScope.userInfo.uicon}" class="rounded z-depth-1" style="height:35px" width="auto">
                    <span id="userName">${sessionScope.user.uname}</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-default">
                    <a class="dropdown-item" href="userInfoServlet">我的空间</a>
                    <a class="dropdown-item" href="logoutServlet">退出登录</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
