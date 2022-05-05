function sort(select_id) {
    var sort_criteria = document.getElementById(select_id).value;


    if (sort_criteria == "id") {
        coupon_list.sort((a, b) => {
            if (a.couponID < b.couponID) {
                return -1;
            }
            else if (a.couponID > b.couponID) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "code") {
        coupon_list.sort((a, b) => {
            if (a.code.toLowerCase() < b.code.toLowerCase()) {
                return -1;
            }
            else if (a.code.toLowerCase() > b.code.toLowerCase()) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "name") {
        // menu item list from the search-menu-item.js file
        coupon_list.sort((a, b) => {
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
    else if (sort_criteria == "discountType") {
        coupon_list.sort((a, b) => {
            if (a.discountType.toLowerCase() < b.discountType.toLowerCase()) {
                return -1;
            }
            else if (a.discountType.toLowerCase() > b.discountType.toLowerCase()) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "discountAmount") {
        coupon_list.sort((a, b) => {
            if (a.discountAmount < b.discountAmount) {
                return -1;
            }
            else if (a.discountAmount > b.discountAmount) {
                return 1;
            }
            else {
                return 0;
            }
        });
    }
    else if (sort_criteria == "status") {
        coupon_list.sort((a, b) => {
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
    };


    var list_frame = document.getElementById("coupon-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    display_list(coupon_list);
}