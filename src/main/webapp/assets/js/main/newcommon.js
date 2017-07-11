var basePath = $("#basePath").val();
//普通弹出内容框
function openWindow(title, content) {
    layer.open({
        type: 1,
        content: content, //这里content是一个普通的String
        title: title
    });
}

//判断是否为json对象
function IsJsonString(str) {
    try {
        JSON.parse(str);
    } catch (e) {
        return false;
    }
    return true;
}
//判断登陆
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
            window.location.href = $("#basePath").val() + "/index.jsp";
        });
    }
}
//pajax错误情况处理
function errhandler(xhr) {
    openWindow("出错信息", xhr.responseText);
}
//成功处理回调函数
function successHandler(data) {
    if (IsJsonString(data)) {
        openWindow("出现异常，JSON对象信息", data);
        return false;
    }
    return true;
}