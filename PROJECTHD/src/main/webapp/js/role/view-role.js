var redirect_address = "/useradmin/view-role.html";

function display_list(role_list) {
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
}

function viewRole(roleID) {
    var role_json = $.ajax({
        async: false,
        "url": "/getRole?roleID=" + roleID,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (!role_json) {
        show_confrim_btn();
        alert_box_msg.textContent = "View Role Fail";
        alert_box.style.display = "inline-block";
        return;
    }

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

    document.getElementById("roleID").value = role_json.roleID;
    document.getElementById("name").value = role_json.name;
    document.getElementById("desc").value = role_json.descriptions;
}

function backToList() {
    document.getElementById("table").style.display = "table";
    document.getElementById("form").style.display = "none";

    document.getElementById("search-frame").style.display = "inline-block";
    document.getElementById("sort-frame").style.display = "inline-block";
}

$.ajax({
    async: true,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        display_list(data.responseJSON);
        hide_loader();
    }
});