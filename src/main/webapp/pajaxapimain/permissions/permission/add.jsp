<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<div class="col-md-5">
    <form class="form-horizontal" id="subform" method="post" action="permission_shiro/savePermission">
        <div class="form-group">
            <label class="control-label">权限名</label>
            <input name="permissionname" type="text" required checkparam  class="form-control" placeholder="权限名">
        </div>
        <div class="form-group">
            <label class="control-label">权限描述</label>
                <textarea class="form-control" name="description" required  cols="80" rows="8"></textarea>
        </div>
        <div class="form-group text-center">
            <button class="btn btn-primary-outline waves-effect waves-light" id="subBT" type="submit" form="subform">保存</button>
            <button id="backBTID" class="btn btn-primary-outline waves-effect waves-light" type="button">返回</button>
        </div>
    </form>
</div>
<script language="javascript" type="text/javascript" src="assets/js/pajaxapimain/permissions/permission/add.js"></script>
