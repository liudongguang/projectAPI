<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="clearfix"></div>
<div class="form-group">
    <button class="btn btn-primary-outline" data-pjax href="dbsorce/source/addsource.jsp">新增</button>
</div>
<div class="table-responsive">
    <table id="dataTable" class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>数据源名</th>
            <th>连接地址</th>
            <th>登录名</th>
            <th>登陆密码</th>
            <th>驱动</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="obj">
            <tr id="${obj.uid}">
                <td>${obj.dbsourcename}</td>
                <td>
                    <div id="layertips_${obj.uid}" class="textoverShengluehao">${obj.dbsourcelinkurl}</div>
                </td>
                <td>${obj.dbsourceusername}</td>
                <td>${obj.dbsourcepassword}</td>
                <td>${obj.dbsourcedriver}</td>
                <td><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td><a class="btn btn-success-outline btn-sm" data-pjax
                       href="dbsourceHandler/getTables?dbsourcelinkurl=${obj.dbsourcelinkurl}&dbsourceusername=${obj.dbsourceusername}&dbsourcepassword=${obj.dbsourcepassword}&dbsourcedriver=${obj.dbsourcedriver}">数据源</a>
                    <a class="btn btn-warning-outline btn-sm" data-pjax
                       href="dbsourceHandler/editDBSource?uid=${obj.uid}">修改</a>
                    <a class="btn btn-danger-outline btn-sm" data-pjax delmark
                       href="dbsourceHandler/delDBSource?uid=${obj.uid}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!--
分页开始
-->
<div id="pagesDIV" style="margin: 0 auto"></div>
<input id="pageNum" type="hidden" value="${page.pageNum}"/>
<input id="pageSize" type="hidden" value="${page.pageSize}"/>
<input id="pages" type="hidden" value="${page.pages}"/>
<input id="total" type="hidden" value="${page.total}"/>
<input id="loadDataURL" type="hidden" value="dbsourceHandler/getDbsourceList"/>
<input id="searFormID" type="hidden" value="subForm"/>
<input id="containerID" type="hidden" value="mainContainer"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript">
    jQuery(document).ready(function () {
        $.getScript("assets/js/jPageExt2.js");
        $.getScript("assets/js/dbsorce/source/disdbsources.js");
    });
</script>
