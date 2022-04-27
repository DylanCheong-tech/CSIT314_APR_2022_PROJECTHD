var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "success"){
    window.alert("Update Account Successfull");

    window.location.href = "/update-account.html";
}
else if (status == "fail"){
    window.alert("Update Account Fail");

    window.location.href = "/update-account.html";
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

var account_list = $.ajax({
    async: false,
    "url": "/getAccountList",
    "type": "get",
    "dataType": "json"
}).responseJSON;


var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

var list_frame = document.getElementById("acc-list");

for (index in account_list) {
    var row = document.createElement("tr");
    row.id = "record-" + (parseInt(index) + 1);

    var column1 = document.createElement("td");
    column1.innerHTML = account_list[index].accountID;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.innerHTML = account_list[index].name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.innerHTML = account_list[index].role.roleID + " - " + account_list[index].role.name;
    row.appendChild(column3);

    var column4 = document.createElement("td");
    column4.innerHTML = account_list[index].username;
    row.appendChild(column4);

    var column5 = document.createElement("td");
    column5.innerHTML = "*".repeat(8);
    row.appendChild(column5);

    var column6 = document.createElement("td");
    column6.innerHTML = account_list[index].dateJoined.split(" ")[0];
    row.appendChild(column6);

    var btnCol = document.createElement("td");
    var button = document.createElement("button");
    button.innerHTML = "Update";
    button.onclick = updateAccount.bind(event, row.id);

    btnCol.appendChild(button);
    row.appendChild(btnCol);


    list_frame.appendChild(row);
}

function updateAccount(recordID) {
    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    // invisible id field (as needed for updated in backed end)
    var column = document.createElement("td");
    var input = document.createElement("input");
    input.name = "accID";
    input.type = "text";
    input.value = childs[0].textContent;

    column.appendChild(input);
    column.style.display = "none";
    row.appendChild(column);

    // name field
    column = document.createElement("td");
    input = document.createElement("input");
    input.name = "name";
    input.type = "text";
    input.value = childs[1].textContent;

    column.appendChild(input);
    childs[1].replaceWith(column);

    // role id (drop down list)
    column = document.createElement("td");
    var select = document.createElement("select");
    select.name = "role";
    for (index in role_list) {
        var option = document.createElement("option");
        option.value = role_list[index].roleID;
        option.innerText = role_list[index].name;
        select.appendChild(option);
    }
    column.appendChild(select);
    childs[2].replaceWith(column);

    // username field
    column = document.createElement("td");
    input = document.createElement("input");
    input.name = "username"
    input.type = "text";
    input.value = childs[3].textContent;

    column.appendChild(input);
    childs[3].replaceWith(column);

    // password field
    column = document.createElement("td");
    input = document.createElement("input");
    input.name = "password";
    input.type = "text";
    // extract out the the real password 
    console.log(account_list)
    for (index in account_list){
        if (account_list[index].accountID == childs[0].textContent){
            input.value = account_list[index].password;
        }
    }
    
    column.appendChild(input);
    childs[4].replaceWith(column);

    var button = document.createElement("button");
    button.type = "submit";
    button.textContent = "Submit";

    childs[6].replaceWith(button);

    var buttonsList = document.querySelectorAll("button");

    for (index in buttonsList) {
        if (buttonsList[index].innerHTML == "Update") {
            buttonsList[index].disabled = true;
        }
    }
}