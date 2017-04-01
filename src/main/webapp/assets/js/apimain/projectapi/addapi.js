jQuery(document).ready(function(){
    initAjaxForm($("#subform"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true);
    $("button[id^='addRequestBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        var jq_clone=rowdiv.clone(true);
        jq_clone.find("input[type=text]").val("");
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
        rowdiv.remove();
        return false;
    });
    $("button[id^='addResponseBTID']").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        var jq_clone=rowdiv.clone(true);
        jq_clone.find("input[type=text]").val("");
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
        rowdiv.remove();
        return false;
    });
});