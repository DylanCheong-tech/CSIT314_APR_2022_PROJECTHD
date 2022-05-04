var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

function show_confrim_btn() {
    var hide_btn = document.getElementsByClassName("confirm-btn");
    for (index in hide_btn) {
        hide_btn.item(index).style.display = "inline-block";
    }
}

function alert_confirm() {
    alert_box.style.display = "none";
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
        column1.classList.add("mode-font-color");
        column1.classList.add("mode-border-color-1");
        row.appendChild(column1);

        var column2 = document.createElement("td");
        column2.classList.add("mode-font-color");
        column2.classList.add("mode-border-color-1");
        column2.innerHTML = json_list[index].role.roleID + " - " + json_list[index].role.name;
        row.appendChild(column2);

        var column3 = document.createElement("td");
        column3.classList.add("mode-font-color");
        column3.classList.add("mode-border-color-1");
        column3.innerHTML = json_list[index].name;
        row.appendChild(column3);

        var column4 = document.createElement("td");
        column4.classList.add("mode-font-color");
        column4.classList.add("mode-border-color-1");
        column4.innerHTML = json_list[index].username;
        row.appendChild(column4);

        var column5 = document.createElement("td");
        column5.classList.add("mode-font-color");
        column5.classList.add("mode-border-color-1");
        column5.innerHTML = "*".repeat(8);
        row.appendChild(column5);

        var column6 = document.createElement("td");
        column6.classList.add("mode-font-color");
        column6.classList.add("mode-border-color-1");
        column6.innerHTML = json_list[index].dateJoined.split(" ")[0];
        row.appendChild(column6);

        var column7 = document.createElement("td");
        column7.classList.add("mode-font-color");
        column7.classList.add("mode-border-color-1");
        column7.innerHTML = json_list[index].status;
        row.appendChild(column7);

        list_frame.appendChild(row);
    }
}

// display the list of account 
displayAccountList(account_list);

function searchAccount() {
    document.getElementById("back-btn-frame").style.display = "block";

    var accName = document.getElementById("search-bar").value;

    var requested_json = $.ajax({
        async: false,
        "url": "/searchAccount?name=" + accName,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    var list_frame = document.getElementById("acc-list");

    if (!requested_json) {
        show_confrim_btn();
        alert_box_msg.textContent = "Search Account Fail";
        alert_box.style.display = "inline-block";
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
    display_theme(current_theme);
}

function alert_confirm() {
    alert_box.style.display = "none";
}

function back () {
    document.getElementById("back-btn-frame").style.display = "none";
    document.getElementById("search-bar").value = "";

    var list_frame = document.getElementById("acc-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    displayAccountList(account_list);
}