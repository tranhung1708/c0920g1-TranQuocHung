<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/16/2020
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<form>
    <input type="hidden" name="action" value="search">
    <input class="form-control" style="width: 500px " type="text" name="searchName" value="">
    <input style="margin-left: 505px; margin-top: -38px"  class="btn btn-light" type="submit" value="search">
</form>
<center>
    <h1>Customer Management</h1>
    <a href="${pageContext.request.contextPath}/CaseStudy.jsp"><h2>Home Page</h2></a>
    <h2>
        <a href="${pageContext.request.contextPath}/customer?action=create">Add new Customer</a>
    </h2>
</center>
<div align="center">
    <table id="customer" class="table table-striped table-bordered">
        <caption><h2>List Customer</h2></caption>
        <thead>
        <tr>
            <th>Customer id</th>
            <th>Customer type id</th>
            <th>Customer name</th>
            <th>Customer birthday</th>
            <th>Customer gender</th>
            <th>Customer id_card</th>
            <th>Customer phone</th>
            <th>Customer email</th>
            <th>Customer address</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cus" items="${customerList}">
            <tr>
                <td><c:out value="${cus.getCustomer_id()}"/></td>
                <td><c:out value="${cus.getCustomer_type_id()}"/></td>
                <td><c:out value="${cus.getCustomer_name()}"/></td>
                <td><c:out value="${cus.getCustomer_birthday()}"/></td>
                <td><c:out value="${cus.getCustomer_gender()}"/></td>
                <td><c:out value="${cus.getCustomer_id_card()}"/></td>
                <td><c:out value="${cus.getCustomer_phone()}"/></td>
                <td><c:out value="${cus.getCustomer_email()}"/></td>
                <td><c:out value="${cus.getCustomer_address()}"/></td>
                <td>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/customer?action=edit&id=${cus.getCustomer_id()}">Edit</a>
<%--                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/customer?action=delete&id=${cus.getCustomer_id()}">Delete</a>--%>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exam<c:out value='${cus.getCustomer_id()}'/>" >
                        Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exam<c:out value='${cus.getCustomer_id()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete ${cus.getCustomer_id()}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="${pageContext.request.contextPath}/customer?action=delete&id=${cus.getCustomer_id()}"><button type="button" class="btn btn-primary">Delete</button></a>
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
<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap413/js/popper.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../../bootstrap413/js/bootstrap.min.js"></script>
<script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength":5
        })
    })
</script>
</body>
</html>
