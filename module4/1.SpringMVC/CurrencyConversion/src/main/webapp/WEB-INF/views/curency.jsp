<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/31/2020
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency</title>
</head>
<body>

<form action="/convert" method="post">
    <label>
        USD:
    </label>
   <input type="text" name="usd">
    <button type="submit">CHUYỂN ĐỔI</button>
</form>
<h1>Result : ${usd}</h1>
</body>
</html>
