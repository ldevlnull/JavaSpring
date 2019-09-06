<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="style1.css" rel="stylesheet">
</head>
<body>
    <h1>User Info</h1>
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
    <p>Password: ${user.password}</p>
    <p>Age: ${user.age}</p>
    <p>Phone: ${user.phone}</p>
    <a href="/">
        <button>Exit</button>
    </a>
</body>
</html>
