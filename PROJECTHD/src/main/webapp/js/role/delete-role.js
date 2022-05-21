var alert_success_message = "Delete Role Successful";
var alert_fail_message = "Delete Role Fail";
var redirect_address = "/useradmin/delete-role.html";

function display_list(role_list) {

    var list_frame = document.getElementById("role-list");

    for (index in role_list) {
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