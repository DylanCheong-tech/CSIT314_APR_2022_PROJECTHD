function searchCoupon() {
    var searched_item = $.ajax({
        async: false,
        "url": "/searchCoupon?coupon_name=" + document.getElementById("search-bar").value,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (!searched_item) {
        show_confrim_btn();
        alert_box_msg.textContent = "Coupon Not Found";
        alert_box.style.display = "inline-block";
        return;
    }

    var list_frame = document.getElementById("coupon-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    let result_list = [searched_item];

    // defined in the page js file 
    display_list(result_list);

    console.log(searched_item);
}