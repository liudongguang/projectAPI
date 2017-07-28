<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row">
    <div class="col-md-12"><label>接口地址:</label><span class="from-control">${apiobj.interfaceurl}</span>
    </div>
</div>
<div class="row">
    <div class="col-md-12"><label>请求类型:</label>
        <button class="btn btn-purple-outline waves-effect waves-light btn-sm" type="button">${apiobj.formmethod}</button></div>
</div>
<div class="row">
    <div class="col-md-8">
        <label>接口描述:</label>
        <textarea class="form-control" style="margin-left: 70px;margin-bottom: 10px;" disabled="disabled">${apiobj.description}</textarea>
    </div>
</div>
<div class="row"><h3>请求参数</h3></div>
<table id="dataTable" class="table table-striped table-hover table-bordered">
    <thead>
    <tr>
        <th>参数名</th>
        <th>参数类型</th>
        <th>是否必填</th>
        <th>备注</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${paramListRquest}" var="obj" varStatus="stat">
        <tr>
            <td>${obj.paramname}</td>
            <td>${obj.paramtype}</td>
            <td><span
                    <c:if test="${obj.paramrequired=='是'}">style="color: red" </c:if> >${obj.paramrequired}
            </span>
            </td>
            <td>${obj.parambeizhu}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--一行三列结束--%>
<div class="row"><h3>返回参数</h3></div>
<table id="dataTable" class="table table-striped table-hover table-bordered">
    <thead>
    <tr>
        <th>参数名</th>
        <th>参数类型</th>
        <th>是否必填</th>
        <th>备注</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${paramListResponse}" var="obj" varStatus="stat">
        <tr>
            <td>${obj.paramname}</td>
            <td>${obj.paramtype}</td>
            <td><span
                    <c:if test="${obj.paramrequired=='是'}">style="color: red" </c:if> >${obj.paramrequired}
            </span>
            </td>
            <td>${obj.parambeizhu}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
