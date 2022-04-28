var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

if (status == "success"){
    alert_box_msg.textContent = "Suspend Account Successfull";
    alert_box.style.display = "inline-block";
}
else if (status == "fail"){
    alert_box_msg.textContent = "Suspend Account Fail";
    alert_box.style.display = "inline-block";
}

setInterval(() => {
    var currentDate = new Date();

    var month_str;

    switch (currentDate.getMonth() + 1) {
        case 1:
            month_str = "January";
            break;
        case 2:
            month_str = "February";
            break;
        case 3:
            month_str = "March";
            break;
        case 4:
            month_str = "April";
            break;
        case 5:
            month_str = "May";
            break;
        case 6:
            month_str = "June";
            break;
        case 7:
            month_str = "July";
            break;
        case 8:
            month_str = "August";
            break;
        case 9:
            month_str = "September";
            break;
        case 10:
            month_str = "October";
            break;
        case 11:
            month_str = "November";
            break;
        case 12:
            month_str = "December";
            break;
        default:
            break;
    }

    var hour = currentDate.getHours() + "";
    hour = hour.length < 2 ? "0" + hour : hour;

    var minutes = currentDate.getMinutes() + "";
    minutes = minutes.length < 2 ? "0" + minutes : minutes;

    var second = currentDate.getSeconds() + "";
    second = second.length < 2 ? "0" + second : second;

    var date = currentDate.getDate() + " "  + month_str + " " + currentDate.getFullYear();
    var time = hour + " : " + minutes + " : " + second;

    document.getElementById("header-date-time").innerHTML = date + "<br />" + time;
}, 1000);


function displayLogout() {
    window.confirm("Are you sure want to logout ? ");
}

var account_list = $.ajax({
    async: false,
    "url": "/getAccountList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

console.log(account_list);

let role_list = ["1 - Restaurant Manager", "2 - Staff", "3 - Restaurant Owner"];

var list_frame = document.getElementById("acc-list");

for (index in account_list) {
    var row = document.createElement("tr");
    row.id = "record-" + (parseInt(index) + 1);

    var column1 = document.createElement("td");
    column1.classList.add("mode-font-color");
    column1.classList.add("mode-border-color-1");
    column1.innerHTML = account_list[index].accountID;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.classList.add("mode-font-color");
    column2.classList.add("mode-border-color-1");
    column2.innerHTML = account_list[index].role.roleID + " - " + account_list[index].role.name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.classList.add("mode-font-color");
    column3.classList.add("mode-border-color-1");
    column3.innerHTML = account_list[index].name;
    row.appendChild(column3);

    var column4 = document.createElement("td");
    column4.classList.add("mode-font-color");
    column4.classList.add("mode-border-color-1");
    column4.innerHTML = account_list[index].username;
    row.appendChild(column4);

    var column5 = document.createElement("td");
    column5.classList.add("mode-font-color");
    column5.classList.add("mode-border-color-1");
    column5.innerHTML = "*".repeat(8);
    row.appendChild(column5);

    var column6 = document.createElement("td");
    column6.classList.add("mode-font-color");
    column6.classList.add("mode-border-color-1");
    column6.innerHTML = account_list[index].dateJoined.split(" ")[0];
    row.appendChild(column6);

    var column7 = document.createElement("td");
    column7.classList.add("mode-font-color");
    column7.classList.add("mode-border-color-1");
    column7.innerHTML = account_list[index].status;
    row.appendChild(column7);

    var btnCol = document.createElement("td");
    btnCol.classList.add("mode-border-color-1");

    var form = document.createElement("form");
    form.method = "post";
    form.action = "/suspendAccount";

    var invisible_input = document.createElement("input");
    invisible_input.name = "accID";
    invisible_input.type = "text";
    invisible_input.value = account_list[index].accountID;
    invisible_input.style.display = "none";

    form.appendChild(invisible_input);

    var button = document.createElement("button");
    button.classList.add("mode-font-color");
    button.innerHTML = "Suspend";
    button.type = "submit";

    form.appendChild(button);
    btnCol.appendChild(form);
    row.appendChild(btnCol);


    list_frame.appendChild(row);
}

var mode_font_color = document.getElementsByClassName("mode-font-color");
var mode_bg_color_2 = document.getElementsByClassName("mode-bg-color-2");
var mode_border_color_1 = document.getElementsByClassName("mode-border-color-1");
var mode_border_color_2 = document.getElementsByClassName("mode-border-color-2");

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
}

if (hours < 19){
    display_theme(day_theme);
}
else{
    display_theme(night_theme);
}

function alert_confirm (){
    alert_box.style.display = "none";
    window.location.href = "/suspend-account.html";
}