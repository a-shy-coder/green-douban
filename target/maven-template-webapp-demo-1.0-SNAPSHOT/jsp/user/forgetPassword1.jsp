<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>找回密码</title>
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
<body style="background-color: #f2f2f2">
<script>
    $(document).ready(function(){

        // 监听表单是否更改
        inputModifyListener();

        // 点击下一步, 进行重置密码
        $("#nextBtn").click(function () {
            window.location.href = "jsp/user/forgetPassword2.jsp?email=" + $("#email").val();

            // if(formValidation() === true){
            //     window.location.href = "jsp/user/forgetPassword2.jsp?email=" + $("#email").val();
            // }
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
            }else if(emailIsAvailable($("#email").val()) === false){
                $("#emailErrorInfo").css("display", "inline");
                $("#emailErrorInfo").html("该邮箱还没有注册过");
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

        // 监听表单input是否修改
        function inputModifyListener() {
            $("#email").blur(function () {
                if ($("#email").val() !== '') {
                    $("#emailErrorInfo").css("display", "none");
                }
            })
            $("#verificationCode").blur(function () {
                if ($("#verificationCode").val() !== '') {
                    $("#verificationCodeErrorInfo").css("display", "none");
                }
            })

        }

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
    })
</script>
<div class="container">
    <div class="col-7 mx-auto  z-depth-1 card-body" style="background-color: white">
        <div class="card-body">
            <h2 class="text-center ">找回密码</h2>
            <form action="#">
                <h5>邮箱</h5>
                <div class="md-form form-sm">
                    <input type="email" id="email" class="form-control">
                    <label for="email" class="">请输入注册邮箱</label>
                    <div class="errorMsg" id="emailErrorInfo"></div>
                </div>
                <h5>验证码</h5>
                <div class="md-form form-sm form-inline">
                    <input type="text" id="verificationCode" class="form-control col-9" autocomplete="true">
                    <label for="verificationCode" class="">输入验证码</label>
                    <button class="btn btn-light-green btn-sm" id="sendVerificationCodeBtn" type="button">发送验证码</button>
                    <div class="errorMsg" id="verificationCodeErrorInfo"></div>
                </div>
            </form>
            <div class="ml-auto text-center">
                <button class="btn btn-light-green btn-sm" id="nextBtn" type="button">下一步</button>
            </div>
            </form>
        </div>
    </div>
</div>
</div>

</body>
</html>
