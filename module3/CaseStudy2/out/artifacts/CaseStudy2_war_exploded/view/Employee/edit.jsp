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
    <title>Edit Employee</title>
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Employee</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/employee?action=employeeList">List Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption><h2>Edit Employee</h2></caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="employee_id" value="<c:out value="${employee.employee_id}"/>">
            </c:if>
            <tr>
                <th>Employee Id</th>
                <td>
                    <input type="text" name="employee_id" size="45" disabled
                           value="<c:out value="${employee.employee_id}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Id</th>
                <td>
                    <input type="text" name="employee_name" size="45"
                           value="<c:out value="${employee.employee_name}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday</th>
                <td>
                    <input type="text" name="employee_birthday" size="45"
                           value="<c:out value="${employee.employee_brithday}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card</th>
                <td>
                    <input type="text" name="employee_id_card" size="45"
                           value="<c:out value="${employee.employee_id_card}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Salary</th>
                <td>
                    <input type="text" name="employee_salary" size="45"
                           value="<c:out value="${employee.employee_salary}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone</th>
                <td>
                    <input type="text" name="employee_phone" size="45"
                           value="<c:out value="${employee.employee_phone}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Email</th>
                <td>
                    <input type="text" name="employee_email" size="45" 
                           value="<c:out value="${employee.employee_email}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Address</th>
                <td>
                    <input type="text" name="employee_address" size="45"
                           value="<c:out value="${employee.employee_address}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Position Id</th>
                <td>
                    <input type="text" name="position_id" size="45" 
                           value="<c:out value="${employee.position_id}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Education Degree Id</th>
                <td>
                    <input type="text" name="education_degree_id" size="45"
                           value="<c:out value="${employee.education_degree_id}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>Division Id</th>
                <td>
                    <input type="text" name="division_id" size="45"
                           value="<c:out value="${employee.division_id}"/>" required/>
                </td>
            </tr>
            <tr>
                <th>User Name</th>
                <td>
                    <input type="text" name="username" size="45"
                           value="<c:out value="${employee.username}"/>" required/>
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
<script src="../../bootstrap413/js/popper.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../../bootstrap413/js/bootstrap.min.js"></script>
<script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
