<%@ page import="java.util.List" %>
<%@ page import="team.sdguys.service.impl.ActorServiceImpl" %>
<%@ page import="team.sdguys.service.ActorService" %>
<%@ page import="team.sdguys.service.impl.ActorServiceImpl" %>
<%@ page import="team.sdguys.service.ActorService" %>
<%@ page import="team.sdguys.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>演员信息管理</title>
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
    })
    // 删除演员
    function deleteActor(actorId){
        $.ajax({
            url:"deleteOneActorServlet",
            type:"GET",
            data:{
                "actorId":actorId,
            },
            success(){
                $("tr[id=actorTr"+actorId+"]").fadeOut('slow');
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
        <h1 class="title mb-4">演员信息管理
            <a href="jsp/admin/addActorInfo.jsp" class="btn btn-sm btn-outline-light-green m-0 ml-5">添加演员信息</a>
        </h1>
        <hr>
        <div class="table">
            <table class="table table-hover table-borderless text-center">
                <thead>
                <tr>
                    <th scope="col">个人照</th>
                    <th scope="col">演员</th>
                    <th scope="col">修改</th>
                    <th scope="col">删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.page.dataList}" var="actor">
                    <tr id="actorTr${actor.actorId}">
                        <td class="ml-auto mt-auto">
                            <img id="actorImg" class="tableImg" src="${actor.actorImg}">
                        </td>
                        <td class="p-5">${actor.actorChineseName}</td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="modifyActorInfoServlet?actorId=${actor.actorId}">修改</a></td>
                        <td style="padding: 40px"><a class="btn btn-sm btn-outline-light-green" type="button" href="javascript:deleteActor('${actor.actorId}')">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <div class="text-center">
                    <nav aria-label="Page navigation">
                        <ul class="pagination pagination-circle pg-blue">
                            <li class="page-item"><a class="page-link" href="actorManagementInfoServlet?pageNo=1">首页</a></li>
                            <li class="page-item"><a class="page-link" href="actorManagementInfoServlet?pageNo=${page.previousPage}">上一页</a></li>
                            <c:forEach items="${requestScope.page.navPages}" var="i">
                                <c:if test="${i != 0}">
                                    <li class="${i==page.pageNo?'active':''} page-item"><a class="page-link" href="actorManagementInfoServlet?pageNo=${i}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                            <li class="page-item"><a class="page-link" href="actorManagementInfoServlet?pageNo=${page.nextPage}">下一页</a></li>
                            <li class="page-item"><a class="page-link" href="actorManagementInfoServlet?pageNo=${page.totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </table>
        </div>
    </div>
    <!-- 侧边栏 -->
    <%@include file="/jsp/adminSiderbar.jsp"%>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
