
var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");


function show_confrim_btn() {
    var hide_btn = document.getElementsByClassName("confirm-btn");
    for (index in hide_btn) {
        hide_btn.item(index).style.display = "inline-block";
    }
}

if (status == "success") {
    show_confrim_btn();
    alert_box_msg.textContent = "Create Account Successful";
    alert_box.style.display = "inline-block";
}
else if (status == "fail") {
    show_confrim_btn();
    alert_box_msg.textContent = "Create Account Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/create-account.html";
}

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

document.getElementById("id-input").value = parseInt(account_list[account_list.length - 1].accountID) + 1;