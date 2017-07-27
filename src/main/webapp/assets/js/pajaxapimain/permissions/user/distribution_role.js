jQuery(document).ready(function () {
    initBackUpBT("backBTID");
    initAjaxForm("subform", "mainContainer");
    var $permissionsContainer = $("#permissionsContainerID");
     newajaxRequest({
        paramurl: 'permission_shiro/getRoleList',
        dataType: 'json',
        pushstate:false,
        successHandler: function (data) {
            var i=1;
            for(var index in data){
                var obj=data[index];
                var rolename=obj.rolename;
                var uid=obj.uid;
                var addHTML = ' <div class="checkbox checkbox-primary checkbox-inline"><input type="checkbox" name="permissionIDS"  value="{0}" id="inlineCheckbox{0}">   <label for="inlineCheckbox{0}">{1}</label></div>';
                addHTML=addHTML.format(uid,rolename);
                $permissionsContainer.append(addHTML);
                if (i % 5 == 0) {
                    $permissionsContainer.append("<br/>");
                }
                i++;
            }
        }
    });
});