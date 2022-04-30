var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

var hide_btn = document.getElementsByClassName("logout-btn");
for (index in hide_btn) {
    hide_btn.item(index).style.display = "none";
}

if (status == "success"){
    alert_box_msg.textContent = "Create Role Successfull";
    alert_box.style.display = "inline-block";
}
else if (status == "fail"){
    alert_box_msg.textContent = "Create Role Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/create-role.html";
}