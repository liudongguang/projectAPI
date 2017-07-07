<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<div class="col-md-6">

    <form class="form-horizontal" id="subForm" method="post" action="dbsourceHandler/saveSource">
        <input id="uidID" name="uid" value="${obj.uid}" type="hidden"/>
        <div class="form-group">
            <label class="col-md-3 control-label">数据库类型</label>
            <label class="radio-inline">
                <input type="radio" name="dbtype" value="1"
                > mysql
            </label>
            <label class="radio-inline">
                <input type="radio" name="dbtype" value="2"
                > oracle
            </label>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">数据源名（别名）</label>
            <div class="col-md-8">
                <input name="dbsourcename" value="${obj.dbsourcename}" type="text" required errInfo="数据源名不能为空"
                       class="form-control" placeholder="数据源名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">连接地址</label>
            <div class="col-md-8">
                <input name="dbsourcelinkurl" value="${obj.dbsourcelinkurl}" type="text" required errInfo="连接地址不能为空"
                       class="form-control" placeholder="连接地址">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">登录名</label>
            <div class="col-md-8">
                <input name="dbsourceusername" value="${obj.dbsourceusername}" type="text" required errInfo="登录名不能为空"
                       class="form-control" placeholder="登录名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">登陆密码</label>
            <div class="col-md-8">
                <input name="dbsourcepassword" value="${obj.dbsourcepassword}" type="text" required errInfo="登陆密码不能为空"
                       class="form-control" placeholder="登陆密码">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">驱动</label>
            <div class="col-md-8">
                <input name="dbsourcedriver" value="${obj.dbsourcedriver}" type="text" required errInfo="驱动不能为空" readonly="readonly"
                       class="form-control" placeholder="驱动">
            </div>
        </div>
        <c:forEach items="${paramValues}" var="item">
            <input name="${item.key}" value="${item.value[0]}" type="hidden"/>
        </c:forEach>
    </form>
    <div class="form-group col-md-offset-4" style="margin-top: 30px">
        <button class="btn btn-primary" id="subBT" type="button">保存</button>
        <button id="backBTID" href="/dbsourceHandler/getDbsourceList" class="btn btn-default" type="button">返回</button>
    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/dbsorce/source/addsource.js"></script>

