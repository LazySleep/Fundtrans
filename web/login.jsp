<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登陆基金交易系统</title>
    <link rel="stylesheet" href="resources/css/login.css" type="text/css" media="screen"/>
    <script language="javascript">
        function checkNull() {
            /*判断是否有空内容*/
            for (i = 0; i < form1.length; i++) {
                if (form1.elements[i].value == "") {
                    alert(form1.elements[i].title + "不能为空!");
                    form1.elements[i].focus();
                    return false;
                }
            }
        }
    </script>
</head>
<body>
<form name="form1" action="user/checkUser.action" method="post" onSubmit="return checkNull()">
    <div class="login-input-box">
        <span> 用户名:</span>
        <input name="user.name" type="text" >
    </div>
    <div class="login-input-box">
        <span>密码:</span>
        <input name="user.password" type="password">
    </div>
    <br>
    <input type="submit" value="登陆"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>