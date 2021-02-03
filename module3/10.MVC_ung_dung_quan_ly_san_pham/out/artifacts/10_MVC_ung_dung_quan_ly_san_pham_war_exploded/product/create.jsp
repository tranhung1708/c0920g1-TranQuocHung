<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/15/2020
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>create</title>
    <style>
     .message{
         color:green;
     }
    </style>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="${pageContext.request.contextPath}/product">Back to Product</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>NameProduct</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Producer</td>
                <td><input type="text" name="producer" id="producer"></td>
                <td><input type="submit" value="Create Product"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
