function add_menu_items(menu_item, qty, order_status) {
    var menu_items_frame = document.getElementById("menu-items");

    var span = document.createElement("span");
    span.classList.add("item");

    var img = document.createElement("img");
    img.src = menu_item.imageDataURL;

    var span1 = document.createElement("span");
    span1.classList.add("item-name");
    var name = document.createElement("span");
    name.textContent = menu_item.name;
    var price = document.createElement("span");
    price.textContent = "$ " + menu_item.price.toFixed(2);

    span1.appendChild(name);
    span1.appendChild(price);

    var span2 = document.createElement("span");
    span2.classList.add("item-qty");
    var span3 = document.createElement("span");
    var minus_button = document.createElement("button");
    minus_button.type = "button";
    minus_button.onclick = order_status == "Submitted" ? null : minus_qty.bind(event, menu_item.menuItemID, 'qty_' + menu_item.menuItemID);
    minus_button.textContent = "-";
    var input = document.createElement("input");
    input.id = 'qty_' + menu_item.menuItemID;
    input.type = "text";
    input.value = qty;
    input.disabled = true;
    var add_button = document.createElement("button");
    add_button.type = "button";
    add_button.onclick = order_status == "Submitted" ? null : add_qty.bind(event, menu_item.menuItemID, 'qty_' + menu_item.menuItemID);
    add_button.textContent = "+";

    span3.appendChild(minus_button);
    span3.appendChild(input);
    span3.appendChild(add_button);
    span2.appendChild(span3);

    span.appendChild(img);
    span.appendChild(span1);
    span.appendChild(span2);
    menu_items_frame.appendChild(span);

}

function add_qty(menuitemid, input_id) {
    var input = document.getElementById(input_id);
    input.value = parseInt(input.value) + 1;

    $.ajax({
        async: true,
        "url": "/customerUpdateOrder?menuItemID=" + menuitemid + "&qty=" + 1,
        "type": "get",
        "dataType": "json",
        "complete": (data) => {
            update_total_amount(data.responseJSON.order.totalAmount);
        }
    });
}

function minus_qty(menuitemid, input_id, confirm_remove) {
    var input = document.getElementById(input_id);
    var value = input.value;

    if (value > 0) {
        if (confirm_remove == true){
            close_confirm_box();
            document.location.reload();
        }
        else if (value == 1){
            show_confirm_box(menuitemid, input_id);
            return;
        }
        $.ajax({
            async: true,
            "url": "/customerUpdateOrder?menuItemID=" + menuitemid + "&qty=" + -1,
            "type": "get",
            "dataType": "json",
            "complete": (data) => {
                update_total_amount(data.responseJSON.order.totalAmount);
            }
        });
    }else {

    }

    value == 0 ? 0 : value--;
    input.value = value;
}

$.ajax({
    async: true,
    "url": "/customerGetOrder",
    "type": "get",
    "dataType": "json",
    "complete": (data) => {
        var order = data.responseJSON;
        if (order.status == "Submitted") {
            document.getElementById("submit-order-btn").disabled = true;
        }

        update_total_amount(order.totalAmount);

        for (id in order.menuItems) {
            $.ajax({
                async: false,
                "url": "/getMenuItem?menuItemID=" + id,
                "type": "get",
                "dataType": "json",
                "complete": (data2) => {
                    add_menu_items(data2.responseJSON, order.menuItems[id], order.status);
                }
            });
        }
    }
});

function apply_coupon() {
    var coupon_code = document.getElementById("coupon").value;
    $.ajax({
        async: true,
        "url": "/customerApplyCoupon?couponCode=" + coupon_code,
        "type": "get",
        "dataType": "json",
        "complete": (data) => {
            var promotion = document.getElementById("promotion");
            promotion.className = "";
            promotion.classList.add(data.responseJSON.status);

            document.getElementById("coupon-message").innerHTML = data.responseJSON.status == "success" ? "Coupon Applied successfully" : "Sorry, this code is not valid.<br />Please check the code and try again";
        }
    });
}

function update_total_amount(value) {
    document.getElementById("sub-total-amount").textContent = "$ " + value.toFixed(2);
}

function show_confirm_box (menuitemid, input_id){
    document.getElementById("confirm-box").style.display = "block";
    document.getElementById("confirm-btn").onclick = confirm_remove.bind(event, menuitemid, input_id);
}

function close_confirm_box() {
    document.getElementById("confirm-box").style.display = "none";
}

function confirm_remove(menuitemid, input_id){
    console.log(menuitemid)
    minus_qty(menuitemid, input_id, true)
}