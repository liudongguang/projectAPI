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
        paramurl: basePath + 'apiHandler/getApiTitlesData',
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
            $("#saveBT").show();//保存按钮显示
            $("#saveBT").unbind("click").click(function () {
                var ii2 = layer.load(0, {
                    shade: [0.8, '#fff']
                    // 0.1透明度的白色背景
                });
                var sdata = $('#jstreeID').jstree(true).get_json();
                var ajaxOpt = {
                    paramurl: basePath + 'jsTree/saveApiTitleData',
                    paramdata: JSON.stringify(sdata),
                    rquestType:'json',
                    dataType: 'json',
                    callbackFun: function (data) {
                        layer.close(ii2);
                        if (data.errcode == 0) {
                            layer.msg("保存成功！");
                            //location.href = basePath + "/apimain/projectapi/disApiList.jsp?uid="+projectid;
                            init(projectid);
                        } else {
                            layer.msg("保存失败！");
                        }
                    }
                };
                ajaxRun(ajaxOpt);
            });
        }
    };
    $("#saveBT").hide();//保存按钮隐藏
    ajaxRun(ajaxOpt_getApiTitlesData);
}
function initdata(data) {
    var projectid = $("#projectID").val();
    $.jstree.defaults.core.themes.variant = "large";
    $.jstree.defaults.contextmenu.items = {
        "mcreate": {
            "label": "新建菜单",
            "action": function (data) {
                var inst = jQuery.jstree.reference(data.reference), obj = inst
                    .get_node(data.reference);
                var thisLevel=obj.li_attr.level;
                if (thisLevel == 2) {
                    layer.alert("不允许添加！");
                    return false;
                }
                var newID = inst.create_node(obj, {
                    "type": "text",
                    "text": "新建菜单",
                    "li_attr": {
                        "level": thisLevel + 1,
                        "projectid":projectid
                    }
                });
                inst.open_node(obj);
                // 生成就编辑
                var newObj = inst.get_node(newID);
                //////异步修改

                //////
                inst.set_id (newObj, '3333');
                inst.edit(newObj);
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
                    inst.delete_node(obj);
                    layer.close(index);
                });
            }
        },
        "mrename": {
            "label": "重命名",
            "action": function (data) {
                var ref = $('#jstreeID').jstree(true), sel = ref.get_selected(),obj = ref.get_node(sel);
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
    var jq_tree=$('#jstreeID').jstree({
        "core": {
            "check_callback": true
           // 'data': data
        },
        "plugins": ["contextmenu"]
    });
    $('#jstreeID').jstree(true).settings.core.data=data;//放入数据
    $('#jstreeID').jstree(true).refresh();//刷新数据
    $('#jstreeID').on("select_node.jstree", function (event, node) {
        var rnode = node.node;
        var id = rnode.id;
        var name = rnode.text;
        var level = rnode.li_attr.level;
        var projectid = rnode.li_attr.projectid;
        console.log("id:"+id+"     name:"+name+"   level:"+level+"    "+"      projectid:"+projectid);

    })
    ////////修改了名称后触发
    $('#jstreeID').on("rename_node.jstree", function (event, node) {
        var rnode = node.node;
        var id = rnode.id;
        var name = rnode.text;
        var level = rnode.li_attr.level;
        var projectid = rnode.li_attr.projectid;
        var firstIndexVal=id.indexOf('j');
        if(firstIndexVal==-1){//不是开头的可以跟数据库进行交互
            console.log("rename_node db................")
        }
        console.log("rename_node id:"+id)
    })
    //删除触发
    $('#jstreeID').on("delete_node.jstree", function (event, node) {
        var rnode = node.node;
        var id = rnode.id;
        var name = rnode.text;
        var level = rnode.li_attr.level;
        var projectid = rnode.li_attr.projectid;
        var firstIndexVal=id.indexOf('j');
        if(firstIndexVal==-1){//不是开头的可以跟数据库进行交互
             console.log("delete_node db................")
        }
        console.log("delete_node")
    })
}
function initFirstBT() {
    var jq_div = $("#jstreeID");
    var createbutton = $("<button class='btn btn-primary'>初始化</button>");
    createbutton.click(function () {
        var projectid = $("#projectID").val();
        if (!projectid) {
            layer.alert("没有选择项目！");
            return false;
        }
        var ajaxOpt = {
            paramurl: basePath + 'apiHandler/initApiTitleData',
            paramdata: {projectid: projectid},
            dataType: 'json',
            callbackFun: function (data) {
                location.href = basePath + "/apimain/projectapi/disApiList.jsp?uid="+projectid;
            }
        };
        ajaxRun(ajaxOpt);
    });
    jq_div.append(createbutton);
}