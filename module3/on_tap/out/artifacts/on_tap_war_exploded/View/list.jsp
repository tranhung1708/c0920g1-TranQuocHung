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
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <script src="../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
</head>
<form>
    <input type="hidden" name="action" value="search">
    <input class="form-control" style="width: 500px" type="text" name="searchName" value="">
    <input style="margin-left: 510px ; margin-top: -38px" class="btn btn-light" type="submit" value="search">
</form>
<center>
    <h2>
        <a href="${pageContext.request.contextPath}/hoc_sinh?action=create">Add new Hoc Sinh</a>
    </h2>
</center>
<body>
<div align="center">
    <table id="hoc_sinh" class="table table-striped table-bordered">
        <caption><h2>List Hoc_sinh</h2></caption>
        <thead>
        <tr>
            <th>Ma Hoc Sinh</th>
            <th>Ten Hoc Sinh</th>
            <th>Lop</th>
            <th>Ngay Sinh</th>
            <th>Dia Chi</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hoc_sinh" items="${hoc_sinhList}">
            <tr>
                <td><c:out value="${hoc_sinh.getMa_hoc_sinh()}"/></td>
                <td><c:out value="${hoc_sinh.getTen_hoc_sinh()}"/></td>
                <td><c:out value="${hoc_sinh.getLop()}"/></td>
                <td><c:out value="${hoc_sinh.getNgay_sinh()}"/></td>
                <td><c:out value="${hoc_sinh.getDia_chi()}"/></td>
                <td>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/hoc_sinh?action=edit&id=${hoc_sinh.getMa_hoc_sinh()}">Edit</a>
                        <%--                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/contract_detail?action=delete&id=${contract_detail.getContract_detail_id()}">Delete</a>--%>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exam<c:out value='${hoc_sinh.getMa_hoc_sinh()}'/>" >
                        Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exam<c:out value='${hoc_sinh.getMa_hoc_sinh()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete  ${hoc_sinh.getMa_hoc_sinh()}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="${pageContext.request.contextPath}/hoc_sinh?action=delete&id=${hoc_sinh.getMa_hoc_sinh()}"><button type="button" class="btn btn-primary">Delete</button></a>
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
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../bootstrap413/js/popper.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../bootstrap413/js/bootstrap.min.js"></script>
<script src="../bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#contract_detail').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
</body>
</html>
