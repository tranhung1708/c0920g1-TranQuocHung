<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/17/2020
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Service</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<form>
    <input type="hidden" name="action" value="search">
    <input class="form-control" style="width: 500px" type="text" name="searchName" value="">
    <input style="margin-left: 510px ; margin-top: -38px"  class="btn btn-light" type="submit" value="search">
</form>
<center>
    <h1>List Service</h1>
    <a href="${pageContext.request.contextPath}/CaseStudy.jsp"><h2>Home Page</h2></a>
    <h2>
        <a href="/service?action=create">Add New Service</a>
    </h2>
</center>
<div align="center">
    <table id="service" class="table table-striped table-bordered">
        <caption><h2>List Service</h2></caption>
        <thead>
        <tr>
            <th>Service Id</th>
            <th>Service Name</th>
            <th>Service Area</th>
            <th>Service Cost</th>
            <th>Service Max People</th>
            <th>Rent Type Id</th>
            <th>Service Type Id</th>
            <th>Standard Room</th>
            <th>Description Other Convenience</th>
            <th>Pool Area</th>
            <th>Number Of Floors</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${serviceList}">
            <tr>
                <td><c:out value="${service.getService_id()}"/></td>
                <td><c:out value="${service.getService_name()}"/></td>
                <td><c:out value="${service.getService_area()}"/></td>
                <td><c:out value="${service.getService_cost()}"/></td>
                <td><c:out value="${service.getService_max_people()}"/></td>
                <td><c:out value="${service.getRent_type_id()}"/></td>
                <td><c:out value="${service.getService_type_id()}"/></td>
                <td><c:out value="${service.getStandard_room()}"/></td>
                <td><c:out value="${service.getDescription_other_convenience()}"/></td>
                <td><c:out value="${service.getPool_area()}"/></td>
                <td><c:out value="${service.getNumber_of_floors()}"/></td>
                <td>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/service?action=edit&id=${service.getService_id()}">Edit</a>
<%--                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/service?action=delete&id=${service.getService_id()}">Delete</a>--%>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exam<c:out value='${service.getService_id()}'/>" >
                        Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exam<c:out value='${service.getService_id()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete ${service.getService_id()}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="${pageContext.request.contextPath}/service?action=delete&id=${service.getService_id()}"><button type="button" class="btn btn-primary">Delete</button></a>
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
        $('#service').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength":5
        })
    })
</script>
</body>
</html>
