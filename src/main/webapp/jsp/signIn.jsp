<%--
  Created by IntelliJ IDEA.
  User: niazh
  Date: 24.10.2021
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signin</title>
</head>
<body>
<form action="/signIn" method="post" class="form">
    <p>Sign up</p>
    <p>
        <label for="login">Login<input id="login" type="text" name="login"><Br></label><br>
        <label for="password">Password<input id="password" type="password" name="password"><Br></label>
    </p>
    <p><button type="submit">Войти</button></p>
</form>
</body>
</html>
