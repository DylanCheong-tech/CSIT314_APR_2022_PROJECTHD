var alert_success_message = "Update Role Successful";
var alert_fail_message = "Update Role Fail";
var redirect_address = "/useradmin/update-role.html";

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
        button.innerHTML = "Update";
        button.type = "button";
        button.onclick = updateRole.bind(event, row.id);

        btnCol.appendChild(button);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
}

function updateRole(recordID) {
    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

    document.getElementById("roleID").value = childs[0].textContent;
    document.getElementById("name").value = childs[1].textContent;
    document.getElementById("desc").value = childs[2].textContent;
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