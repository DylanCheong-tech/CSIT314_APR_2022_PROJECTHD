function display_menu_items(menu_item_list, category) {
    var frame = document.getElementById("menu-items-frame");

    for (index in menu_item_list) {
        if (menu_item_list[index].type == category && menu_item_list[index].status == "Available") {
            var span = document.createElement("span");
            span.classList.add("menu-item");
            span.onclick = redirect_menu_item_page.bind(event, menu_item_list[index].menuItemID);

            var img = document.createElement("img");
            img.src = menu_item_list[index].imageDataURL;

            var menu_item_name = document.createElement("span");
            menu_item_name.textContent = menu_item_list[index].name;

            var menu_item_price = document.createElement("span");
            menu_item_price.textContent = "$ " + menu_item_list[index].price.toFixed(2);

            span.appendChild(img);
            span.appendChild(menu_item_name);
            span.appendChild(menu_item_price);

            frame.appendChild(span);
        }

    }
}

function change_menu(ele, category) {
    display_loader();

    var list_frame = document.getElementById("menu-items-frame");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    if (ele) {
        var spans = document.querySelectorAll("#menu-category-tab span");
        spans.forEach((item) => {
            item.classList.remove("on-select");
        });
        ele.classList.add("on-select");
    }


    $.ajax({
        async: true,
        "url": "/getMenuItemList",
        "type": "get",
        "dataType": "json",
        "complete": (data) => {
            display_menu_items(data.responseJSON, category);
            hide_loader();
        }
    });
}

change_menu(null, "MainCourse");

function redirect_menu_item_page (menuItemID){
    window.location.href = "/customer/menu-item-page.html?menuItemID=" + menuItemID;
}