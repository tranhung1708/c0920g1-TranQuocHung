<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/14/2020
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resort Furama</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
    <style>
        body {
            font-family: Arial, Tahoma;
            font-size: 12px;
        }

        #main {
            width: 100%;
            padding: 0;
            margin-left: auto;
            margin-right: auto;
        }

        #head {
            width: 100%;
            height: 100px;
            background-color: #F5F5F5;
            margin-bottom: 5px;
            position: fixed;
            z-index: 9;
            top: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        #head-link {
            background-color: #F5F5F5;
            margin-bottom: 5px;
            position: relative;
            top: 100px;
            display: flex;
            justify-content: space-around;
            align-items: center;

        }

        #content-left {
            width: 20%;
            height: 900px;
            float: left;
            /*background-color: #b3b3ff;*/
            background: honeydew;
            margin-bottom: 5px;

        }

        #content-right {
            width: 80%;
            height: 900px;
            float: right;
            background-color: #ffffe6;
            margin-bottom: 5px;
        }

        #content {
            width: 100%;
            height: 900px;
            position: relative;
            top: 95px;

        }

        #footer {
            height: 50px;
            clear: both;
            background-color: #F8F8FF;
            position: relative;
            width: 100%;
            margin-top: 100px;
            display: flex;
            justify-content: center;
            align-items: flex-end;

        }
        #font{
            display: flex;
            justify-content: center;
            align-items: flex-end;
        }

        .img {
            width: 50px;
            height: 50px;
            margin-left: 45px;
            border-radius: 5px;
        }

        .word {
            font-family: 'Courier New', Courier, monospace;
            margin-right: 63px;
        }

        .search {
            width: 100%;
        }

        .img1 {
            width: 100%;
            height: 100%;
        }

        .carousel-inner {
            height: 100%;
        }
        .font1{
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Courier New', Courier, monospace;
        }
        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
    </style>
</head>
<body>
<div id="main">
    <div id="head">
        <div><a href="https://danang.codegym.vn/" target="_blank">
            <img class="img"
                 src="https://yt3.ggpht.com/ytc/AAUvwnggKV40oVjF4SGADNHPfCtb2z2AQcGA4zXR6hI=s900-c-k-c0x00ffffff-no-rj"
                 alt="1"></a></div>
        <div><h1 class="font1">Welcome to Furama Resort</h1></div>
        <div><h4 class="word">Trần Quốc Hưng</h4></div>
    </div>
    <div id="head-link" class="page-header">
        <nav style="width: 100%" class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/employee"> Employee<span
                                class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/customer"> Customer</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="${pageContext.request.contextPath}/service">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="${pageContext.request.contextPath}/contract">Contract</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="${pageContext.request.contextPath}/contract_detail">Contract
                            Detail</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Show Customer Service</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <a><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button></a>
                </form>
            </div>
        </nav>
    </div>
    <div id="content">
        <div id="content-left">
            <iframe width="99%" height="34%"
                    src="https://www.youtube.com/embed/PgvSSl4jm1U" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
                    picture-in-picture" allowfullscreen></iframe>
            <iframe width="99%" height="34%"
                    src="https://www.youtube.com/embed/dJCeMv8vyBE" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>
            <iframe width="99%" height="34%"
                    src="https://www.youtube.com/embed/_suEb9rHPnQ" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    allowfullscreen></iframe>
        </div>
        <div id="content-right">
            <div id="demo" class="carousel slide" data-ride="carousel">

                <!-- Indicators -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>

                <!-- The slideshow -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://staticproxy.mytourcdn.com/1000x600,q90/resources/pictures/hotels/0/gm-DFduESxCsgxh27vwkFA-187-Vietnam_Danang_Furama_Resort_Exterior_Courtyard%2520%2520Night.jpeg"
                             alt="Los Angeles" width="100%" height="100%">
                    </div>
                    <div class="carousel-item">
                        <img src="https://bazantravel.com/cdn/medias/uploads/53/53114-furama-resort-da-nang-11.jpg"
                             alt="Chicago" width="100%" height="100%">
                    </div>
                    <div class="carousel-item">
                        <img src="https://d3tosvr3yotk6r.cloudfront.net/Content/UserUploads/Images/Hotels/6/6/medium_furama-resort-1.png"
                             alt="New York" width="100%" height="100%">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
    </div>
    <div id="footer">
        <p id="font" style="font-weight: bold">@Trần Quốc Hưng C0920G1 Module3</p>
    </div>
</div>
</div>


<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="bootstrap413/js/popper.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap413/js/bootstrap.min.js"></script>
<script src="bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
