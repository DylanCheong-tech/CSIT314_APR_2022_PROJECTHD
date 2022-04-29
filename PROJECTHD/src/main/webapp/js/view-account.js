var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

var hide_btn = document.getElementsByClassName("logout-btn");
for (index in hide_btn) {
    hide_btn.item(index).style.display = "none";
}

function alert_confirm() {
    alert_box.style.display = "none";
}

function displayLogout() {
    window.confirm("Are you sure want to logout ? ");
}

var account_list = $.ajax({
    async: false,
    "url": "/getAccountList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

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
    var button = document.createElement("button");
    button.innerHTML = "View";
    button.onclick = viewAccount.bind(event, account_list[index].accountID);

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    list_frame.appendChild(row);
}

function viewAccount (accountID){
    var acc_json = $.ajax({
        async :false,
        "url": "/getAccount?accID=" + accountID,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (!acc_json){
        alert_box_msg.textContent = "View Account Fail";
        alert_box.style.display = "inline-block";
        return;
    }

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("accID").value = acc_json.accountID;
    document.getElementById("name").value = acc_json.name;
    document.getElementById("role").value = acc_json.role.roleID + " - " + acc_json.role.name;
    document.getElementById("username").value = acc_json.username;
    document.getElementById("password").value = acc_json.password;
    document.getElementById("dateJoined").value = acc_json.dateJoined.split(" ")[0];
    document.getElementById("status").value = acc_json.status;
}

function backToList (){
    document.getElementById("table").style.display = "table";
    document.getElementById("form").style.display = "none";
}

var mode_font_color = document.getElementsByClassName("mode-font-color");
var mode_bg_color_2 = document.getElementsByClassName("mode-bg-color-2");
var mode_border_color_1 = document.getElementsByClassName("mode-border-color-1");
var mode_border_color_2 = document.getElementsByClassName("mode-border-color-2");
var mode_border_color_3 = document.getElementsByClassName("mode-border-color-3");
var mode_row_hover_color = document.querySelectorAll("body table tbody tr");

var currentDate = new Date();
var hours = currentDate.getHours();
// var hours = 20;

var day_theme = {font_color : "#000000", bg_color_1 : "#FFFFFF" , bg_color_2 : "#FFD100", border_1 : "2px #000000 solid", border_2 : "2px #FFFFFF solid", hover : "#FFD100", origin : "Light"};
var night_theme = {font_color : "#FFFFFF", bg_color_1 : "#000000" , bg_color_2 : "#000000", border_1 : "2px #FFD100 solid", border_2 : "2px #FFD100 solid", hover : "darkslategrey", origin : "Dark"};

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

    mode_row_hover_color.forEach((item) => {
        item.addEventListener("mouseenter", (event) => {
            event.target.style.backgroundColor = theme.hover;
        });

        item.addEventListener("mouseleave", (event) => {
            event.target.style.backgroundColor = "transparent";
        });
    });
}

if (hours < 19){
    display_theme(day_theme);
}
else{
    display_theme(night_theme);
}