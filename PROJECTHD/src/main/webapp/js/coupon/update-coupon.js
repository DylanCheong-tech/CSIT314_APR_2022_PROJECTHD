var alert_success_message = "Update Coupon Successful";
var alert_fail_message = "Update Coupon Fail";
var redirect_address = "update-coupon.html";

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
        row.id = coupon_list[index].couponID;

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


        var button = document.createElement("button");
        button.innerHTML = "Update";
        button.type = "button";
        button.onclick = updateCoupon.bind(event, coupon_list[index].couponID);
        btnCol.appendChild(button);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
}

display_list(coupon_list);

function updateCoupon(recordID) {
    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("id-input").value = childs[0].textContent;

    document.getElementById("code").value = childs[1].textContent;
    document.getElementById("name").value = childs[2].textContent;
    document.getElementById("discountType").value = childs[3].textContent;
    document.getElementById("discountAmount").value = childs[4].textContent;
    document.getElementById("descriptions").value = childs[5].textContent;
    document.getElementById("status").value = childs[6].textContent;
}