function sort(select_id) {
    var sort_criteria = document.getElementById(select_id).value;

    var role_list = $.ajax({
        async: false,
        "url": "/getRoleList",
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (sort_criteria == "id") {
        role_list.sort((a, b) => {
            if (a.roleID < b.roleID) {
                return -1;
            }
            else if (a.roleID > b.roleID) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "name") {
        role_list.sort((a, b) => {
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

    var list_frame = document.getElementById("role-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    display_list(role_list);
}