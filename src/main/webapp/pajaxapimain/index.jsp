<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <!-- App Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- App title -->
    <title>API管理系统后台主页面</title>


    <!-- Switchery css -->
    <link href="assets/uplon/plugins/switchery/switchery.min.css" rel="stylesheet"/>

    <!-- App CSS -->
    <link rel="stylesheet" href="assets/uplon/style.css"/>
    <link rel="stylesheet" href="assets/tether-1.3.3/css/tether.css"/>
    <link rel="stylesheet" href="assets/bootstrap4alpha6/css/bootstrap.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
    <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
    <!-- Modernizr js -->
    <script src="assets/uplon/js/modernizr.min.js"></script>
    <style>
        #clockID img{
            position: relative;
            width: 15px;
            height:20px;

        }

    </style>
</head>


<body class="fixed-left">
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<!-- Begin page -->
<div id="wrapper">

    <!-- Top Bar Start -->
    <div class="topbar">
        <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="javascript:void(0);">
                <button class="button-menu-mobile open-left waves-light waves-effect">
                    <i class="zmdi zmdi-menu"></i>
                </button>
            </a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <ul class="nav  justify-content-end">
                    <li class="nav-item dropdown notification-list">
                        <!--时钟-->
                        <div id="clockID" class="nav-link">
                            <img class="timeNum" src="assets/images/clock/1.png"/>
                            <img class="timeNum" src="assets/images/clock/2.png"/>
                            <img src="assets/images/clock/second1.png"/>

                            <img class="timeNum" src="assets/images/clock/3.png"/>
                            <img class="timeNum" src="assets/images/clock/4.png"/>
                            <img src="assets/images/clock/second1.png"/>

                            <img class="timeNum" src="assets/images/clock/5.png"/>
                            <img class="timeNum" src="assets/images/clock/0.png"/>
                        </div>
                    </li>
                    <li class="nav-item dropdown notification-list">
                        <a class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-toggle="dropdown"
                           href="#" role="button"
                           aria-haspopup="false" aria-expanded="false">
                            <i class="zmdi zmdi-notifications-none noti-icon color_black"></i>
                            <span class="noti-icon-badge"></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-lg" aria-labelledby="Preview">
                            <!-- item-->
                            <div class="dropdown-item noti-title">
                                <h5>
                                    <small><span class="label label-danger pull-xs-right">7</span>Notification</small>
                                </h5>
                            </div>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-success"><i class="icon-bubble"></i></div>
                                <p class="notify-details">Robert S. Taylor commented on Admin
                                    <small class="text-muted">1min ago</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-info"><i class="icon-user"></i></div>
                                <p class="notify-details">New user registered.
                                    <small class="text-muted">1min ago</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-danger"><i class="icon-like"></i></div>
                                <p class="notify-details">Carlos Crouch liked <b>Admin</b>
                                    <small class="text-muted">1min ago</small>
                                </p>
                            </a>

                            <!-- All-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item notify-all">
                                View All
                            </a>

                        </div>
                    </li>


                    <li class="nav-item dropdown notification-list">
                        <a class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-toggle="dropdown"
                           href="#" role="button"
                           aria-haspopup="false" aria-expanded="false">
                            <i class="zmdi zmdi-email noti-icon color_black"></i>
                            <span class="noti-icon-badge"></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg"
                             aria-labelledby="Preview">
                            <!-- item-->
                            <div class="dropdown-item noti-title bg-success">
                                <h5>
                                    <small><span class="label label-danger pull-xs-right">7</span>Messages</small>
                                </h5>
                            </div>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-faded">
                                    <img src="assets/uplon/images/users/avatar-2.jpg" alt="img" class="img-circle img-fluid">
                                </div>
                                <p class="notify-details">
                                    <b>Robert Taylor</b>
                                    <span>New tasks needs to be done</span>
                                    <small class="text-muted">1min ago</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-faded">
                                    <img src="assets/uplon/images/users/avatar-3.jpg" alt="img" class="img-circle img-fluid">
                                </div>
                                <p class="notify-details">
                                    <b>Carlos Crouch</b>
                                    <span>New tasks needs to be done</span>
                                    <small class="text-muted">1min ago</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-faded">
                                    <img src="assets/uplon/images/users/avatar-4.jpg" alt="img" class="img-circle img-fluid">
                                </div>
                                <p class="notify-details">
                                    <b>Robert Taylor</b>
                                    <span>New tasks needs to be done</span>
                                    <small class="text-muted">1min ago</small>
                                </p>
                            </a>

                            <!-- All-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item notify-all">
                                View All
                            </a>

                        </div>
                    </li>

                    <li class="nav-item dropdown notification-list">
                        <a class="nav-link waves-effect waves-light right-bar-toggle" href="javascript:void(0);">
                            <i class="zmdi zmdi-format-subject noti-icon color_black"></i>
                        </a>
                    </li>

                    <li class="nav-item dropdown notification-list">
                        <a class="nav-link dropdown-toggle arrow-none waves-effect waves-light nav-user"
                           data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="false" aria-expanded="false">
                            <img src="assets/uplon/images/users/avatar-1.jpg" alt="user" class="img-circle">
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-arrow profile-dropdown "
                             aria-labelledby="Preview">
                            <!-- item-->
                            <div class="dropdown-item noti-title">
                                <h5 class="text-overflow">
                                    <small>Welcome ! John</small>
                                </h5>
                            </div>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="zmdi zmdi-account-circle"></i> <span>Profile</span>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="zmdi zmdi-settings"></i> <span>Settings</span>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="zmdi zmdi-lock-open"></i> <span>Lock Screen</span>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i class="zmdi zmdi-power"></i> <span>Logout</span>
                            </a>

                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- Top Bar End -->


    <!-- ========== Left Sidebar Start ========== -->
    <div class="left side-menu">
        <div class="sidebar-inner slimscrollleft">

            <!--- Sidemenu -->
            <div id="sidebar-menu">
                <ul>
                    <li class="text-muted menu-title">导航栏</li>

                    <li class="has_sub">
                        <a href="pajaxapimain/index.jsp" class="waves-effect"><i
                                class="zmdi zmdi-view-dashboard"></i><span>首页 </span> </a>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i class="zmdi zmdi-format-underlined"></i>
                            <span>功能列表</span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a data-pjax href="apiHandler2/getProjects">项目列表</a></li>
                            <li><a data-pjax href="dbsourceHandler2/getDbsourceList">数据源</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <!-- Sidebar -->
            <div class="clearfix"></div>

        </div>

    </div>
    <!-- Left Sidebar End -->


    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <!-- ============================================================== -->
    <div class="content-page">
        <!-- Start content -->
        <div class="content">
            <div class="container">

                <div class="row">
                    <div class="col-md-12">
                        <div id="mainContainer">
                            <div id="pajaxDIV"></div>
                        </div>
                    </div>
                </div>
            </div> <!-- container -->
        </div> <!-- content -->
    </div>
    <!-- End content-page -->


    <!-- ============================================================== -->
    <!-- End Right content here -->
    <!-- ============================================================== -->


    <!-- Right Sidebar -->
    <div class="side-bar right-bar">
        <div class="nicescroll">
            <ul class="nav nav-tabs text-xs-center">
                <li class="nav-item">
                    <a href="#home-2" class="nav-link active" data-toggle="tab" aria-expanded="false">
                        Activity
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#messages-2" class="nav-link" data-toggle="tab" aria-expanded="true">
                        Settings
                    </a>
                </li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane fade in active" id="home-2">
                    <div class="timeline-2">
                        <div class="time-item">
                            <div class="item-info">
                                <small class="text-muted">5 minutes ago</small>
                                <p><strong><a href="#" class="text-info">John Doe</a></strong> Uploaded a photo <strong>"DSC000586.jpg"</strong>
                                </p>
                            </div>
                        </div>

                        <div class="time-item">
                            <div class="item-info">
                                <small class="text-muted">30 minutes ago</small>
                                <p><a href="" class="text-info">Lorem</a> commented your post.</p>
                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus
                                    ut tincidunt euismod. "</em></p>
                            </div>
                        </div>

                        <div class="time-item">
                            <div class="item-info">
                                <small class="text-muted">59 minutes ago</small>
                                <p><a href="" class="text-info">Jessi</a> attended a meeting with<a href="#"
                                                                                                    class="text-success">John
                                    Doe</a>.</p>
                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus
                                    ut tincidunt euismod. "</em></p>
                            </div>
                        </div>

                        <div class="time-item">
                            <div class="item-info">
                                <small class="text-muted">1 hour ago</small>
                                <p><strong><a href="#" class="text-info">John Doe</a></strong>Uploaded 2 new photos</p>
                            </div>
                        </div>

                        <div class="time-item">
                            <div class="item-info">
                                <small class="text-muted">3 hours ago</small>
                                <p><a href="" class="text-info">Lorem</a> commented your post.</p>
                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus
                                    ut tincidunt euismod. "</em></p>
                            </div>
                        </div>

                        <div class="time-item">
                            <div class="item-info">
                                <small class="text-muted">5 hours ago</small>
                                <p><a href="" class="text-info">Jessi</a> attended a meeting with<a href="#"
                                                                                                    class="text-success">John
                                    Doe</a>.</p>
                                <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus
                                    ut tincidunt euismod. "</em></p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tab-pane fade" id="messages-2">

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">Notifications</h5>
                            <p class="text-muted m-b-0">
                                <small>Do you need them?</small>
                            </p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#64b0f2"
                                   data-size="small"/>
                        </div>
                    </div>

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">API Access</h5>
                            <p class="m-b-0 text-muted">
                                <small>Enable/Disable access</small>
                            </p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#64b0f2"
                                   data-size="small"/>
                        </div>
                    </div>

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">Auto Updates</h5>
                            <p class="m-b-0 text-muted">
                                <small>Keep up to date</small>
                            </p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#64b0f2"
                                   data-size="small"/>
                        </div>
                    </div>

                    <div class="row m-t-20">
                        <div class="col-xs-8">
                            <h5 class="m-0">Online Status</h5>
                            <p class="m-b-0 text-muted">
                                <small>Show your status to all</small>
                            </p>
                        </div>
                        <div class="col-xs-4 text-right">
                            <input type="checkbox" checked data-plugin="switchery" data-color="#64b0f2"
                                   data-size="small"/>
                        </div>
                    </div>

                </div>
            </div>
        </div> <!-- end nicescroll -->
    </div>
    <!-- /Right-bar -->

    <footer class="footer text-right">
        2016 © Uplon.
    </footer>


