var alert_success_message = "Delete Coupon Successful";
var alert_fail_message = "Delete Coupon Fail";
var redirect_address = "delete-coupon.html";

var coupon_list = $.ajax({
    async: false,
    "url": "/getCouponList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

console.log(coupon_list);

var list_frame = document.getElementById("coupon-list");

function display_list(coupon_list) {
    for (index in coupon_list) {
        var row = document.createElement("tr");

        var column1 = document.createElement("td");
        column1.classList.add("mode-font-color");
        column1.classList.add("mode-border-color-1");
        column1.innerHTML = coupon_list[index].couponID;
        row.appendChild(column1);

        var column2 = document.createElement("td");
        column2.classList.add("mode-font-color");
        column2.classList.add("mode-border-color-1");
        column2.innerHTML = coupon_list[index].code;
        row.appendChild(column2);

        var column3 = document.createElement("td");
        column3.classList.add("mode-font-color");
        column3.classList.add("mode-border-color-1");
        column3.innerHTML = coupon_list[index].name;
        row.appendChild(column3);

        var column4 = document.createElement("td");
        column4.classList.add("mode-font-color");
        column4.classList.add("mode-border-color-1");
        column4.innerHTML = coupon_list[index].discountType;
        row.appendChild(column4);

        var column5 = document.createElement("td");
        column5.classList.add("mode-font-color");
        column5.classList.add("mode-border-color-1");
        column5.innerHTML = coupon_list[index].discountType == "Value" ? "$ " + coupon_list[index].discountAmount : coupon_list[index].discountAmount + "%";
        row.appendChild(column5);

        var column6 = document.createElement("td");
        column6.classList.add("mode-font-color");
        column6.classList.add("mode-border-color-1");
        column6.innerHTML = coupon_list[index].descriptions;
        row.appendChild(column6);

        var column7 = document.createElement("td");
        column7.classList.add("mode-font-color");
        column7.classList.add("mode-border-color-1");
        column7.innerHTML = coupon_list[index].status;
        row.appendChild(column7);

        var btnCol = document.createElement("td");
        btnCol.classList.add("mode-border-color-1");
        var form = document.createElement("form");
        form.method = "post";
        form.action = "/deleteCoupon";

        var invisible_input = document.createElement("input");
        invisible_input.name = "couponID";
        invisible_input.type = "text";
        invisible_input.value = coupon_list[index].couponID;
        invisible_input.style.display = "none";

        form.appendChild(invisible_input);

        var button = document.createElement("button");
        button.innerHTML = "Delete";
        button.type = "submit";

        form.appendChild(button);
        btnCol.appendChild(form);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
}

display_list(coupon_list);