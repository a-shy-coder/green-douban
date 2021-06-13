<%@ page import="team.sdguys.entity.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>个人信息</title>
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
    $(document).ready(function(){

        // 选择头像
        $("#chooseBtn").click(function (){
            $("input[id='icon']").click();
        })
        
        //上传头像
        $("#uploadBtn").click(function (){
            var formData = new FormData();
            formData.append('file',$("input[id='icon']")[0].files[0]);
            $.ajax({
                url: 'uploadUserIconServlet',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (fileName) {
                    console.log(fileName);
                    $("#iconImg").attr("src",fileName);
                },
                error: function () {
                    alert("error");
                }
            });
        })
        // 地址级联选择器
        $('#areaSelect').cxSelect({
            url: 'JSON/cityData.min.json',
            selects: ['province', 'city', 'area'],
            nodata: 'none'
        });
        // 修改个人信息
        $("#modifyBtn").click(function(){
            $.ajax({
                url: "modifyUserInfoServlet",
                type:"POST",
                data:{
                    "nickyName":$("#nickyName").val(),
                    "iconImg":$("#iconImg").attr("src"),
                    "province":$(".province").val(),
                    "city":$(".city").val(),
                    "area":$(".area").val(),
                    "birthday":$("#birthday").val(),
                    "gender":$('input:radio[name="gender"]:checked').val(),
                    "sign":$("#sign option:selected").val()
                },
                success: function(){
                    alert("修改成功");
                    window.location.reload();
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        })
    })
</script>
<body style="font-size: 14px">
<%@include file="/jsp/navbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 700px">

        <!-- 我的个人信息 -->
        <h1 class="title mb-4">我的信息</h1>
        <hr>
        <div id="content1" class="clearfix">
            <div id="subContent1" class="float-left" style="width: 500px">
                <h5 class="mb-5 mt-3">您是绿豆芽的第${requestScope.user.uid}位用户 · · · · · ·</h5>
                <form id="infoForm">
                    <h5>您注册时的邮箱</h5>
                    <div class="md-form">
                        <input type="email" id="email" class="form-control" value="${requestScope.user.uemail}" disabled>
                    </div>
                    <h5>昵称</h5>
                    <div class="md-form">
                        <input type="text" id="nickyName" class="form-control" value="${requestScope.user.uname}">
                    </div>
                    <h5>头像</h5>
                    <div class="md-form">
                        <div style="width: 160px;   display:inline-block">
                            <img id="iconImg" src="${requestScope.userInfo.uicon}" style="width:160px; height:auto">
                        </div>
                        <input type="file" id="icon" name="file" class="form-control" hidden>
                        <button id="chooseBtn" class="btn btn-light-green btn-sm" type="button">选择头像</button>
                        <button class="btn btn-light-green btn-sm" id="uploadBtn" type="button">上传</button>
                    </div>
                    <h5>地址</h5>
                    <div class="mb-3" id="areaSelect">
                        <select class="form-control form-inline province" data-value="${requestScope.province}"></select>
                        <select class="form-control form-inline city" data-value="${requestScope.city}"></select>
                        <select class="form-control form-inline area" data-value="${requestScope.area}"></select>
                    </div>
                    <h5>生日</h5>
                    <div class="md-form">
                        <input placeholder="Select date" type="date" id="birthday" class="form-control" value="${requestScope.userInfo.ubirthday}">
                    </div>

                    <h5>性别</h5>
                    <div class="custom-control custom-radio custom-control-inline mb-3">
                        <%
                            UserInfo userInfo = (UserInfo) request.getAttribute("userInfo");
                            String gender = userInfo.getUgender();
                            if("男".equals(gender)){
                        %>
                        <input type="radio" class="custom-control-input" id="radio1" value="男" name="gender" checked>

                        <%
                            }else{
                        %>
                            <input type="radio" class="custom-control-input" id="radio1" value="男" name="gender">
                        <%}%>
                        <label class="custom-control-label" for="radio1">男</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline" mb-3>
                        <%
                        if("女".equals(gender)){
                        %>
                        <input type="radio" class="custom-control-input" id="radio2" value="女" name="gender" checked>

                        <%
                            }else{
                        %>
                        <input type="radio" class="custom-control-input" id="radio2" value="女" name="gender">
                        <%}%>
                        <label class="custom-control-label" for="radio2">女</label>
                    </div>

                    <h5 class="mt-3">星座</h5>
                    <select class="browser-default custom-select mb-3" name="sign" id="sign">
                        <option value="${requestScope.userInfo.usign}" selected>${requestScope.userInfo.usign}</option>
                        <option value="白羊座">白羊座</option>
                        <option value="金牛座">金牛座</option>
                        <option value="双子座">双子座</option>
                        <option value="巨蟹座">巨蟹座</option>
                        <option value="狮子座">狮子座</option>
                        <option value="处女座">处女座</option>
                        <option value="天秤座">天秤座</option>
                        <option value="天蝎座">天蝎座</option>
                        <option value="射手座">射手座</option>
                        <option value="摩羯座">摩羯座</option>
                        <option value="水瓶座">水瓶座</option>
                        <option value="双鱼座">双鱼座</option>
                    </select>
                    <button class="btn btn-light-green btn-sm" id="modifyBtn" type="button">确认修改</button>
                </form>

            </div>
        </div>
    </div>
    <div id="sidebar" class="float-right">
        <div class="treeview w-20 text-right">
            <h6 class="pt-3 pl-3">我的空间</h6>
            <br>
            <ul class="mb-1 pl-3 pb-2">
                <li class="mb-2"><a href="#"><i class="far fa-user ic-w mr-1"></i>我的信息</a></li>
                <li class="mb-2"><a href="#"><i class="far fa-edit ic-w mr-1"></i>我的日志</a></li>
                <li class="mb-2"><a href="#"><i class="far fa-star ic-w mr-1"></i>我的收藏</a></li>
                <li class="mb-2"><a href="#"><i class="far fa-comment ic-w mr-1"></i>我的评论</a></li>
                <li class="mb-2"><a href="#"><i class="far fa-comment ic-w mr-1"></i>我的回复</a></li>
            </ul>
        </div>
    </div>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
