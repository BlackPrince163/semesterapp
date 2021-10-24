<%--
  Created by IntelliJ IDEA.
  User: niazh
  Date: 23.10.2021
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <form action="/signUp" method="post" class="form">
        <p>Sign up</p>
        <p>
            <label for="first_name">fist name<input id="first_name" type="text" name="first_name"><Br></label>
            <label for="last_name">last name<input id="last_name" type="text" name="last_name"><Br></label>
            <label for="login">Login<input id="login" type="text" name="login"><Br></label>
            <label for="password">Password<input id="password" type="password" name="password"><Br></label>
            <label for="repassword">Repassword<input id="repassword" type="password" name="repassword"><Br></label>
        </p>
        <p><button type="submit">Зарегистрироваться</button></p>
    </form>
</body>
</html>
