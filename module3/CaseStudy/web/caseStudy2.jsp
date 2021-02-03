<%--
  Created by IntelliJ IDEA.
  User: Quynh
  Date: 12/10/2020
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Resort Furama</title>
    <link href="demo1.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div id="main">
    <div id="head">
        <div><a href="https://danang.codegym.vn/" target="_blank">
            <img class="img"
                 src="https://yt3.ggpht.com/ytc/AAUvwnggKV40oVjF4SGADNHPfCtb2z2AQcGA4zXR6hI=s900-c-k-c0x00ffffff-no-rj"
                 alt="1"></a></div>
        <div><p class="word">Trần Quốc Hưng</p></div>
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
                        <a class="nav-link" href="#"> Employee<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Customer</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Service
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Contract</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <div id="content">
        <div id="content-left">
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
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Tạm Biệt Các Bạn
        </button>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Hãy Thường Xuyên Đến Đây Nhé
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
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
