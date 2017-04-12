<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/user/login" method="Post">
    用户名： <input type="input" name="userName"><br />
    密码：<input type="input" name="userPwd"><br />
    <input type="submit" value="登录"><br />
    <a href="/user/register">注册</a>
</form>
</body>
</html>
