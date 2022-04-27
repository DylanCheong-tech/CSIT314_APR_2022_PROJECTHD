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

function displayAccountList(json_list) {
    var list_frame = document.getElementById("acc-list");

    for (index in json_list) {
        var row = document.createElement("tr");
        row.id = "record-" + (parseInt(index) + 1);

        var column1 = document.createElement("td");
        column1.innerHTML = json_list[index].accountID;
        row.appendChild(column1);

        var column2 = document.createElement("td");
        column2.innerHTML = json_list[index].name;
        row.appendChild(column2);

        var column3 = document.createElement("td");
        column3.innerHTML = json_list[index].username;
        row.appendChild(column3);

        var column4 = document.createElement("td");
        column4.innerHTML = json_list[index].role.roleID + " - " + json_list[index].role.name;
        row.appendChild(column4);

        var column5 = document.createElement("td");
        column5.innerHTML = "*".repeat(8);
        row.appendChild(column5);

        var column6 = document.createElement("td");
        column6.innerHTML = json_list[index].dateJoined.split(" ")[0];
        row.appendChild(column6);

        list_frame.appendChild(row);
    }
}

function searchAccount() {
    var accName = document.getElementById("search-bar").value;

    var requested_json = $.ajax({
        async :false,
        "url": "/searchAccount?name=" + accName,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    var list_frame = document.getElementById("acc-list");

    if (!requested_json){
        window.alert("Search Account Fail");
        return;
    }

    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    let result_list = [requested_json];

    displayAccountList(result_list);
}

// display the list of account 
displayAccountList(account_list);
