<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<div class="col-md-6">
    <form class="form-horizontal" id="subform" method="post" action="apiHandler/saveProject">
        <div class="form-group">
            <label class="col-md-2 control-label">项目名</label>
            <div class="col-md-8">
                <input name="projectname" type="text" required checkparam errInfo="项目名不能为空" class="form-control" placeholder="项目名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">服务地址</label>
            <div class="col-md-8">
                <input name="serverurl" type="text" required checkparam errInfo="服务地址不能为空" class="form-control" placeholder="服务地址">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">项目描述</label>
            <div class="col-md-8">
                <textarea name="description" required errInfo="项目描述不能为空" cols="80" rows="8"></textarea>
            </div>
        </div>
        <c:forEach items="${paramValues}" var="item">
            <input name="${item.key}" value="${item.value[0]}" type="hidden"/>
        </c:forEach>
    </form>
    <div class="form-group col-md-offset-4" style="margin-top: 30px">
        <button class="btn btn-primary-outline waves-effect waves-light" id="subBT" type="submit" form="subform">保存</button>
        <button id="backBTID" class="btn btn-primary-outline waves-effect waves-light" type="button">返回</button>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/pajaxapimain/project/addproject.js"></script>

