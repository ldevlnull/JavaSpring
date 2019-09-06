<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product Control</h1>
<form:form modelAttribute="product" action="/newProduct" method="post">
    <div>
        <form:input placeholder="Name" path="productName"/>
        <span id="error">${product.invalidProductName}</span>
    </div>
    <div>
        <form:input placeholder="Price" path="price"/>
        <span id="error">${product.invalidPrice}</span>
    </div>
    <div>
        <form:input placeholder="Amount" path="amount"/>
        <span id="error">${product.invalidAmount}</span>
    </div>
    <div>
        <form:input placeholder="Manufacturer" path="manufacturer"/>
        <span id="error">${product.manufacturer}</span>
    </div>
    <div>
        <f:input placeholder="Description" path="description"/>
        <span id="error">${product.description}</span>
    </div>
    <input type="submit" value="Save">
</form:form>
<a href="${pageContext.request.contextPath}/home">Back</a>
</body>
</html>
