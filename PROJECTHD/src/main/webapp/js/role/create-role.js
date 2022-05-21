var alert_success_message = "Create Role Successful";
var alert_fail_message = "Create Role Fail";
var redirect_address = "/useradmin/create-role.html";

var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
  }).responseJSON;

document.getElementById("id-input").value = parseInt(role_list.length != 0 ? role_list[role_list.length - 1].roleID : 0) + 1;