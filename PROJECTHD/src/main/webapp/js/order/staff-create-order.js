var alert_success_message = "Create Order Successful";
var alert_fail_message = "Create Order Fail";
var redirect_address = "/staff/staff-create-order.html";

var total_amount = 0;
var menu_item_json = {};

function update_total_amount() {
    document.getElementById("total-amount").value = "$ " + total_amount.toFixed(2);
}

function decreaseQty(inputID, price, eleNode, menuItemID) {
    var qtyInput = document.getElementById(inputID);
    if (parseInt(qtyInput.value) > 0) {
        qtyInput.value = parseInt(qtyInput.value) - 1;
        total_amount -= parseFloat(price);
        update_total_amount();

        if (qtyInput.value <= 0) {
            eleNode.classList.remove("highlight-item");
        }
    }

    if (menu_item_json[menuItemID] && menu_item_json[menuItemID] > 0) {
        if ((--menu_item_json[menuItemID]) == 0) {
            delete menu_item_json[menuItemID];
        }
    }

    document.getElementById("menu-items").value = JSON.stringify(menu_item_json);
}

function increaseQty(inputID, price, eleNode, menuItemID) {
    var qtyInput = document.getElementById(inputID);
    if (parseInt(qtyInput.value) < 999) {
        qtyInput.value = parseFloat(qtyInput.value) + 1;
        total_amount += price;
        update_total_amount();
        eleNode.classList.add("highlight-item");
    }

    if (menu_item_json[menuItemID]) {
        menu_item_json[menuItemID]++;
    } else {
        menu_item_json[menuItemID] = 1;
    }

    document.getElementById("menu-items").value = JSON.stringify(menu_item_json);
}

var menu_item_list = {};

function display_menu_items(category) {
    var frame = document.getElementById(category);

    for (index in menu_item_list) {
        if (menu_item_list[index].type == category && menu_item_list[index].status == "Available") {
            var span = document.createElement("span");
            span.classList.add("menu-item");

            var img = document.createElement("img");
            img.src = menu_item_list[index].imageDataURL;

            var span1 = document.createElement("span");
            span1.innerText = menu_item_list[index].name;

            var span2 = document.createElement("span");
            span2.innerText = "$ " + menu_item_list[index].price.toFixed(2);

            var span3 = document.createElement("span");
            span3.innerText = "Qty : ";
            var minusBtn = document.createElement("button");
            minusBtn.type = "button";
            minusBtn.innerText = "-";
            minusBtn.onclick = decreaseQty.bind(event, category + index, menu_item_list[index].price, span, menu_item_list[index].menuItemID);

            var qtyInput = document.createElement("input");
            qtyInput.id = category + index;
            qtyInput.type = "text";
            qtyInput.value = "0";
            qtyInput.disabled = true;

            var addBtn = document.createElement("button");
            addBtn.type = "button";
            addBtn.innerText = "+";
            addBtn.onclick = increaseQty.bind(event, category + index, menu_item_list[index].price, span, menu_item_list[index].menuItemID);

            span3.appendChild(minusBtn);
            span3.appendChild(qtyInput);
            span3.appendChild(addBtn);

            span.appendChild(img);
            span.appendChild(span1);
            span.appendChild(span2);
            span.appendChild(span3);

            frame.appendChild(span);
        }
    }
}

$.ajax({
    async: true,
    "url": "/getMenuItemList",
    "type": "get",
    "dataType": "json",
    "complete": (data) => {
        menu_item_list = data.responseJSON;
        display_menu_items("MainCourse");
        display_menu_items("SideDish");
        display_menu_items("Beverage");
        hide_loader();
    }
});

$.ajax({
    async: true,
    "url": "/getOrderList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        var order_list = data.responseJSON;
        document.getElementById("orderID").value = parseInt(order_list.length != 0 ? order_list[order_list.length - 1].orderID : 0) + 1;
    }
});