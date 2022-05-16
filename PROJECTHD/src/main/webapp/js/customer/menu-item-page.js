function qty_1(mode) {
    var qty_input = document.getElementById("qty");
    if (mode == "minus" && qty_input.value == 1)
        return;

    qty_input.value = parseInt(qty_input.value) + (mode == "add" ? 1 : -1);
}

var params = new URLSearchParams(window.location.search);
var menu_item_id = params.get("menuItemID");

$.ajax({
    async: true,
    "url": "/getMenuItem?menuItemID=" + menu_item_id,
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        return_json = data.responseJSON;
        document.title = return_json.name;
        document.getElementById("menuItemID").value  = return_json.menuItemID;
        document.getElementById("menu-item-img").src = return_json.imageDataURL;
        document.getElementById("menu-item-name").textContent = return_json.name;
        document.getElementById("price").textContent = "$ " + return_json.price;
        document.getElementById("menu-item-description").textContent = return_json.descriptions;
    }
});