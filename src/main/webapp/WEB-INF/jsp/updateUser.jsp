<%--
  Created by IntelliJ IDEA.
  User: Zhangxq
  Date: 2016/7/16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
    <form action="/user/update?id=${user.id}" method="Post">
       用户名： <input type="input" name="userName" value="${user.userName}"><br />
        手机号：<input type="input" name="userPhone" value="${user.userPhone}"><br />
       邮箱：<input type="input" name="userEmail" value="${user.userEmail}"><br />
        密码：<input type="input" name="pwd" value="${user.userPwd}"><br />
        <input type="submit" value="注册">
    </form>
</body>
</html>
