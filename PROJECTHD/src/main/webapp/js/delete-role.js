var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "success"){
    window.alert("Delete Role Successfull");

    window.location.href = "/delete-role.html";
}
else if (status == "fail"){
    window.alert("Delete Role Fail");

    window.location.href = "/delete-role.html";
}

setInterval(() => {
    var currentDate = new Date();
    var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
    var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

    document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);


function displayLogout() {
    window.confirm("Are you sure want to logout ? ");
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
    column1.innerHTML = role_list[index].roleID;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.innerHTML = role_list[index].name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.innerHTML = role_list[index].descriptions;
    row.appendChild(column3);

    var btnCol = document.createElement("td");

    var form = document.createElement("form");
    form.method = "post";
    form.action = "/deleteRole";

    var invisible_input = document.createElement("input");
    invisible_input.name = "roleID";
    invisible_input.type = "text";
    invisible_input.value = role_list[index].id;
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