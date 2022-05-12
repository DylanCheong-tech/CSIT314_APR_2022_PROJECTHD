var alert_success_message = "Delete Order Successful";
var alert_fail_message = "Delete Order Fail";
var redirect_address = "staff-delete-order.html";

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
        var form = document.createElement("form");
        form.method = "post";
        form.action = "/staffDeleteOrder";

        var invisible_input = document.createElement("input");
        invisible_input.name = "orderID";
        invisible_input.type = "text";
        invisible_input.value = order_list[index].orderID;
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

display_list(order_list);