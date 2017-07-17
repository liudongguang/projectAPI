<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <!-- App Favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- App title -->
    <title>Uplon - Responsive Admin Dashboard Template</title>

    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="assets/uplon/plugins/morris/morris.css">

    <!-- Switchery css -->
    <link href="assets/uplon/plugins/switchery/switchery.min.css" rel="stylesheet"/>

    <!-- App CSS -->

    <link rel="stylesheet" href="assets/tether-1.3.3/css/tether.css"/>
    <link rel="stylesheet" href="assets/bootstrap4alpha6/css/bootstrap.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="assets/uplon/style.css"/>

    <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
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
                    <li class="text-muted menu-title">Navigation</li>

                    <li class="has_sub">
                        <a href="index.html" class="waves-effect active"><span
                                class="label label-pill label-primary pull-xs-right">1</span><i
                                class="zmdi zmdi-view-dashboard"></i><span> Dashboard </span> </a>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i class="zmdi zmdi-format-underlined"></i>
                            <span> User Interface </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="ui-buttons.html">Buttons</a></li>
                            <li><a href="ui-cards.html">Cards</a></li>
                            <li><a href="ui-dropdowns.html">Dropdowns</a></li>
                            <li><a href="ui-checkbox-radio.html">Checkboxs-Radios</a></li>
                            <li><a href="ui-navs.html">Navs</a></li>
                            <li><a href="ui-progress.html">Progress</a></li>
                            <li><a href="ui-modals.html">Modals</a></li>
                            <li><a href="ui-notification.html">Notification</a></li>
                            <li><a href="ui-alerts.html">Alerts</a></li>
                            <li><a href="ui-carousel.html">Carousel</a></li>
                            <li><a href="ui-bootstrap.html">Bootstrap UI</a></li>
                            <li><a href="ui-typography.html">Typography</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i class="zmdi zmdi-album"></i> <span> Components </span>
                            <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="components-grid.html">Grid</a></li>
                            <li><a href="components-range-sliders.html">Range sliders</a></li>
                            <li><a href="components-sweet-alert.html">Sweet Alerts</a></li>
                            <li><a href="components-ratings.html">Ratings</a></li>
                            <li><a href="components-treeview.html">Treeview</a></li>
                            <li><a href="components-tour.html">Tour</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="calendar.html" class="waves-effect"><i
                                class="zmdi zmdi-calendar"></i><span> Calendar </span> </a>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i class="zmdi zmdi-widgets"></i> <span> Widgets </span>
                            <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="widgets-tiles.html">Tile Box</a></li>
                            <li><a href="widgets-charts.html">Chart Widgets</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i class="zmdi zmdi-fire"></i>
                            <span> Icons </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="icons-materialdesign.html">Material Design</a></li>
                            <li><a href="icons-ionicons.html">Ion Icons</a></li>
                            <li><a href="icons-fontawesome.html">Font awesome</a></li>
                            <li><a href="icons-themify.html">Themify Icons</a></li>
                            <li><a href="icons-simple-line.html">Simple line Icons</a></li>
                            <li><a href="icons-weather.html">Weather Icons</a></li>
                            <li><a href="icons-pe7.html">PE7 Icons</a></li>
                            <li><a href="icons-typicons.html">Typicons</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><span
                                class="label label-pill label-warning pull-xs-right">8</span><i
                                class="zmdi zmdi-collection-text"></i><span> Forms </span> </a>
                        <ul class="list-unstyled">
                            <li><a href="form-elements.html">General Elements</a></li>
                            <li><a href="form-advanced.html">Advanced Form</a></li>
                            <li><a href="form-validation.html">Form Validation</a></li>
                            <li><a href="form-pickers.html">Form Pickers</a></li>
                            <li><a href="form-wizard.html">Form Wizard</a></li>
                            <li><a href="form-mask.html">Form Masks</a></li>
                            <li><a href="form-uploads.html">Multiple File Upload</a></li>
                            <li><a href="form-xeditable.html">X-editable</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i
                                class="zmdi zmdi-format-list-bulleted"></i> <span> Tables </span> <span
                                class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="tables-basic.html">Basic Tables</a></li>
                            <li><a href="tables-datatable.html">Data Table</a></li>
                            <li><a href="tables-responsive.html">Responsive Table</a></li>
                            <li><a href="tables-tablesaw.html">Tablesaw</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i
                                class="zmdi zmdi-chart"></i><span> Charts </span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="chart-flot.html">Flot Chart</a></li>
                            <li><a href="chart-morris.html">Morris Chart</a></li>
                            <li><a href="chart-chartjs.html">Chartjs</a></li>
                            <li><a href="chart-peity.html">Peity Charts</a></li>
                            <li><a href="chart-chartist.html">Chartist Charts</a></li>
                            <li><a href="chart-c3.html">C3 Charts</a></li>
                            <li><a href="chart-sparkline.html">Sparkline charts</a></li>
                            <li><a href="chart-knob.html">Jquery Knob</a></li>
                        </ul>
                    </li>

                    <li class="text-muted menu-title">More</li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><span
                                class="label label-success label-pill pull-xs-right">9</span><i
                                class="zmdi zmdi-collection-item"></i><span> Pages </span></a>
                        <ul class="list-unstyled">
                            <li><a href="pages-starter.html">Starter Page</a></li>
                            <li><a href="pages-login.html">Login</a></li>
                            <li><a href="pages-register.html">Register</a></li>
                            <li><a href="pages-recoverpw.html">Recover Password</a></li>
                            <li><a href="pages-lock-screen.html">Lock Screen</a></li>
                            <li><a href="pages-404.html">Error 404</a></li>
                            <li><a href="pages-500.html">Error 500</a></li>
                            <li><a href="pages-timeline.html">Timeline</a></li>
                            <li><a href="pages-invoice.html">Invoice</a></li>
                        </ul>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(0);" class="waves-effect"><i class="zmdi zmdi-blur-linear"></i><span>Multi Level </span>
                            <span class="menu-arrow"></span></a>
                        <ul>
                            <li class="has_sub">
                                <a href="javascript:void(0);" class="waves-effect"><span>Menu Level 1.1</span> <span
                                        class="menu-arrow"></span> </a>
                                <ul style="">
                                    <li><a href="javascript:void(0);"><span>Menu Item</span></a></li>
                                    <li><a href="javascript:void(0);"><span>Menu Item</span></a></li>
                                    <li><a href="javascript:void(0);"><span>Menu Item</span></a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);"><span>Menu Level 1.2</span></a>
                            </li>
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
                    <div class="col-xs-12">
                        <div class="page-title-box">
                            <h4 class="page-title">Dashboard - T H E M E L O C K . C O M </h4>
                            <ol class="breadcrumb p-0">
                                <li>
                                    <a href="#">Uplon</a>
                                </li>
                                <li>
                                    <a href="#">Dashboard</a>
                                </li>
                                <li class="active">
                                    Dashboard
                                </li>
                            </ol>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <!-- end row -->


                <div class="row">
                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-layers pull-xs-right text-muted"></i>
                            <h6 class="text-muted text-uppercase m-b-20">Orders</h6>
                            <h2 class="m-b-20" data-plugin="counterup">1,587</h2>
                            <span class="label label-success"> +11% </span> <span class="text-muted">From previous period</span>
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-paypal pull-xs-right text-muted"></i>
                            <h6 class="text-muted text-uppercase m-b-20">Revenue</h6>
                            <h2 class="m-b-20">$<span data-plugin="counterup">46,782</span></h2>
                            <span class="label label-danger"> -29% </span> <span
                                class="text-muted">From previous period</span>
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-chart pull-xs-right text-muted"></i>
                            <h6 class="text-muted text-uppercase m-b-20">Average Price</h6>
                            <h2 class="m-b-20">$<span data-plugin="counterup">15.9</span></h2>
                            <span class="label label-pink"> 0% </span> <span
                                class="text-muted">From previous period</span>
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
                        <div class="card-box tilebox-one">
                            <i class="icon-rocket pull-xs-right text-muted"></i>
                            <h6 class="text-muted text-uppercase m-b-20">Product Sold</h6>
                            <h2 class="m-b-20" data-plugin="counterup">1,890</h2>
                            <span class="label label-warning"> +89% </span> <span class="text-muted">Last year</span>
                        </div>
                    </div>
                </div>
                <!-- end row -->


                <div class="row">
                    <div class="col-xs-12 col-lg-12 col-xl-8">
                        <div class="card-box">

                            <h4 class="header-title m-t-0 m-b-20">Sales Statistics</h4>

                            <div class="text-xs-center">
                                <ul class="list-inline chart-detail-list m-b-0">
                                    <li class="list-inline-item">
                                        <h6 style="color: #3db9dc;"><i class="zmdi zmdi-circle-o m-r-5"></i>Series A
                                        </h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <h6 style="color: #1bb99a;"><i class="zmdi zmdi-triangle-up m-r-5"></i>Series B
                                        </h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <h6 style="color: #818a91;"><i class="zmdi zmdi-square-o m-r-5"></i>Series C
                                        </h6>
                                    </li>
                                </ul>
                            </div>

                            <div id="morris-bar-stacked" style="height: 320px;"></div>

                        </div>
                    </div><!-- end col-->

                    <div class="col-xs-12 col-lg-12 col-xl-4">
                        <div class="card-box">

                            <h4 class="header-title m-t-0 m-b-30">Trends Monthly</h4>

                            <div class="text-xs-center m-b-20">
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <button type="button" class="btn btn-sm btn-secondary">Today</button>
                                    <button type="button" class="btn btn-sm btn-secondary">This Week</button>
                                    <button type="button" class="btn btn-sm btn-secondary">Last Week</button>
                                </div>
                            </div>

                            <div id="morris-donut-example" style="height: 263px;"></div>

                            <div class="text-xs-center">
                                <ul class="list-inline chart-detail-list m-b-0">
                                    <li class="list-inline-item">
                                        <h6 style="color: #3db9dc;"><i class="zmdi zmdi-circle-o m-r-5"></i>English</h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <h6 style="color: #1bb99a;"><i class="zmdi zmdi-triangle-up m-r-5"></i>Italian
                                        </h6>
                                    </li>
                                    <li class="list-inline-item">
                                        <h6 style="color: #818a91;"><i class="zmdi zmdi-square-o m-r-5"></i>French</h6>
                                    </li>
                                </ul>
                            </div>

                        </div>
                    </div><!-- end col-->


                </div>
                <!-- end row -->


                <div class="row">
                    <div class="col-xs-12 col-lg-12 col-xl-7">
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <div class="card-box">
                                    <h4 class="header-title m-t-0 m-b-20">Inbox</h4>

                                    <div class="inbox-widget nicescroll" style="height: 320px;">
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-1.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Chadengle</p>
                                                <p class="inbox-item-text">Hey! there I'm available...</p>
                                                <p class="inbox-item-date">13:40 PM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-2.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Tomaslau</p>
                                                <p class="inbox-item-text">I've finished it! See you so...</p>
                                                <p class="inbox-item-date">13:34 PM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-3.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Stillnotdavid</p>
                                                <p class="inbox-item-text">This theme is awesome!</p>
                                                <p class="inbox-item-date">13:17 PM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-4.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Kurafire</p>
                                                <p class="inbox-item-text">Nice to meet you</p>
                                                <p class="inbox-item-date">12:20 PM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-5.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Shahedk</p>
                                                <p class="inbox-item-text">Hey! there I'm available...</p>
                                                <p class="inbox-item-date">10:15 AM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-6.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Adhamdannaway</p>
                                                <p class="inbox-item-text">This theme is awesome!</p>
                                                <p class="inbox-item-date">9:56 AM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-8.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Arashasghari</p>
                                                <p class="inbox-item-text">Hey! there I'm available...</p>
                                                <p class="inbox-item-date">10:15 AM</p>
                                            </div>
                                        </a>
                                        <a href="#">
                                            <div class="inbox-item">
                                                <div class="inbox-item-img"><img src="assets/uplon/images/users/avatar-9.jpg"
                                                                                 class="img-circle" alt=""></div>
                                                <p class="inbox-item-author">Joshaustin</p>
                                                <p class="inbox-item-text">I've finished it! See you so...</p>
                                                <p class="inbox-item-date">9:56 AM</p>
                                            </div>
                                        </a>
                                    </div>

                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6">
                                <div class="card-box">
                                    <h4 class="header-title m-t-0 m-b-20">Sales Statistics</h4>

                                    <p class="font-600 m-b-5">iMacs <span
                                            class="text-danger pull-right"><b>79%</b></span></p>
                                    <progress class="progress progress-striped progress-xs progress-danger m-b-0"
                                              value="79" max="100">79%
                                    </progress>
                                </div>

                                <div class="card-box">
                                    <h4 class="header-title m-t-0 m-b-20">Monthly Sales</h4>

                                    <p class="font-600 m-b-5">Macbooks <span class="text-success pull-right"><b>30%</b></span>
                                    </p>
                                    <progress class="progress progress-striped progress-xs progress-success m-b-0"
                                              value="30" max="100">30%
                                    </progress>
                                </div>

                                <div class="card-box">
                                    <h4 class="header-title m-t-0 m-b-20">Daily Sales</h4>

                                    <p class="font-600 m-b-5">Mobiles <span
                                            class="text-warning pull-right"><b>50%</b></span></p>
                                    <progress class="progress progress-striped progress-xs progress-warning m-b-0"
                                              value="50" max="100">50%
                                    </progress>
                                </div>

                            </div>

                        </div>
                    </div><!-- end col-->

                    <div class="col-xs-12 col-lg-12 col-xl-5">
                        <div class="card-box">

                            <h4 class="header-title m-t-0 m-b-30">Top Contracts</h4>

                            <div class="table-responsive">
                                <table class="table table-bordered m-b-0">
                                    <thead>
                                    <tr>
                                        <th>Company</th>
                                        <th>Start Date</th>
                                        <th>End Date</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th class="text-muted">Apple Technology</th>
                                        <td>20/02/2014</td>
                                        <td>19/02/2020</td>
                                        <td><span class="label label-success">Paid</span></td>
                                    </tr>
                                    <tr>
                                        <th class="text-muted">Envato Pty Ltd.</th>
                                        <td>20/02/2014</td>
                                        <td>19/02/2020</td>
                                        <td><span class="label label-danger">Unpaid</span></td>
                                    </tr>
                                    <tr>
                                        <th class="text-muted">Dribbble LLC.</th>
                                        <td>20/02/2014</td>
                                        <td>19/02/2020</td>
                                        <td><span class="label label-success">Paid</span></td>
                                    </tr>
                                    <tr>
                                        <th class="text-muted">Adobe Family</th>
                                        <td>20/02/2014</td>
                                        <td>19/02/2020</td>
                                        <td><span class="label label-success">Paid</span></td>
                                    </tr>
                                    <tr>
                                        <th class="text-muted">Apple Technology</th>
                                        <td>20/02/2014</td>
                                        <td>19/02/2020</td>
                                        <td><span class="label label-danger">Unpaid</span></td>
                                    </tr>
                                    <tr>
                                        <th class="text-muted">Envato Pty Ltd.</th>
                                        <td>20/02/2014</td>
                                        <td>19/02/2020</td>
                                        <td><span class="label label-success">Paid</span></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>


                        </div>
                    </div><!-- end col-->


                </div>
                <!-- end row -->


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

<!--Morris Chart-->
<script src="assets/uplon/plugins/morris/morris.min.js"></script>
<script src="assets/uplon/plugins/raphael/raphael-min.js"></script>

<!-- Counter Up  -->
<script src="assets/uplon/plugins/waypoints/lib/jquery.waypoints.js"></script>
<script src="assets/uplon/plugins/counterup/jquery.counterup.min.js"></script>

<!-- App js -->
<script src="assets/uplon/js/jquery.core.js"></script>
<script src="assets/uplon/js/jquery.app.js"></script>

<!-- Page specific js -->
<script src="assets/uplon/pages/jquery.dashboard.js"></script>
<script src="assets/js/clock.js"></script>
</body>
</html>