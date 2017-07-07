<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<div class="col-md-6">
    数据源名:${param.dbsourcename}<br/>
    连接地址:${param.dbsourcelinkurl}<br/>
    登录名:${param.dbsourceusername}<br/>
    登陆密码:${param.dbsourcepassword}<br/>
    驱动:${param.dbsourcedriver}<br/>
    <table id="dataTable" class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>表名称</th>
            <th>表注释</th>
            <th>表模式</th>
            <th>表类别</th>
            <th>表类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="obj">
            <tr>
                <td>${obj.TABLE_NAME}</td>
                <td>${obj.REMARKS}</td>
                <td>${obj.TABLE_SCHEM}</td>
                <td>${obj.TABLE_CAT}</td>
                <td>${obj.TABLE_TYPE}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/dbsorce/source/handlersource.js"></script>

