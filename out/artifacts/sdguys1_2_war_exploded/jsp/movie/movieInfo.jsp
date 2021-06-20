<%@ page import="team.sdguys.entity.MovieComment" %>
<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.entity.User" %>
<%@ page import="team.sdguys.service.UserService" %>
<%@ page import="team.sdguys.service.impl.UserServiceImpl" %>
<%@ page import="team.sdguys.service.UserInfoService" %>
<%@ page import="team.sdguys.service.impl.UserInfoServiceImpl" %>
<%@ page import="team.sdguys.entity.UserInfo" %>
<%@ page import="team.sdguys.util.DateFormatUtil" %>
<%@ page import="team.sdguys.entity.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="false" %>
<%@ page isELIgnored="false" %>
<%@ page buffer="128kb" %>

<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>${requestScope.movie.MChineseName}</title>
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

        checkMovieCollection();
        getUserMovieRating();
        checkLike();

        // 监听收藏按钮
        $("#collectionBtn").click(function(){
            if($("#collectionBtn").hasClass("btn-warning")){
                addMovieCollection();
            }else{
                deleteMovieCollection();
            }
        })

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

        // 添加电影收藏
        function addMovieCollection(){
            $.ajax({
                url: "addMovieCollectionServlet",
                type: "GET",
                async:false, // 同步请求
                data: {
                    "movieId": ${requestScope.movie.movieId},
                    "uid":${sessionScope.uid}
                },
                success: function (data) {
                    checkMovieCollection();
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 删除电影收藏
        function deleteMovieCollection(){
            $.ajax({
                url: "deleteMovieCollectionServlet",
                type: "GET",
                async:false, // 同步请求
                data: {
                    "movieId": ${requestScope.movie.movieId},
                    "uid":${sessionScope.uid}
                },
                success: function (data) {
                    checkMovieCollection();
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 检查当前用户是否收藏了此电影,并改变按钮样式
        function checkMovieCollection(){
            $.ajax({
                url: "checkMovieCollectionServlet",
                type: "GET",
                async:false,
                data: {
                    "movieId": ${requestScope.movie.movieId},
                    "uid":${sessionScope.uid}
                },
                success: function (data) {
                   if(data === "true"){
                       $("#collectionBtn").removeClass("btn-warning");
                       $("#collectionBtn").addClass("btn-light");
                       $("#collectionBtn").html("<i class=\"fas fa-star\"></i> 已收藏");
                   }else{
                       $("#collectionBtn").removeClass("btn-light");
                       $("#collectionBtn").addClass("btn-warning");
                       $("#collectionBtn").html("<i class=\"far fa-star\"></i> 收藏");
                   }
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 检索用户对电影的评分
        function getUserMovieRating(){
            $.ajax({
                url: "getUserMovieRatingServlet",
                type: "GET",
                async:false,
                data: {
                    "movieId": ${requestScope.movie.movieId},
                    "uid":${sessionScope.uid}
                },
                success: function (data) {
                   $("#userRating").attr("data-score",data);
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 发表评论
        function submitComment(){
            $.ajax({
                url: "submitMovieCommentServlet",
                type: "POST",
                async:false,
                data: {
                    "movieId": ${requestScope.movie.movieId},
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
            $.ajax({
                url: "submitLikeServlet",
                type: "GET",
                async:false, // 同步请求
                data: {
                    "type":0,
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
                    "type":0
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

        <!-- 电影标题 -->
        <h1 class="title mb-4">
            <span id="movieTitle">${requestScope.movie.MChineseName} ${requestScope.movie.MOriginName}</span>
            <span style="color:#888" id="year">(<%=DateFormatUtil.formatYear(((Movie)(request.getAttribute("movie"))).getMReleaseDate())%>)</span>
        </h1>
        <div id="content1" class="clearfix">
            <!-- 电影封面 和 电影信息 -->
            <div id="subContent1" class="float-left" style="width: 500px">
                <!-- 电影封面 -->
                <div id="movieCoverDiv" class="float-left" style="max-width:135px">
                    <img id="movieCover" src="${requestScope.movie.mCover}"
                         class="cover">
                </div>
                <!-- 电影信息 -->
                <div id="movieInfo" class="float-left ml-3" style="max-width:333px">
                    <span class="greyText">导演: </span><span id="director">
                    <a href="directorInfoServlet?directorId=${requestScope.director.directorId}">${requestScope.director.directorChineseName}</a>
                    </span>
                    <br>
                    <span class="greyText">主演: </span><span class="actors">
                    <c:forEach items="${requestScope.actorList}" var="actor" end="4">
                        <a href="actorInfoServlet?actorId=${actor.actorId}">${actor.actorChineseName}</a> /
                    </c:forEach>

                    </span>
                    <br>
                    <span class="greyText">类型: </span><span id="type">${requestScope.movie.MType}</span>
                    <br>
                    <span class="greyText">制片国家/地区: </span><span id="area">${requestScope.movie.mArea}</span>
                    <br>
                    <span class="greyText">语言: </span><span id="language">${requestScope.movie.mLanguage}</span>
                    <br>
                    <span class="greyText">上映日期: </span><span id="releaseDate"><%=DateFormatUtil.formatDate(((Movie)(request.getAttribute("movie"))).getMReleaseDate())%></span>
                    <br>
                    <span class="greyText">片长: </span><span id="length">${requestScope.movie.mLength}分钟</span>
                    <br>
                </div>
            </div>
            <!-- 电影评分与收藏 -->
            <div id="subContent2" class="float-left ml-4 borderLeft pl-2" style="width: 170px">
                <!-- 评分 -->
                <div class="pb-3">
                    <div style="color: #9b9b9b" class="mb-2">
                        绿豆芽评分
                    </div>
                    <div id="ratingLeft" class="ratingText float-left mr-2">${requestScope.movie.MRating}</div>
                    <div id="rating" data-score="${requestScope.movie.MRating/2}"></div>
                    <script>
                        $(document).ready(function () {
                            $("#rating").raty({
                                path: 'img',
                                half: true,
                                readOnly: true,
                                halfShow: true,
                                noRatedMsg: "暂无评分",
                            });
                        })
                    </script>
                    <div id="ratingCount">
                        ${requestScope.movie.MRatingCount}人评价
                    </div>
                </div>
                <!-- 用户评价 -->
                <div class="pb-3">
                    <span style="color: #9b9b9b" class="mb-2">
                        您的评分:
                    </span>
                    <span id="userRating" data-score=""></span>
                    <script>
                        $(document).ready(function () {
                            $("#userRating").raty({
                                path: 'img',
                                half: true,
                                halfShow: true,
                                noRatedMsg: "暂无评分",
                                click:function (score) {
                                    $.ajax({
                                        url: "modifyUserMovieRatingServlet",
                                        type: "GET",
                                        async:false, // 同步请求,
                                        dataType:"json",
                                        data: {
                                            "movieId": ${requestScope.movie.movieId},
                                            "uid":${sessionScope.uid},
                                            "rating":score*2
                                        },
                                        success: function (result) {
                                            console.log(result);
                                            alert("评分成功");
                                            $("#rating").attr("data-score",result.rating/2);
                                            $("#ratingLeft").html(result.rating.toFixed(1));
                                            $("#ratingCount").html(result.ratingCount + "人评价");
                                        },
                                        error: function () {
                                            alert("请求方式错误");
                                        }
                                    })
                                }
                            });
                        })
                    </script>
                </div>
                <!-- 收藏 -->
                <div id="collection" class="pt-3 text-center borderTop">
                    <button class="btn btn-warning btn-sm" id="collectionBtn" type="button"><i class="far fa-star"></i> 收藏</button>
                </div>
            </div>
        </div>

        <!-- 电影简介 -->
        <div id="content2" class="clearfix mt-4">
            <h2 id="movieInfoTitle" class="contentTitle">${requestScope.movie.MChineseName}的剧情简介 · · · · · ·</h2>
            <div id="movieInfoContent">
                ${requestScope.movie.mContent}
            </div>
            <div id="side" class="float-right">
            </div>

        </div>

        <!-- 电影职员列表 -->
        <div id="content3" class="clearfix mt-4">
            <h2 id="movieActorTitle" class="contentTitle">${requestScope.movie.MChineseName}的演职员 · · · · · · </h2>
            <ul id="actorList" class="actorUl">
                <c:if test="${ not empty requestScope.director}">
                    <li class="actorLi m-2">
                        <a href="directorInfoServlet?directorId=${requestScope.director.directorId}">
                            <img id="directorImg" class="actorImg"
                                 src="${requestScope.director.directorImg}">
                            <div id="directorName" class="actorName text-truncate">${requestScope.director.directorChineseName}</div>
                            <div id="directorRole" class="actorRole">导演</div>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${requestScope.actorList}" var="actor">
                    <li class="actorLi m-2">
                        <a href="actorInfoServlet?actorId=${actor.actorId}">
                            <img id="actorImg" class="actorImg"
                                 src="${actor.actorImg}">
                            <div id="actorName" class="actorName text-truncate">${actor.actorChineseName}</div>
                            <div id="actorRole" class="actorRole">主演</div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- 收藏了这部电影的人也收藏了-->
        <div id="content4" class="clearfix mt-4">
            <h2 id="togetherCollectionTitle" class="contentTitle">收藏了${requestScope.movie.MChineseName}的人也收藏了 · · · · · · </h2>
            <ul id="togetherCollectionList" class="togetherCollectionUl">
            <c:forEach items="${requestScope.movieCollectionList}" var="movieCollect" end="4">
                <li class="togetherCollectionLi m-2">
                    <a href="movieInfoServlet?movieChineseName=${movieCollect.MChineseName}">
                        <img id="movieImg" class="movieImg"
                             src="${movieCollect.mCover}">
                        <div id="movieName" class="movieName text-truncate">${movieCollect.MChineseName}</div>
                    </a>
                    <div class="smallRatingText">${movie.MRating}</div>
                </li>
            </c:forEach>
            </ul>
        </div>

        <!-- 电影评论 -->
        <%
            UserService userService = new UserServiceImpl();
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<MovieComment> movieCommentList = (List<MovieComment>) request.getAttribute("movieCommentList");
        %>
        <div id="content5" class="clearfix mt-4">
            <div >
                <h2 id="commentListTitle" class="contentTitle float-left">${requestScope.movie.MChineseName}的评论 · · · · · · </h2>
                <button id="commentButton" class="btn btn-sm btn-light-green m-0 ml-5"><i class="fas fa-comment-dots"></i>我要评论</button>
            </div>
            <div id="commentList" class="mt-3">
                <%
                    for (MovieComment movieComment : movieCommentList) {
                        int uid = movieComment.getUId();
                        User user = userService.findUserByUid(uid);
                        UserInfo userInfo = userInfoService.findUserInfoById(uid);
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
                        <button id="likeButton" class="btn btn-sm btn-light-green" type="button" data-toggle="<%=movieComment.getMCId()%>"><i class="far fa-thumbs-up"> <%=movieComment.getMCLikeCount()%></i></button>
                        <a class="btn btn-sm btn-info" type="button" href="movieReplyInfoServlet?movieCommentId=<%=movieComment.getMCId()%>"><i class="fas fa-reply"></i> 回复</a>
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
