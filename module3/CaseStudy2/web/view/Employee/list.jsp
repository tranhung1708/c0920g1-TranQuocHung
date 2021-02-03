<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/18/2020
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Management Application</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
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
    <h1>Employee Management</h1>
    <a href="${pageContext.request.contextPath}/CaseStudy.jsp"><h2>Home Page</h2></a>
    <h2>
        <a href="${pageContext.request.contextPath}/employee?action=create">Add new Employee</a>
    </h2>
</center>
<div align="center">
    <table style="width: 100%" id="employee" class="table table-striped table-bordered">
        <caption><h2>List Employee</h2></caption>
        <thead>
        <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Birthday</th>
            <th>Employee Id Card</th>
            <th>Employee Salary</th>
            <th>Employee Phone</th>
            <th>Employee Email</th>
            <th>Employee Address</th>
            <th>Position Id</th>
            <th>Education Degree Id</th>
            <th>Division Id</th>
            <th>Username</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td><c:out value="${employee.getEmployee_id()}"/></td>
                <td><c:out value="${employee.getEmployee_name()}"/></td>
                <td><c:out value="${employee.getEmployee_brithday()}"/></td>
                <td><c:out value="${employee.getEmployee_id_card()}"/></td>
                <td><c:out value="${employee.getEmployee_salary()}"/></td>
                <td><c:out value="${employee.getEmployee_phone()}"/></td>
                <td><c:out value="${employee.getEmployee_email()}"/></td>
                <td><c:out value="${employee.getEmployee_address()}"/></td>
                <td><c:out value="${employee.getPosition_id()}"/></td>
                <td><c:out value="${employee.getEducation_degree_id()}"/></td>
                <td><c:out value="${employee.getDivision_id()}"/></td>
                <td><c:out value="${employee.getUsername()}"/></td>
                <td>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/employee?action=edit&id=${employee.getEmployee_id()}">Edit</a>
<%--                    <a class="btn btn-danger"--%>
<%--                       href="${pageContext.request.contextPath}/employee?action=delete&id=${employee.getEmployee_id()}">Delete</a>--%>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exam<c:out value='${employee.getEmployee_id()}'/>" >
                        Delete
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exam<c:out value='${employee.getEmployee_id()}'/>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Do you want to delete  ${employee.getEmployee_id()}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a href="${pageContext.request.contextPath}/employee?action=delete&id=${employee.getEmployee_id()}"><button type="button" class="btn btn-primary">Delete</button></a>
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
        $('#employee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength":5
        })
    })
</script>
</body>
</html>
