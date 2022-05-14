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

if (status == "success"){
    show_confrim_btn();
    alert_box_msg.textContent = "Create Role Successful";
    alert_box.style.display = "inline-block";
}
else if (status == "fail"){
    show_confrim_btn();
    alert_box_msg.textContent = "Create Role Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/useradmin/create-role.html";
}

var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
  }).responseJSON;

document.getElementById("id-input").value = parseInt(role_list.length != 0 ? role_list[role_list.length - 1].roleID : 0) + 1;