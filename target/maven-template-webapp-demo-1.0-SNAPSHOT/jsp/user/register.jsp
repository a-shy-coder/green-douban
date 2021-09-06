<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>注册</title>
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
    $(document).ready(function (){

        // 监听表单是否更改
        inputModifyListener();

        // 点击注册, 完整验证和注册
        $("#registerBtn").click(function () {
            if(formValidation() === true){
                register();
            }
        })

        // 点击按钮发送验证码
        $("#sendVerificationCodeBtn").click(function (){
            // 邮箱不能为空
            if ($("#email").val() === '') {
                $("#emailErrorInfo").css("display", "inline");
                $("#emailErrorInfo").html("请输入邮箱");
            }else{
                sendVerificationCode();
                countDown60s();
            }
        })

        var countDown;
        var timer;
        // 倒计时 60s
        function countDown60s(){
            countDown = 60; // 测试效果, 请把60改小
            timer = setInterval(function (){
                resendVerificationCode()
            },1000)
        }

        // 设置 倒计时 按钮样式
        function resendVerificationCode(){
            if(countDown <= 0){
                $("#sendVerificationCodeBtn").removeAttr("disabled");
                $("#sendVerificationCodeBtn").html("发送验证码");
                clearInterval(timer);
            }else{
                $("#sendVerificationCodeBtn").attr("disabled",true);
                $("#sendVerificationCodeBtn").html(countDown + "(s)");
                countDown --;
            }

        }

        // 邮箱是否已经注册过账号(ajax同步请求) true 已经注册过 false 未注册过
        function emailIsAvailable(email){
            var result;
            $.ajax({
                url: "validateEmailIsAvailableServlet",
                type: "GET",
                async: false, // 同步请求,如果是异步请求,则 return result 与 success 是 并行的, 这样 result 就成了 undefined
                data: {
                    "email": email,
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

        // 发送验证码(ajax请求)
        function sendVerificationCode(){
            $.ajax({
                url: "sendVerificationCodeServlet",
                type: "GET",
                data: {
                    "email": $("#email").val(),
                },
                error: function () {
                    alert("请求方式错误");
                }
            })
        }

        //验证码是否正确(ajax同步请求)
        function validateVerificationCode(verificationCode){
            var result;
            $.ajax({
                url: "validateVerificationCodeServlet",
                type: "GET",
                async:false,
                data: {
                    "verificationCode": verificationCode,
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

        // 表单验证
        function formValidation(){
            var flag = true;
            var emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            var passwordReg=/^(?![^a-zA-Z]+$)(?!\D+$)/;

            // 邮箱是否为空 邮箱格式是否正确 邮箱是否已经注册过账号
            if ($("#email").val() === '') {
                $("#emailErrorInfo").css("display", "inline");
                $("#emailErrorInfo").html("请输入邮箱");
                flag = false;
            }else if(emailReg.test($("#email").val()) === false){
                $("#emailErrorInfo").css("display", "inline");
                $("#emailErrorInfo").html("请正确的邮箱格式");
                flag = false;
            }else if(emailIsAvailable($("#email").val()) === true){
                $("#emailErrorInfo").css("display", "inline");
                $("#emailErrorInfo").html("该邮箱已经注册过账号, 请直接登录");
                flag = false;
            }

            // 密码是否为空  密码必须为6-18位字母、数字
            if ($("#password").val() === '') {
                $("#passwordErrorInfo").css("display", "inline");
                $("#passwordErrorInfo").html("请输入密码");
                flag = false;
            }else if(passwordReg.test($("#password").val()) === false) {
                $("#passwordErrorInfo").css("display", "inline");
                $("#passwordErrorInfo").html("密码必须为6-18位字母和数字");
                flag = false;
            }

            // 重复密码是否为空 两次输入是否相同
            if ($("#rePassword").val() === '') {
                $("#rePasswordErrorInfo").css("display", "inline");
                $("#rePasswordErrorInfo").html("请再次输入密码");
                flag = false;
            }else if($("#rePassword").val() !== $("#password").val()) {
                $("#rePasswordErrorInfo").css("display", "inline");
                $("#rePasswordErrorInfo").html("两次输入的密码不一致");
                flag = false;
            }

            // 昵称是否为空
            if ($("#userName").val() === '') {
                $("#userNameErrorInfo").css("display", "inline");
                $("#userNameErrorInfo").html("请设置您的昵称");
                flag = false;
            }

            // 验证吗是否为空 验证码输入是否正确
            if ($("#verificationCode").val() === '') {
                $("#verificationCodeErrorInfo").css("display", "inline");
                $("#verificationCodeErrorInfo").html("请输入验证码");
                flag = false;
            }else if(validateVerificationCode($("#verificationCode").val()) === false){
                $("#verificationCodeErrorInfo").css("display", "inline");
                $("#verificationCodeErrorInfo").html("验证码输入有误");
                flag = false;
            }
            return flag;
        }

        // 注册(非ajax请求)
        function register(){
            window.location.href = "registerServlet?email=" + $("#email").val() + "&password=" + hex_md5($("#password").val()) + "&userName=" + $("#userName").val();
        }

        // 监听表单input是否修改
        function inputModifyListener() {
            $("#email").blur(function () {
                if ($("#email").val() !== '') {
                    $("#emailErrorInfo").css("display", "none");
                }
            })
            $("#password").blur(function () {
                if ($("#password").val() !== '') {
                    $("#passwordErrorInfo").css("display", "none");
                }
            })
            $("#rePassword").blur(function () {
                if ($("#rePassword").val() !== '') {
                    $("#rePasswordErrorInfo").css("display", "none");
                }
            })
            $("#userName").blur(function () {
                if ($("#userName").val() !== '') {
                    $("#userNameErrorInfo").css("display", "none");
                }
            })
            $("#verificationCode").blur(function () {
                if ($("#verificationCode").val() !== '') {
                    $("#verificationCodeErrorInfo").css("display", "none");
                }
            })

        }



    })
</script>
<body style="background-color: #f2f2f2">
<div class="container">
    <div class="col-7 mx-auto  z-depth-1 card-body" style="background-color: white">
        <div class="card-body">
            <h2 class="text-center ">欢迎注册</h2>
            <form action="#">
                <h5>邮箱</h5>
                <div class="md-form form-sm">
                    <input type="email" id="email" class="form-control">
                    <label for="email" class="">请输入注册邮箱</label>
                    <div class="errorMsg" id="emailErrorInfo"></div>
                </div>
                <h5>密码</h5>
                <div class="md-form form-sm">
                    <input type="password" id="password" class="form-control" autocomplete="true">
                    <label for="password" class="">密码必须为6-18位字母和数字</label>
                    <div class="errorMsg" id="passwordErrorInfo"></div>
                </div>
                <h5>确认密码</h5>
                <div class="md-form form-sm">
                    <input type="password" id="rePassword" class="form-control" autocomplete="true">
                    <label for="rePassword" class="">请再次确认您的密码</label>
                    <div class="errorMsg" id="rePasswordErrorInfo"></div>
                </div>
                <h5>昵称</h5>
                <div class="md-form form-sm">
                    <input type="text" id="userName" class="form-control" autocomplete="true">
                    <label for="userName" class="">请设置您的昵称</label>
                    <div class="errorMsg" id="userNameErrorInfo"></div>
                </div>
                <h5>验证码</h5>
                <div class="md-form form-sm form-inline">
                    <input type="text" id="verificationCode" class="form-control col-9" autocomplete="true">
                    <label for="verificationCode" class="">输入验证码</label>
                    <button class="btn btn-light-green btn-sm" id="sendVerificationCodeBtn" type="button">发送验证码</button>
                    <div class="errorMsg" id="verificationCodeErrorInfo"></div>
                </div>

            </form>
            <div class="text-center pb-2">
                <a href="jsp/user/login.jsp">已有账号? 点此登录</a>
            </div>
            <div class="ml-auto text-center">
                <button class="btn btn-light-green btn-sm" id="registerBtn" type="button">注册</button>
            </div>
            </form>
        </div>
    </div>
</div>
</div>

</body>
</html>
