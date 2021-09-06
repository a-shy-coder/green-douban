<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.impl.MovieServiceImpl" %>
<%@ page import="team.sdguys.service.MovieService" %>
<%@ page import="team.sdguys.service.impl.BookServiceImpl" %>
<%@ page import="team.sdguys.service.BookService" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>我的收藏</title>
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

    <!--rating-->
    <link rel="stylesheet" href="css/jquery.raty.css"/>
    <script type="text/javascript" src="js/jquery.raty.js"></script>

    <!-- 多级选择框 -->
    <script src="js/jquery.cxselect.js"></script>
</head>
<script>

    // 删除电影收藏
    function deleteMovieCollection(movieId){
        $.ajax({
            url:"deleteMovieCollectionServlet",
            type:"GET",
            data:{
                "movieId":movieId,
                "uid":${sessionScope.uid}
            },
            success(){
                $("tr[id=movieTr"+movieId+"]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }

    // 删除图书收藏
    function deleteBookCollection(bookId){
        $.ajax({
            url:"deleteBookCollectionServlet",
            type:"GET",
            data:{
                "bookId":bookId,
                "uid":${sessionScope.uid}
            },
            success(){
                $("tr[id=bookTr"+bookId+"]").fadeOut('slow');
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
    <div id="article" class="float-left mt-3" style="width: 700px;">
        <h1 class="title mb-4">我的收藏</h1>
        <hr>
        <div class="table">
            <table class="table table-hover table-borderless text-center">
                <thead>
                <tr>
                    <th scope="col">封面</th>
                    <th scope="col">名称</th>
                    <th scope="col">评分</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.userMovieCollectionList}" var="movie">
                    <tr id="movieTr${movie.movieId}">
                        <td class="ml-auto mt-auto">
                            <img id="movieImg" class="tableImg" src="${movie.mCover}">
                        </td>
                        <td class="p-5"><a href="movieInfoServlet?movieChineseName=${movie.MChineseName}" style="color: #007bff;">${movie.MChineseName}</a></td>
                        <td class="p-5 smallRatingText">${movie.MRating}</td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:deleteMovieCollection('${movie.movieId}')">删除</a></td>
                    </tr>
                </c:forEach>
                <c:forEach items="${requestScope.userBookCollectionList}" var="book">
                    <tr id="bookTr${book.BId}">
                        <td class="ml-auto mt-auto">
                            <img id="bookImg" class="tableImg" src="${book.bCover}">
                        </td>
                        <td class="p-5"><a href="bookInfoServlet?bookChineseName=${book.BChineseName}" style="color: #007bff;">${book.BChineseName}</a></td>
                        <td class="p-5 smallRatingText">${book.BRating}</td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:deleteBookCollection('${book.BId}')">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/siderbar.jsp"%>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
