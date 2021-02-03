<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/20/2020
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Contract Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/contract?action=contractList">List Contract</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table  class="table table-striped">
            <caption>
                <h2>Edit Contract</h2>
            </caption>
            <c:if test="${contract != null}">
                <input type="hidden" name="contract_id" value="<c:out value='${contract.contract_id}' />" required/>
            </c:if>
            <tr>
                <th>Contract Id</th>
                <td>
                    <input type="text" name="contract_id" size="45" disabled
                           value="<c:out value='${contract.contract_id}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Contract Start Date</th>
                <td>
                    <input type="text" name="contract_start_date" size="45"
                           value="<c:out value='${contract.contract_start_date}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Contract End Date</th>
                <td>
                    <input type="text" name="contract_end_date" size="45"
                           value="<c:out value='${contract.contract_end_date}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Contract Deposit</th>
                <td>
                    <input type="text" name="contract_deposit" size="45"
                           value="<c:out value='${contract.contract_deposit}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Contract Total Money</th>
                <td>
                    <input type="text" name="contract_total_money" size="45"
                           value="<c:out value='${contract.contract_total_money}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Id</th>
                <td>
                    <input type="text" name="employee_id" size="45"
                           value="<c:out value='${contract.employee_id}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Id</th>
                <td>
                    <input type="text" name="customer_id" size="45"
                           value="<c:out value='${contract.customer_id}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Service Id</th>
                <td>
                    <input type="text" name="service_id" size="45"
                           value="<c:out value='${contract.service_id}' />"required
                    />
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
