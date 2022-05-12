var redirect_address = "staff-view-order.html";

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
            qtyInnerText += order_list[index].orderItems[menuItemID] + "<br />";
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
        button.innerHTML = "View";
        button.type = "button";
        button.onclick = view_order.bind(event, order_list[index].orderID);
        btnCol.appendChild(button);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
}

display_list(order_list);

function view_order(orderID) {
    document.getElementById("table").style.display = "none";
    document.getElementById("view-form").style.display = "block";

    var order_json = $.ajax({
        async: false,
        "url": "/staffGetOrder?orderID=" + orderID,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    document.getElementById("order-id").value = order_json.orderID;
    document.getElementById("table-number").value = order_json.tableNum;
    document.getElementById("created-by").value = order_json.createdBy.name;
    document.getElementById("created-at").value = order_json.createdAt;
    document.getElementById("updated-at").value = order_json.updatedAt ? order_json.updatedAt : "-";
    document.getElementById("status").value = order_json.status;
    document.getElementById("total-amount").value = "$ " + order_json.totalAmount;

    var menu_items = [];
    for (menuItemID in order_json.orderItems) {
        var menu_item_json = $.ajax({
            async: false,
            "url": "/getMenuItem?menuItemID=" + menuItemID,
            "type": "get",
            "dataType": "json"
        }).responseJSON;

        menu_items.push(menu_item_json);
    }

    display_menu_items(menu_items, order_json);
}

function display_menu_items(menu_item_list, order) {
    var frame = document.getElementById("menu-items");

    for (index in menu_item_list) {
        var span = document.createElement("span");
        span.classList.add("menu-item");

        var img = document.createElement("img");
        img.src = menu_item_list[index].imageDataURL;

        var span1 = document.createElement("span");
        span1.innerText = menu_item_list[index].name;

        var span2 = document.createElement("span");
        span2.innerText = "$ " + menu_item_list[index].price.toFixed(2);

        var span3 = document.createElement("span");
        span3.innerText = "Qty : " + order.orderItems[menu_item_list[index].menuItemID];

        span.appendChild(img);
        span.appendChild(span1);
        span.appendChild(span2);
        span.appendChild(span3);

        frame.appendChild(span);
    }
}

function back_to_list() {
    document.getElementById("table").style.display = "table";
    document.getElementById("view-form").style.display = "none";
}