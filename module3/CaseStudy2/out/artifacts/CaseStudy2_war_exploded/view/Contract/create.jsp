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
    <title>Create Contract</title>
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Contract</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/contract?action=contractList">List Contract</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption>
                <h2>Add new Contract</h2>
            </caption>
            <tr>
                <th>Contract Id</th>
                <td>
                    <input type="text" name="contract_id" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Contract Start Date</th>
                <td>
                    <c:if test="${messageDate1 != null}">
                        <p style="color: red"><c:out value="${messageDate1}"/></p>
                    </c:if>
                    <input type="text" name="contract_start_date" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Contract End Date</th>
                <td>
                    <c:if test="${messageDate2 != null}">
                        <p style="color: red"><c:out value="${messageDate2}"/></p>
                    </c:if>
                    <input type="text" name="contract_end_date" size="45"required/>
                </td>
            </tr>
            <tr>
                <th>Contract Deposit</th>
                <td>
                    <input type="text" name="contract_deposit" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Contract Total Money</th>
                <td>
                    <c:if test="${messageMoney != null}">
                        <p style="color: red"><c:out value="${messageMoney}"/></p>
                    </c:if>
                    <input type="text" name="contract_total_money" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="employee_id">
                        <c:forEach var="employee" items="${requestScope['employeeList']}">
                            <option value="${employee.getEmployee_id()}">${employee.getEmployee_name()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="customer_id">
                        <c:forEach var="customer" items="${requestScope['customerList']}">
                            <option value="${customer.getCustomer_id()}">${customer.getCustomer_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="customer_id" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>Service Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="service_id">
                        <c:forEach var="service" items="${requestScope['serviceList']}">
                            <option value="${service.getService_id()}">${service.getService_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="service_id" size="45" required/>--%>
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
