var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "success"){
    window.alert("Suspend Account Successfull");

    window.location.href = "/suspend-account.html";
}
else if (status == "fail"){
    window.alert("Suspend Account Fail");

    window.location.href = "/suspend-account.html";
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

let sample_data = [
    { id: 1, name: "json", username: "username", password: "password", roleID: "1 - Staff", dateJoined: "10/10/2022" },
    { id: 2, name: "json", username: "username", password: "password", roleID: "1 - Staff", dateJoined: "10/10/2022" },
    { id: 3, name: "json", username: "username", password: "password", roleID: "1 - Staff", dateJoined: "10/10/2022" },
    { id: 4, name: "json", username: "username", password: "password", roleID: "1 - Staff", dateJoined: "10/10/2022" },
    { id: 5, name: "json", username: "username", password: "password", roleID: "1 - Staff", dateJoined: "10/10/2022" },
]

let role_list = ["1 - Restaurant Manager", "2 - Staff", "3 - Restaurant Owner"];

var list_frame = document.getElementById("acc-list");

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
    column3.innerHTML = sample_data[index].username;
    row.appendChild(column3);

    var column4 = document.createElement("td");
    column4.innerHTML = sample_data[index].roleID;
    row.appendChild(column4);

    var column5 = document.createElement("td");
    column5.innerHTML = "*".repeat(sample_data[index].password.length);
    row.appendChild(column5);

    var column6 = document.createElement("td");
    column6.innerHTML = sample_data[index].dateJoined;
    row.appendChild(column6);

    var btnCol = document.createElement("td");

    var form = document.createElement("form");
    form.method = "post";
    form.action = "/suspendAccount";

    var invisible_input = document.createElement("input");
    invisible_input.name = "accID";
    invisible_input.type = "text";
    invisible_input.value = sample_data[index].id;
    invisible_input.style.display = "none";

    form.appendChild(invisible_input);

    var button = document.createElement("button");
    button.innerHTML = "Suspend";
    button.type = "submit";

    form.appendChild(button);
    btnCol.appendChild(form);
    row.appendChild(btnCol);


    list_frame.appendChild(row);
}