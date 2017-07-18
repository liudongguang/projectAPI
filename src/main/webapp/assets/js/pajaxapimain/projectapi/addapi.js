jQuery(document).ready(function(){
    initAjaxForm("subform", "treemainContent");
    initSetDataForMulti();
    $("button[id^='addRequestBTID']").click(function () {
        var jq_this=$(this);
        var jq_getformgroup =jq_this.parent().parent().parent();
        var jq_clone=jq_getformgroup.clone(true);
        jq_clone.find("input[type=text]").val("");
        jq_clone.find("input[name=rquestParamUID]").val("-1");
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_qian=buttonID[0];
        var buttonID_hou=buttonID[1];
        var newButtonID=buttonID_qian+"_"+(parseInt(buttonID_hou)+1);
        var newBT=jq_clone.find("button[id^=addRequestBTID]").attr("id",newButtonID);
        newBT.children().remove();//删除button中无用的div
        var jq_formgroup=$('<div class="form-group"></div>');
        jq_formgroup.append(jq_clone);
        jq_getformgroup.after(jq_formgroup);
        jq_this.blur();
        return false;
    });
    $("button[id^='delRequestBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent().parent();
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_hou=buttonID[1];
        if(buttonID_hou!=-1){
            var delinputhtml=$('<input name="rquestDelParamUID" type="hidden"  value="'+buttonID_hou+'"/>');
            rowdiv.after(delinputhtml);
        }
        rowdiv.remove();
        return false;
    });
    $("button[id^='addResponseBTID']").click(function () {
        var jq_this=$(this);
        var jq_getformgroup =jq_this.parent().parent().parent();
        var jq_clone=jq_getformgroup.clone(true);
        jq_clone.find("input[type=text]").val("");
        jq_clone.find("input[name=responseParamUID]").val("-1");
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_qian=buttonID[0];
        var buttonID_hou=buttonID[1];
        var newButtonID=buttonID_qian+"_"+(parseInt(buttonID_hou)+1);
        var newBT=jq_clone.find("button[id^=addResponseBTID]").attr("id",newButtonID);
        newBT.children().remove();//删除button中无用的div
        var jq_formgroup=$('<div class="form-group"></div>');
        jq_formgroup.append(jq_clone);
        jq_getformgroup.after(jq_formgroup);
        jq_this.blur();
        return false;
    });

    $("button[id^='delResponseBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var jq_formgroup=btDIV.parent().parent();

        console.log(jq_formgroup);
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_hou=buttonID[1];
        if(buttonID_hou!=-1){
            var delinputhtml=$('<input name="responseDelParamUID" type="hidden"  value="'+buttonID_hou+'"/>');
            jq_formgroup.after(delinputhtml);
        }
        jq_formgroup.remove();
        return false;
    });
});