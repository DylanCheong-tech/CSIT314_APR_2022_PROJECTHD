function display_menu_items(menu_item_list, category) {
    var frame = document.getElementById("menu-items-frame");

    for (index in menu_item_list) {
        if (!category) category = menu_item_list[index].type;
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

function clean_menu() {
    var list_frame = document.getElementById("menu-items-frame");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }
}

var current_category = "MainCourse";
var current_category_ele = null;

function change_menu(ele, category) {
    display_loader();

    clean_menu();

    if (ele) {
        current_category_ele = ele;
        var spans = document.querySelectorAll("#menu-category-tab span");
        spans.forEach((item) => {
            item.classList.remove("on-select");
        });
        ele.classList.add("on-select");
    }

    current_category = category;

    $.ajax({
        async: true,
        "url": "/customerGetMenuItemList",
        "type": "get",
        "dataType": "json",
        "complete": (data) => {
            display_menu_items(data.responseJSON, category);
            hide_loader();
        }
    });
}

change_menu(current_category_ele, current_category);

function redirect_menu_item_page(menuItemID) {
    window.location.href = "/customer/menu-item-page.html?menuItemID=" + menuItemID;
}

$.ajax({
    async: true,
    "url": "/customerGetOrder",
    "type": "get",
    "dataType": "json",
    "complete": (data) => {
        var order = data.responseJSON;
        document.getElementById("table-number").textContent = order.tableNum;
        if (Object.keys(order.menuItems).length)
            document.getElementById("cart-red-dot").classList.add("not-empty");
        else
            document.getElementById("cart-red-dot").className = "";
    }
});

function search_menu_item() {
    var search_name = document.getElementById("search-bar").value;
    if (search_name) {
        $.ajax({
            async: true,
            "url": "/customerSearchMenuItem?name=" + search_name,
            "type": "get",
            "dataType": "json",
            "complete": (data) => {
                clean_menu();
                display_menu_items(data.responseJSON);
                console.log(data.responseJSON);
            }
        });
    } else {
        change_menu(current_category_ele, current_category)
    }
}