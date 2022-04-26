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
    {id : 2, name: "json", desc : "abc"},
    {id : 3, name: "json", desc : "abc"},
    {id : 4, name: "json", desc : "abc"},
    {id : 5, name: "json", desc : "abc"}
]

var list_frame = document.getElementById("role-list");

for (index in sample_data)
{
    var row = document.createElement("tr");
    var form = document.createElement("form");
    form.id = "form" + (index+1);

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
    button.innerHTML = "Delete";
    button.onclick = deleteRole.bind(event, sample_data[index].id);

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    row.appendChild(form);
    
    list_frame.appendChild(row);
}

function deleteRole (roleID){
    window.alert("Deleting Role " + roleID);
}