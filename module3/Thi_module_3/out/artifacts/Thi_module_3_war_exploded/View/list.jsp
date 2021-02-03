<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/28/2020
  Time: 8:02 PM
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
<form>
    <input type="hidden" name="action" value="search">
    <input class="form-control" style="width: 500px" type="text" name="searchName" value="">
    <input style="margin-left: 510px ; margin-top: -38px" class="btn btn-light" type="submit" value="search">
</form>
<center>
    <h2>
        <a href="${pageContext.request.contextPath}/kiemtramodule3?action=create">Thêm Mới</a>
    </h2>
</center>
<div align="center">
    <table style="width: 100%" id="benhAn" class="table table-striped table-bordered">
        <caption><h2>Danh Sách Bệnh Án</h2></caption>
        <thead>
        <tr>
            <th>Mã Bệnh Án</th>
            <th>Mã Bệnh Nhân</th>
            <th>Ngày Nhập Viện</th>
            <th>Ngày Ra Viện </th>
            <th>Lý Do Nhập Viện</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="benh_an" items="${benh_anList}">
            <tr>
                <td><c:out value="${benh_an.getMa_benh_an()}"/></td>
                <td><c:out value="${benh_an.getMa_benh_nhan()}"/></td>
                <td><c:out value="${benh_an.getNgay_nhap_vien()}"/></td>
                <td><c:out value="${benh_an.getNgay_ra_vien()}"/></td>
                <td><c:out value="${benh_an.getLy_do_nhap_vien()}"/></td>
                <td>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/kiemtramodule3?action=edit&id=${benh_an.getMa_benh_an()}">Edit</a>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exam<c:out value='${benh_an.getMa_benh_an()}'/>" >
                        Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exam<c:out value='${benh_an.getMa_benh_an()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete  ${benh_an.getMa_benh_an()}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="${pageContext.request.contextPath}/kiemtramodule3?action=delete&id=${benh_an.getMa_benh_an()}"><button type="button" class="btn btn-primary">Delete</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="assets/jquery/jquery-3.5.1.min.js"></script>
<script src="assets/bootstrap413/js/popper.min.js"></script>
<script src="assets/datatables/js/jquery.dataTables.min.js"></script>
<script src="assets/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="assets/bootstrap413/js/bootstrap.min.js"></script>
<script src="assets/abootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#benhAn').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
</body>
</html>
