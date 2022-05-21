
var alert_success_message = "Create Account Successful";
var alert_fail_message = "Create Account Fail";
var redirect_address = "/useradmin/create-account.html";

var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

var select = document.getElementById("role-list");
for (index in role_list) {
    var option = document.createElement("option");
    option.value = role_list[index].roleID;
    option.innerText = role_list[index].roleID + " - " + role_list[index].name;
    select.appendChild(option);
}

var account_list = $.ajax({
    async: false,
    "url": "/getAccountList",
    "type": "get",
    "dataType": "json"
}).responseJSON;
console.log(account_list);

document.getElementById("id-input").value = parseInt(account_list.length != 0 ? account_list[account_list.length - 1].accountID : 0) + 1;