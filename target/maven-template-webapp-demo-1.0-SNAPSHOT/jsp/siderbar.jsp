<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>${requestScope.actor.actorChineseName}</title>
    <link rel="shortcut icon" href="img/douban.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/movieInfo.css"/>


    <!-- MDB -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/mdb.min.js"></script>
    <script>
        $(document).ready(function() {
            $('.treeview').mdbTreeview();
        });
    </script>
</head>
<body>
<div id="sidebar" class="float-right">
    <div class="treeview w-20 text-right">
        <h6 class="pt-3 pl-3">我的空间</h6>
        <br>
        <ul class="mb-1 pl-3 pb-2">
            <li class="mb-2"><a href="userInfoServlet"><i class="far fa-user ic-w mr-1"></i>我的信息</a></li>
            <li class="mb-2"><a href="userDiaryInfoServlet"><i class="far fa-edit ic-w mr-1"></i>我的日志</a></li>
            <li class="mb-2"><a href="userCollectionInfoServlet"><i class="far fa-star ic-w mr-1"></i>我的收藏</a></li>
            <li class="mb-2"><a href="userCommentInfoServlet"><i class="far fa-comment ic-w mr-1"></i>我的评论</a></li>
            <li class="mb-2"><a href="userReplyInfoServlet"><i class="far fa-comment ic-w mr-1"></i>我的回复</a></li>
        </ul>
    </div>
</div>
</body>
</html>
