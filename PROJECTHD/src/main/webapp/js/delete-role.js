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
    alert_box_msg.textContent = "Delete Role Successfull";
    alert_box.style.display = "inline-block";
}
else if (status == "fail") {
    show_confrim_btn();
    alert_box_msg.textContent = "Delete Role Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/delete-role.html";
}

var role_list = $.ajax({
    async :false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

var list_frame = document.getElementById("role-list");

for (index in role_list)
{
    var row = document.createElement("tr");

    var column1 = document.createElement("td");
    column1.classList.add("mode-font-color");
    column1.classList.add("mode-border-color-1");
    column1.innerHTML = role_list[index].roleID;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.classList.add("mode-font-color");
    column2.classList.add("mode-border-color-1");
    column2.innerHTML = role_list[index].name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.classList.add("mode-font-color");
    column3.classList.add("mode-border-color-1");
    column3.innerHTML = role_list[index].descriptions;
    row.appendChild(column3);

    var btnCol = document.createElement("td");
    btnCol.classList.add("mode-border-color-1");
    var form = document.createElement("form");
    form.method = "post";
    form.action = "/deleteRole";

    var invisible_input = document.createElement("input");
    invisible_input.name = "roleID";
    invisible_input.type = "text";
    invisible_input.value = role_list[index].roleID;
    invisible_input.style.display = "none";

    form.appendChild(invisible_input);

    var button = document.createElement("button");
    button.innerHTML = "Delete";
    button.type = "submit";

    form.appendChild(button);
    btnCol.appendChild(form);
    row.appendChild(btnCol);
    
    list_frame.appendChild(row);
}