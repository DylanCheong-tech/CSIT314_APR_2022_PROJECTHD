var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

if (status == "fail"){
    alert_box_msg.textContent = "Login Fail";
    alert_box.style.display = "inline-block";
}

var role_list = $.ajax({
    async :false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

var select = document.getElementById("role-list");
for (index in role_list) {
    var option = document.createElement("option");
    option.value = role_list[index].roleID;
    option.innerText = role_list[index].name;
    select.appendChild(option);
}

function alert_confirm (){
    alert_box.style.display = "none";
    window.location.href = "/login.html";
}

setInterval(() => {
    var bg_img_frame = document.getElementById("image-frame");
    var current_left_pos = bg_img_frame.style.left ? bg_img_frame.style.left : "-1%";
    current_left_pos = parseInt(current_left_pos.substring(0, current_left_pos.length - 1));

    if (current_left_pos > -250){
        current_left_pos -= 104;
        bg_img_frame.style.left = current_left_pos + "%";
    }
    else{
        current_left_pos = -1;
        bg_img_frame.style.left = current_left_pos + "%";
    }
    
}, 4000);