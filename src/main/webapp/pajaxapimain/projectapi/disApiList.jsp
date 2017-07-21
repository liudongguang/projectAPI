<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" href="assets/jstreecss/style.css">
<input id="projectID" type="hidden" value="${param.uid}"/>
<input id="projectnameID" type="hidden" value="${param.projectname}"/>
<div class="row">
      <div class="col-md-3">
        <div id="jstreeID">
        </div>
    </div>
    <div class="col-md-9" id="treemainContent">

    </div>
</div>
<script language="javascript" type="text/javascript" src="assets/js/pajaxapimain/projectapi/disApiList.js"></script>

