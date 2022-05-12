function searchOrder() {
    var searched_item = $.ajax({
        async: false,
        "url": "/staffSearchOrder?tableNum=" + document.getElementById("search-bar").value,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (searched_item.length == 0) {
        show_confrim_btn();
        alert_box_msg.textContent = "Order Not Found";
        alert_box.style.display = "inline-block";
        return;
    }

    console.log(searched_item);

    var list_frame = document.getElementById("order-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    // defined in the page js file 
    display_list(searched_item);
}