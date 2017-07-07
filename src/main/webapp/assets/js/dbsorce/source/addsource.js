jQuery(document).ready(function () {
    var jq_content = $("#mainContent");
    var $dbsourcelinkurl=$("[name=dbsourcelinkurl]");//连接地址
    var $dbsourcedriver=$("[name=dbsourcedriver]");//连接驱动
    initBackBt($("#backBTID"), jq_content);
    initAjaxForm($("#subForm"), $("#subBT"), function (data) {
        $("#mainContent").empty().html(data);
    }, true, function (form, options) {
        //修改情况直接进行提交
        if($("#uidID").val()){
            options.zzcid = layer.load(0, {
                shade: [0.8, '#fff']
                // 0.1透明度的白色背景
            });
            form.ajaxSubmit(options);
            return false;
        }
        var jq_dbsourcename=$("input[name=dbsourcename]");
        var jq_dbsourcelinkur=$("input[name=dbsourcelinkurl]");
        if(!jq_dbsourcename.val()){
            alertNullMsg(jq_dbsourcename);
            return false;
        }
        if(!jq_dbsourcelinkur.val()){
            alertNullMsg(jq_dbsourcelinkur);
            return false;
        }
        var ajaxOpt = {
            paramurl: $("#basePath").val() + "/dbsourceHandler/checkSourceNameAndlink",
            paramdata: {"dbsourcename": jq_dbsourcename.val(), "dbsourcelinkurl": jq_dbsourcelinkur.val()},
            dataType: 'json',
            callbackFun: function (data) {
                if (data.errcode == 0) {
                    options.zzcid = layer.load(0, {
                        shade: [0.8, '#fff']
                        // 0.1透明度的白色背景
                    });
                    form.ajaxSubmit(options);
                } else {
                    layer.alert(data.errmsg);
                }
            }
        };
        ajaxRun(ajaxOpt);
    });
    /////////////////////////////////////

    var mysqldriver="com.mysql.jdbc.Driver";
    var mysqlurl="jdbc:mysql://localhost:3306/x?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF8&useSSL=false";
    var oracledriver="oracle.jdbc.driver.OracleDriver";
    var oracleurl="jdbc:oracle:thin:@localhost:1521:x";
    $("[name='dbtype']").click(function () {
        var $this=$(this);
        var type=$this.val();
        if(type==1){//mysql
            $dbsourcelinkurl.val(mysqlurl);
            $dbsourcedriver.val(mysqldriver);
        }else if(type==2){//oracle
            $dbsourcelinkurl.val(oracleurl);
            $dbsourcedriver.val(oracledriver);
        }
    });
});