<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.impl.BookServiceImpl" %>
<%@ page import="team.sdguys.service.BookService" %>
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
    <title>图书管理</title>
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
        // 修改图书
        $("#addBookBtn").click(function () {
            $.ajax({
                url:"modifyOneBookServlet",
                type: "POST",
                data:{
                    "id":${requestScope.book.BId},
                    "chineseName":$("#chineseName").val(),
                    "originName":$("#originName").val(),
                    "cover":$("#cover").attr("src"),
                    "type":$("#type").val(),
                    "releaseDate":$("#releaseDate").val(),
                    "language":$("#language").val(),
                    "publisher":$("#publisher").val(),
                    "pageCount":$("#pageCount").val(),
                    "content":$("#content").val(),
                    "binding":$("#binding").val(),
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
    function modifyBookAuthor(authorId){
        $.ajax({
            url:"modifyBookAuthorServlet",
            type:"POST",
            data:{
                "authorId":authorId,
                "bookId":${requestScope.book.BId},
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
    // 弹出添加作者模态框
    function showAddAuthorModal(){
        $("#addAuthorModal").modal('show');
    }
</script>
<body style="font-size: 14px">
<%@include file="/jsp/adminNavbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 770px;">
        <h1 class="title mb-4">发布图书</h1>
        <hr>
        <div style="width: 400px">
            <form>
                <h6>中文名</h6>
                <div class="md-form form-sm">
                    <input type="text" id="chineseName" class="form-control" value="${requestScope.book.BChineseName}">
                    <label for="chineseName" class="">图书中文名</label>
                </div>
                <h6>原名</h6>
                <div class="md-form form-sm">
                    <input type="text" id="originName" class="form-control" value="${requestScope.book.BOriginName}">
                    <label for="originName" class="">图书原名</label>
                </div>
                <h6>封面</h6>
                <div class="md-form">
                    <div style="width: 160px;   display:inline-block">
                        <img class="cover" id="cover" src="${requestScope.book.bCover}">
                    </div>
                    <input type="file" id="coverInput" name="file" class="form-control" hidden>
                    <button id="chooseBtn" class="btn btn-light-green btn-sm" type="button">选择封面</button>
                    <button class="btn btn-light-green btn-sm" id="uploadBtn" type="button">上传</button>
                </div>
                <h6>类型</h6>
                <div class="md-form form-sm">
                    <input type="text" id="type" class="form-control" value="${requestScope.book.BType}">
                    <label for="type" class="">图书类型</label>
                </div>
                <h6>出版日期</h6>
                <div class="md-form">
                    <input placeholder="Select date" type="date" id="releaseDate" class="form-control" value="<fmt:formatDate value="${requestScope.book.BReleaseDate}" pattern="yyyy-MM-dd"/>">
                </div>
                <h6>语言</h6>
                <div class="md-form form-sm">
                    <input type="text" id="language" class="form-control" value="${requestScope.book.bLanguage}">
                    <label for="language" class="">语言</label>
                </div>
                <h6>出版社</h6>
                <div class="md-form form-sm">
                    <input type="text" id="publisher" class="form-control" value="${requestScope.book.BPublisher}">
                    <label for="publisher" class="">出版社</label>
                </div>
                <h6>装帧</h6>
                <div class="md-form form-sm">
                    <input type="text" id="binding" class="form-control" value="${requestScope.book.bBinding}">
                    <label for="binding" class="">装帧</label>
                </div>
                <h6>页数</h6>
                <div class="md-form form-sm">
                    <input class="quantity" min="0" name="pageCount" id="pageCount" value="${requestScope.book.bPageCount}" type="number">
                </div>
                <h6>简介</h6>
                <div class="md-form md-outline">
                    <textarea id="content" class="md-textarea form-control" rows="5" style="width: 700px">${requestScope.book.bContent}</textarea>
                    <label for="content">图书简介....</label>
                </div>
                <button class="btn btn-light-green btn-sm" id="addBookBtn" type="button">确认修改</button>
            </form>
        </div>
        <div>
            <br><br>
            <h1 class="title mb-4">
                图书作者
                <a class="btn btn-sm btn-light-green" type="button" href="javascript:showAddAuthorModal()">添加作者</a>
            </h1>
            <hr>
            <c:if test="${ not empty requestScope.author}">
                <div class="table">
                    <table class="table table-hover table-borderless text-center">
                        <thead>
                        <tr>
                            <th scope="col">个人照</th>
                            <th scope="col">作者</th>
                            <th scope="col">删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="directorTr${requestScope.author.authorId}">
                            <td class="ml-auto mt-auto">
                                <img id="directorImg" class="tableImg" src="${requestScope.author.authorImg}">
                            </td>
                            <td class="p-5">${requestScope.author.authorChineseName}</td>
                            <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:modifyBookAuthor('0')">删除</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/adminSiderbar.jsp"%>
    <!-- 添加作者信息模态框 -->
    <div class="modal fade" id="addAuthorModal" tabindex="-1" role="dialog" backdrop="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">添加作者信息</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" id="modifyUserId" class="form-control">
                        <h5>作者ID</h5>
                        <div class="md-form form-sm">
                            <input type="text" id="addAuthorInput" class="form-control" placeholder="请输入作者ID">
                            <div class="errorInfo" id="errorInfo"></div>
                            <script>
                                $(document).ready(function(){
                                    function checkBookAuthor(){
                                        var result;
                                        $.ajax({
                                            url: "checkBookAuthorServlet",
                                            type:"POST",
                                            async:false,
                                            data:{
                                                "bookId":${requestScope.book.BId},
                                                "authorId":$("#addAuthorInput").val()
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
                                    $("#addAuthorInput").blur(function () {
                                        if(checkBookAuthor() === false){
                                            $("#errorInfo").css("display", "inline");
                                            $("#errorInfo").html("该作者ID不存在或者已经被添加到该图书");
                                            $("#addAuthorBtn").attr("disabled",true);
                                        }else{
                                            $("#errorInfo").css("display", "none");
                                            $("#addAuthorBtn").removeAttr("disabled",false);
                                        }
                                    })

                                })
                            </script>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="addAuthorBtn" class="btn btn-sm btn-light-green" type="button" ><i class="fas fa-comment-dots"></i> 确认添加 </button>
                    <script>
                        $(document).ready(function (){
                            $("#addAuthorBtn").click(function (){
                                modifyBookAuthor($("#addAuthorInput").val());
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
