jQuery(document).ready(function () {
    Waves.init(); //激活点击按钮效果// <a class="btn float-buttons waves-effect waves-button waves-float">Button A</a>
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
    //加载进度条
    $(document).on('pjax:start', function() { NProgress.start(); });
    $(document).on('pjax:end',   function() { NProgress.done();  });
});
