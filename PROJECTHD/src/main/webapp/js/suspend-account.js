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
    alert_box_msg.textContent = "Suspend Account Successfull";
    alert_box.style.display = "inline-block";
}
else if (status == "fail") {
    show_confrim_btn();
    alert_box_msg.textContent = "Suspend Account Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/suspend-account.html";
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
    button.innerHTML = "Suspend";
    button.type = "submit";

    form.appendChild(button);
    btnCol.appendChild(form);
    row.appendChild(btnCol);


    list_frame.appendChild(row);
}