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
    { accountID: 1, name: "json", username: "username", password: "password", role : {roleID: "1 - Staff"}, dateJoined: "10/10/2022 1" },
    { accountID: 1, name: "json", username: "username", password: "password", role : {roleID: "1 - Staff"}, dateJoined: "10/10/2022 1" },
    { accountID: 1, name: "json", username: "username", password: "password", role : {roleID: "1 - Staff"}, dateJoined: "10/10/2022 1" },
    { accountID: 1, name: "json", username: "username", password: "password", role : {roleID: "1 - Staff"}, dateJoined: "10/10/2022 1" },
    { accountID: 1, name: "json", username: "username", password: "password", role : {roleID: "1 - Staff"}, dateJoined: "10/10/2022 1" }
]

let role_list = ["1 - Restaurant Manager", "2 - Staff", "3 - Restaurant Owner"];

var list_frame = document.getElementById("acc-list");

for (index in sample_data) {
    var row = document.createElement("tr");
    row.id = "record-" + (parseInt(index) + 1);

    var column1 = document.createElement("td");
    column1.innerHTML = sample_data[index].accountID;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.innerHTML = sample_data[index].name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.innerHTML = sample_data[index].username;
    row.appendChild(column3);

    var column4 = document.createElement("td");
    column4.innerHTML = sample_data[index].role.roleID;
    row.appendChild(column4);

    var column5 = document.createElement("td");
    column5.innerHTML = "*".repeat(sample_data[index].password.length);
    row.appendChild(column5);

    var column6 = document.createElement("td");
    column6.innerHTML = sample_data[index].dateJoined;
    row.appendChild(column6);

    var btnCol = document.createElement("td");
    var button = document.createElement("button");
    button.innerHTML = "View";
    button.onclick = viewAccount.bind(event, sample_data[index].accountID);

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    list_frame.appendChild(row);
}

function viewAccount (accountID){
    var acc_json = $.ajax({
        async :false,
        "url": "/getAccount?accID=" + accountID,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (!requested_json){
        window.alert("View Account Fail");
        return;
    }

    document.getElementById("search-acc-table").style.display = "none";
    document.getElementById("view-account-form").style.display = "block";

    document.getElementById("accID").value = acc_json.accountID;
    document.getElementById("name").value = acc_json.name;
    document.getElementById("role").value = acc_json.role.roleID + " - " + acc_json.role.name;
    document.getElementById("username").value = acc_json.username;
    document.getElementById("password").value = acc_json.password;
    document.getElementById("dateJoined").value = acc_json.dateJoined.split(" ")[0];
}

function backToList (){
    document.getElementById("search-acc-table").style.display = "table";
    document.getElementById("view-account-form").style.display = "none";
}