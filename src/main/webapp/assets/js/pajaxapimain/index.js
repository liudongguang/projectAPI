jQuery(document).ready(function () {
    var containerSelector = '#mainContainer';
    if ($.support.pjax) {
        $(document).on('click', '[data-pjax]', function(event) {
            var url=$(this).attr("href");
            if($(this).attr("delmark")==""){
                layer.confirm('确认要删除吗?', {icon: 3, title:'请谨慎操作'}, function(index){
                    pajaxReq(url,containerSelector);
                    layer.close(index);
                });
            }else{
                pajaxReq(url,containerSelector);
            }
            return false;
        });
    }else{
        layer.alert("不支持pajax！");
    }
});
