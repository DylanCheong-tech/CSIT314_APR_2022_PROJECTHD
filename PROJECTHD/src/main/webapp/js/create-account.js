
var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

var hide_btn = document.getElementsByClassName("logout-btn");
for (index in hide_btn) {
    hide_btn.item(index).style.display = "none";
}

if (status == "success"){
    alert_box_msg.textContent = "Create Account Successfull";
    alert_box.style.display = "inline-block";
}
else if (status == "fail"){
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
    option.innerText = role_list[index].name;
    select.appendChild(option);
}

var mode_font_color = document.getElementsByClassName("mode-font-color");
var mode_bg_color_2 = document.getElementsByClassName("mode-bg-color-2");
var mode_border_color_1 = document.getElementsByClassName("mode-border-color-1");
var mode_border_color_2 = document.getElementsByClassName("mode-border-color-2");
var mode_border_color_3 = document.getElementsByClassName("mode-border-color-3");

var currentDate = new Date();
var hours = currentDate.getHours();
// var hours = 20;

var day_theme = {font_color : "#000000", bg_color_1 : "#FFFFFF" , bg_color_2 : "#FFD100", border_1 : "2px #000000 solid", border_2 : "2px #FFFFFF solid", origin : "Light"};
var night_theme = {font_color : "#FFFFFF", bg_color_1 : "#000000" , bg_color_2 : "#000000", border_1 : "2px #FFD100 solid", border_2 : "2px #FFD100 solid", origin : "Dark"};

function display_theme (theme) {
    for (index in mode_font_color){
        mode_font_color.item(index).style.color = theme.font_color;
    }
    
    document.getElementsByTagName("body")[0].style.backgroundColor = theme.bg_color_1;    
    
    for (index in mode_bg_color_2){
        mode_bg_color_2.item(index).style.backgroundColor = theme.bg_color_2;
    }
    
    for (index in mode_border_color_1){
        mode_border_color_1.item(index).style.border = theme.border_1;
    }

    for (index in mode_border_color_2){
        mode_border_color_2.item(index).style.borderBottom = theme.border_2;
        mode_border_color_2.item(index).style.borderTop = theme.border_2;
    }

    for (index in mode_border_color_3){
        mode_border_color_3.item(index).style.borderBottom = theme.border_1;
    }
}

if (hours < 19){
    display_theme(day_theme);
}
else{
    display_theme(night_theme);
}