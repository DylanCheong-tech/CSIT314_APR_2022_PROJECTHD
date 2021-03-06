var alert_success_message = "Suspend Account Successful";
var alert_fail_message = "Suspend Account Fail";
var redirect_address = "/useradmin/suspend-account.html";

function display_list(account_list) {
    var list_frame = document.getElementById("acc-list");

    for (index in account_list) {
        var row = document.createElement("tr");
        row.id = "record-" + (parseInt(index) + 1);

        var column1 = document.createElement("td");
        column1.classList.add("mode-font-color");
        column1.classList.add("mode-border-color-1");
        column1.innerHTML = account_list[index].accountID;
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

        var form = document.createElement("form");
        form.method = "post";
        form.action = "/suspendAccount";

        var invisible_input = document.createElement("input");
        invisible_input.name = "accountID";
        invisible_input.type = "text";
        invisible_input.value = account_list[index].accountID;
        invisible_input.style.display = "none";

        form.appendChild(invisible_input);

        var button = document.createElement("button");
        button.innerHTML = "Suspend";
        button.type = "submit";
        if (account_list[index].status == "Suspended") button.disabled = true;

        form.appendChild(button);
        btnCol.appendChild(form);
        row.appendChild(btnCol);


        list_frame.appendChild(row);
    }
}

$.ajax({
    async: true,
    "url": "/getAccountList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        display_list(data.responseJSON);
        hide_loader();
    }
});