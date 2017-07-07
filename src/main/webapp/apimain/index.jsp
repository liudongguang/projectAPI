<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    StringBuilder basePath = new StringBuilder();
    basePath.append(request.getScheme()).append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(path).append("/").toString();

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>API接口管理系统-管理</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="assets/css/templatemo_main.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<div class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <div class="logo">
            <img src="assets/images/logo2.png">
        </div>
    </div>
    <div class="pull-right">
        <div class="person_a">
            <label>你好，</label>
            <div class="btn-group">
                <button type="button" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">${sessionScope.user.uname} <span class="caret"></span></button>
                <ul class="dropdown-menu" style=" min-width:100px;">
                    <li><a ajaxhref href="/followupDisplay/updatePass.jsp">修改密码</a></li>
                    <li><a href="apiHandler/loginOut">退出</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!--btn-group结束-->

</div>
<div class="template-page-wrapper">
    <div class="navbar-collapse collapse templatemo-sidebar">
        <ul class="templatemo-sidebar-menu">
            <!-- <li>
               <form class="navbar-form">
                 <input type="text" class="form-control" id="templatemo_search_box" placeholder="Search...">
                 <span class="btn btn-default">go</span>
               </form>
             </li>-->
            <li class="active"><a href="javascript:;"><i class="fa fa-home"></i>首页</a></li>
            <li class="sub open"><a href="javascript:;"><span class="glyphicon glyphicon-calendar btn-lg"></span> 接口管理
                <div class="pull-right tt"><span class="caret"></span></div>
                    </a>
                <ul class="templatemo-submenu">
                    <li><a id="cysfID" href="/apiHandler/getProjects"><span class="glyphicon glyphicon-list-alt"></span>项目列表</a>
                    </li>
                    <li><a id="dbsourceID" href="/dbsourceHandler/getDbsourceList"><span class="glyphicon glyphicon-list-alt"></span>数据源</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <!--/.navbar-collapse -->

    <div class="templatemo-content-wrapper">
        <div class="templatemo-content-title">
         <ol id="titleBarID" class="breadcrumb">
            <li><a href="javascript:;">首页</a></li>
            <li><a href="javascript:;" id="v1ID"></a></li>
            <li class="active" id="v2ID"></li>
         </ol>
        </div>
        <div id="mainContent" class="templatemo-content" >

        </div>
    </div>
</div>
</div>
<footer class="templatemo-footer">
    <div class="templatemo-copyright">
        <p>Copyright &copy; liudongguang</p>
    </div>
</footer>
</div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap3.3.7.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxsessiontimeout.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/apimain/index.js"></script>
</body>
</html>