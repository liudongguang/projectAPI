<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>API接口管理系统-管理</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="assets/tether-1.3.3/css/tether.css"/>
    <link rel="stylesheet" href="assets/bootstrap4alpha6/css/bootstrap.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="assets/css/ldgmain.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <input type="hidden" id="basePath" value="${pageContext.request.contextPath }/"/>
        <img src="assets/images/logo2.png">
    </div>
    <div style="margin-left: 10px;margin-right: 10px;">
        <div class="row">
            <div class="col-md-2">
                <!--左侧导航开始-->
                <div id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="card">
                        <div class="card-header" role="tab" id="headingOne">
                            <h5 class="mb-0">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                                   aria-expanded="true"
                                   aria-controls="collapseOne">
                                     功能列表
                                </a>
                            </h5>
                        </div>
                        <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                            <div class="card-block">
                                <div class="list-group">
                                    <a href="${pageContext.request.contextPath }/apiHandler/getProjects2" class="list-group-item list-group-item-action" data-pjax>项目列表</a>
                                    <a href="${pageContext.request.contextPath }/dbsourceHandler/getDbsourceList2" class="list-group-item list-group-item-action" data-pjax>数据源</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header" role="tab" id="headingTwo">
                            <h5 class="mb-0">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                                   aria-expanded="false" aria-controls="collapseTwo">
                                  菜单2
                                </a>
                            </h5>
                        </div>
                        <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="card-block">
                                <a href="#" class="list-group-item active">
                                    Cras justo odio
                                </a>
                                <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>
                                <a href="#" class="list-group-item list-group-item-action">Morbi leo risus</a>
                                <a href="#" class="list-group-item list-group-item-action">Porta ac consectetur ac</a>
                                <a href="#" class="list-group-item list-group-item-action disabled">Vestibulum at
                                    eros</a>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header" role="tab" id="headingThree">
                            <h5 class="mb-0">
                                <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseThree"
                                   aria-expanded="false" aria-controls="collapseThree">
                                    菜单3
                                </a>
                            </h5>
                        </div>
                        <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="card-block">
                                <a href="#" class="list-group-item active">
                                    Cras justo odio
                                </a>
                                <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in</a>
                                <a href="#" class="list-group-item list-group-item-action">Morbi leo risus</a>
                                <a href="#" class="list-group-item list-group-item-action">Porta ac consectetur ac</a>
                                <a href="#" class="list-group-item list-group-item-action disabled">Vestibulum at
                                    eros</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--左侧导航 结束-->
            <div class="col-md-10">
                <div class="templatemo-content-wrapper">
                    <div class="templatemo-content-title">
                        <ol id="titleBarID" class="breadcrumb">
                            <li><a href="javascript:;">首页</a></li>
                            <li><a href="javascript:;" id="v1ID"></a></li>
                            <li class="active" id="v2ID"></li>
                        </ol>
                    </div>
                    <div id="mainContent" class="templatemo-content">

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="card text-center fixed-bottom">
        <div class="card-block">
            <blockquote class="card-blockquote">
                <footer>Copyright &copy; liudongguang</footer>
            </blockquote>
        </div>
    </div>
</div>
</body>
<script language="javascript" type="text/javascript" src="assets/js/jquery-3.2.0.js"></script>
<script type="text/javascript" language="javascript" src="assets/tether-1.3.3/js/tether.js"></script>
<script language="javascript" type="text/javascript" src="assets/bootstrap4alpha6/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPage2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/pajax.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/moment.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/layer/layer.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/main/newcommon.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/newMainIndex.js"></script>
</html>