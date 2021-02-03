<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/18/2020
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <script src="../../bootstrap413/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<center>
    <h1>Employee</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/employee?action=employeeList">List Service</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption>
                <h2>Add new Employee</h2>
            </caption>
            <tr>
                <th>Employee Id</th>
                <td><input type="text" name="employee_id" size="45" required/></td>
            </tr>
            <tr>
                <th>Employee Name</th>
                <td><input type="text" name="employee_name" size="45" required/></td>
            </tr>
            <tr>
                <th>Employee Birthday</th>
                <td>
                    <c:if test="${messageBirthday != null}">
                        <p style="color: red"><c:out value="${messageBirthday}"/></p>
                    </c:if>
                    <input type="text" name="employee_birthday" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card</th>
                <td>
                    <c:if test="${messageIdCard != null}">
                        <p style="color: red"><c:out value="${messageIdCard}"/></p>
                    </c:if>
                    <input type="text" name="employee_id_card" size="45" required/></td>
            </tr>
            <tr>
                <th>Employee Salary</th>
                <td><input type="text" name="employee_salary" size="45" required/></td>
            </tr>
            <tr>
                <th>Employee Phone</th>
                <td>
                    <c:if test="${messagePhone != null}">
                        <p style="color: red"><c:out value="${messagePhone}"/></p>
                    </c:if>
                    <input type="text" name="employee_phone" size="45" required/></td>
            </tr>
            <tr>
                <th>Employee Email</th>
                <td>
                    <c:if test="${messageEmail != null}">
                        <p style="color: red"><c:out value="${messageEmail}"/></p>
                    </c:if>
                    <input type="text" name="employee_email" size="45" required/>
                </td>
            </tr>
            <tr>
                <th>Employee Address</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="employee_address">
                        <option>Thành phố Hà Nội</option>
                        <option>Tỉnh Hà Giang</option>
                        <option>Tỉnh Cao Bằng</option>
                        <option>Tỉnh Bắc Kạn</option>
                        <option>Tỉnh Tuyên Quang</option>
                        <option>Tỉnh Lào Cai</option>
                        <option>Tỉnh Điện Biên</option>
                        <option>Tỉnh Lai Châu</option>
                        <option>Tỉnh Sơn La</option>
                        <option>Tỉnh Yên Bái</option>
                        <option>Tỉnh Hoà Bình</option>
                        <option>Tỉnh Thái Nguyên</option>
                        <option>Tỉnh Lạng Sơn</option>
                        <option>Tỉnh Quảng Ninh</option>
                        <option>Tỉnh Bắc Giang</option>
                        <option>Tỉnh Phú Thọ</option>
                        <option>Tỉnh Vĩnh Phúc</option>
                        <option>Tỉnh Bắc Ninh</option>
                        <option>Tỉnh Hải Dương</option>
                        <option>Thành phố Hải Phòng</option>
                        <option>Tỉnh Hưng Yên</option>
                        <option>Tỉnh Thái Bình</option>
                        <option>Tỉnh Hà Nam</option>
                        <option>Tỉnh Nam Định</option>
                        <option>Tỉnh Ninh Bình</option>
                        <option>Tỉnh Thanh Hóa</option>
                        <option>Tỉnh Nghệ An</option>
                        <option>Tỉnh Hà Tĩnh</option>
                        <option>Tỉnh Quảng Bình</option>
                        <option>Tỉnh Quảng Trị</option>
                        <option>Tỉnh Thừa Thiên Huế</option>
                        <option>Thành phố Đà Nẵng</option>
                        <option>Tỉnh Quảng Nam</option>
                        <option>Tỉnh Quảng Ngãi</option>
                        <option>Tỉnh Bình Định</option>
                        <option>Tỉnh Phú Yên</option>
                        <option>Tỉnh Khánh Hòa</option>
                        <option>Tỉnh Ninh Thuận</option>
                        <option>Tỉnh Bình Thuận</option>
                        <option>Tỉnh Kon Tum</option>
                        <option>Tỉnh Gia Lai</option>
                        <option>Tỉnh Đắk Lắk</option>
                        <option>Tỉnh Đắk Nông</option>
                        <option>Tỉnh Lâm Đồng</option>
                        <option>Tỉnh Bình Phước</option>
                        <option>Tỉnh Tây Ninh</option>
                        <option>Tỉnh Bình Dương</option>
                        <option>Tỉnh Đồng Nai</option>
                        <option>Tỉnh Bà Rịa - Vũng Tàu</option>
                        <option>Thành phố Hồ Chí Minh</option>
                        <option>Tỉnh Long An</option>
                        <option>Tỉnh Tiền Giang</option>
                        <option>Tỉnh Bến Tre</option>
                        <option>Tỉnh Trà Vinh</option>
                        <option>Tỉnh Vĩnh Long</option>
                        <option>Tỉnh Đồng Tháp</option>
                        <option>Tỉnh An Giang</option>
                        <option>Tỉnh Kiên Giang</option>
                        <option>Thành phố Cần Thơ</option>
                        <option>Tỉnh Hậu Giang</option>
                        <option>Tỉnh Sóc Trăng</option>
                        <option>Tỉnh Bạc Liêu</option>
                        <option>Tỉnh Cà Mau</option>
                    </select>
<%--                    <input type="text" name="employee_address" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>Position Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="position_id">
                        <c:forEach var="positions" items="${requestScope['positionList']}">
                            <option value="${positions.getPosition_id()}">${positions.getPosition_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="position_id" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>Education Degree Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="education_degree_id">
                        <c:forEach var="education_degree" items="${requestScope['education_degreeList']}">
                            <option value="${education_degree.getEducation_degree_id()}">${education_degree.getEducation_degree_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="education_degree_id" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>Division Id</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="division_id">
                        <c:forEach var="division" items="${requestScope['divisionList']}">
                            <option value="${division.getDivision_id()}">${division.getDivision_name()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="division_id" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <th>User Name</th>
                <td>
                    <select class="input-group" style="width: 375px;" name="username">
                        <c:forEach var="user" items="${requestScope['userList']}">
                            <option value="${user.getUsername()}">${user.getUsername()}</option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="username" size="45" required/>--%>
                </td>
            </tr>
            <tr>
                <td colspan="2"align="center">
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
