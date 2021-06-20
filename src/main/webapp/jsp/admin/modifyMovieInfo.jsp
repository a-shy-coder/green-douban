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
    <title>电影管理</title>
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

        // 选择头像
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
        // 修改电影
        $("#addMovieBtn").click(function () {
            $.ajax({
                url:"modifyOneMovieServlet",
                type: "POST",
                data:{
                    "id":${requestScope.movie.movieId},
                    "chineseName":$("#chineseName").val(),
                    "originName":$("#originName").val(),
                    "cover":$("#cover").attr("src"),
                    "type":$("#type").val(),
                    "releaseDate":$("#releaseDate").val(),
                    "language":$("#language").val(),
                    "area":$("#area").val(),
                    "time":$("#time").val(),
                    "content":$("#content").val(),
                },
                success:function () {
                    alert("修改成功!");
                    window.location.reload();
                },
                error:function (){

                }
            })
        })
    })
    function modifyMovieDirector(directorId){
        $.ajax({
            url:"modifyMovieDirectorServlet",
            type:"POST",
            data:{
                "directorId":directorId,
                "movieId":${requestScope.movie.movieId},
            },
            success:function(){
                alert("修改成功!");
                window.location.reload();
            },
            error:function(){
                alert("error");
            }
        })
    }
    // 弹出添加导演模态框
    function showAddDirectorModal(){
        $("#addDirectorModal").modal('show');
    }

