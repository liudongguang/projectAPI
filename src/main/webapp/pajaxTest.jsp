<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<head>
    <base href="${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>pajaxtest</title>
    <link rel="stylesheet" href="assets/tether-1.3.3/css/tether.css"/>
    <link rel="stylesheet" href="assets/bootstrap4alpha6/css/bootstrap.css"/>
</head>

<body>
<a href="pajaxA.jsp" data-pjax >pajaxA.jsp</a>
<a href="pajaxB.jsp" data-pjax >pajaxB.jsp</a>
<a href="bootstrap4.jsp" data-pjax >bootstrap4.jsp</a>
<div id="pjax-container"></div>
</body>
<script type="text/javascript" language="javascript" src="assets/js/jquery-3.2.0.js"></script>
<script type="text/javascript" language="javascript" src="assets/tether-1.3.3/js/tether.js"></script>
<script language="javascript" type="text/javascript" src="assets/bootstrap4alpha6/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/pajax.js"></script>

<script language="javascript" type="text/javascript">
    jQuery(document).ready(function () {
        $(document).pjax('[data-pjax] a, a[data-pjax]', '#pjax-container')
    })
</script>
</html>