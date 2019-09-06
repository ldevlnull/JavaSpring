<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="${pageContext.request.contextPath}/performLogin" method="post">
    <span class="error">${message}</span>
    <div>
        <input type="text" name="username" id="username" placeholder="Username">
        <input type="password" name="password" id="password" placeholder="Password">
        <input type="submit" value="Login">
    </div>
</form>
<div>
    <a href="${pageContext.request.contextPath}/registration">First time?</a>
</div>
<div>
    <a href="${pageContext.request.contextPath}/">Back</a>
</div>
</body>
</html>
