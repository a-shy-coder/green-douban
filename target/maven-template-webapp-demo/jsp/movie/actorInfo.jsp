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
</head>
<body style="font-size: 14px">
<div class="container ml-auto">
    <div id="article" class="float-left mt-3" style="width: 700px">

        <!-- 演员姓名 -->
        <h1 class="title mb-4">
            <span id="title">${requestScope.actor.actorChineseName} ${requestScope.actor.actorOriginName}</span>
        </h1>
        <div id="content1" class="clearfix">
            <!-- 演员个人照及个人信息 -->
            <div id="subContent1" class="float-left" style="width: 500px">
                <!-- 个人照 -->
                <div id="coverDiv" class="float-left" style="max-width:135px">
                    <img id="cover" src="${requestScope.actor.actorImg}"
                         class="cover">
                </div>
                <!-- 个人信息 -->
                <div id="info" class="float-left ml-3" style="max-width:333px">
                    <span class="greyText">中文名: </span><span
                        id="chineseName">${requestScope.actor.actorChineseName}</span>
                    <br>
                    <span class="greyText">原名: </span><span
                        id="originName">${requestScope.actor.actorOriginName}</span>
                    <br>
                    <span class="greyText">性别: </span><span id="gender">${requestScope.actor.actorGender}</span>
                    <br>
                </div>
            </div>
        </div>

        <!-- 个人简介 -->
        <div id="content2" class="clearfix mt-4">
            <h2 id="infoTitle" class="contentTitle">个人简介 · · · · · ·</h2>
            <div id="infoContent">
                ${requestScope.actor.actorInfo}
            </div>
            <div id="side" class="float-right">
            </div>
        </div>


        <!-- 最近的5部作品（已上映）-->
        <div id="content3" class="clearfix mt-4">
            <h2 class="contentTitle">最近的5部作品（已上映） · · · · · · </h2>
            <ul class="movieUl">
                <c:forEach items="${requestScope.latestMovieList}" var="movie">
                    <li class="togetherCollectionLi m-2">
                        <h3 class="releaseDate"><fmt:formatDate value="${movie.MReleaseDate}" pattern="yyyy"></fmt:formatDate></h3>
                        <a href="movieInfoServlet?movieChineseName=${movie.MChineseName}">
                            <img class="movieImg"
                                 src="${movie.mCover}">
                            <div class="movieName text-truncate">${movie.MChineseName}</div>
                        </a>
                        <div class="smallRatingText">${movie.BRating}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- 最受好评的5部作品 -->
        <div id="content4" class="clearfix mt-4">
            <h2 class="contentTitle">最受好评的5部作品 · · · · · · </h2>
            <ul class="movieUl">
                <c:forEach items="${requestScope.popularMovieList}" var="movie">
                    <li class="togetherCollectionLi m-2">
                        <a href="movieInfoServlet?movieChineseName=${movie.MChineseName}">
                            <img class="movieImg"
                                 src="${movie.mCover}">
                            <div class="movieName text-truncate">${movie.MChineseName}</div>
                        </a>
                        <div class="smallRatingText">${movie.BRating}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
