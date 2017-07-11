jQuery(document).ready(function () {
    $(document).pjax('[data-pjax] a, a[data-pjax]', '#mainContent', {type: "post"})
});