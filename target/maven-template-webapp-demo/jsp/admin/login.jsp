<%--管理员登录页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>管理员登录</title>
    <link rel="shortcut icon" href="img/douban.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

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
        inputModifyListener();

        // 点击登录, 完成验证和登录
        $("#loginBtn").click(function () {
            if(formValidation() === true){
                // 验证密码是否正确
                validateLogin();
            }
        })

        // 监听表单input是否修改
        function inputModifyListener() {
            $("#username").blur(function () {
                if ($("#username").val() !== '') {
                    $("#usernameErrorInfo").css("display", "none");
                    $("#loginErrorInfo").css("display", "none");
                }
            })
            $("#password").blur(function () {
                if ($("#password").val() !== '') {
                    $("#passwordErrorInfo").css("display", "none");
                    $("#loginErrorInfo").css("display", "none");
                }
            })
        }

        // 管理员是否存在(ajax同步请求)
        function usernameIsAvailable(){
            var result;
            $.ajax({
                url: "validateUsernameIsAvailableServlet",
                type: "GET",
                async: false,
                data: {
                    "username": $("#username").val(),
                },
                success: function (data) {
                    result = (data === 'true');
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
            return result;
        }

        // 验证密码是否正确
        function validateLogin(){
            $.ajax({
                url: "validateAdminLoginPasswordIsCorrectServlet",
                type: "GET",
                data: {
                    "username": $("#username").val(),
                    "password": hex_md5($("#password").val())
                },
                success: function (data) {
                    if (data === "false") {
                        $("#loginErrorInfo").css("display", "block");
                    }else{
                        window.location.href = "adminLoginServlet?username=" + $("#username").val();
                    }
                },
                error: function (message) {
                    alert("error");
                    console.log(message);
                }
            })

        }


        // 表单验证
        function formValidation(){
            var flag = true;
            // 管理员是否为空 管理员是否存在
            if ($("#username").val() === '') {
                $("#usernameErrorInfo").css("display", "inline");
                $("#usernameErrorInfo").html("请输入用户名")
                flag = false;
            }else if(usernameIsAvailable($("#username").val()) === false){
                $("#usernameErrorInfo").css("display", "inline");
                $("#usernameErrorInfo").html("该管理员不存在");
                flag = false;
            }
            // 密码是否为空  密码必须为6-18位字母、数字
            if ($("#password").val() === '') {
                $("#passwordErrorInfo").css("display", "inline");
                $("#passwordErrorInfo").html("请输入密码");
                flag = false;
            }
            return flag;
        }
    })
</script>
<body style="background-color: #f2f2f2">
<div class="container">
    <div class="col-7 mx-auto  z-depth-1 card-body" style="background-color: white">
        <div class="card-body">
            <h2 class="text-center ">管理员登录</h2>
            <form action="#">
                <h5>用户名</h5>
                <div class="md-form form-sm">
                    <i class="far fa-user prefix"></i>
                    <input type="text" id="username" class="form-control">
                    <label for="username">请输入用户名</label>
                    <div class="errorMsg" id="usernameErrorInfo"></div>
                </div>
                <h5>密码</h5>
                <div class="md-form form-sm">
                    <i class="fas fa-key prefix"></i>
                    <input type="password" id="password" class="form-control" autocomplete="true">
                    <label for="password" class="">请输入密码</label>
                    <div class="errorMsg" id="passwordErrorInfo"></div>
                </div>
                </form>
                <div class="text-center pb-2">
                    <a href="jsp/user/login.jsp">普通用户登录</a>
                </div>
            <div class="ml-auto text-center">
                    <button class="btn btn-light-green btn-sm" type="button" id="loginBtn" >登录</button>
                    <div class="errorMsg" id="loginErrorInfo">用户名或密码错误</div>
            </div>
            </form>
        </div>
    </div>
</div>
</div>

</body>
</html>
