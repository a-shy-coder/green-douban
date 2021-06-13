<%@ page import="team.sdguys.service.UserService" %>
<%@ page import="team.sdguys.service.UserInfoService" %>
<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.impl.UserInfoServiceImpl" %>
<%@ page import="team.sdguys.service.impl.UserServiceImpl" %>
<%@ page import="team.sdguys.util.DateFormatUtil" %>
<%@ page import="team.sdguys.service.impl.MovieServiceImpl" %>
<%@ page import="team.sdguys.service.MovieService" %>
<%@ page import="team.sdguys.service.BookService" %>
<%@ page import="team.sdguys.service.impl.BookServiceImpl" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="false" %>
<%@ page isELIgnored="false" %>
<%@ page buffer="128kb" %>
<html>
<head>
    <head>
        <base href="<%=request.getContextPath()%>/">
        <title>我的评论</title>
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
    </head>
</head>
<script>
    // 删除电影评论
    function deleteMovieComment(movieCommentId){
        $.ajax({
            url:"deleteMovieCommentServlet",
            type:"GET",
            data:{
                "mcid":movieCommentId,
            },
            success(){
                $("div[id=movieComment"+movieCommentId+"]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }

    // 删除图书评论
    function deleteBookComment(bookCommentId){
        $.ajax({
            url:"deleteBookCommentServlet",
            type:"GET",
            data:{
                "bcid":bookCommentId,
            },
            success(){
                $("div[id=bookComment"+bookCommentId+"]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }
</script>
<body>
<%@include file="/jsp/navbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 700px">
        <!-- 电影评论 和 图书评论 -->
        <%
            UserService userService = new UserServiceImpl();
            UserInfoService userInfoService = new UserInfoServiceImpl();
            MovieService movieService = new MovieServiceImpl();
            List<MovieComment> movieCommentList = (List<MovieComment>) request.getAttribute("userMovieCommentList");
            BookService bookService = new BookServiceImpl();
            List<BookComment> bookCommentList = (List<BookComment>) request.getAttribute("userBookCommentList");
        %>
            <h1 class="title mb-4">我的评论</h1>
            <div id="commentList" class="mt-3" style="font-size: 14px">
                <%
                    for (MovieComment movieComment : movieCommentList) {
                        int uid = movieComment.getUId();
                        User user = userService.findUserByUid(uid);
                        UserInfo userInfo = userInfoService.findUserInfoById(uid);
                        Movie movie = movieService.findMovieById(movieComment.getMId());
                %>
                <div id="movieComment<%=movieComment.getMCId()%>"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="<%=userInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                                    <%=user.getUname()%>
                        </span>
                        &nbsp;评论
                        <a id="movieId" class="ml-2 commentIcon" href="movieInfoServlet?movieChineseName=<%=movie.getMChineseName()%>"><%=movie.getMChineseName()%></a>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((movieComment.getMCTime()))%></span>
                        <a href="javascript:deleteMovieComment('<%=movieComment.getMCId()%>')"> 删除 <i class="fas fa-times"></i></a>

                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        <%=movieComment.getMCcontent()%>
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <button id="likeButton" class="btn btn-sm btn-light-green" type="button" data-toggle="<%=movieComment.getMCId()%>" disabled><i class="far fa-thumbs-up"> <%=movieComment.getMCLikeCount()%></i></button>
                    </div>
                </div>
                <%
                    }
                %>

                <%
                    for (BookComment bookComment : bookCommentList) {
                        int uid = bookComment.getUId();
                        User user = userService.findUserByUid(uid);
                        UserInfo userInfo = userInfoService.findUserInfoById(uid);
                        Book book = bookService.findBookById(bookComment.getBId());
                %>
                <div id="bookComment<%=bookComment.getBcId()%>"  class="borderTop mt-2 pt-3">
                    <div>
                        <img width="24" height="24" src="<%=userInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                                <%=user.getUname()%>
                        </span>
                        &nbsp;评论
                        <a class="ml-2 commentIcon" href="bookInfoServlet?bookChineseName=<%=book.getBChineseName()%>"><%=book.getBChineseName()%></a>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((bookComment.getBcTime()))%></span>
                        <a href="javascript:deleteBookComment('<%=bookComment.getBcId()%>')"> 删除 <i class="fas fa-times"></i></a>

                    </div>
                    <div class="mt-3 commentContent">
                        <%=bookComment.getBcContent()%>
                    </div>
                    <div class="mt-1">
                        <button  class="btn btn-sm btn-light-green" type="button" data-toggle="<%=bookComment.getBcId()%>" disabled><i class="far fa-thumbs-up"> <%=bookComment.getBcLikeCount()%></i></button>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
    </div>
    <!-- 侧边栏 -->
    <div id="sidebar" class="float-right">
        <div class="treeview w-20 text-right">
            <h6 class="pt-3 pl-3">我的空间</h6>
            <br>
            <ul class="mb-1 pl-3 pb-2">
                <li class="mb-2"><a href="userInfoServlet"><i class="far fa-user ic-w mr-1"></i>我的信息</a></li>
                <li class="mb-2"><a href="#"><i class="far fa-edit ic-w mr-1"></i>我的日志</a></li>
                <li class="mb-2"><a href="userCollectionInfoServlet"><i class="far fa-star ic-w mr-1"></i>我的收藏</a></li>
                <li class="mb-2"><a href="userCommentInfoServlet"><i class="far fa-comment ic-w mr-1"></i>我的评论</a></li>
                <li class="mb-2"><a href="userReplyInfoServlet"><i class="far fa-comment ic-w mr-1"></i>我的回复</a></li>
            </ul>
        </div>
    </div>
</div>
<%@ include file="/jsp/footer.jsp"%>

</body>
</html>
