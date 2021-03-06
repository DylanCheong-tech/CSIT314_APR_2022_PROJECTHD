var alert_success_message = "Update Order Successful";
var alert_fail_message = "Update Order Fail";
var redirect_address = "/staff/staff-update-order.html";

var total_amount = 0;
var menu_item_json = {};

var list_frame = document.getElementById("order-list");
var order_list = {};

function display_list(order_list) {
    for (index in order_list) {
        var row = document.createElement("tr");

        var column1 = document.createElement("td");
        column1.innerHTML = order_list[index].orderID;
        row.appendChild(column1);

        var column2 = document.createElement("td");
        column2.innerHTML = order_list[index].tableNum;
        row.appendChild(column2);

        var menuItemInnerText = "";
        var qtyInnerText = "";
        var priceInnerText = "";
        for (menuItemID in order_list[index].menuItems) {
            var menu_item_json = $.ajax({
                async: false,
                "url": "/getMenuItem?menuItemID=" + menuItemID,
                "type": "get",
                "dataType": "json"
            }).responseJSON;

            menuItemInnerText += menu_item_json.name + "<br />";
            qtyInnerText += order_list[index].menuItems[menuItemID] + "<br />";
            priceInnerText += "$ " + menu_item_json.price + "<br />";
        }
        var column3 = document.createElement("td");
        column3.innerHTML = menuItemInnerText;
        row.appendChild(column3);

        var column4 = document.createElement("td");
        column4.innerHTML = qtyInnerText;
        row.appendChild(column4);

        var column5 = document.createElement("td");
        column5.innerHTML = priceInnerText;
        row.appendChild(column5);

        var column6 = document.createElement("td");
        column6.innerHTML = "$ " + order_list[index].totalAmount.toFixed(2);
        row.appendChild(column6);

        var column7 = document.createElement("td");
        column7.innerHTML = order_list[index].createdBy ? order_list[index].createdBy.name : "-";
        row.appendChild(column7);

        var column8 = document.createElement("td");
        column8.innerHTML = order_list[index].status;
        row.appendChild(column8);

        var btnCol = document.createElement("td");
        var button = document.createElement("button");
        if (order_list[index].status != "Created"){
            button.disabled = true;
            button.classList.add("disabled-btn");
        }
        button.innerHTML = "Update";
        button.onclick = update_order.bind(event, order_list[index], );
        button.type = "button";

        btnCol.appendChild(button);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
}

$.ajax({
    async: true,
    "url": "/getOrderList",
    "type": "get",
    "dataType": "json",
    "complete" :  (data) => {
        order_list = data.responseJSON;
        display_list(data.responseJSON);
        hide_loader();
    }
});

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

function display_menu_items(category, menuItems) {
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
            console.log(menuItems)
            if (menuItems[menu_item_list[index].menuItemID]){
                qtyInput.value = menuItems[menu_item_list[index].menuItemID];
                span.classList.add("highlight-item");
            }else {
                qtyInput.value = "0";
            }
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

function update_total_amount() {
    document.getElementById("total-amount").value = "$ " + total_amount.toFixed(2);
}

function update_order(order) {
    display_loader();
    document.getElementById("table").style.display = "none";
    document.getElementById("update-form").style.display = "block";

    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

    document.getElementById("order-id").value = order.orderID;
    document.getElementById("table-number").value = order.tableNum;
    menu_item_json = order.menuItems;
    document.getElementById("menu-items").value = JSON.stringify(order.menuItems);
    total_amount = order.totalAmount;
    update_total_amount();

    $.ajax({
        async: true,
        "url": "/getMenuItemList",
        "type": "get",
        "dataType": "json",
        "complete": (data) => {
            menu_item_list = data.responseJSON;
            display_menu_items("MainCourse", order.menuItems);
            display_menu_items("SideDish", order.menuItems);
            display_menu_items("Beverage", order.menuItems);
            hide_loader();
        }
    });
}