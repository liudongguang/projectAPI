<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<head>
    <base href="${pageContext.request.contextPath }/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>API接口管理系统-登陆</title>

    <!-- CSS -->

    <link rel="stylesheet" href="assets/css/bootstrap3.3.7.css" />
    <link rel="stylesheet" href="assets/login/loginfonts.css">
    <link rel="stylesheet"
          href="assets/login/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/login/form-elements.css">
    <link rel="stylesheet" href="assets/login/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/login/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="assets/login/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="assets/login/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="assets/login/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          href="assets/login/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>
                        <strong>API接口管理系统</strong>
                    </h1>
                    <div class="description">
                        <p>后台接口展示</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>系统登陆</h3>
                            <p>输入你的用户名与密码登陆:</p>
                            <p style="color: red">${requestScope.message }</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="apiHandler/login" method="post"
                              class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label> <input
                                    type="text" name="username" placeholder="用户名..." value=""
                                    class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label> <input
                                    type="password" name="password" placeholder="密码..."  value=""
                                    class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">登陆</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script src="assets/login/js/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="assets/login/js/scripts.js"></script>
<!--[if lt IE 10]>
<script type="text/javascript" src="assets/login/js/placeholder.js"></script>
<![endif]-->
</body>
</html>