<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.07.2019
  Time: 14:29 Uhr
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
</head>
<body>
    <form:form modelAttribute="user" action="/addValidatedUser">
        <div>
            <form:label path="username">Username: </form:label>
            <form:input path="username"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div>
            <form:label path="email">Email: </form:label>
            <form:input path="email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <div>
            <form:label path="password">Password: </form:label>
            <form:input type="password" path="password"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div>
        <div>
            <form:label path="age">Age: </form:label>
            <form:input path="age"/>
            <form:errors path="age" cssClass="error"/>
        </div>
        <div>
        <div>
            <form:label path="phone">Phone: </form:label>
            <form:input path="phone"/>
            <form:errors path="phone" cssClass="error"/>
        </div>
        <div>
            <input type="submit" value="Save"/>
        </div>
    </form:form>
</body>
</html>
