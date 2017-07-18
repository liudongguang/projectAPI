jQuery(document).ready(function(){
    initAjaxForm("subform", "treemainContent");
    initSetDataForMulti();
    $("button[id^='addRequestBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        var jq_clone=rowdiv.clone(true);
        jq_clone.find("input[type=text]").val("");
        jq_clone.find("input[name=rquestParamUID]").val("-1");
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_qian=buttonID[0];
        var buttonID_hou=buttonID[1];
        var newButtonID=buttonID_qian+"_"+(parseInt(buttonID_hou)+1);
        jq_clone.find("button[id^=addRequestBTID]").attr("id",newButtonID);
        $("#requestDIVID").append(jq_clone);
        jq_this.text("删除").unbind("click").click(function () {
            rowdiv.remove();
            return false;
        });
        return false;
    });
    $("button[id^='delRequestBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_hou=buttonID[1];
        if(buttonID_hou!=-1){
            var delinputhtml=$('<input name="rquestDelParamUID" type="hidden"  value="'+buttonID_hou+'"/>');
            $("#requestDIVID").append(delinputhtml);
        }
        rowdiv.remove();
        return false;
    });
    $("button[id^='addResponseBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        var jq_clone=rowdiv.clone(true);
        jq_clone.find("input[type=text]").val("");
        jq_clone.find("input[name=responseParamUID]").val("-1");
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_qian=buttonID[0];
        var buttonID_hou=buttonID[1];
        var newButtonID=buttonID_qian+"_"+(parseInt(buttonID_hou)+1);
        jq_clone.find("button[id^=addResponseBTID]").attr("id",newButtonID);
        $("#responseDIVID").append(jq_clone);
        jq_this.text("删除").unbind("click").click(function () {
            rowdiv.remove();
            return false;
        });
        return false;
    });

    $("button[id^='delResponseBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        var buttonID=jq_this.attr("id").split("_");
        var buttonID_hou=buttonID[1];
        if(buttonID_hou!=-1){
            var delinputhtml=$('<input name="responseDelParamUID" type="hidden"  value="'+buttonID_hou+'"/>');
            $("#responseDIVID").append(delinputhtml);
        }
        rowdiv.remove();
        return false;
    });
});