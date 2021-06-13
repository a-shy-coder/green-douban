<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>登录</title>
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

    $(document).ready(function () {
        inputModifyListener();


        // 登录表单验证
        function formValidation() {
            if ($("#email").val() === '') {
                $("#emailErrorInfo").css("display", "inline");
            }
            if ($("#password").val() === '') {
                $("#passwordErrorInfo").css("display", "inline");
            }
            if ($("#password").val !== '' && $("#email").val() !== '') {
                validateLogin();
            }
        }

        $('#loginBtn').click(formValidation);

        // 验证登录(用户名密码是否正确)
        function validateLogin() {
            $.ajax({
                url: "validateLoginPasswordIsCorrectServlet",
                type: "GET",
                data: {
                    "email": $("#email").val(),
                    "password": hex_md5($("#password").val())
                },
                success: function (data) {
                    if (data === "false") {
                        $("#loginErrorInfo").css("display", "block");
                    }else{
                        window.location.href = "loginServlet?email=" + $("#email").val() + "&password=" + hex_md5($("#password").val());
                    }
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        // 监听表单input是否修改
        function inputModifyListener() {
            $("#email").blur(function () {
                if ($("#email").val() !== '') {
                    $("#emailErrorInfo").css("display", "none");
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

    });
</script>
<body style="background-color: #f2f2f2">
<div class="container">
    <div class="col-7 mx-auto  z-depth-1 card-body" style="background-color: white">
        <div class="card-body">
            <h2 class="text-center ">欢迎登录</h2>
            <form action="admin\login.jsp" class="loginForm" novalidate>
                <h5>邮箱</h5>
                <div class="md-form form-sm">
                    <i class="far fa-envelope prefix"></i>
                    <input type="email" id="email" class="form-control" required>
                    <label for="email" class="">请输入您的邮箱</label>
                    <div class="errorMsg" id="emailErrorInfo">请输入正确的邮箱地址</div>
                </div>
                <h5>密码</h5>
                <div class="md-form form-sm">
                    <i class="fas fa-key prefix"></i>
                    <input type="password" id="password" class="form-control" autocomplete="true" required>
                    <label for="password" class="">请输入您的密码</label>
                    <div class="errorMsg" id="passwordErrorInfo">请输入密码</div>
                </div>
            </form>
            <div class="text-center pb-2">
                <a href="jsp/user/forgetPassword.jsp">忘记密码</a> |
                <a href="jsp/user/register.jsp">注册</a> |
                <a href="jsp/admin/login.jsp">管理员登录</a>
            </div>
            <div class="ml-auto text-center">
                <button class="btn btn-light-green btn-sm" id="loginBtn" type="button">登录</button>
                <div class="errorMsg" id="loginErrorInfo">用户名或密码错误</div>
            </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
