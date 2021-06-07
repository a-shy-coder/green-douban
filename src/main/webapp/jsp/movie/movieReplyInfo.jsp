<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.UserService" %>
<%@ page import="team.sdguys.service.impl.UserServiceImpl" %>
<%@ page import="team.sdguys.service.UserInfoService" %>
<%@ page import="team.sdguys.service.impl.UserInfoServiceImpl" %>
<%@ page import="team.sdguys.util.DateFormatUtil" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="false" %>
<%@ page isELIgnored="false" %>
<%@ page buffer="128kb" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>所有回复</title>
    <link rel="shortcut icon" href="img/douban.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/movieInfo.css"/>

    <!-- MD5加密 -->
    <script type="text/javascript" src="js/md5.js"></script>


    <!-- MDB -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/mdb.min.js"></script>

    <!--rating-->
    <link rel="stylesheet" href="css/jquery.raty.css"/>
    <script type="text/javascript" src="js/jquery.raty.js"></script>

</head>
<script>
    $(document).ready(function(){

        var toId;

        // 监听发表评论按钮
        $("#submitCommentButton").click(submitComment);

        // 点击评论按钮, 弹出模态框, 并且清空文本框内容
        $("#commentButton, #replyButton").click(function (){
            toId = $(this).attr("data-toggle");
            $("#commentModal").modal('show');
            $("#submitCommentContent").val("");
            // 监听文本域是否为空, 如果为空, 不让提交
            textAreaListener()
        });

        // 监听文本域是否为空, 为空不能提交
        function textAreaListener(){
            if($("#submitCommentContent").val() === ""){
                $("#submitCommentButton").addClass('disabled');
            }
            $("#submitCommentContent").blur(function (){
                if($("#submitCommentContent").val() === ""){
                    $("#submitCommentButton").addClass('disabled');
                }else{
                    $("#submitCommentButton").removeClass('disabled');
                }
            })
        }

        // 我要回复
        function submitComment(){
            $.ajax({
                url: "submitMovieReplyServlet",
                type: "POST",
                async:false,
                data: {
                    "toId":toId,
                    "movieId": ${requestScope.movieComment.MId},
                    "movieCommentId":${requestScope.movieComment.MCId},
                    "commentContent":$("#submitCommentContent").val()
                },
                success: function (result) {
                    console.log(result);
                    $("#commentModal").modal('hide'); // 关闭模态框
                    $(".modal-backdrop").remove();
                    $("#replyList").append("                <div id=\"reply\"  class=\"borderTop mt-2 pt-3\">\n" +
                        "                    <div id=\"replyHeader\">\n" +
                        "                        <img width=\"24\" height=\"24\" src=\""+result.fromUserIcon +"\"\n" +
                        "                        <span id=\"fromUserName\" class=\"ml-2 commentIcon\">\n" + result.fromUserName +
                        "                        </span>\n" +
                        "                        &nbsp;回复\n" +
                        "                        <span id=\"toUserName\" class=\"ml-2 commentIcon\">\n" + result.toUserName +
                        "                        </span>\n" +
                        "                        <span class=\"ml-2\">"+result.movieReplyTime+"</span>\n" +
                        "                    </div>\n" +
                        "                    <div id=\"replyContent\" class=\"mt-3 commentContent\">\n" + result.commentContent +
                        "                    </div>\n" +
                        "                    <div id=\"replyFooter\" class=\"mt-1\">\n" +
                        "                        <btton class=\"btn btn-sm btn-light-green\" type=\"button\"><i class=\"far fa-thumbs-up\"></i>"+result.commentLikeCount+"</btton>\n" +
                        "                        <button id=\"replyButton\" class=\"btn btn-sm btn-info\" type=\"button\" data-toggle=\""+result.fromId+"\"><i class=\"fas fa-reply\"></i> 回复层主</button>\n" +
                        "                    </div>\n" +
                        "                </div>\n");
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }
    })

</script>
<body style="font-size: 14px">
<div class="container ml-auto">
    <div id="article" class="float-left mt-3" style="width: 700px">

        <!-- 评论 -->
        <div id="content1" class="clearfix mt-4">
            <div >
                <h2 id="commentListTitle" class="contentTitle">当前评论 · · · · · · </h2>
            </div>
            <div id="commentList" class="mt-3">
                <%
                    MovieComment movieComment = (MovieComment) request.getAttribute("movieComment");
                    UserService userService = new UserServiceImpl();
                    UserInfoService userInfoService = new UserInfoServiceImpl();
                    UserInfo userInfo = userInfoService.findUserInfoById(movieComment.getUId());
                    User user = userService.findUserByUid(movieComment.getUId());
                %>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="<%=userInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                            <%=user.getUname()%>
                        </span>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((movieComment.getMCTime()))%></span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        <%=movieComment.getMCcontent()%>
                    </div>
                    <div id="commentFooter" class="mt-1">
                    </div>
                </div>
            </div>
        </div>

        <!-- 全部回复 -->
        <%
            List<MovieReply> movieReplyList = (List<MovieReply>) request.getAttribute("movieReplyList");
        %>
        <div id="content2" class="clearfix mt-4">
            <div >
                <h2 id="replyListTitle" class="contentTitle float-left">全部回复 · · · · · · </h2>
                <btton id="commentButton" class="btn btn-sm btn-light-green m-0 ml-5" data-toggle="<%=movieComment.getUId()%>"><i class="fas fa-comment-dots"></i> 回复楼主</btton>
            </div>
            <div id="replyList" class="mt-3">
                <%
                    for (MovieReply movieReply : movieReplyList) {
                        int formId = movieReply.getMRFromId();
                        User fromUser = userService.findUserByUid(formId);
                        UserInfo formUserInfo = userInfoService.findUserInfoById(formId);

                        int toId = movieReply.getMRToId();
                        User toUser = userService.findUserByUid(toId);
                %>
                <div id="reply"  class="borderTop mt-2 pt-3">
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
                    </div>
                    <div id="replyContent" class="mt-3 commentContent">
                        <%=movieReply.getMRContent()%>
                    </div>
                    <div id="replyFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> <%=movieReply.getMRLikeCount()%></btton>
                        <button id="replyButton" class="btn btn-sm btn-info" type="button" data-toggle="<%=formId%>"><i class="fas fa-reply"></i> 回复层主</button>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
            <!-- 评论框 -->
            <div class="modal fade" id="commentModal" tabindex="-1" role="dialog" backdrop="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">评论</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group ">
                                <textarea class="form-control" id="submitCommentContent" rows="3" placeholder="写下您的评论" required></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <btton id="submitCommentButton" class="btn btn-sm btn-light-green " type="button" ><i class="fas fa-comment-dots"></i> 评论 </btton>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
