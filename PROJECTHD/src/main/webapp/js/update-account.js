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

    // name field
    var column = document.createElement("td");
    var input = document.createElement("input");
    input.type = "text";
    input.value = childs[1].textContent;

    column.appendChild(input);
    childs[1].replaceWith(column);

    // username field
    column = document.createElement("td");
    input = document.createElement("input");
    input.type = "text";
    input.value = childs[2].textContent;

    column.appendChild(input);
    childs[2].replaceWith(column);

    // password field
    column = document.createElement("td");
    input = document.createElement("input");
    input.type = "text";
    input.value = childs[4].textContent;

    column.appendChild(input);
    childs[4].replaceWith(column);

    // role id (drop down list)
    column = document.createElement("td");
    var select = document.createElement("select");
    for (index in role_list) {
        var option = document.createElement("option");
        option.value = role_list[index];
        option.innerText = role_list[index];
        select.appendChild(option);
    }
    column.appendChild(select);
    childs[3].replaceWith(column);

    var button = document.createElement("button");
    button.type = "submit";
    button.textContent = "Submit";
    
    childs[6].replaceWith(button);

    var buttonsList = document.querySelectorAll("button");

    for (index in buttonsList)
    {
        if (buttonsList[index].innerHTML == "Update")
        {
            buttonsList[index].disabled = true;
        }
    }
}
