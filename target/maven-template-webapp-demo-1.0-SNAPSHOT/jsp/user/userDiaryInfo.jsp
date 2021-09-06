<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.impl.MovieServiceImpl" %>
<%@ page import="team.sdguys.service.MovieService" %>
<%@ page import="team.sdguys.service.impl.BookServiceImpl" %>
<%@ page import="team.sdguys.service.BookService" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>我的日志</title>
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
<script>
    // 删除日志
    function deleteDiary(diaryId){
        $.ajax({
            url:"deleteDiaryServlet",
            type:"GET",
            data:{
                "diaryId":diaryId,
            },
            success(){
                $("tr[id=diaryTr"+diaryId+"]").fadeOut('slow');
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
    <div id="article" class="float-left mt-3" style="width: 770px;">
        <h1 class="title mb-4">我的日志
            <a href="jsp/diary/submitDiary.jsp" class="btn btn-sm btn-outline-light-green m-0 ml-5">发表日志</a>
        </h1>
        <hr>
        <div class="table">
            <table class="table table-hover table-borderless text-center">
                <thead>
                <tr>
                    <th scope="col" class="text-left">日志标题</th>
                    <th scope="col">发布时间</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.userDiaryList}" var="diary">
                    <tr id="diaryTr${diary.diaryId}">
                        <td class="text-left text-truncate pt-5" style="max-width: 350px"><a href="diaryInfoServlet?diaryId=${diary.diaryId}" style="color: #007bff;">${diary.diaryTitle}</a></td>
                        <td class="p-5"><fmt:formatDate value="${diary.diaryTime}" type="Date"/></td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:deleteDiary('${diary.diaryId}')">删除</a></td>
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
