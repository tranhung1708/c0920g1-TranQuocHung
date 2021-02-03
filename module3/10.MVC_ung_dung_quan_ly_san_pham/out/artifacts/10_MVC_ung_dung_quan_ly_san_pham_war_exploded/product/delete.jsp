<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/15/2020
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="${pageContext.request.contextPath}/product">Back to Product</a>
</p>
<form method="post">
    <h3>Are You Sure?</h3>
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Id : </td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name : </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price : </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>producer</td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="${pageContext.request.contextPath}/product"> Back To Product</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
