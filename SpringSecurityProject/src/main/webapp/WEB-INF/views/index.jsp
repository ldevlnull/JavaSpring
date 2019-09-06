<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>Welcome</h1>
<sec:authorize access="isAuthenticated()">
    <div>
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>
                    <a href="${pageContext.request.contextPath}/index?page=${param.get("page")}&sort=productName">Name</a>
                </th>
                <th><a href="${pageContext.request.contextPath}/index?page=${param.get("page")}&sort=price">Price</a>
                </th>
                <th><a href="${pageContext.request.contextPath}/index?page=${param.get("page")}&sort=manufacturer">Manufacturer</a>
                </th>
                <th><a href="${pageContext.request.contextPath}/index?page=${param.get("page")}&sort=amount">Amount</a>
                </th>
                <th><a href="${pageContext.request.contextPath}/index?page=${param.get("page")}&sort=description">Description</a>
                </th>
            </tr>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.productName}</td>
                    <td>${p.price}</td>
                    <td>${p.manufacturer}</td>
                    <td>${p.amount}</td>
                    <td>${p.description}</td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <a href="${pageContext.request.contextPath}/index?page=1&sort=${param.get("sort")}">1</a>
            <a href="${pageContext.request.contextPath}/index?page=2&sort=${param.get("sort")}">2</a>
            <a href="${pageContext.request.contextPath}/index?page=3&sort=${param.get("sort")}">3</a>
            <a href="${pageContext.request.contextPath}/index?page=4&sort=${param.get("sort")}">4</a>
            <a href="${pageContext.request.contextPath}/index?page=5&sort=${param.get("sort")}">5</a>
            <div>
                <form action="${pageContext.request.contextPath}/index?page=${param.get("page")}&sort=${param.get("sort")}">
                    <input type="number" width="5px" name="total" id="total" min="3" max="20">
                    <input type="submit" value="Ok">
                </form>
            </div>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/home">Home</a>
        </div>
        <div class="logout">
            Logged in user:
            <div>
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="submit" value="Logout">
                </form>
            </div>
        </div>
    </div>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <div>
        <a href="${pageContext.request.contextPath}/login">Log In with existing account</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/registration">Don't have an account yet?</a>
    </div>
</sec:authorize>
</body>
</html>
