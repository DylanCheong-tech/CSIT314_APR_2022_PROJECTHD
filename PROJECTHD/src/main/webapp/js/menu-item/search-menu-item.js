var menu_item_list = $.ajax({
    async: false,
    "url": "/getMenuItemList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

console.log(menu_item_list);

var list_frame = document.getElementById("menu-item-list");

function display_list(menu_item_list) {
    for (index in menu_item_list) {
        var row = document.createElement("tr");

        var column1 = document.createElement("td");
        column1.classList.add("mode-font-color");
        column1.classList.add("mode-border-color-1");
        column1.innerHTML = menu_item_list[index].menuItemID;
        row.appendChild(column1);

        var column2 = document.createElement("td");
        column2.classList.add("mode-font-color");
        column2.classList.add("mode-border-color-1");
        column2.innerHTML = menu_item_list[index].name;
        row.appendChild(column2);

        var column3 = document.createElement("td");
        column3.classList.add("mode-font-color");
        column3.classList.add("mode-border-color-1");
        column3.innerHTML = menu_item_list[index].type;
        row.appendChild(column3);

        var column4 = document.createElement("td");
        column4.classList.add("mode-font-color");
        column4.classList.add("mode-border-color-1");
        column4.innerHTML = "$ " + menu_item_list[index].price.toFixed(2);
        row.appendChild(column4);

        var column5 = document.createElement("td");
        column5.classList.add("mode-font-color");
        column5.classList.add("mode-border-color-1");
        column5.innerHTML = menu_item_list[index].status;
        row.appendChild(column5);

        var column6 = document.createElement("td");
        column6.classList.add("mode-font-color");
        column6.classList.add("mode-border-color-1");
        column6.innerHTML = menu_item_list[index].createdAt;
        row.appendChild(column6);

        var column7 = document.createElement("td");
        column7.classList.add("mode-font-color");
        column7.classList.add("mode-border-color-1");
        column7.innerHTML = menu_item_list[index].updatedAt ? menu_item_list[index].updatedAt : "-";
        row.appendChild(column7);

        list_frame.appendChild(row);
    }
}

display_list(menu_item_list);