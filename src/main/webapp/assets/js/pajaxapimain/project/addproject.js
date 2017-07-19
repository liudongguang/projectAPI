jQuery(document).ready(function () {
    initBackUpBT("backBTID");
    initAjaxForm("subform", "mainContainer",{paramurl:'apiHandler/checkProjectName'});
});