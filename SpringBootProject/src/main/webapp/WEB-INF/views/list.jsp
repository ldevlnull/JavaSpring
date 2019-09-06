<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<h1>Users List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th><a href="/users/${requestScope.get("page")}/id">Id</a></th>
        <th><a href="/users/${requestScope.get("page")}/username">Username</a></th>
        <th><a href="/users/${requestScope.get("page")}/email">Email</a></th>
        <th><a href="/users/${requestScope.get("page")}/password">Password</a></th>
        <th><a href="/users/${requestScope.get("page")}/age">Age</a></th>
        <th><a href="/users/${requestScope.get("page")}/phone">Phone</a></th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.email}</td>
            <td>${u.password}</td>
            <td>${u.age}</td>
            <td>${u.phone}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<div>
    <a href="/users/1/${requestScope.get("sort")}">1</a>
    <a href="/users/2/${requestScope.get("sort")}">2</a>
    <a href="/users/3/${requestScope.get("sort")}">3</a>
    <a href="/users/4/${requestScope.get("sort")}">4</a>
    <a href="/users/5/${requestScope.get("sort")}">5</a>
</div>
<div>
    <a href="/">Back</a>
</div>
</body>
</html>