</div>
<!-- END wrapper -->


<script>
    var resizefunc = [];
</script>

<!-- jQuery  -->
<script language="javascript" type="text/javascript" src="assets/uplon/js/jquery2.1.4.js"></script>
<script type="text/javascript" language="javascript" src="assets/tether-1.3.3/js/tether.js"></script>
<script language="javascript" type="text/javascript" src="assets/bootstrap4alpha6/js/bootstrap.js"></script>
<script src="assets/uplon/js/detect.js"></script>
<script src="assets/uplon/js/fastclick.js"></script>
<script src="assets/uplon/js/jquery.blockUI.js"></script>
<script src="assets/uplon/js/waves.js"></script>
<script src="assets/uplon/js/jquery.nicescroll.js"></script>
<script src="assets/uplon/js/jquery.scrollTo.min.js"></script>
<script src="assets/uplon/js/jquery.slimscroll.js"></script>
<script src="assets/uplon/plugins/switchery/switchery.min.js"></script>


<!-- Counter Up  -->
<script src="assets/uplon/plugins/waypoints/lib/jquery.waypoints.js"></script>
<script src="assets/uplon/plugins/counterup/jquery.counterup.min.js"></script>

<!-- App js -->
<script src="assets/uplon/js/jquery.core.js"></script>
<script src="assets/uplon/js/jquery.app.js"></script>

<script src="assets/js/clock.js"></script>
<!--ldg main js-->
<script language="javascript" type="text/javascript" src="assets/js/jPage2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/pajax.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/newcommon.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/pajaxapimain/index.js"></script>
</body>
</html>