<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/16/2020
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <h1>Customer Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/customer?action=customerList">List Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table  class="table table-striped">
            <caption>
                <h2>Edit Customer</h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="customer_id" value="<c:out value='${customer.customer_id}' />" required/>
            </c:if>
            <tr>
                <th>Customer Id</th>
                <td>
                    <input type="text" name="customer_id" size="45" disabled
                           value="<c:out value='${customer.customer_id}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Type Id</th>
                <td>
                    <input type="text" name="customer_type_id" size="45"
                           value="<c:out value='${customer.customer_type_id}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Name</th>
                <td>
                    <input type="text" name="customer_name" size="45"
                           value="<c:out value='${customer.customer_name}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday</th>
                <td>
                    <input type="text" name="customer_birthday" size="45"
                           value="<c:out value='${customer.customer_birthday}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender</th>
                <td>
                    <input type="text" name="customer_gender" size="45"
                           value="<c:out value='${customer.customer_gender}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Id Card</th>
                <td>
                    <input type="text" name="customer_id_card" size="45"
                           value="<c:out value='${customer.customer_id_card}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone</th>
                <td>
                    <input type="text" name="customer_phone" size="45"
                           value="<c:out value='${customer.customer_phone}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email</th>
                <td>
                    <input type="text" name="customer_email" size="45"
                           value="<c:out value='${customer.customer_email}' />"required
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address</th>
                <td>
                    <input type="text" name="customer_address" size="45"
                           value="<c:out value='${customer.customer_address}' />"required
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
