<%@ page import="team.sdguys.service.UserService" %>
<%@ page import="team.sdguys.service.impl.UserServiceImpl" %>
<%@ page import="team.sdguys.service.UserInfoService" %>
<%@ page import="team.sdguys.service.impl.UserInfoServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page import="team.sdguys.util.DateFormatUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="false" %>
<%@ page isELIgnored="false" %>
<%@ page buffer="128kb" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>${requestScope.book.BChineseName}</title>
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

        checkBookCollection();
        getUserBookRating();

        // 监听收藏按钮
        $("#collectionBtn").click(function(){
            if($("#collectionBtn").hasClass("btn-warning")){
                addBookCollection();
            }else{
                deleteBookCollection();
            }
        })

        // 添加图书收藏
        function addBookCollection(){
            $.ajax({
                url: "addBookCollectionServlet",
                type: "GET",
                data: {
                    "bookId": ${requestScope.book.BId},
                    "uid":${sessionScope.uid}
                },
                success: function (data) {
                    checkBookCollection();
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }
        // 删除图书收藏
        function deleteBookCollection(){
            $.ajax({
                url: "deleteBookCollectionServlet",
                type: "GET",
                async:false, // 同步请求
                data: {
                    "bookId": ${requestScope.book.BId},
                    "uid":${sessionScope.uid}
                },
                success: function (data) {
                    checkBookCollection();
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 检查当前用户是否收藏了此图书,并改变按钮样式
        function checkBookCollection(){
            $.ajax({
                url: "checkBookCollectionServlet",
                type: "GET",
                async:false,
                data: {
                    "bookId": ${requestScope.book.BId},
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
        function getUserBookRating(){
            $.ajax({
                url: "getUserBookRatingServlet",
                type: "GET",
                async:false,
                data: {
                    "bookId": ${requestScope.book.BId},
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

    })
</script>

<body style="font-size: 14px">
<div class="container ml-auto">
    <div id="article" class="float-left mt-3" style="width: 700px">

        <!-- 图书标题 -->
        <h1 class="title mb-4">
            <span id="bookTitle">${requestScope.book.BChineseName} ${requestScope.book.BOriginName}</span>
            <span style="color:#888" id="year">(<%=DateFormatUtil.formatYear(((Book)(request.getAttribute("book"))).getBReleaseDate())%>)</span>
        </h1>
        <div id="content1" class="clearfix">
            <!-- 图书封面 和 图书信息 -->
            <div id="subContent1" class="float-left" style="width: 500px">
                <!-- 图书封面 -->
                <div id="bookCoverDiv" class="float-left" style="max-width:135px">
                    <img id="bookCover" src="${requestScope.book.bCover}"
                         class="cover">
                </div>
                <!-- 图书信息 -->

                <div id="bookInfo" class="float-left ml-3" style="max-width:333px">
                    <span class="greyText">作者: </span>
                        <span id="author">
                            <a href="authorInfoServlet?authorId=${requestScope.author.authorId}">
                                <c:choose>
                                    <c:when test="${requestScope.author.authorChineseName == null}">
                                        ${requestScope.author.authorOriginName}
                                    </c:when>
                                    <c:otherwise>
                                        ${requestScope.author.authorChineseName}
                                    </c:otherwise>
                                </c:choose>
                            </a>
                        </span>
                    <br>
                    <span class="greyText">类型: </span><span id="type">${requestScope.book.BType}</span>
                    <br>
                    <span class="greyText">出版社: </span><span id="publisher">${requestScope.book.BPublisher}</span>
                    <br>
                    <span class="greyText">原作名: </span><span id="originName">${requestScope.book.BOriginName}</span>
                    <br>
                    <span class="greyText">语言: </span><span id="language">${requestScope.book.bLanguage}</span>
                    <br>
                    <span class="greyText">出版日期: </span><span id="releaseDate"><%=DateFormatUtil.formatDate(((Book)(request.getAttribute("book"))).getBReleaseDate())%></span>
                    <br>
                    <span class="greyText">页数: </span><span id="pageCount">${requestScope.book.bPageCount}</span>
                    <br>
                    <span class="greyText">装帧: </span><span id="binding">${requestScope.book.bBinding}</span>
                    <br>
                </div>
            </div>
            <!-- 图书评分与收藏 -->
            <div id="subContent2" class="float-left ml-4 borderLeft pl-2" style="width: 170px">
                <!-- 评分 -->
                <div class="pb-3">
                    <div style="color: #9b9b9b" class="mb-2">
                        绿豆芽评分
                    </div>
                    <div id="ratingLeft"  class="ratingText float-left mr-2">${requestScope.book.BRating}</div>
                    <div id="rating" data-score="${requestScope.book.BRating/2}"></div>
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
                        ${requestScope.book.BRatingCount}人评价
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
                                        url: "modifyUserBookRatingServlet",
                                        type: "GET",
                                        async:false, // 同步请求,
                                        dataType:"json",
                                        data: {
                                            "bookId": ${requestScope.book.BId},
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

        <!-- 图书简介 -->
        <div id="content2" class="clearfix mt-4">
            <h2 id="bookInfoTitle" class="contentTitle">${requestScope.book.BChineseName}内容简介  · · · · · ·</h2>
            <div id="bookInfoContent">
                ${requestScope.book.bContent}
            </div>
            <div id="side" class="float-right">
            </div>
        </div>

        <!-- 图书作者 -->
        <div id="content3" class="clearfix mt-4">
            <h2 id="bookAuthorTitle" class="contentTitle">${requestScope.book.BChineseName}的作者 · · · · · · </h2>
            <ul id="authorList" class="authorUl">
                <li class="authorLi m-2">
                    <a href="authorInfoServlet?authorId=${requestScope.author.authorId}">
                        <img id="authorImg" class="authorImg"
                             src="${requestScope.author.authorImg}">
                        <div id="authorName" class="authorName text-truncate">
                            <c:choose>
                                <c:when test="${requestScope.author.authorChineseName == null}">
                                    ${requestScope.author.authorOriginName}
                                </c:when>
                                <c:otherwise>
                                    ${requestScope.author.authorChineseName}
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div id="authorRole" class="authorRole">作者</div>
                    </a>
                </li>
            </ul>
        </div>

        <!-- 收藏了这部书的人也收藏了-->
        <div id="content4" class="clearfix mt-4">
            <h2 id="togetherCollectionTitle" class="contentTitle">收藏了${requestScope.book.BChineseName}的人也收藏了 · · · · · · </h2>
            <ul id="togetherCollectionList" class="togetherCollectionUl">
                <c:forEach items="${requestScope.bookCollectionList}" var="book" end="4">
                    <li class="togetherCollectionLi m-2">
                        <a href="bookInfoServlet?bookId=${book.BId}">
                            <img id="bookImg" class="bookImg"
                                 src="${book.bCover}">
                            <div id="bookName" class="bookName text-truncate">${book.BChineseName}</div>
                        </a>
                        <div class="smallRatingText">${book.BRating}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- 图书评论 -->
        <%
            UserService userService = new UserServiceImpl();
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<BookComment> bookCommentList = (List<BookComment>) request.getAttribute("bookCommentList");
        %>
        <div id="content5" class="clearfix mt-4">
            <h2 id="commentListTitle" class="contentTitle">${requestScope.book.BChineseName}的评论 · · · · · · </h2>
            <div id="commentList" class="mt-3">
                <%
                    for(BookComment bookComment : bookCommentList){
                        int uid = bookComment.getUId();
                        User user = userService.findUserByUid(uid);
                        UserInfo userInfo = userInfoService.findUserInfoById(uid);
                %>
                <div id="comment"  class="borderTop mt-2 pt-3">
                    <div id="commentHeader">
                        <img width="24" height="24" src="<%=userInfo.getUicon()%>">
                        <span class="ml-2 commentIcon">
                            <%=user.getUname()%>
                        </span>
                        <span class="ml-2"><%=DateFormatUtil.formatDateTime(bookComment.getBcTime())%></span>
                    </div>
                    <div id="commentContent" class="mt-3 commentContent">
                        <%=bookComment.getBcContent()%>
                    </div>
                    <div id="commentFooter" class="mt-1">
                        <btton class="btn btn-sm btn-light-green" type="button"><i class="far fa-thumbs-up"></i> <%=bookComment.getBcLikeCount()%></btton>
                        <btton class="btn btn-sm btn-info" type="button"><i class="fas fa-reply"></i> 回复</btton>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>



</body>
</html>
