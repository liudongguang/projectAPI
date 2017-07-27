var basePath = $("#basePath").val();
//1.普通弹出内容框
function openWindow(title, content) {
    layer.open({
        type: 2,
        content: content, //这里content是一个普通的String
        title: title,
        area: ['500px', '300px']
    });
}

//2.判断是否为json对象
function IsJsonString(str) {
    try {
        JSON.parse(str);
    } catch (e) {
        return false;
    }
    return true;
}
//3.判断登陆
function checkLogin(xhr) {
    var sessionstatus = xhr.getResponseHeader("sessionstatus");
    if (sessionstatus == "timeout") {
        layer.alert("登录超时,请重新登录！", {
            skin: 'layui-layer-error', // 样式类名
            title: '提示',
            closeBtn: 0,
            shadeClose: true
        }, function (index) {
            layer.close(index);
            window.location.href = basePath + "/index.jsp";
        });
    }
}
//4.pajax错误情况处理
function errhandler(xhr) {
    openWindow("出错信息", xhr.responseText);
}
//5.成功处理回调函数
function successHandler(data) {
    if (IsJsonString(data)) {
        openWindow("出现异常，JSON对象信息", data);
        return false;
    }

    return true;
}
//6.初始化ajax请求的元素
function initAjaxRequest(container_ID) {
    $("#" + container_ID).find("[data-pjax]").click(function () {
        var subURL = $(this).attr("href");
        $.pjax({
            url: basePath + subURL,
            container: '#' + container_ID,
            errorCallbackFun: errhandler
        });
    });
}
//7.初始化ajax form表单
function initAjaxForm(form_ID, container_ID, checkParam) {
    $("#" + form_ID).submit(function (event) {
        if (!checkParam) {
            $.pjax.submit(event, '#' + container_ID)
        } else {
            checkParam.successHandler = function (data) {
                if (data.errcode == 1) {
                    layer.alert(data.errmsg);
                } else {
                    $.pjax.submit(event, '#' + container_ID)
                }
            }
            var data = {};
            //要检查的属性
            $(this).find("[checkparam]").each(function () {
                var $checkParam = $(this);
                var pname = $checkParam.attr("name");
                var pvalue = $checkParam.val();
                data[pname] = pvalue;
            })
            checkParam.data = data;
            checkParam.dataType = 'json';
            newajaxRequest(checkParam);
            return false;
        }
    })
}
//8.返回按钮
function initBackUpBT(backBT_ID) {
    $("#" + backBT_ID).click(function () {
        history.back(-1);
    });
}
//9.普通ajax请求
function newajaxRequest(param) {
    var dataType = "html";// from server
    if (param.dataType) {
        dataType = param.dataType;
    }
    var data = null;
    if (param.data) {
        data = param.data;
    }
    ///打开遮罩层
    var zzcid = "";

    function openZZC() {
        if (typeof layer != "undefined") {
            zzcid = layer.load(0, {
                shade: [0.8, '#fff']
                // 0.1透明度的白色背景
            });
        }
    }

    //关闭遮罩层
    function closeZZC() {
        if (typeof layer != "undefined") {
            layer.close(zzcid);
        }
    }

    $.ajax({
        url: basePath + param.paramurl,
        dataType: dataType,
        data: data,
        method: 'post',
        beforeSend: function (XMLHttpRequest) {
            openZZC();
        },
        complete: function (XMLHttpRequest, textStatus) {
            closeZZC();
        },
        success: function (data, textStatus) {
            param.successHandler(data)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            errhandler(XMLHttpRequest);
        }
    });
}
//////10.多行，同名默认选中
function initSetDataForMulti() {
    var vals = $("[setVal]");
    vals.each(function () {
        var jq_this = $(this);
        var value = jq_this.attr("setVal");
        if (value) {
            if (jq_this.is("select")) {
                jq_this.val(value);
            } else if (jq_this.attr("type") == 'radio') {
                var setRadio = $("[name=" + id + "][value=" + value + "]");
                if (setRadio.length != 0) {
                    setRadio.prop('checked', true);
                }
            } else {
                layer.alert('未知类型')
            }
        }
    });
}
///11.pajax访问
function pajaxReq(url, containerSelector, pdata, pushstate) {
    var data = null;
    if (pdata) {
        data = pdata;
    }
    var pushs = true;
    if (!pushstate) {
        pushs = pushstate;
    }
    $.pjax({
        url: url, container: containerSelector, type: "post",
        timeout: 3000,
        data: data,
        push: pushs,
        completeCallbackFun: checkLogin,
        errorCallbackFun: errhandler,
        successCallbackFun: successHandler
    })
}
////12.弹出tips
function layertips(id) {
    var tipsIndex = "";
    $("div[id^=" + id + "]").mouseover(function () {
        var jq_this = $(this);
        tipsIndex = layer.tips(jq_this.text(), "#" + jq_this.attr('id'), {
            tips: [3, '#1E9FFF'],
            time: 0
        });
    }).mouseout(function () {
        layer.close(tipsIndex);
    })
}
///13.初始化分页
function jPageInit() {
    var pageNum = $("#pageNum").val();  //当前页数
    var pageSize = $("#pageSize").val();//一页上的条数
    var total = $("#total").val();//总条数
    var pages = $("#pages").val();//总页数
    var loadDataURL = $("#loadDataURL").val();//获取数据连接
    var searFormID = $("#searFormID").val();//有提交的表单
    var noAjaxPageVal = $("#noAjaxPage").val();
    var containerIDVal = $("#containerID").val();
    $("#pagesDIV").page({count: total, pageNo: pageNum, pageSize: pageSize, skipPart: true});
    //分页按钮点击事件
    $("#pagesDIV > ul > li ").click(function () {
        var num = $(this).attr("num");
        if ($(this).attr("class").indexOf("disabled") != -1) {
            return false;
        }
        if (num == 0 || num == (total + 1)) {

        } else {
            var subURL = loadDataURL + "?pageNum=" + num;
            if (searFormID && $("#" + searFormID).length != 0) {
                var formSerialize = $("#" + searFormID).serialize();
                subURL = subURL + "&" + formSerialize;
            }
            if (noAjaxPageVal == 1) {
                location.href = basePath + subURL;
            } else {
                $.pjax({
                    url: basePath + subURL, container: '#' + containerIDVal, timeout: 3000
                });
            }
        }
    });
    $("#toPageNumID").keyup(function () {
        var val = $(this).val();
        $(this).val(val.replace(/[^\d]/g, ''));
        val = $(this).val();
        if (parseInt(val) > pages) {
            $(this).val(pages);
        }
    });
    /////跳转页面
    $("#pageRealBTID").click(function () {
        var num = $("#toPageNumID").val();
        if (!num) {
            layer.alert("请填写页码！");
            return false;
        }
        var subURL = loadDataURL + "?pageNum=" + num;
        if (searFormID) {
            var formSerialize = $("#" + searFormID).serialize();
            subURL = subURL + "&" + formSerialize;
        }
        if (noAjaxPageVal == 1) {
            location.href = basePath + subURL;
        } else {
            $.pjax({url: basePath + subURL, container: '#' + containerIDVal});
        }
    });
}
//14.占位符
String.prototype.format = function () {
    if (arguments.length == 0) return this;
    for (var s = this, i = 0; i < arguments.length; i++)
        s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
    return s;
};
