jQuery(document).ready(function () {
    var projectid = $("#projectID").val();
    if (!projectid) {
        layer.alert("没有选择项目！");
        return false;
    }
    var projectname=$("#projectnameID").val();
    init(projectid,projectname);
});
function init(projectid,projectname) {
    var ajaxOpt_getApiTitlesData = {
        paramurl: 'jsTree/getApiTitlesData',
        data: {projectid: projectid,projectname:projectname},
        dataType: 'json',
        successHandler: function (data) {
            initdata(data.data);
        }
    };
    newajaxRequest(ajaxOpt_getApiTitlesData);
}
function initdata(data) {
    $.jstree.defaults.core.themes.variant = "large";
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
        //console.log("id:" + id + "     name:" + name + "   level:" + level + "    " + "      projectid:" + projectid);
        if(level==2){
            ///打开接口详情
            // var ajaxOpt_getApiTitlesData = {
            //     paramurl: "apiHandler/getApiInfo",
            //     data: {apiID: id,projectid:projectid},
            //     successHandler: function (data) {
            //        $("#treemainContent").empty().append(data);
            //     }
            // };
            // newajaxRequest(ajaxOpt_getApiTitlesData);
            pajaxReq("apiHandler/getApiInfo","#treemainContent",{apiID: id,projectid:projectid},false);
        }
    })
}
