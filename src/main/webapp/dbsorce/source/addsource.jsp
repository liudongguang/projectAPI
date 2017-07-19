<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<div class="col-md-5">
    <form class="form-horizontal" id="subForm" method="post" action="dbsourceHandler/saveSource">
        <input id="uidID" name="uid" value="${obj.uid}" type="hidden"/>
        <div class="form-group">
            <div role="alert" class="alert alert-success">
                <strong>选择数据库类型</strong> 可以生成简要的数据库地址。
            </div>
        </div>
        <div class="form-group">
            <div class="radio radio-primary radio-inline">
                <input type="radio" value="1" id="radio1" name="dbtype">
                <label for="radio1">
                    mysql
                </label>
            </div>
            <div class="radio radio-primary radio-inline">
                <input type="radio" value="2" id="radio2" name="dbtype">
                <label for="radio2">
                    oracle
                </label>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label">数据源名（别名）</label>
            <input name="dbsourcename" checkparam value="${obj.dbsourcename}" type="text" required errInfo="数据源名不能为空"
                   class="form-control" placeholder="数据源名">
        </div>
        <div class="form-group">
            <label class="control-label">连接地址</label>
            <input name="dbsourcelinkurl" checkparam value="${obj.dbsourcelinkurl}" type="text" required
                   errInfo="连接地址不能为空"
                   class="form-control" placeholder="连接地址">
        </div>
        <div class="form-group">
            <label class="control-label">登录名</label>
            <input name="dbsourceusername" value="${obj.dbsourceusername}" type="text" required errInfo="登录名不能为空"
                   class="form-control" placeholder="登录名">
        </div>
        <div class="form-group">
            <label class="control-label">登陆密码</label>
            <input name="dbsourcepassword" value="${obj.dbsourcepassword}" type="text" required errInfo="登陆密码不能为空"
                   class="form-control" placeholder="登陆密码">
        </div>
        <div class="form-group">
            <label class="control-label">驱动</label>
            <input name="dbsourcedriver" value="${obj.dbsourcedriver}" type="text" required errInfo="驱动不能为空"
                   readonly="readonly"
                   class="form-control" placeholder="驱动">
        </div>
        <div class="form-group text-center">
            <button class="btn btn-primary-outline waves-effect waves-light" id="subBT" type="submit" form="subForm">保存</button>
            <button id="backBTID" class="btn btn-primary-outline waves-effect waves-light" type="button">返回</button>
        </div>
    </form>
</div>
<script language="javascript" type="text/javascript" src="assets/js/dbsorce/source/addsource.js"></script>

