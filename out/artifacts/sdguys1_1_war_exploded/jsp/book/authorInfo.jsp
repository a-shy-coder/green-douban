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
    <title>${requestScope.author.authorChineseName}</title>
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
<%@include file="/jsp/navbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 700px">

        <!-- 作者姓名 -->
        <h1 class="title mb-4">
            <span id="title">${requestScope.author.authorChineseName} ${requestScope.author.authorOriginName}</span>
        </h1>
        <div id="content1" class="clearfix">
            <!-- 作者个人照及个人信息 -->
            <div id="subContent1" class="float-left" style="width: 500px">
                <!-- 个人照 -->
                <div id="coverDiv" class="float-left" style="max-width:135px">
                    <img id="cover" src="${requestScope.author.authorImg}"
                         class="cover">
                </div>
                <!-- 个人信息 -->
                <div id="info" class="float-left ml-3" style="max-width:333px">
                    <span class="greyText">中文名: </span><span
                        id="chineseName">${requestScope.author.authorChineseName}</span>
                    <br>
                    <span class="greyText">原名: </span><span
                        id="originName">${requestScope.author.authorOriginName}</span>
                    <br>
                    <span class="greyText">性别: </span><span id="gender">${requestScope.author.authorGender}</span>
                    <br>
                </div>
            </div>
        </div>

        <!-- 个人简介 -->
        <div id="content2" class="clearfix mt-4">
            <h2 id="infoTitle" class="contentTitle">个人简介 · · · · · ·</h2>
            <div id="infoContent">
                ${requestScope.author.authorInfo}
            </div>
            <div id="side" class="float-right">
            </div>
        </div>


        <!-- 最近出版的5部作品  -->
        <div id="content3" class="clearfix mt-4">
            <h2 class="contentTitle">最近出版的5部作品  · · · · · · </h2>
            <ul class="movieUl">
                <c:forEach items="${requestScope.latestBookList}" var="book">
                    <li class="togetherCollectionLi m-2">
                        <h3 class="releaseDate"><fmt:formatDate value="${book.BReleaseDate}" pattern="yyyy"></fmt:formatDate></h3>
                        <a href="bookInfoServlet?bookChineseName=${book.BChineseName}">
                            <img class="bookImg"
                                 src="${book.bCover}">
                            <div class="bookName text-truncate">${book.BChineseName}</div>
                        </a>
                        <div class="smallRatingText">${book.BRating}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- 最受好评的5部作品 -->
        <div id="content4" class="clearfix mt-4">
            <h2 class="contentTitle">最受好评的5部作品 · · · · · · </h2>
            <ul class="bookUl">
                <c:forEach items="${requestScope.popularBookList}" var="book">
                    <li class="togetherCollectionLi m-2">
                        <a href="bookInfoServlet?bookChineseName=${book.BChineseName}">
                            <img class="bookImg"
                                 src="${book.bCover}">
                            <div class="bookName text-truncate">${book.BChineseName}</div>
                        </a>
                        <div class="smallRatingText">${book.BRating}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<%@include file="/jsp/footer.jsp"%>
</body>
</html>
