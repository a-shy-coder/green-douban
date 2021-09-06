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
    <title>账号管理</title>
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
    $(document).ready(function(){
        // 点击按钮, 弹出添加管理员模态框
        $("#addAdminModalBtn").click(function (){
            $("#addAdminModal").modal('show');
        });
        $("#addAdminBtn").click(addAdmin);
        $("#modifyAdminBtn").click(modifyAdmin);
    })
    // 删除管理员用户
    function deleteAdmin(adminId){
        $.ajax({
            url:"deleteAdminServlet",
            type:"GET",
            data:{
                "adminId":adminId,
            },
            success(){
                $("tr[id=adminTr"+adminId+"]").fadeOut('slow');
            },
            error(){
                alert("error");
            }
        })
    }
    // 弹出修改模态框
    function showModifyModal(adminId,adminUserName,adminPassword){
        $("#modifyAdminModal").modal('show');
        // 设置表单内容
        $("#modifyUserName").val(adminUserName);
        $("#modifyPassword").val(adminPassword);
        $("#modifyUserId").val(adminId);
    }
    // 修改管理员信息
    function modifyAdmin(){
        $.ajax({
            url:"modifyAdminServlet",
            type: "GET",
            data:{
                "adminId": $("#modifyUserId").val(),
                "adminPassword": hex_md5($("#modifyPassword").val())
            },
            success(){
                window.location.reload(); // 直接重新刷新页面
            },
            error(){
                alert("error");
            }
        })
    }
    // 添加管理员信息
    function addAdmin(){
        $.ajax({
            url:"addAdminServlet",
            type: "GET",
            data:{
                "userName":$("#addUserName").val(),
                "password":hex_md5($("#addPassword").val())
            },
            success(){
                window.location.reload(); // 直接重新刷新页面
            },
            error(){
                alert("error");
            }
        })
    }
</script>
<body style="font-size: 14px">
<%@include file="/jsp/adminNavbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 770px;">
        <h1 class="title mb-4">账号管理
            <button class="btn btn-sm btn-outline-light-green m-0 ml-5" id="addAdminModalBtn">新建账号</button>
        </h1>
        <hr>
        <div class="table">
            <table class="table table-hover table-borderless text-center">
                <thead>
                <tr>
                    <th scope="col" class="text-left">ID</th>
                    <th scope="col">用户名</th>
                    <th scope="col" class="text-left">密码(加密后)</th>
                    <th scope="col">修改</th>
                    <th scope="col">删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.adminList}" var="admin">
                    <tr id="adminTr${admin.aid}">
                        <td class="pt-5 text-left">${admin.aid}</td>
                        <td class="p-5">${admin.AUsername}</td>
                        <td class="pt-5 text-left">${admin.APassword}</td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:showModifyModal('${admin.aid}','${admin.AUsername}','${admin.APassword}')">修改</a></td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:deleteAdmin('${admin.aid}')">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/adminSiderbar.jsp"%>
    <!-- 添加管理员账号模态框 -->
    <div class="modal fade" id="addAdminModal" tabindex="-1" role="dialog" backdrop="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">添加管理员</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <h5>用户名</h5>
                        <div class="md-form form-sm">
                            <input type="text" id="addUserName" class="form-control">
                            <label for="addUserName" class="">请输入管理员用户名</label>
                        </div>
                        <h5>密码</h5>
                        <div class="md-form form-sm">
                            <input type="password" id="addPassword" class="form-control" autocomplete="true" required>
                            <label for="addPassword" class="">请输入管理员密码</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="addAdminBtn" class="btn btn-sm btn-light-green" type="button" ><i class="fas fa-comment-dots"></i> 添加 </button>
                </div>
            </div>
        </div>
    </div>
    <!-- 修改管理员账号模态框 -->
    <div class="modal fade" id="modifyAdminModal" tabindex="-1" role="dialog" backdrop="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">修改管理员</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" id="modifyUserId" class="form-control">
                        <h5>用户名</h5>
                        <div class="md-form form-sm">
                            <input type="text" id="modifyUserName" class="form-control" disabled>
                        </div>
                        <h5>密码</h5>
                        <div class="md-form form-sm">
                            <input type="password" id="modifyPassword" class="form-control" autocomplete="true" required>
                            <label for="addPassword" class="">请输入新的管理员密码</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="modifyAdminBtn" class="btn btn-sm btn-light-green" type="button" ><i class="fas fa-comment-dots"></i> 确认修改 </button>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
