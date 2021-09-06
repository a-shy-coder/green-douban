<%@ page import="team.sdguys.entity.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.entity.Book" %>
<%@ page import="team.sdguys.entity.Diary" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page autoFlush="false" %>
<%@ page isELIgnored="false" %>
<%@ page buffer="128kb" %>
<html>
<head>
    <title>山洞</title>
    <base href="<%=request.getContextPath()%>/">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/sdhome.css">
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
<body>
    <jsp:include page="../navbar.jsp"/>
    <div style="margin-top: 70px">
    <br>
    <hr>
    <br>
    <h3>电影推荐</h3>
    <hr>
    <div class="movieGallery">
        <%
            List<Movie> movieList = (List<Movie>)request.getAttribute("recommendMovieList");
            if(movieList==null){
                System.out.println("电影列表为空");
            }else{
            for(Movie m : movieList){
        %>
        <a class="item">
            <div>
                <img src="<%=m.getmCover()%>" alt="<%=m.getMChineseName() %>">
            </div>
            <p>
                <!--显示电影中文名和评分-->
                <%=m.getMChineseName() %> [<%= m.getMRating() %>]
            </p>
        </a>
        <%
            } }
        %>
    </div>
    <br>
    <hr>
    <h3>图书推荐</h3>
    <div class="movieGallery">
        <%
            List<Book> bookList = (List<Book>)request.getAttribute("recommendBookList");
            if(bookList==null){
                System.out.println("图书列表为空");
            }else{
            for (Book b: bookList) {
        %>
        <a class="item" target="" href="">
            <div>
                <img src="<%=b.getbCover()%>" alt="<%=b.getBChineseName() %>">
            </div>
            <p>
                <!--显示电影中文名和评分-->
                <%=b.getBChineseName() %> [<%= b.getBRating() %>]
            </p>
        </a>
        <%
            }}
        %>
    </div>
    <hr>
    <h3>日志精选</h3>
    <%
        List<Diary> diaryList = (List<Diary>) request.getAttribute("recommendDiaryList");
        if(diaryList == null){
            System.out.println("日志列表为空");
        }else{
            for(Diary d : diaryList){
    %>
    <hr>
    <div class="item">
        <img src="img\csdn.png"  alt="用户头像"/>
        <p><%= d.getDiaryContent()%></p>
    </div>
    <hr>
    <%
        }}
    %>
    </div>
    <br>
    <br>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
