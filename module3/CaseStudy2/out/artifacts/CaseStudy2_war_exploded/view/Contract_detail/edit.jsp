<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/21/2020
  Time: 9:48 AM
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
    <h1>Contract Detail Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/contract_detail?action=contract_detailList">List Contract Detail</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table  class="table table-striped">
            <caption>
                <h2>Edit Contract</h2>
            </caption>
            <c:if test="${contract_detail != null}">
                <input type="hidden" name="contract_detail_id"
                       value="<c:out value='${contract_detail.contract_detail_id}' />" required/>
            </c:if>
            <tr>
                <th>Contract Detail Id</th>
                <td>
                    <input type="text" name="contract_detail_id" size="45" disabled
                           value="<c:out value='${contract_detail.contract_detail_id}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Contract Id</th>
                <td>
                    <input type="text" name="contract_id" size="45"
                           value="<c:out value='${contract_detail.contract_id}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Attach Service</th>
                <td>
                    <input type="text" name="attach_service_id" size="45"
                           value="<c:out value='${contract_detail.attach_service_id}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>
                    <input type="text" name="quantity" size="45"
                           value="<c:out value='${contract_detail.quantity}' />"required
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
