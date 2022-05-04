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

if (status == "success") {
    show_confrim_btn();
    alert_box_msg.textContent = "Update Account Successful";
    alert_box.style.display = "inline-block";
}
else if (status == "fail") {
    show_confrim_btn();
    alert_box_msg.textContent = "Updates Account Fail";
    alert_box.style.display = "inline-block";
}

function alert_confirm() {
    alert_box.style.display = "none";
    window.location.href = "/update-account.html";
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
    column1.classList.add("mode-font-color");
    column1.classList.add("mode-border-color-1");
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.classList.add("mode-font-color");
    column2.classList.add("mode-border-color-1");
    column2.innerHTML = account_list[index].role.roleID + " - " + account_list[index].role.name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.classList.add("mode-font-color");
    column3.classList.add("mode-border-color-1");
    column3.innerHTML = account_list[index].name;
    row.appendChild(column3);

    var column4 = document.createElement("td");
    column4.classList.add("mode-font-color");
    column4.classList.add("mode-border-color-1");
    column4.innerHTML = account_list[index].username;
    row.appendChild(column4);

    var column5 = document.createElement("td");
    column5.classList.add("mode-font-color");
    column5.classList.add("mode-border-color-1");
    column5.innerHTML = "*".repeat(8);
    row.appendChild(column5);

    var column6 = document.createElement("td");
    column6.classList.add("mode-font-color");
    column6.classList.add("mode-border-color-1");
    column6.innerHTML = account_list[index].dateJoined.split(" ")[0];
    row.appendChild(column6);

    var column7 = document.createElement("td");
    column7.classList.add("mode-font-color");
    column7.classList.add("mode-border-color-1");
    column7.innerHTML = account_list[index].status;
    row.appendChild(column7);

    var btnCol = document.createElement("td");
    btnCol.classList.add("mode-border-color-1");
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

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("accID").value = childs[0].textContent;

    var select = document.getElementById("role-list");
    for (index in role_list) {
        var option = document.createElement("option");
        option.value = role_list[index].roleID;
        option.innerText = role_list[index].roleID + " - " + role_list[index].name;
        if (option.textContent == childs[1].textContent){
            option.selected = true;
        }
        select.appendChild(option);
    }

    document.getElementById("name").value = childs[2].textContent;
    document.getElementById("username").value = childs[3].textContent;
    // extract out the the real password 
    for (index in account_list) {
        if (account_list[index].accountID == childs[0].textContent) {
            document.getElementById("password").value = account_list[index].password;;
        }
    }

    document.getElementById("dateJoined").value = childs[5].textContent;
    document.getElementById("status").value = childs[6].textContent;
}