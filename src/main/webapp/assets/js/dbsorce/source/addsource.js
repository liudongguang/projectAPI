jQuery(document).ready(function () {
    initBackUpBT("backBTID");
    initAjaxForm("subForm", "mainContainer", {paramurl: 'dbsourceHandler/checkSourceNameAndlink'});
/////////////////////////////////////
var mysqldriver = "com.mysql.jdbc.Driver";
var mysqlurl = "jdbc:mysql://localhost:3306/x?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF8&useSSL=false";
var oracledriver = "oracle.jdbc.driver.OracleDriver";
var oracleurl = "jdbc:oracle:thin:@localhost:1521:x";
var $dbsourcelinkurl=$("[name=dbsourcelinkurl]");//连接地址
var $dbsourcedriver=$("[name=dbsourcedriver]");//连接驱动
$("[name='dbtype']").click(function () {
    var $this = $(this);
    var type = $this.val();
    if (type == 1) {//mysql
        $dbsourcelinkurl.val(mysqlurl);
        $dbsourcedriver.val(mysqldriver);
    } else if (type == 2) {//oracle
        $dbsourcelinkurl.val(oracleurl);
        $dbsourcedriver.val(oracledriver);
    }
});
});