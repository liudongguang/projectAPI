jQuery(document).ready(function () {
    $(document).pjax('[data-pjax] a, a[data-pjax]', '#mainContainer', {
        type: "post",
        timeout:3000,
        completeCallbackFun: checkLogin,
        errorCallbackFun: errhandler,
        successCallbackFun:successHandler
    });
});