<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/28/2020
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Bệnh Án</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/kiemtramodule3?action=benh_anList">Danh Sách Bệnh Án</a>
    </h2>
</center>

<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption><h2>Chỉnh Sửa Bệnh Án</h2></caption>
            <c:if test="${Benh_an != null}">
                <input type="hidden" name="ma_benh_an" value="<c:out value="${Benh_an.ma_benh_an}"/>">
            </c:if>
            <tr>
                <th>Mã Bệnh Án</th>
                <td>
                    <input type="text" name="ma_benh_an" size="45" disabled
                           value="<c:out value="${Benh_an.ma_benh_an}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Mã Bệnh Nhân</th>
                <td>
                    <input type="text" name="ma_benh_nhan" size="45" disabled
                           value="<c:out value="${Benh_an.ma_benh_nhan}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Ngày Nhập Viện</th>
                <td>
                    <input type="text" name="ngay_nhap_vien" size="45"
                           value="<c:out value="${Benh_an.ngay_nhap_vien}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Ngày Ra Viện</th>
                <td>
                    <input type="text" name="ngay_ra_vien" size="45"
                           value="<c:out value="${Benh_an.ngay_ra_vien}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Lý Do Vào Viện</th>
                <td>
                    <input type="text" name="ly_do_nhap_vien" size="45"
                           value="<c:out value="${Benh_an.ly_do_nhap_vien}"/>" required/>
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
<script src="assets/jquery/jquery-3.5.1.min.js"></script>
<script src="assets/bootstrap413/js/popper.min.js"></script>
<script src="assets/datatables/js/jquery.dataTables.min.js"></script>
<script src="assets/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="assets/bootstrap413/js/bootstrap.min.js"></script>
<script src="assets/abootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
