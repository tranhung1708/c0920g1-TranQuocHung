<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/15/2020
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2 style="display:flex ; justify-content: center">Danh Sách Khách Hàng</h2>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Tên</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Địa CHỉ</th>
        <th scope="col">Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">Mai Văn Hoàn</th>
        <td>1983-08-20</td>
        <td>Hà Nội</td>
        <td>@mdo</td>
    </tr>
    <tr>
        <th scope="row">Nguyễn Văn Nam</th>
        <td>1983-08-21</td>
        <td>Bắc Giang</td>
        <td>@fat</td>
    </tr>
    <tr>
        <th scope="row">Nguyễn Thái Hòa</th>
        <td>1983-08-22</td>
        <td>Nam Định </td>
        <td>@twitter</td>
    </tr>
    <tr>
        <th scope="row">Trần Đăng Khoa</th>
        <td>1983-08-22</td>
        <td>Hà Tây</td>
        <td>@twitter</td>
    </tr>
    <tr>
        <th scope="row">Nguyễn ĐÌnh Thi</th>
        <td>1983-08-22</td>
        <td>Hà Nội</td>
        <td>@twitter</td>
    </tr>
    </tbody>
</table>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="bootstrap413/js/popper.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap413/js/bootstrap.min.js"></script>
<script src="bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
