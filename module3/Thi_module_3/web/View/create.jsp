<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/28/2020
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Benh An</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/kiemtramodule3?action=benh_anList">Danh Sach Benh An</a>
    </h2>
</center>

<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption>
                <h2>Them Mới Benh An</h2>
            </caption>
            <tr>
                <th>Mã Bệnh Án</th>
                <td>
                    <c:if test="${messageID != null}">
                        <p style="color: red"><c:out value="${messageID}"/></p>
                    </c:if>
                    <input type="text" name="ma_benh_an" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Mã Bệnh Nhân</th>
                <td>
                    <c:if test="${messageID1 != null}">
                        <p style="color: red"><c:out value="${messageID1}"/></p>
                    </c:if>
                    <input type="text" name="ma_benh_nhan" size="45" required/></td>
            </tr>
            <tr>
                <th>Ngày Nhập Viện</th>
                <td>
                    <c:if test="${messageBirthday != null}">
                        <p style="color: red"><c:out value="${messageBirthday}"/></p>
                    </c:if>
                    <input type="text" name="ngay_nhap_vien" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Ngày Ra Viện</th>
                <td>
                    <c:if test="${messageBirthday != null}">
                        <p style="color: red"><c:out value="${messageBirthday}"/></p>
                    </c:if>
                    <input type="text" name="ngay_ra_vien" size="45" required/></td>
            </tr>
            <tr>
                <th>Lý Do Nhập Viện</th>
                <td><input type="text" name="ly_do_nhap_vien" size="45" required/></td>
            </tr>
            <tr>
                <td colspan="2"align="center">
                    <input class="btn btn-danger" type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="assets/jquery/jquery-3.5.1.min.js"></script>
<script src="assets/bootstrap413/js/popper.min.js"></script>
<script src="assets/datatables/js/jquery.dataTables.min.js"></script>
<script src="assets/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="assets/bootstrap413/js/bootstrap.min.js"></script>
<script src="assets/abootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
