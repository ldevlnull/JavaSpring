<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Log In</h1>
    <form action="/login" method="post">
        <label for="username">Username: </label>
        <input type="text" id="username" name="username">
        <label for="password">Password: </label>
        <input type="password" name="password" id="password">
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
