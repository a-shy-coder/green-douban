<%--
  Created by IntelliJ IDEA.
  User: 12859
  Date: 2021/5/19
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>测试</title>
    <script src="js/jquery.js"></script>
</head>
<script>
    $(document).ready(function (){
        $("#test").click(function (){
            $.ajax({
                url:"validateEmailIsAvailableServlet",
                type:"GET",
                data:{"email":"1285929172@qq.com"},
                success:function (data){
                    // window.location.href = "validateEmailIsAvailableServlet" 可以从JS中通过URL的方式请求Servlet,但必须为GET请求
                    console.log(data)
                },
                error:function (data){
                    console.log(data);
                }
            })
        })
    })
</script>
<body>
    <button id="test" type="button">ajax请求</button>
</body>
</html>
