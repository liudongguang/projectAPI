<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
    .m_r{ margin-right: 15px;}
    .one-group{ margin-top:20px !important;}
    .one-group .from-group{ margin-right: 15px;}
    label{ width: 80px; text-align: right}
    .form-control{ width: 167px !important;}
</style>

<div class="clearfix"></div>
<div class="col-md-12">

    <div style="position: fixed;background: #fff; width: 100%" >
        <button class="btn btn-primary" id="subBT" type="button">保存</button>
    </div>

    <form class="form-group"  style="margin-top: 50px; height: 800px;" id="subForm" method="post" action="apiHandler/saveProject">
        <div class="form-group top_01">
            <h3>参数名</h3>
            <div class="form-inline">
                <label>请求类型</label>
                <select class="form-control">
                    <option selected>post</option>
                    <option>get</option>
                </select>
                <label>接口地址</label>
                <input type="text" class="form-control" placeholder="">
            </div>

        </div>
        <h4>请求参数</h4>
        <%--一行三列开始--%>
        <div class="form-inline one-group">
        <div class="form-group">
            <label>参数名</label>
            <input type="text" class="form-control" placeholder="">
        </div>
        <div class="form-group">
            <label>参数类型</label>
            <select class="form-control">
                <option selected>string</option>
                <option>number</option>
            </select>
        </div>
        <div class="form-group">
            <label >备注</label>
            <input type="text" class="form-control"  placeholder="">
        </div>
        </div>
        <%--一行三列结束--%>
        <%--一行三列开始--%>
        <div class="form-inline one-group">
            <div class="form-group">
                <label>参数名</label>
                <input type="text" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <label>参数类型</label>
                <select class="form-control">
                    <option selected>string</option>
                    <option>number</option>
                </select>
            </div>
            <div class="form-group">
                <label >备注</label>
                <input type="text" class="form-control"  placeholder="">

            </div>
            <%--添加按钮--%>
            <div class="form-group">
                <button class="btn btn-success">添加</button>
            </div>
            <%--添加按钮结束--%>
        </div>
        <%--一行三列结束--%>
        <h4>返回参数</h4>
        <%--一行三列开始--%>
        <div class="form-inline one-group">
            <div class="form-group">
                <label>参数名</label>
                <input type="text" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <label>参数类型</label>
                <select class="form-control">
                    <option selected>string</option>
                    <option>number</option>
                </select>
            </div>
            <div class="form-group">
                <label >备注</label>
                <input type="text" class="form-control"  placeholder="">
            </div>
        </div>
        <%--一行三列结束--%>
        <%--一行三列开始--%>
        <div class="form-inline one-group">
            <div class="form-group">
                <label>参数名</label>
                <input type="text" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <label>参数类型</label>
                <select class="form-control">
                    <option selected>string</option>
                    <option>number</option>
                </select>
            </div>
            <div class="form-group">
                <label >备注</label>
                <input type="text" class="form-control"  placeholder="">

            </div>
            <%--添加按钮--%>
            <div class="form-group">
                <button class="btn btn-success">添加</button>
            </div>
            <%--添加按钮结束--%>
        </div>
        <%--一行三列结束--%>
    </form>
    </div>
<script language="javascript" type="text/javascript" src="assets/js/main/ajaxForm.js"></script>
<script language="javascript" type="text/javascript" src="assets/js/apimain/projectapi/addapi.js"></script>

