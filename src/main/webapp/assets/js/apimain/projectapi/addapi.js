jQuery(document).ready(function(){
    initAjaxForm($("#subform"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true);
    $("#addRequestBTID").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        $("#requestDIVID").append(rowdiv.clone(true));
        jq_this.text("删除").unbind("click").click(function () {
            rowdiv.remove();
            return false;
        });
        return false;
    });
    $("#addResponseBTID").click(function () {
        var jq_this=$(this);
        var btDIV=jq_this.parent();
        var rowdiv=btDIV.parent();
        $("#responseDIVID").append(rowdiv.clone(true));
        jq_this.text("删除").unbind("click").click(function () {
            rowdiv.remove();
            return false;
        });
        return false;
    });
});