jQuery(document).ready(function () {
    var projectid = $("#projectID").val();
    if (!projectid) {
        layer.alert("没有选择项目！");
        return false;
    }

    init(projectid);
});
function init(projectid) {
    var ajaxOpt_getApiTitlesData = {
        paramurl: 'jsTree2/getApiTitlesData',
        data: {projectid: projectid},
        dataType: 'json',
        successHandler: function (data) {
            initdata(data.data);
        }
    };
    newajaxRequest(ajaxOpt_getApiTitlesData);
}
function initdata(data) {
    $.jstree.defaults.core.themes.variant = "large";
    $.jstree.defaults.contextmenu.items = {
        "mcreate": {
            "label": "新建菜单",
            "action": function (data) {
                var projectid = $("#projectID").val();
                var inst = jQuery.jstree.reference(data.reference), obj = inst
                    .get_node(data.reference);
                var thisLevel = obj.li_attr.level;
                if (thisLevel == 2) {
                    layer.alert("不允许添加！");
                    return false;
                }
                var newID = inst.create_node(obj, {
                    "type": "text",
                    "text": "新建菜单",
                    "li_attr": {
                        "level": thisLevel + 1,
                        "projectid": projectid
                    }
                });
                inst.open_node(obj);
                // 生成就编辑
                var newObj = inst.get_node(newID);
                //////异步添加
                var name = newObj.text;
                var level = newObj.li_attr.level;
                var projectid = newObj.li_attr.projectid;
                var parentid = newObj.parent;
                ajaxRequest("jsTree/createTreeElement", {
                    "parentid": parentid,
                    "apititle": name,
                    "projectid": projectid,
                    "level": level
                }, function (data) {
                    inst.set_id(newObj, data.data);
                    inst.edit(newObj);
                });
                //////
            }
        },
        "mdelete": {
            "label": "删除菜单",
            "action": function (data) {
                var inst = jQuery.jstree.reference(data.reference), obj = inst
                    .get_node(data.reference);
                if (obj.parent == '#') {
                    layer.alert("不允许删除！");
                    return false;
                }
                // ///
                layer.confirm('删除菜单?', {
                    icon: 3,
                    title: '会删除关联子菜单'
                }, function (index) {
                    // do something
                    /////
                    ajaxRequest("jsTree/deleteTreeElement", {
                        "uid": obj.id
                    }, function (data) {
                        inst.delete_node(obj);
                        layer.close(index);
                    });
                    /////
                });
            }
        },
        "mrename": {
            "label": "重命名",
            "action": function (data) {
                var ref = $('#jstreeID').jstree(true), sel = ref.get_selected(), obj = ref.get_node(sel);
                if (obj.parent == '#') {
                    layer.alert("不允许改名！");
                    return false;
                }
                if (!sel.length) {
                    layer.alert("未选中元素！");
                    return false;
                }
                ref.edit(obj);
            }
        }
    };
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
            var ajaxOpt_getApiTitlesData = {
                paramurl: "apiHandler2/getApiInfo",
                data: {apiID: id,projectid:projectid},
                successHandler: function (data) {
                   $("#treemainContent").empty().append(data);
                }
            };
            newajaxRequest(ajaxOpt_getApiTitlesData);
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