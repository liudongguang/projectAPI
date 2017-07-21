<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="clearfix"></div>
<div class="form-group">
    <button class="btn btn-primary-outline" data-pjax href="pajaxapimain/project/addproject.jsp">新增</button>
</div>
<div class="table-responsive">
    <table id="dataTable" class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>项目名</th>
            <th>创建时间</th>
            <th>项目描述</th>
            <th>服务地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="obj">
            <tr id="${obj.uid}">
                <td>${obj.projectname}</td>
                <td><fmt:formatDate value="${obj.createtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                <td>${obj.description}</td>
                <td>${obj.serverurl}</td>
                <td><a class="btn btn-warning-outline btn-sm" data-pjax
                       href="jsTree/getApiTitles?uid=${obj.uid}&projectname=${obj.projectname}">API接口文档</a>
                    <a class="btn btn-danger-outline btn-sm" data-pjax delmark href="apiHandler/delApiProject?uid=${obj.uid}">删除</a></td>
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
<input id="loadDataURL" type="hidden" value="apiHandler/getProjects"/>
<input id="searFormID" type="hidden" value="subForm"/>
<input id="containerID" type="hidden" value="mainContainer"/>

<!--
分页结束
-->
<script language="javascript" type="text/javascript" src="assets/js/jPageExt2.js"></script>


