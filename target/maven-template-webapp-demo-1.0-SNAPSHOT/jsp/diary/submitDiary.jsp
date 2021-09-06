<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <base href="<%=request.getContextPath()%>/">
    <title>发表日志</title>
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

    <!-- wangEditor -->
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js"></script>
</head>
<script>
    $(document).ready(function (){
        diaryListener();
    })
    // 监听日志标题和日志内容是否为空, 为空不能提交
    function diaryListener(){
        if($("#diaryTitle").val() === ""){
            $("#submitBtn").addClass('disabled');
        }
        $("#diaryTitle").blur(function (){
            if($("#diaryTitle").val() === ""){
                $("#submitBtn").addClass('disabled');
            }else{
                $("#submitBtn").removeClass('disabled');
            }
        })
    }
</script>
<body style="font-size: 14px;">
<%@include file="/jsp/navbar.jsp"%>
<div class="container ml-auto clearfix" style="margin-top: 70px">
    <div id="article" class="float-left mt-3" style="width: 700px">
        <h1 class="title mb-4">发表日志</h1>
        <br>
        <h2 class="contentTitle">日志标题 · · · · · ·</h2>
        <div class="md-form form-sm">
            <input type="text" id="diaryTitle" class="form-control" placeholder="起个标题吧......"/>
        </div>
        <h2 class="contentTitle">写点什么吧 · · · · · ·</h2>
        <div id="diary" class="mt-4 mb-2"></div>
        <script type="text/javascript">
            const E = window.wangEditor;
            const editor = new E('#diary');
            editor.config.placeholder = "写点什么,记录你的生活吧......";
            editor.config.zIndex = 0;
            editor.config.uploadImgServer = 'uploadDiaryImageServlet';
            editor.create();
        </script>
        <button class="btn btn-light-green btn-sm" type="button" id="submitBtn">发表</button>
        <script>
            // 发表日志
            $("#submitBtn").click(function () {

                $.ajax({
                    url: 'uploadDiaryServlet',
                    type: 'POST',
                    data: {
                        diaryTitle: $("#diaryTitle").val(),
                        diaryContent: editor.txt.html()
                    },
                    success: function (data) {
                        alert("发表成功")
                        console.log(data);
                        window.location.href = "diaryInfoServlet?diaryId=" + data;
                        // 跳转日志详情页面
                    },
                    error: function () {
                        alert("error");
                    }
                });
            });
        </script>
    </div>
</div>
<%@include file="/jsp/footer.jsp"%>
<!-- Footer -->
</body>
</html>
