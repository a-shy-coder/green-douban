<%@ page import="team.sdguys.entity.DiaryComment" %>
<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.entity.User" %>
<%@ page import="team.sdguys.service.UserService" %>
<%@ page import="team.sdguys.service.impl.UserServiceImpl" %>
<%@ page import="team.sdguys.service.UserInfoService" %>
<%@ page import="team.sdguys.service.impl.UserInfoServiceImpl" %>
<%@ page import="team.sdguys.entity.UserInfo" %>
<%@ page import="team.sdguys.util.DateFormatUtil" %>
<%@ page import="team.sdguys.entity.Diary" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="false" %>
<%@ page isELIgnored="false" %>
<%@ page buffer="128kb" %>

<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>${requestScope.diary.diaryTitle}</title>
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

    <!-- wangEditor -->
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js"></script>
</head>
<script>
    $(document).ready(function(){

        checkLike();

        // 监听发表评论按钮
        $("#submitCommentButton").click(submitComment);

        // 监听点赞按钮, 更改点赞样式
        $("[id=likeButton]").click(function (){

            // 点赞
            if($(this).children().hasClass("far")){
                $(this).children().removeClass("far");
                $(this).children().addClass("fas");
                var count = parseInt($(this).children().html()) + 1;
                $(this).children().html(" " + count);
                submitLike($(this).attr("data-toggle"),1)
                // 取消点赞
            }else{
                $(this).children().removeClass("fas");
                $(this).children().addClass("far");
                var count = parseInt($(this).children().html()) - 1;
                $(this).children().html(" " + count);
                submitLike($(this).attr("data-toggle"),-1)

            }
        })

        // 点击评论按钮, 弹出模态框, 并且清空文本框内容
        $("#commentButton").click(function (){
            alert("!");
            $("#commentModal").modal('show');
            $("#submitCommentContent").val("");
            // 监听文本域是否为空, 如果为空, 不让提交
            textAreaListener();
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


        // 发表评论
        function submitComment(){
            $.ajax({
                url: "submitDiaryCommentServlet",
                type: "POST",
                async:false,
                data: {
                    "diaryId": ${requestScope.diary.diaryId},
                    "commentContent":$("#submitCommentContent").val()
                },
                success: function (data) {
                    window.location.reload(); // 直接重新刷新页面
                    // console.log(data);
                    // $("#commentModal").modal('hide'); // 关闭模态框
                    // $(".modal-backdrop").remove();
                    // $("#commentList").append("                <div id=\"comment\"  class=\"borderTop mt-2 pt-3\">\n" +
                    //     "                    <div id=\"commentHeader\">\n" +
                    //     "                        <img width=\"24\" height=\"24\" src=\"" + data.userIcon +"\">\n" +
                    //     "                        <span class=\"ml-2 commentIcon\">\n" +
                    //     "                            "+ data.userName +"\n" +
                    //     "                        </span>\n" +
                    //     "                        <span class=\"ml-2\">"+data.movieCommentTime+"</span>\n" +
                    //     "                    </div>\n" +
                    //     "                    <div id=\"commentContent\" class=\"mt-3 commentContent\">\n" +
                    //     "                        "+ data.commentContent +
                    //     "                    </div>\n" +
                    //     "                    <div id=\"commentFooter\" class=\"mt-1\">\n" +
                    //     "                                                <button id=\"likeButton\" class=\"btn btn-sm btn-light-green\" type=\"button\" data-toggle=\""+data.movieCommentId+"\"><i class=\"far fa-thumbs-up\">"+data.commentLikeCount+"</i></button>\n"+
                    //     "                        <a class=\"btn btn-sm btn-info\" type=\"button\" href=\"movieReplyInfoServlet?movieCommentId="+ data.movieCommentId +"\"><i class=\"fas fa-reply\"></i> 回复</a>\n" +
                    //     "                    </div>\n" +
                    //     "                </div>\n")
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 点赞
        function submitLike(likeId,count){
            console.log(likeId);
            console.log(count);
            $.ajax({
                url: "submitLikeServlet",
                type: "GET",
                async:false, // 同步请求
                data: {
                    "type":4,
                    "likeId":likeId,
                    "count":count,
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 检索用户点赞过的评论
        function checkLike(){
            $.ajax({
                url: "checkLikeServlet",
                type: "GET",
                async:false, // 同步请求
                data: {
                    "type":4
                },
                success: function (data) {
                    var jsonArray = JSON.parse(data);
                    console.log(jsonArray);
                    for(var i=0; i<jsonArray.length; i++){
                        var id = jsonArray[i];
                        console.log(id);
                        // 改变点赞样式
                        var element = $("button[data-toggle="+id+"]");
                        element.children().removeClass("far");
                        element.children().addClass("fas");
                    }
                },
                error: function () {
                    alert("请求方式错误");
                }
            })

        }
    })

</script>
<body style="font-size: 14px">
<%@include file="/jsp/navbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 700px">
        <!-- 日志标题 -->
        <h1 class="title mb-4">
            <span id="diaryTitle">${requestScope.diary.diaryTitle}</span>
        </h1>
        <hr>
        <div id="articleContent" class="clearfix">
            ${requestScope.diary.diaryContent}
        </div>
        <!-- 电影评论 -->
        <%
            UserService userService = new UserServiceImpl();
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<DiaryComment> diaryCommentList = (List<DiaryComment>) request.getAttribute("diaryCommentList");
        %>
        <div id="content5" class="clearfix mt-5">
            <div >
                <h2 id="commentListTitle" class="contentTitle float-left">该日志的评论 · · · · · · </h2>
                <button id="commentButton" class="btn btn-sm btn-light-green m-0 ml-5"><i class="fas fa-comment-dots"></i>我要评论</button>
            </div>
            <div id="commentList" class="mt-3">
                <%
                    for (DiaryComment diaryComment : diaryCommentList) {
                        int uid = diaryComment.getUid();
                        User user = userService.findUserByUid(uid);
                        UserInfo userInfo = userInfoService.findUserInfoById(uid);
                %>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="<%=userInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                            <%=user.getUname()%>
                        </span>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime((diaryComment.getdCTime()))%></span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        <%=diaryComment.getdCContent()%>
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <button id="likeButton" class="btn btn-sm btn-light-green" type="button" data-toggle="<%=diaryComment.getdCid()%>"><i class="far fa-thumbs-up"> <%=diaryComment.getdCLikeCount()%></i></button>
                        <a class="btn btn-sm btn-info" type="button" href="diaryReplyInfoServlet?diaryCommentId=<%=diaryComment.getdCid()%>"><i class="fas fa-reply"></i> 回复</a>
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
                            <button id="submitCommentButton" class="btn btn-sm btn-light-green" type="button" ><i class="fas fa-comment-dots"></i> 评论 </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%@ include file="/jsp/footer.jsp"%>
</body>
</html>
