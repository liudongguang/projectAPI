jQuery(document).ready(function () {
    var basePath = $("#basePath").val();
    var projectid = $("#projectID").val();
    if (!projectid) {
        layer.alert("没有选择项目！");
        return false;
    }
    init(projectid);
});
function init(projectid) {
    var ii = layer.load(0, {
        shade: [0.8, '#fff']
        // 0.1透明度的白色背景
    });
    var ajaxOpt_getApiTitlesData = {
        paramurl: basePath + 'jsTree/getApiTitlesData',
        paramdata: {projectid: projectid},
        dataType: 'json',
        callbackFun: function (data) {
            if (data.errcode == 1) {
                layer.close(ii);
                layer.alert("需要初始化,请点击初始化按钮！");
                initFirstBT();
                return false;
            }
            initdata(data.data);
            layer.close(ii);
        }
    };
    ajaxRun(ajaxOpt_getApiTitlesData);
}
function initdata(data) {
    $.jstree.defaults.core.themes.variant = "large";
    $.jstree.defaults.contextmenu.items = {};
    var jq_tree = $('#jstreeID').jstree({
        "core": {
            "check_callback": true
            // 'data': data
        },
        "plugins": ["contextmenu"]
    });
    $('#jstreeID').jstree(true).settings.core.data = data;//放入数据
    $('#jstreeID').jstree(true).refresh();//刷新数据
    $('#jstreeID').on("select_node.jstree", function (event, node) {
        var rnode = node.node;
        var id = rnode.id;
        var name = rnode.text;
        var level = rnode.li_attr.level;
        var projectid = rnode.li_attr.projectid;
        if(level==2){
            ///打开接口详情
            jumpPageNoAuthority("/apiHandler/getApiInfo?apiID="+id+"&projectid="+projectid,$("#mainContent"));
        }
    })
    ////////修改了名称后触发
    $('#jstreeID').on("rename_node.jstree", function (event, node) {
        var rnode = node.node;
        var id = rnode.id;
        var name = rnode.text;
        var level = rnode.li_attr.level;
        var projectid = rnode.li_attr.projectid;
        var firstIndexVal = id.indexOf('j');
        if (firstIndexVal == -1) {//不是开头的可以跟数据库进行交互
           // console.log("rename_node db................")
            ajaxRequest("jsTree/updateTreeElement", {
                "uid":id,
                "apititle":name
            }, function (data) {
                if(data.errcode ==0 ){
                    layer.msg("修改成功！");
                }
            });
        }
        //console.log("rename_node id:" + id)
    })
    //删除触发
    $('#jstreeID').on("delete_node.jstree", function (event, node) {
        var rnode = node.node;
        var id = rnode.id;
        var name = rnode.text;
        var level = rnode.li_attr.level;
        var projectid = rnode.li_attr.projectid;
        var firstIndexVal = id.indexOf('j');
        if (firstIndexVal == -1) {//不是开头的可以跟数据库进行交互
            //   console.log("delete_node db................")
        }
       // console.log("delete_node")
    })
}
function initFirstBT() {
    var jq_div = $("#jstreeID");
    var createbutton = $("<button class='btn btn-primary'>初始化</button>");
    createbutton.click(function () {
        var projectid = $("#projectID").val();
        var projectname = $("#projectnameID").val();
        if (!projectid) {
            layer.alert("没有选择项目！");
            return false;
        }
        var ajaxOpt = {
            paramurl: basePath + 'jsTree/initApiTitleData',
            paramdata: {projectid: projectid, projectname: projectname},
            dataType: 'json',
            callbackFun: function (data) {
                location.href = basePath + "/apimain/projectapi/disApiList.jsp?uid=" + projectid + "&projectname=" + projectname;
            }
        };
        ajaxRun(ajaxOpt);
    });
    jq_div.append(createbutton);
}