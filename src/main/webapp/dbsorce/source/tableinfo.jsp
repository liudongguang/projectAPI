<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="clearfix"></div>
<div class="col-md-6">
    <table id="dataTable" class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>序号</th>
            <th>列名称</th>
            <th>类型</th>
            <th>列注释</th>
                   </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="obj" varStatus="sta">
             <tr>
                 <td>${sta.index+1}</td>
                 <td>${obj.COLUMN_NAME}</td>
                 <td>${obj.TYPE_NAME}</td>
                 <td>${obj.REMARKS}</td>
             </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script language="javascript" type="text/javascript" src="assets/js/dbsorce/source/handlersource.js"></script>

