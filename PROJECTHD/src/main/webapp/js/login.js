var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "fail"){
    var inputs = document.getElementsByTagName("input");

    for (index in inputs){
        inputs.item(index).classList.add("login-fail");
    }

    document.getElementById("login-fail-msg").innerHTML = "Login Fail !";
}

function remove_fail_alert(){
    var inputs = document.getElementsByTagName("input");

    for (index in inputs){
        inputs.item(index).classList.remove("login-fail");
    }

    document.getElementById("login-fail-msg").innerHTML = "";
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

function updateLoginAction () {
    var form = document.getElementById("login-form");
    var roleID = document.getElementById("role-list").value;

    if (roleID == 1){
        form.action = "/loginRestaurantManager";
    }
    else if (roleID == 2){
        form.action = "/loginStaff";
    }
    else if (roleID == 3){
        form.action = "/loginRestaurantOwner";
    }
    else if (roleID == 4){
        form.action = "/loginUserAdmin";
    }
}