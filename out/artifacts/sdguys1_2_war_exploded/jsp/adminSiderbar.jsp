<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>${requestScope.actor.actorChineseName}</title>
    <link rel="shortcut icon" href="src/main/webapp/img/douban.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/css/movieInfo.css"/>


    <!-- MDB -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="src/main/webapp/css/bootstrap.min.css">
    <link rel="stylesheet" href="src/main/webapp/css/mdb.min.css">
    <script type="text/javascript" src="src/main/webapp/js/jquery.min.js"></script>
    <script type="text/javascript" src="src/main/webapp/js/popper.min.js"></script>
    <script type="text/javascript" src="src/main/webapp/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="src/main/webapp/js/mdb.min.js"></script>
    <script>
        $(document).ready(function() {
            $('.treeview').mdbTreeview();
        });
    </script>
</head>
<body>
<div id="sidebar" class="float-right">
    <div class="treeview w-20 text-right">
        <h6 class="pt-3 pl-3">管理员空间</h6>
        <br>
        <ul class="mb-1 pl-3 pb-2">
            <li class="mb-2"><a href="accountManagementInfoServlet"><i class="far fa-user ic-w mr-1"></i>账号信息管理</a></li>
            <li class="mb-2"><a href="movieManagementInfoServlet"><i class="fab fa-youtube"></i></i> 电影信息管理</a></li>
            <li class="mb-2"><a href="directorManagementInfoServlet"><i class="far fa-user ic-w mr-1"></i></i> 导演信息管理</a></li>
            <li class="mb-2"><a href="actorManagementInfoServlet"><i class="far fa-user ic-w mr-1"></i></i> 演员信息管理</a></li>
            <li class="mb-2"><a href="bookManagementInfoServlet"><i class="fas fa-book"></i></i> 图书信息管理</a></li>
            <li class="mb-2"><a href="authorManagementInfoServlet"><i class="far fa-user ic-w mr-1"></i></i> 作者信息管理</a></li>

        </ul>
    </div>
</div>
</body>
</html>
