var redirect_address = "staff-search-order.html";

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

        list_frame.appendChild(row);
    }
}

display_list(order_list);