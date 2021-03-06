var redirect_address = "/restaurantmanager/view-menu-item.html";

var list_frame = document.getElementById("menu-item-list");

function display_list(menu_item_list) {
    for (index in menu_item_list) {
        var row = document.createElement("tr");
        row.id = menu_item_list[index].menuItemID;

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

        var btnCol = document.createElement("td");
        btnCol.classList.add("mode-border-color-1");
        var form = document.createElement("form");
        form.method = "post";
        form.action = "/deleteRole";

        var invisible_input = document.createElement("input");
        invisible_input.name = "menuItemID";
        invisible_input.type = "text";
        invisible_input.value = menu_item_list[index].menuItemID;
        invisible_input.style.display = "none";

        form.appendChild(invisible_input);

        var button = document.createElement("button");
        button.onclick = viewMenuItem.bind(event, menu_item_list[index].menuItemID);
        button.innerHTML = "View";
        button.type = "button";

        form.appendChild(button);
        btnCol.appendChild(form);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
};

$.ajax({
    async: true,
    "url": "/getMenuItemList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        display_list(data.responseJSON);
        hide_loader();
    }
});

function viewMenuItem(recordID) {
    var menu_item_json = $.ajax({
        async: false,
        "url": "/getMenuItem?menuItemID=" + recordID,
        "type": "get",
        "dataType": "json"
    }).responseJSON;

    if (!menu_item_json) {
        show_confrim_btn();
        alert_box_msg.textContent = "View Menu Item Fail";
        alert_box.style.display = "inline-block";
        return;
    }

    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("id-input").value = menu_item_json.menuItemID;

    document.getElementById("name").value = menu_item_json.name;
    document.getElementById("type").value = menu_item_json.type;
    document.getElementById("price").value = "$ " + menu_item_json.price;
    document.getElementById("status").value = menu_item_json.status;
    document.getElementById("desc").value = menu_item_json.descriptions;
    document.getElementById("image-preview").src = menu_item_json.imageDataURL;
}

function backToList() {
    document.getElementById("search-frame").style.display = "inline-block";
    document.getElementById("sort-frame").style.display = "inline-block";
    document.getElementById("table").style.display = "table";
    document.getElementById("form").style.display = "none";
}