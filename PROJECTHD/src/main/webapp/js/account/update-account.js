var alert_success_message = "Update Account Successful";
var alert_fail_message = "Update Account Fail";
var redirect_address = "/useradmin/update-account.html";

var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

function display_list(account_list){
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
        column6.innerHTML = account_list[index].dateJoined;
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
}

function updateAccount(recordID) {
    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

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

var account_list = {};

$.ajax({
    async: true,
    "url": "/getAccountList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        display_list(data.responseJSON);
        hide_loader();
        account_list = data.responseJSON;
    }
});