<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/15/2020
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="${pageContext.request.contextPath}/product"> Back To Product</a>
</p>
<form method="post">
    <h3>Are You Sure?</h3>
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Id : </td>
                <td><input type="text" name="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name : </td>
                <td><input type="text" name="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price : </td>
                <td><input type="number" name="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" value="${requestScope["product"].getDescription()}"></td>
            </tr>
            <tr>
                <td>producer</td>
                <td><input type="text" name="producer" value="${requestScope["product"].getProducer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
