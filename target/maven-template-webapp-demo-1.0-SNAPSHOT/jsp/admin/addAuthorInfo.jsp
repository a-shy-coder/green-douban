<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.impl.AuthorServiceImpl" %>
<%@ page import="team.sdguys.service.AuthorService" %>
<%@ page import="team.sdguys.service.impl.AuthorServiceImpl" %>
<%@ page import="team.sdguys.service.AuthorService" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>作者管理</title>
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
</head>
<script>
    $(document).ready(function (){
        // 选择封面
        $("#chooseBtn").click(function (){
            $("input[id='coverInput']").click();
        })
        //上传封面
        $("#uploadBtn").click(function (){
            var formData = new FormData();
            formData.append('file',$("input[id='coverInput']")[0].files[0]);
            $.ajax({
                url: 'uploadUserIconServlet',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (fileName) {
                    console.log(fileName);
                    $("#cover").attr("src",fileName);
                },
                error: function () {
                    alert("error");
                }
            });
        })
        // 上传作者
        $("#addAuthorBtn").click(function () {
            $.ajax({
                url:"addOneAuthorServlet",
                type: "POST",
                data:{
                    "chineseName":$("#chineseName").val(),
                    "originName":$("#originName").val(),
                    "cover":$("#cover").attr("src"),
                    "gender":$("#gender").val(),
                    "content":$("#content").val(),
                },
                success:function () {
                    alert("添加成功! 请返回列表查看");
                },
                error:function (){

                }
            })
        })
    })
</script>
<body style="font-size: 14px">
<%@include file="/jsp/adminNavbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 770px;">
        <h1 class="title mb-4">发布作者</h1>
        <hr>
        <div style="width: 400px">
            <form>
                <h6>中文名</h6>
                <div class="md-form form-sm">
                    <input type="text" id="chineseName" class="form-control">
                    <label for="chineseName" class="">作者中文名</label>
                </div>
                <h6>原名</h6>
                <div class="md-form form-sm">
                    <input type="text" id="originName" class="form-control">
                    <label for="originName" class="">作者原名</label>
                </div>
                <h6>个人照</h6>
                <div class="md-form">
                    <div style="width: 160px;   display:inline-block">
                        <img class="cover" id="cover" src="https://gitee.com/a-shy-coder/blog-images/raw/master/author-default-medium.png">
                    </div>
                    <input type="file" id="coverInput" name="file" class="form-control" hidden>
                    <button id="chooseBtn" class="btn btn-light-green btn-sm" type="button">选择封面</button>
                    <button class="btn btn-light-green btn-sm" id="uploadBtn" type="button">上传</button>
                </div>
                <h6>性别</h6>
                <div class="md-form form-sm">
                    <input type="text" id="gender" class="form-control">
                    <label for="gender" class="">性别</label>
                </div>
                <h6>简介</h6>
                <div class="md-form md-outline">
                    <textarea id="content" class="md-textarea form-control" rows="3"></textarea>
                    <label for="content">作者简介....</label>
                </div>
                <button class="btn btn-light-green btn-sm" id="addAuthorBtn" type="button">确认发布</button>
            </form>
        </div>

    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/adminSiderbar.jsp"%>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
