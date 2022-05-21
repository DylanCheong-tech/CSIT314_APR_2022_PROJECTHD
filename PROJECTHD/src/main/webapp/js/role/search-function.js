function searchRole() {
    var roleName = document.getElementById("search-bar").value;

    var requested_json = $.ajax({
        async: false,
        "url": "/searchRole?name=" + roleName,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    var list_frame = document.getElementById("role-list");

    if (!requested_json) {
        show_confrim_btn();
        alert_box_msg.textContent = "Search Role Fail";
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

    display_list(result_list);
}