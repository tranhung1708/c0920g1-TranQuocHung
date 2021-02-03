<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 1/5/2021
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển Đổi Từ Điển</title>
</head>
<body>
<form action="/convert" method="post" >
    <label>Nhập từ cần tra cứu!</label>
    <input type="text" name="searchWord">
    <button type="submit"> tra cứu </button>
</form>
<h1>Result : ${result}</h1>
</body>
</html>
