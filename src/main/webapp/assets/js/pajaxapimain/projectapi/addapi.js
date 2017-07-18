jQuery(document).ready(function () {
    initAjaxForm("subform", "treemainContent");
    initSetDataForMulti();
    $("button[id^='addRequestBTID']").click(addrequest);
    $("button[id^='delRequestBTID']").click(delRequest);
    $("button[id^='addResponseBTID']").click(addresponse);
    $("button[id^='delResponseBTID']").click(delresponse);
    /////////////////////////////////////////////
    $("#requestBaseID").click(function () {
        var requestHTML = ' <div class="form-group" id="baseGroup'+new Date().getTime()+'">                         <input name="rquestParamUID" type="hidden" value="-1"/>                         <div class="form-inline">                             <label class="mr-sm-2">参数名</label>                             <input name="rquestParam" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"                                    placeholder="请求参数名" required                                    value=""                                    errInfo="请求参数名不能为空！">                              <label class="mr-sm-2">参数类型</label>                             <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="rquestParamType">                                 <option selected>string</option>                                 <option>number</option>                             </select>                              <label class="mr-sm-2">是否必填</label>                             <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="rquestParamrequired"                                     setVal="">                                 <option value="是" selected>是</option>                                 <option value="否">否</option>                             </select>                              <label class="mr-sm-2">备注</label>                             <input name="rquestParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"                                    placeholder="请求参数备注"                                    value=""                                    required                                    errInfo="请求参数备注不能为空！">                                                             <div class="form-group">                                 <button id="addRequestBTID_'+new Date().getTime()+'"                                      class="btn btn-success-outline btn-rounded waves-effect waves-light">添加                                 </button>                                                                   <button id="delRequestBTID_'+new Date().getTime()+'"    class="btn btn-danger-outline btn-rounded waves-effect waves-light">删除                                 </button>                             </div>                                                     </div>                     </div>';
        var jq_requestHTML=$(requestHTML);
        $("#requestDIVID").append(jq_requestHTML);
        var newGroup=$("#requestDIVID").children("div[id^=baseGroup]");
        newGroup.find("button[id^='addRequestBTID']").click(addrequest)
        newGroup.find("button[id^='delRequestBTID']").click(delRequest)
        return false;
    });
    $("#resposeBaseID").click(function () {
        var responseHTML = '<div class="form-group" id="baseGroup'+new Date().getTime()+'">             <input name="responseParamUID" type="hidden" value="-1"/>                        <div class="form-inline">                            <label class="mr-sm-2">参数名</label>                            <input name="responseParam" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"                                   placeholder="返回参数名" required                                   value=""                                   errInfo="返回参数名不能为空！">                            <label class="mr-sm-2">参数类型</label>                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="responseParamType">                                <option selected>string</option>                                <option>number</option>                            </select>                            <label class="mr-sm-2">是否必填</label>                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="responseParamrequired"                                    setVal="${obj.paramrequired}">                                <option value="是" selected>是</option>                                <option value="否">否</option>                            </select>                            <label class="mr-sm-2">备注</label>                            <input name="responseParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"                                   placeholder="返回参数备注"                                   value=""                                   required                                   errInfo="返回参数备注不能为空！">                                                            <div class="form-group">                                <button id="addResponseBTID_"                                        class="btn btn-success-outline btn-rounded waves-effect waves-light">添加                                </button>                            </div>                                                      </div>                    </div>';
        var jq_responseHTML=$(responseHTML);
        $("#responseDIVID").append(jq_responseHTML);
        var newGroup=$("#requestDIVID").children("div[id^=baseGroup]");
        newGroup.find("button[id^='addRequestBTID']").click(addrequest)
        newGroup.find("button[id^='delRequestBTID']").click(delRequest)
        return false;
    });

});
function addrequest() {
    var jq_this = $(this);
    var jq_getformgroup = jq_this.parent().parent().parent();
    var jq_clone = jq_getformgroup.clone(true);
    jq_clone.find("input[type=text]").val("");
    jq_clone.find("input[name=rquestParamUID]").val("-1");
    var buttonID = jq_this.attr("id").split("_");
    var buttonID_qian = buttonID[0];
    var buttonID_hou = buttonID[1];
    var newButtonID = buttonID_qian + "_" + (parseInt(buttonID_hou) + 1);
    var newBT = jq_clone.find("button[id^=addRequestBTID]").attr("id", newButtonID);
    newBT.children().remove();//删除button中无用的div
    var jq_formgroup = $('<div class="form-group"></div>');
    jq_formgroup.append(jq_clone);
    jq_getformgroup.after(jq_formgroup);
    jq_this.blur();
    return false;
}
function delRequest() {
    var jq_this = $(this);
    var btDIV = jq_this.parent();
    var rowdiv = btDIV.parent().parent();
    var buttonID = jq_this.attr("id").split("_");
    var buttonID_hou = buttonID[1];
    if (buttonID_hou != -1) {
        var delinputhtml = $('<input name="rquestDelParamUID" type="hidden"  value="' + buttonID_hou + '"/>');
        rowdiv.after(delinputhtml);
    }
    rowdiv.remove();
    return false;
}
///////////////////////
function addresponse() {
    var jq_this = $(this);
    var jq_getformgroup = jq_this.parent().parent().parent();
    var jq_clone = jq_getformgroup.clone(true);
    jq_clone.find("input[type=text]").val("");
    jq_clone.find("input[name=responseParamUID]").val("-1");
    var buttonID = jq_this.attr("id").split("_");
    var buttonID_qian = buttonID[0];
    var buttonID_hou = buttonID[1];
    var newButtonID = buttonID_qian + "_" + (parseInt(buttonID_hou) + 1);
    var newBT = jq_clone.find("button[id^=addResponseBTID]").attr("id", newButtonID);
    newBT.children().remove();//删除button中无用的div
    var jq_formgroup = $('<div class="form-group"></div>');
    jq_formgroup.append(jq_clone);
    jq_getformgroup.after(jq_formgroup);
    jq_this.blur();
    return false;
}
function delresponse() {
    var jq_this = $(this);
    var btDIV = jq_this.parent();
    var jq_formgroup = btDIV.parent().parent();
    var buttonID = jq_this.attr("id").split("_");
    var buttonID_hou = buttonID[1];
    if (buttonID_hou != -1) {
        var delinputhtml = $('<input name="responseDelParamUID" type="hidden"  value="' + buttonID_hou + '"/>');
        jq_formgroup.after(delinputhtml);
    }
    jq_formgroup.remove();
    return false;
}