var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

var hide_btn = document.getElementsByClassName("logout-btn");
for (index in hide_btn) {
    hide_btn.item(index).style.display = "none";
}

if (status == "success") {
    alert_box_msg.textContent = "Update Role Successfull";
    alert_box.style.display = "inline-block";
}
else if (status == "fail") {
    alert_box_msg.textContent = "Updates Role Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/update-role.html";
}

var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

var list_frame = document.getElementById("role-list");

for (index in role_list) {
    var row = document.createElement("tr");
    row.id = "record-" + (parseInt(index) + 1);

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
    var button = document.createElement("button");
    button.innerHTML = "Update";
    button.type = "button";
    button.onclick = updateRole.bind(event, row.id);

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    list_frame.appendChild(row);
}

function updateRole(recordID) {
    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("roleID").value = childs[0].textContent;

    document.getElementById("name").value = childs[1].textContent;
    document.getElementById("desc").value = childs[2].textContent;
}