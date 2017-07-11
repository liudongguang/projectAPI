var basePath = $("#basePath").val();
//普通弹出内容框
function openWindow(title,content){
    layer.open({
        type: 1,
        content: content, //这里content是一个普通的String
        title:title
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