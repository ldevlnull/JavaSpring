<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Files</title>
</head>
<body>
    <c:if test="${message}">
        <h2>${message}</h2>
    </c:if>
    <div>
        <form enctype="multipart/form-data" method="post" action="/upload">
            <label for="file">Upload File: </label>
            <input name="file" id="file" type="file"/>
            <input type="submit" value="Upload">
        </form>
    </div>
    <div>
        <ul>
            <c:forEach items="${files}" var="file">
                <li><a href="${file}">${file}</a></li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
