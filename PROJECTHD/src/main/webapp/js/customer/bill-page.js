$.ajax({
    async: true,
    "url": "/customerGetBill" ,
    "type": "get",
    "dataType": "json",
    "complete" :  (data) => {
        var bill = data.responseJSON;
        document.getElementById("table-num").textContent = bill.order.tableNum;
        document.getElementById("bill-id").textContent = bill.billID;
        document.getElementById("created-date").textContent = bill.createdAt;
        display_menu_items(bill.order.menuItems);
        document.getElementById("subtotal").textContent = "$ " + bill.order.totalAmount.toFixed(2);
        if (bill.coupon) document.getElementById("coupon").textContent = "Discount: " + bill.coupon.code.toUpperCase();
        document.getElementById("discount").textContent = "- $ " + bill.discountAmount.toFixed(2);
        document.getElementById("GST").textContent = "$ " + bill.GST.toFixed(2);
        document.getElementById("grand-total-value").textContent = "$ " + bill.payableAmount.toFixed(2);
    }
});

function display_menu_items (menu_items){
    var frame = document.getElementById("menu-items-frame");

    for (id in menu_items){
        var item = $.ajax({
            async : false,
            "url" : "/getMenuItem?menuItemID=" + id,
            "type": "get",
            "dataType" : "json"
        }).responseJSON;

        var span = document.createElement("span");
        span.classList.add("menu-items");

        var column1 = document.createElement("span");
        column1.classList.add("column-1");
        column1.textContent = menu_items[id] + " x";

        var column2 = document.createElement("span");
        column2.classList.add("column-2");
        column2.textContent = item.name;

        var column3 = document.createElement("span");
        column3.classList.add("column-3");
        column3.textContent = "$ " + item.price.toFixed(2);

        span.appendChild(column1);
        span.appendChild(column2);
        span.appendChild(column3);

        frame.appendChild(span);
    }
}