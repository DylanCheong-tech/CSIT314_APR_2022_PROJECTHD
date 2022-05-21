function sort(select_id) {
    var sort_criteria = document.getElementById(select_id).value;

    var account_list = $.ajax({
        async: false,
        "url": "/getAccountList",
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    console.log(account_list)

    if (sort_criteria == "id") {
        account_list.sort((a, b) => {
            if (a.accountID < b.accountID) {
                return -1;
            }
            else if (a.accountID > b.accountID) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    if (sort_criteria == "roleID") {
        account_list.sort((a, b) => {
            if (a.role.roleID < b.role.roleID) {
                return -1;
            }
            else if (a.role.roleID > b.role.roleID) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "name") {
        account_list.sort((a, b) => {
            if (a.name.toLowerCase() < b.name.toLowerCase()) {
                return -1;
            }
            else if (a.name.toLowerCase() > b.name.toLowerCase()) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "username") {
        account_list.sort((a, b) => {
            if (a.username.toLowerCase() < b.username.toLowerCase()) {
                return -1;
            }
            else if (a.username.toLowerCase() > b.username.toLowerCase()) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "dateJoined"){
        account_list.sort((a, b) => {
            if (a.dateJoined.toLowerCase() < b.dateJoined.toLowerCase()){
                return -1;
            }
            else if (a.dateJoined.toLowerCase() > b.dateJoined.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "status") {
        account_list.sort((a, b) => {
            if (a.status.toLowerCase() < b.status.toLowerCase()) {
                return -1;
            }
            else if (a.status.toLowerCase() > b.status.toLowerCase()) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }

    var list_frame = document.getElementById("acc-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    display_list(account_list);
}