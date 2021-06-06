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

        // 点击重置密码, 进行重置密码
        $("#resetPasswordBtn").click(function () {
            if(formValidation() === true){
                resetPassword();
            }
        })

        function resetPassword() {
            $.ajax({
                url: "resetPasswordServlet",
                type: "GET",
                async: false, // 同步请求,如果是异步请求,则 return result 与 success 是 并行的, 这样 result 就成了 undefined
                data: {
                    "email": $("#email").val(),
                    "password":hex_md5($("#password").val())
                },
                success: function (data) {
                    console.log(data);
                },
                error: function () {
                    alert("请求方式错误");
                }
            })

        }
        // 表单验证
        function formValidation(){
            var flag = true;
            var passwordReg=/^(?![^a-zA-Z]+$)(?!\D+$)/;

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
            return flag;
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
                    <input type="email" id="email" class="form-control" value="<%=request.getParameter("email")%>" readonly>
                    <label for="email" class="">注册邮箱</label>
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
            </form>
            <div class="ml-auto text-center">
                <button class="btn btn-light-green btn-sm" type="button" id="resetPasswordBtn">重置密码</button>
            </div>
            </form>
        </div>
    </div>
</div>
</div>

</body>
</html>
