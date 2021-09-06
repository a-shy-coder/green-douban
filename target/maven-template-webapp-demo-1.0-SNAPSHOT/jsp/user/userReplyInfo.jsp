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
    // 删除电影回复
    function deleteMovieReply(movieReplyId){
        $.ajax({
            url:"deleteMovieReplyServlet",
            type:"GET",
            data:{
                "movieReplyId":movieReplyId,
            },
            success(){
                $("div[id=movieReply" + movieReplyId + "]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }

    // 删除图书回复
    function deleteBookReply(bookReplyId){
        $.ajax({
            url:"deleteBookReplyServlet",
            type:"GET",
            data:{
                "bookReplyId":bookReplyId,
            },
            success(){
                $("div[id=bookReply" + bookReplyId + "]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }
    // 删除日志回复
    function deleteDiaryReply(diaryReplyId){
        $.ajax({
            url:"deleteDiaryReplyServlet",
            type:"GET",
            data:{
                "diaryReplyId":diaryReplyId,
            },
            success(){
                $("div[id=diaryReply" + diaryReplyId + "]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }
</script>
<body style="font-size: 14px">
<%@include file="/jsp/navbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 700px">
        <!-- 电影评论 和 图书评论 和 日志评论-->
        <%
            UserService userService = new UserServiceImpl();
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<MovieReply> movieReplyList = (List<MovieReply>) request.getAttribute("userMovieReplyList");
            List<BookReply> bookReplyList = (List<BookReply>) request.getAttribute("userBookReplyList");
            List<DiaryReply> diaryReplyList = (List<DiaryReply>) request.getAttribute("userDiaryReplyList");
        %>
            <h1 class="title mb-4">我的回复</h1>
            <div id="replyList" class="mt-3">
                <%
                    for (MovieReply movieReply : movieReplyList) {
                        int formId = movieReply.getMRFromId();
                        User fromUser = userService.findUserByUid(formId);
                        UserInfo formUserInfo = userInfoService.findUserInfoById(formId);
                        int toId = movieReply.getMRToId();
                        User toUser = userService.findUserByUid(toId);
                %>
                <div id="movieReply<%=movieReply.getMRId()%>"  class="borderTop mt-2 pt-3">
                    <div id="replyHeader">
                        <img width="24" height="24" src="<%=formUserInfo.getUicon()%>">
                        <span id="fromUserName" class="ml-2 commentIcon">
                                <%=fromUser.getUname()%>
                        </span>
                        &nbsp;回复
                        <span id="toUserName" class="ml-2 commentIcon">
                                <%=toUser.getUname()%>
                        </span>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((movieReply.getMRTime()))%></span>
                        <a href="javascript:deleteMovieReply('<%=movieReply.getMRId()%>')"> 删除 <i class="fas fa-times"></i></a>

                    </div>
                    <div id="replyContent" class="mt-3 commentContent">
                        <%=movieReply.getMRContent()%>
                    </div>
                    <div id="replyFooter" class="mt-1">
                        <button id="likeButton" class="btn btn-sm btn-light-green" type="button" data-toggle="<%=movieReply.getMRId()%>" disabled><i class="far fa-thumbs-up"> <%=movieReply.getMRLikeCount()%></i></button>
                    </div>
                </div>
                <%
                    }
                %>


                <%
                    for (BookReply bookReply : bookReplyList) {
                        int formId = bookReply.getBRFromId();
                        User fromUser = userService.findUserByUid(formId);
                        UserInfo formUserInfo = userInfoService.findUserInfoById(formId);

                        int toId = bookReply.getBRToId();
                        User toUser = userService.findUserByUid(toId);
                %>
                <div id="bookReply<%=bookReply.getBRId()%>"  class="borderTop mt-2 pt-3" style="font-size: 14px">
                    <div>
                        <img width="24" height="24" src="<%=formUserInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                            <%=fromUser.getUname()%>
                        </span>
                        &nbsp;回复
                        <span class="ml-2 commentIcon">
                            <%=toUser.getUname()%>
                        </span>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((bookReply.getBRTime()))%></span>
                        <a href="javascript:deleteBookReply('<%=bookReply.getBRId()%>')"> 删除 <i class="fas fa-times"></i></a>

                    </div>
                    <div class="mt-3 commentContent">
                        <%=bookReply.getBRContent()%>
                    </div>
                    <div class="mt-1">
                        <button class="btn btn-sm btn-light-green" type="button" data-toggle="<%=bookReply.getBRId()%>" disabled><i class="far fa-thumbs-up"> <%=bookReply.getBRLikeCount()%></i></button>
                    </div>
                </div>
                <%
                    }
                %>

                <%
                    for (DiaryReply diaryReply : diaryReplyList) {
                        int formId = diaryReply.getDRFromId();
                        User fromUser = userService.findUserByUid(formId);
                        UserInfo formUserInfo = userInfoService.findUserInfoById(formId);

                        int toId = diaryReply.getDRToId();
                        User toUser = userService.findUserByUid(toId);
                %>
                <div id="diaryReply<%=diaryReply.getDRId()%>"  class="borderTop mt-2 pt-3" style="font-size: 14px">
                    <div>
                        <img width="24" height="24" src="<%=formUserInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                            <%=fromUser.getUname()%>
                        </span>
                        &nbsp;回复
                        <span class="ml-2 commentIcon">
                            <%=toUser.getUname()%>
                        </span>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((diaryReply.getDRTime()))%></span>
                        <a href="javascript:deleteDiaryReply('<%=diaryReply.getDRId()%>')"> 删除 <i class="fas fa-times"></i></a>

                    </div>
                    <div class="mt-3 commentContent">
                        <%=diaryReply.getDRContent()%>
                    </div>
                    <div class="mt-1">
                        <button class="btn btn-sm btn-light-green" type="button" data-toggle="<%=diaryReply.getDRId()%>" disabled><i class="far fa-thumbs-up"> <%=diaryReply.getDRLikeCount()%></i></button>
                    </div>
                </div>
                <%
                    }
                %>
            </div>

    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/siderbar.jsp"%>
</div>
<%@ include file="/jsp/footer.jsp"%>

</body>
</html>
