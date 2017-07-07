<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="clearfix"></div>
<div class="form-group">
    <button class="btn btn-primary btn-large" ajaxthispage href="/dbsorce/source/addsource.jsp">新增</button>
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
                <td>${obj.dbsourcelinkurl}</td>
                <td>${obj.dbsourceusername}</td>
                <td>${obj.dbsourcepassword}</td>
                <td>${obj.dbsourcedriver}</td>
                <td><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td><a class="label label-success" searFormID="subForm" pageNumParam="${page.pageNum}" ajaxthispage
                       href="/dbsourceHandler/handlerDBSource?uid=${obj.uid}">数据源</a>
                    <a class="label label-warning" searFormID="subForm" pageNumParam="${page.pageNum}" ajaxthispage
                       href="/dbsourceHandler/editDBSource?uid=${obj.uid}">修改</a>
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
<input id="loadDataURL" type="hidden" value="/apiHandler/getProjects"/>
<input id="searFormID" type="hidden" value="subForm"/>
<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jPage-1.2.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/jPageExt.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/dbsorce/source/disdbsources.js"></script>

