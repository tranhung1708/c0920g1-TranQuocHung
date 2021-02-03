<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/20/2020
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Contract Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <a href="${pageContext.request.contextPath}/CaseStudy.jsp"><h2>Home Page</h2></a>
    <h2>
        <a href="${pageContext.request.contextPath}/contract?action=create">Add new Contract</a>
    </h2>
</center>
<form>
    <input type="hidden" name="action" value="search">
    <input class="form-control" style="width: 500px" type="text" name="searchName" value="">
    <input style="margin-left: 510px ; margin-top: -38px"  class="btn btn-light" type="submit" value="search">
</form>
<%--<label>--%>
<%--    <input type="search" class="form-control form-control-sm" aria-controls="contract" placeholder>--%>
<%--</label>--%>
<div align="center">
    <table id="contract" class="table table-striped table-bordered">
        <caption><h2>List Contract</h2></caption>
        <thead>
        <tr>
            <th>Contract Id</th>
            <th>Contract Start Date</th>
            <th>Contract End Date</th>
            <th>Contract Deposit</th>
            <th>Contract Total Money</th>
            <th>Employee Id</th>
            <th>Customer Id</th>
            <th>Service Id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="contract" items="${contractList}">
                <tr>
                    <td><c:out value="${contract.getContract_id()}"/></td>
                    <td><c:out value="${contract.getContract_start_date()}"/></td>
                    <td><c:out value="${contract.getContract_end_date()}"/></td>
                    <td><c:out value="${contract.getContract_deposit()}"/></td>
                    <td><c:out value="${contract.getContract_total_money()}"/></td>
                    <td><c:out value="${contract.getEmployee_id()}"/></td>
                    <td><c:out value="${contract.getCustomer_id()}"/></td>
                    <td><c:out value="${contract.getService_id()}"/></td>
                    <td>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/contract?action=edit&id=${contract.getContract_id()}">Edit</a>
<%--                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/contract?action=delete&id=${contract.getContract_id()}">Delete</a>--%>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exam<c:out value='${contract.getContract_id()}'/>" >
                            Delete
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exam<c:out value='${contract.getContract_id()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Do you want to delete  ${contract.getContract_id()}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <a href="${pageContext.request.contextPath}/contract?action=delete&id=${contract.getContract_id()}"><button type="button" class="btn btn-primary">Delete</button></a>
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
        $('#contract').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength":5
        })
    })
</script>
</body>
</html>
