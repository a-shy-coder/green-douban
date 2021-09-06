<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>搜索结果</title>
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
        <div class="movieGallery">
            <%
                List<Movie> movieList = (List<Movie>)request.getAttribute("movieList");
                if(movieList==null){
                    System.out.println("电影搜索为空");
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

        <div class="bookGallery">
            <%
                List<Book> bookList = (List<Book>)request.getAttribute("bookList");
                if(bookList==null){
                    System.out.println("图书搜索为空");
                }else{
                    for(Book b : bookList){
            %>
            <a class="item">
                <div>
                    <img src="<%=b.getbCover()%>" alt="<%=b.getBChineseName() %>">
                </div>
                <p>
                    <!--显示图书中文名和评分-->
                    <%=b.getBChineseName() %> [<%= b.getBRating() %>]
                </p>
            </a>
            <%
                    } }
            %>
        </div>

        <div class="actorGallery">
            <%
                List<Actor> actorList = (List<Actor>)request.getAttribute("actorList");
                if(actorList==null){
                    System.out.println("演员搜索为空");
                }else{
                    for(Actor ac : actorList){
            %>
            <a class="item">
                <div>
                    <img src="<%=ac.getActorImg()%>" alt="<%=ac.getActorChineseName() %>">
                </div>
                <p>
                    <!--显示演员中文名和原名-->
                    <%=ac.getActorChineseName() %> (<%= ac.getActorOriginName() %>)
                </p>
            </a>
            <%
                    } }
            %>
        </div>

        <div class="authorGallery">
            <%
                List<Author> authorList = (List<Author>)request.getAttribute("authorList");
                if(authorList==null){
                    System.out.println("作者搜索为空");
                }else{
                    for(Author au : authorList){
            %>
            <a class="item">
                <div>
                    <img src="<%=au.getAuthorImg()%>" alt="<%=au.getAuthorChineseName() %>">
                </div>
                <p>
                    <!--显示作者中文名和原名-->
                    <%=au.getAuthorChineseName() %> (<%= au.getAuthorOriginName() %>)
                </p>
            </a>
            <%
                    } }
            %>
        </div>

        <div class="directorGallery">
            <%
                List<Director> directorList = (List<Director>)request.getAttribute("directorList");
                if(directorList==null){
                    System.out.println("导演搜索为空");
                }else{
                    for(Director d : directorList){
            %>
            <a class="item">
                <div>
                    <img src="<%=d.getDirectorImg()%>" alt="<%=d.getDirectorChineseName() %>">
                </div>
                <p>
                    <!--显示导演中文名和原名-->
                    <%=d.getDirectorChineseName() %> (<%= d.getDirectorOriginName() %>)
                </p>
            </a>
            <%
                    } }
            %>
        </div>
    </div>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
