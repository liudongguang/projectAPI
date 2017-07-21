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
    <title>API接口管理系统-项目接口</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="assets/css/templatemo_main.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/jstreecss/style.css">
</head>
<body style="background: #fff">
<input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
<input id="projectID" type="hidden" value="${param.uid}"/>
<input id="projectnameID" type="hidden" value="${param.projectname}"/>
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
<div class="">
    <div class="col-md-3" style=" padding:20px;">
        <div id="jstreeID">
        </div>
    </div>
    <div class="col-md-9" id="mainContent" style="border-left:1px solid #bbbbbb; border-left:1px solid #bbbbbb; padding:20px 15px; min-height: 500px;max-height: 800px;overflow: auto;">

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
<script language="javascript" type="text/javascript" src="assets/bootstrap4alpha6/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/templatemo_script.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/common.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxsessiontimeout.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jstree3.3.3.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/apimain/projectapilock/disApiList.js"></script>
</body>
</html>




