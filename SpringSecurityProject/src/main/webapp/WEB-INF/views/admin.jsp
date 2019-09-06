<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.08.2019
  Time: 13:48 Uhr
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<sec:authorize access='hasRole("ROLE_ADMIN")'>
    <h2>Welcome, ${username}</h2>
    <a href="${pageContext.request.contextPath}/">Back</a>
</sec:authorize>
</body>
</html>
