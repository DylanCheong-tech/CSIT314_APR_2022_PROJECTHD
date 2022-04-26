setInterval(() => {
    var currentDate = new Date();
    var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
    var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

    document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);


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
    button.innerHTML = "View";
    button.onclick = viewRole.bind(event, sample_data[index].roleID);

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

    if (!requested_json){
        window.alert("View Role Fail");
        return;
    }

    document.getElementById("search-role-table").style.display = "none";
    document.getElementById("view-role-form").style.display = "block";

    document.getElementById("roleID").value = role_json.roleID;
    document.getElementById("name").value = role_json.name;
    document.getElementById("desc").value = role_json.desc;
}

function backToList (){
    document.getElementById("search-role-table").style.display = "table";
    document.getElementById("view-role-form").style.display = "none";
}