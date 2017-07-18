<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<input id="projectID" type="hidden" value="${param.uid}"/>
<input id="projectnameID" type="hidden" value="${param.projectname}"/>
<div class="">
    <div class="col-md-3" style=" padding:20px;margin-bottom: 50px;">
        <div id="jstreeID">
        </div>
    </div>
    <div class="col-md-9" id="mainContent" style="border-left:1px solid #bbbbbb; border-left:1px solid #bbbbbb; padding:20px 15px; min-height: 500px;max-height: 800px;overflow: auto;">

    </div>
</div>
</div>
<script language="javascript" type="text/javascript">
    jQuery(document).ready(function () {
        $.getScript("assets/js/jstree3.3.3.js");
        $.getScript("assets/js/pajaxapimain/projectapi/disApiList.js");
    });
</script>

