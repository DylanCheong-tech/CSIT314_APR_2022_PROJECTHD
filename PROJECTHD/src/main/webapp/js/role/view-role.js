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

function alert_confirm() {
    alert_box.style.display = "none";
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
    button.innerHTML = "View";
    button.onclick = viewRole.bind(event, role_list[index].roleID);

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    list_frame.appendChild(row);
}

function viewRole (roleID){
    var role_json = $.ajax({
        async :false,
        "url": "/getRole?roleID=" + roleID,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (!role_json){
        show_confrim_btn();
        alert_box_msg.textContent = "View Role Fail";
        alert_box.style.display = "inline-block";
        return;
    }

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("roleID").value = role_json.roleID;
    document.getElementById("name").value = role_json.name;
    document.getElementById("desc").value = role_json.descriptions;
}

function backToList (){
    document.getElementById("table").style.display = "table";
    document.getElementById("form").style.display = "none";
}