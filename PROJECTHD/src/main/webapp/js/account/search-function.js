function searchAccount() {
    var accName = document.getElementById("search-bar").value;

    console.log(accName)

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

    display_list(result_list);
}