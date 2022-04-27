var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "success"){
    window.alert("Update Role Successfull");

    window.location.href = "/update-role.html";
}
else if (status == "fail"){
    window.alert("Update Role Fail");

    window.location.href = "/update-role.html";
}

setInterval(() => {
    var currentDate = new Date();
    var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
    var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

    document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);

function redirectToPortal() {
    window.location.href = "./user-admin-portal.html";
}

function displayLogout() {
    window.confirm("Are you sure want to logout ? ");
}

let sample_data = [
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"}
]

var list_frame = document.getElementById("role-list");

for (index in sample_data) {
    var row = document.createElement("tr");
    row.id = "record-" + (parseInt(index) + 1);

    var column1 = document.createElement("td");
    column1.innerHTML = sample_data[index].id;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.innerHTML = sample_data[index].name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.innerHTML = sample_data[index].desc;
    row.appendChild(column3);

    var btnCol = document.createElement("td");
    var button = document.createElement("button");
    button.innerHTML = "Update";
    button.onclick = updateRole.bind(event, row.id);

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    list_frame.appendChild(row);
}

function updateRole(recordID) {
    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    // invisible id field (as needed for updated in backed end)
    var column = document.createElement("td");
    var input = document.createElement("input");
    input.name = "roleID";
    input.type = "text";
    input.value = childs[0].textContent;

    column.appendChild(input);
    column.style.display = "none";
    row.appendChild(column);

    // name field
    var column = document.createElement("td");
    var input = document.createElement("input");
    input.name = "name";
    input.type = "text";
    input.value = childs[1].textContent;

    column.appendChild(input);
    childs[1].replaceWith(column);

    // desc field
    column = document.createElement("td");
    input = document.createElement("input");
    input.name = "desc";
    input.type = "text";
    input.value = childs[2].textContent;

    column.appendChild(input);
    childs[2].replaceWith(column);

    var button = document.createElement("button");
    button.type = "submit";
    button.textContent = "Submit";
    
    childs[3].replaceWith(button);

    var buttonsList = document.querySelectorAll("button");

    for (index in buttonsList)  {
        if (buttonsList[index].innerHTML == "Update")  {
            buttonsList[index].disabled = true;
        }
    }
}