var alert_success_message = "Update Order Successful";
var alert_fail_message = "Update Order Fail";
var redirect_address = "staff-update-order.html";

var order_list = $.ajax({
    async: false,
    "url": "/getOrderList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

console.log(order_list);

var list_frame = document.getElementById("order-list");

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
        for (menuItemID in order_list[index].orderItems) {
            var menu_item_json = $.ajax({
                async: false,
                "url": "/getMenuItem?menuItemID=" + menuItemID,
                "type": "get",
                "dataType": "json"
            }).responseJSON;

            menuItemInnerText += menu_item_json.name + "<br />";
            qtyInnerText += order_list[index].orderItems[menuItemID]  + "<br />";
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
        column7.innerHTML = order_list[index].createdBy.name;
        row.appendChild(column7);

        var column8 = document.createElement("td");
        column8.innerHTML = order_list[index].status;
        row.appendChild(column8);

        var btnCol = document.createElement("td");
        var button = document.createElement("button");
        button.innerHTML = "Update";
        button.onclick = update_order.bind(event, order_list[index]);
        button.type = "button";

        btnCol.appendChild(button);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
}

display_list(order_list);

var total_amount = 0;
var menu_item_json = {};

function decreaseQty(inputID, price, eleNode, menuItemID) {
    var qtyInput = document.getElementById(inputID);
    if (parseInt(qtyInput.value) > 0) {
        qtyInput.value = parseInt(qtyInput.value) - 1;
        total_amount -= parseFloat(price);
        update_total_amount();

        if (qtyInput.value <= 0) {
            eleNode.style.backgroundColor = "transparent";
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
        eleNode.style.backgroundColor = "#FFD100";
    }

    if (menu_item_json[menuItemID]) {
        menu_item_json[menuItemID]++;
    } else {
        menu_item_json[menuItemID] = 1;
    }

    document.getElementById("menu-items").value = JSON.stringify(menu_item_json);
}

var menu_item_list = $.ajax({
    async: false,
    "url": "/getMenuItemList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

console.log(menu_item_list)

function display_menu_items(category, order) {
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

display_menu_items("MainCourse");
display_menu_items("SideDish");
display_menu_items("Beverage");


function update_total_amount() {
    document.getElementById("total-amount").value = "$ " + total_amount.toFixed(2);
}

function update_order (order) {
    document.getElementById("table").style.display = "none";
    document.getElementById("update-form").style.display = "block";

    // for (menuItemID in order.orderItems){
    //     for (i = 0 ; i < order.orderItems.menuItemID ; i++){
    //         increaseQty()
    //     }
    // }

    document.getElementById("order-id").value = order.orderID;
    document.getElementById("table-number").value = order.tableNum;
}