</script>
<body style="font-size: 14px">
<%@include file="/jsp/adminNavbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 770px;">
        <h1 class="title mb-4">发布电影</h1>
        <hr>
        <div style="width: 400px">
            <form>
                <h6>中文名</h6>
                <div class="md-form form-sm">
                    <input type="text" id="chineseName" class="form-control" value="${requestScope.movie.MChineseName}">
                    <label for="chineseName" class="">电影中文名</label>
                </div>
                <h6>原名</h6>
                <div class="md-form form-sm">
                    <input type="text" id="originName" class="form-control" value="${requestScope.movie.MOriginName}">
                    <label for="originName" class="">电影原名</label>
                </div>
                <h6>封面</h6>
                <div class="md-form">
                    <div style="width: 160px;   display:inline-block">
                        <img class="cover" id="cover" src="${requestScope.movie.mCover}">
                    </div>
                    <input type="file" id="coverInput" name="file" class="form-control" hidden>
                    <button id="chooseBtn" class="btn btn-light-green btn-sm" type="button">选择封面</button>
                    <button class="btn btn-light-green btn-sm" id="uploadBtn" type="button">上传</button>
                </div>
                <h6>类型</h6>
                <div class="md-form form-sm">
                    <input type="text" id="type" class="form-control" value="${requestScope.movie.MType}">
                    <label for="type" class="">电影类型</label>
                </div>
                <h6>上映日期</h6>
                <div class="md-form">
                    <input placeholder="Select date" type="date" id="releaseDate" class="form-control" value="<fmt:formatDate value="${requestScope.movie.MReleaseDate}" pattern="yyyy-MM-dd"/>">
                </div>
                <script>
                    $("#releaseDate").val()
                </script>
                <h6>语言</h6>
                <div class="md-form form-sm">
                    <input type="text" id="language" class="form-control" value="${requestScope.movie.mLanguage}">
                    <label for="language" class="">语言</label>
                </div>
                <h6>制片国家/地区</h6>
                <div class="md-form form-sm">
                    <input type="text" id="area" class="form-control" value="${requestScope.movie.mArea}">
                    <label for="area" class="">制片国家/地区</label>
                </div>
                <h6>时长</h6>
                <div class="md-form form-sm">
                    <input class="quantity" min="0" name="time" id="time" type="number" value="${requestScope.movie.mLength}">
                </div>
                <h6>简介</h6>
                <div class="md-form md-outline">
                    <textarea class="md-textarea form-control" id="content" rows="5" style="width: 700px">${requestScope.movie.mContent}</textarea>
                    <label for="content">电影简介....</label>
                </div>
                <button class="btn btn-light-green btn-sm" id="addMovieBtn" type="button">确认修改</button>
            </form>
        </div>
        <div>
            <br><br>
            <h1 class="title mb-4">
                拍摄此电影的导演
                <a class="btn btn-sm btn-light-green" type="button" href="javascript:showAddDirectorModal()">添加导演</a>
            </h1>
            <hr>
            <c:if test="${ not empty requestScope.director}">
                <div class="table">
                    <table class="table table-hover table-borderless text-center">
                        <thead>
                        <tr>
                            <th scope="col">个人照</th>
                            <th scope="col">导演</th>
                            <th scope="col">删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="directorTr${requestScope.director.directorId}">
                            <td class="ml-auto mt-auto">
                                <img id="directorImg" class="tableImg" src="${requestScope.director.directorImg}">
                            </td>
                            <td class="p-5">${requestScope.director.directorChineseName}</td>
                            <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:modifyMovieDirector('0')">删除</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
        <div>
            <br><br>
            <h1 class="title mb-4">
                参演演员
                <a class="btn btn-sm btn-light-green" type="button" href="javascript:showAddActorModal()">添加演员</a>
                <script>
                    // 弹出添加演员模态框
                    function showAddActorModal(){
                        $("#addActorModal").modal('show');
                    }
                </script>
            </h1>
            <hr>
            <c:if test="${ not empty requestScope.actorList}">
                <div class="table">
                    <table class="table table-hover table-borderless text-center">
                        <thead>
                        <tr>
                            <th scope="col">个人照</th>
                            <th scope="col">演员</th>
                            <th scope="col">删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.actorList}" var="actor">
                            <tr id="directorTr${actor.actorId}">
                                <td class="ml-auto mt-auto">
                                    <img id="actorImg" class="tableImg" src="${actor.actorImg}">
                                </td>
                                <td class="p-5">${actor.actorChineseName}</td>
                                <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:deleteMovieActor('${actor.actorId}')">删除</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <script>
                    // 删除参演演员
                    function deleteMovieActor(actorId){
                        $.ajax({
                            url: "deleteMovieActorServlet",
                            type: "POST",
                            data: {
                                "actorId":actorId,
                                "movieId":${requestScope.movie.movieId}
                            },
                            success: function () {
                                alert("修改成功");
                                window.location.reload();
                            },
                            error: function () {
                                alert("error");
                            }
                        })
                    }

                </script>
            </c:if>
        </div>



    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/adminSiderbar.jsp"%>
    <!-- 添加导演信息模态框 -->
    <div class="modal fade" id="addDirectorModal" tabindex="-1" role="dialog" backdrop="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">添加导演信息</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" id="modifyUserId" class="form-control">
                        <h5>导演ID</h5>
                        <div class="md-form form-sm">
                            <input type="text" id="addDirectorInput" class="form-control" placeholder="请输入导演ID">
                            <div class="errorInfo" id="errorInfo"></div>
                            <script>
                                $(document).ready(function(){
                                    function checkMovieDirector(){
                                        var result;
                                        $.ajax({
                                            url: "checkMovieDirectorServlet",
                                            type:"POST",
                                            async:false,
                                            data:{
                                                "movieId":${requestScope.movie.movieId},
                                                "directorId":$("#addDirectorInput").val()
                                            },
                                            success: function(data){
                                                result = (data === "true");
                                            },
                                            error: function(){
                                                alert("error");
                                            }
                                        })
                                        console.log(result);
                                        return result;
                                    }
                                    $("#addDirectorInput").blur(function () {
                                        if(checkMovieDirector() === false){
                                            $("#errorInfo").css("display", "inline");
                                            $("#errorInfo").html("该导演ID不存在或者已经被添加到该电影");
                                            $("#addDirectorBtn").attr("disabled",true);
                                        }else{
                                            $("#errorInfo").css("display", "none");
                                            $("#addDirectorBtn").removeAttr("disabled",false);
                                        }
                                    })

                                })
                            </script>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="addDirectorBtn" class="btn btn-sm btn-light-green" type="button" ><i class="fas fa-comment-dots"></i> 确认添加 </button>
                    <script>
                        $(document).ready(function (){
                            $("#addDirectorBtn").click(function (){
                                modifyMovieDirector($("#addDirectorInput").val());
                            })
                        })
                    </script>
                </div>
            </div>
        </div>
    </div>
    <!-- 添加演员信息模态框 -->
    <div class="modal fade" id="addActorModal" tabindex="-1" role="dialog" backdrop="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">添加演员信息</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" id="modifyActorId" class="form-control">
                        <h5>演员ID</h5>
                        <div class="md-form form-sm">
                            <input type="text" id="addActorInput" class="form-control" placeholder="请输入演员ID">
                            <div class="errorInfo" id="actorErrorInfo"></div>
                            <script>
                                $(document).ready(function(){
                                    function checkMovieActor(){
                                        var result;
                                        $.ajax({
                                            url: "checkMovieActorServlet",
                                            type:"POST",
                                            async:false,
                                            data:{
                                                "movieId":${requestScope.movie.movieId},
                                                "actorId":$("#addActorInput").val()
                                            },
                                            success: function(data){
                                                result = (data === "true");
                                            },
                                            error: function(){
                                                alert("error");
                                            }
                                        })
                                        console.log(result);
                                        return result;
                                    }
                                    $("#addActorInput").blur(function () {
                                        if(checkMovieActor() === false){
                                            $("#actorErrorInfo").css("display", "inline");
                                            $("#actorErrorInfo").html("该演员ID不存在或者已经被添加到该电影");
                                            $("#addActorBtn").attr("disabled",true);
                                        }else{
                                            $("#actorErrorInfo").css("display", "none");
                                            $("#addActorBtn").removeAttr("disabled",false);
                                        }
                                    })

                                })
                            </script>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="addActorBtn" class="btn btn-sm btn-light-green" type="button" ><i class="fas fa-comment-dots"></i> 确认添加 </button>
                    <script>
                        function addMovieActor(){
                            $.ajax({
                                url:"addMovieActorServlet",
                                type:"POST",
                                data:{
                                    "movieId":${requestScope.movie.movieId},
                                    "actorId":$("#addActorInput").val(),
                                },
                                success: function(){
                                    alert("添加成功")
                                    window.location.reload(); // 直接重新刷新页面
                                },
                                error: function(){
                                    alert("error");
                                }
                            })
                        }
                        $(document).ready(function (){
                            $("#addActorBtn").click(function (){
                                addMovieActor($("#addActorInput").val());
                            })
                        })
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
