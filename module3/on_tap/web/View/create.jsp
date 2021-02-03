<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/28/2020
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"></head>
</head>
<body>
<center>
    <h1>Contract_Detail</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/hoc_sinh?action=hoc_sinhList">List Hoc Sinh</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption>
                <h2>Add new Hoc Sinh</h2>
            </caption>
            <tr>
                <th>Ma Hoc Sinh</th>
                <td>
                    <input type="text" name="ma_hoc_sinh" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Ten Hoc Sinh</th>
                <td>
                    <input type="text" name="ten_hoc_sinh" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Lop</th>
                <td>
                    <input type="text" name="lop" size="45"required/>
                </td>
            </tr>
            <tr>
                <th>Ngay Sinh</th>
                <td>
                    <input type="text" name="ngay_sinh" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Dia Chi</th>
                <td>
                    <input type="text" name="dia_chi" size="45" required/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-danger" type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
