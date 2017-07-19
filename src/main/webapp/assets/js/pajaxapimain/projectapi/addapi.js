jQuery(document).ready(function () {
    initAjaxForm("subform", "treemainContent");
    initSetDataForMulti();
    $("button[id^='addrequestBTID']").click({createTypeName:"request"},addRowFun);
    $("button[id^='delrequestBTID']").click({createTypeName:"request"},delRowFun);
    $("button[id^='addresponseBTID']").click({createTypeName:"response"},addRowFun);
    $("button[id^='delresponseBTID']").click({createTypeName:"response"},delRowFun);
    /////////////////////////////////////////////
    $("#requestBaseID").click(function () {
        var newGroup=createNewRow("request");
        $("#requestDIVID").append(newGroup);
        return false;
    });
    $("#responseDIVID").click(function () {
        var newGroup=createNewRow("response");
        $("#requestDIVID").append(newGroup);
        return false;
    });
});
function createNewRow(createTypeName) {
    var time = new Date().getTime();
    var $formgroup = $('<div class="form-group" id="baseGroup' + time + '"></div>');
    var $formgroup_e1 = $('<input name="' + createTypeName + 'ParamUID" type="hidden" value="-1"/>');
    $formgroup.append($formgroup_e1);
    var $formInline = $('<div class="form-inline"></div>');
    var $formInline_e1 = $('<label class="mr-sm-2">参数名</label>');
    var $formInline_e2 = $('<input name='+createTypeName+'"Param" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"   placeholder="请求参数名" required    value=""/>');
    var $formInline_e3 = $('<label class="mr-sm-2">参数类型</label>');
    var $formInline_e4 = $('<select class="custom-select mb-2 mr-sm-2 mb-sm-0" name='+createTypeName+'"ParamType"><option selected>string</option> <option>number</option></select>');
    var $formInline_e5 = $('<label class="mr-sm-2">是否必填</label>');
    var $formInline_e6 = $('<select class="custom-select mb-2 mr-sm-2 mb-sm-0" name='+createTypeName+'"Paramrequired"    setVal=""> <option value="是" selected>是</option>    <option value="否">否</option> </select>');
    var $formInline_e7 = $('<label class="mr-sm-2">备注</label>');
    var $formInline_e8 = $('<input name='+createTypeName+'"ParamBeizhu" type="text" class="form-control mb-2 mr-sm-2 mb-sm-0"    placeholder="请求参数备注"    value=""    required   />');
    var $formInline_e9 = $('<button id="add'+createTypeName+'BTID_'+time+'" class="btn btn-success-outline btn-rounded waves-effect waves-light mr-sm-2">添加</button>');
    var $formInline_e10 = $('       <button id="del'+createTypeName+'BTID_'+time+'" class="btn btn-danger-outline btn-rounded waves-effect waves-light">删除</button>');
    $formInline.append($formInline_e1).append($formInline_e2).append($formInline_e3).append($formInline_e4).append($formInline_e5).append($formInline_e6).append($formInline_e7).append($formInline_e8).append($formInline_e9).append($formInline_e10);
    $formgroup.append($formInline);
    /////
    $formInline_e9.click({createTypeName:createTypeName},addRowFun);
    $formInline_e10.click({createTypeName:createTypeName},delRowFun);
    /////
    return $formgroup;
}
function addRowFun(e) {
     var createTypeName=e.data.createTypeName;
     //1.获取当前所在位置
    var jq_this = $(this);
    var $currentFormGroup=jq_this.parent().parent();
    //2.创建元素
    var newGroup=createNewRow(createTypeName);
    //3.添加到当前位置后面
    $currentFormGroup.after(newGroup);
    jq_this.blur();
    return false;
}
function delRowFun(e) {
    var createTypeName=e.data.createTypeName;
    //1.获取当前按钮所在的formgroup
    var jq_this = $(this);
    var $currentFormGroup=jq_this.parent().parent();
    //2.如果不是-1生成当前的隐藏域，值为当前的id
    var hidenID=$currentFormGroup.find("input[name='"+createTypeName+"ParamUID']").val();
    if(hidenID!=-1){
        var delinputhtml = $('<input name="'+createTypeName+'DelParamUID" type="hidden"  value="'+hidenID+'"/>');
        $currentFormGroup.parent().append(delinputhtml);
    }
    //3.删除这个formgroup
    $currentFormGroup.remove();
    return false;
}
