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
    <title>Create Service</title>
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Service</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/service?action=serviceList">List Service</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption>
                <h2>Add new Service</h2>
            </caption>
            <tr>
                <th>Service Id</th>
                <td>
                    <c:if test="${messageId != null}">
                        <p style="color: red"><c:out value="${messageId}"/></p>
                    </c:if>
                    <input type="text" name="service_id" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Service Name</th>
                <td>
                    <input type="text" name="service_name" size="45"required/>
                </td>
            </tr>
            <tr>
                <th>Service Area</th>
                <td>
                    <input type="text" name="service_area" size="45"required/>
                </td>
            </tr>
            <tr>
                <th>Service Cost</th>
                <td>
                    <c:if test="${messageCost != null}">
                        <p style="color: red"><c:out value="${messageCost}"/></p>
                    </c:if>
                    <input type="text" name="service_cost" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Service Max People</th>
                <td>
                    <c:if test="${messagePeople != null}">
                        <p style="color: red"><c:out value="${messagePeople}"/></p>
                    </c:if>
                    <input type="text" name="service_max_people" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Rent Type</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="rent_type_id">
                        <c:forEach var="rent_type" items="${requestScope['rent_typeList']}">
                            <option value="${rent_type.getRent_type_id()}">${rent_type.getRent_type_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="rent_type_id" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>Service Type Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="service_type_id">
                        <c:forEach var="service_type" items="${requestScope['service_typeList']}">
                            <option value="${service_type.getService_type_id()}">${service_type.getService_type_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="service_type_id" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>Standard Room</th>
                <td>
                    <input type="text" name="standard_room" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Description Other Convenience</th>
                <td>
                    <input type="text" name="description_other_convenience" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Pool Area</th>
                <td>
                    <input type="text" name="pool_area" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Number Of Floors</th>
                <td>
                    <c:if test="${messageNumber != null}">
                        <p style="color: red"><c:out value="${messageNumber}"/></p>
                    </c:if>
                    <input type="text" name="number_of_floors" size="45" required/>
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
