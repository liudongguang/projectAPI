<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="clearfix"></div>
<div class="form-group">
    <button class="btn btn-primary-outline" data-pjax href="pajaxapimain/permissions/permission/add.jsp">新增</button>
</div>
<div class="table-responsive">
    <table id="dataTable" class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>权限名</th>
            <th>权限描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="obj">
            <tr id="${obj.uid}">
                <td>${obj.permissionname}</td>
                <td>${obj.description}</td>
                <td><a class="btn btn-danger-outline btn-sm" data-pjax delmark href="permission_shiro/deletePermission?uid=${obj.uid}">删除</a></td>
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
<input id="loadDataURL" type="hidden" value="permission_shiro/getPermissionPageInfo"/>
<input id="searFormID" type="hidden" value="subForm"/>
<input id="containerID" type="hidden" value="mainContainer"/>

<!--
分页结束
-->
<script language="javascript" type="text/javascript">
    jPageInit();
</script>


