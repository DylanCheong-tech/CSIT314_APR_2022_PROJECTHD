var alert_success_message = "Update Menu Item Successful";
var alert_fail_message = "Update Menu Item Fail";
var redirect_address = "/restaurantmanager/update-menu-item.html";

var img_reader = new FileReader();
var img_data_url;

img_reader.addEventListener('load', () => {
    img_data_url = img_reader.result;
    console.log(img_data_url);
    document.getElementById("image-preview").src = img_data_url;
    document.getElementById("hidden-image-data-url").value = img_data_url;
    document.getElementById("submit-btn").disabled = false;
    document.getElementById("image-drop").style.backgroundColor = "rgb(113, 255, 124, 0.6)";
});

function compress_image (file){
    if (file.size > 500000){
        imageConversion.compress(file, 0.2).then((file) => {
            console.log("compressed");
            console.log(file);
            img_reader.readAsDataURL(file);
        });
    }else {
        imageConversion.compress(file, 0.5).then((file) => {
            console.log("compressed");
            console.log(file);
            img_reader.readAsDataURL(file);
        });
    }
}

function dropImage(event) {
    event.preventDefault();

    var image_drop_frame = document.getElementById("image-drop-frame");
    image_drop_frame.style.display = "block";
    image_drop_frame.style.width = "100%";
    image_drop_frame.style.margin = "0 0 0 0";

    var image_drop = document.getElementById("image-drop");
    image_drop.style.textAlign = "left";
    image_drop.style.width = "61%";

    var message_frame = document.getElementById("upload-message");
    message_frame.style.display = "inline-block";

    document.querySelectorAll("div#image-drop *").forEach((item) => {
        item.style.display = "none";
    });

    document.getElementById("image-preview").style.display = "inline-block";

    if (event.dataTransfer.items) {
        for (var i = 0; i < event.dataTransfer.items.length; i++) {
            if (event.dataTransfer.items[i].kind === "file") {
                var file = event.dataTransfer.items[i].getAsFile();
                console.log(event.dataTransfer.items[i]);

                if (file) {
                    compress_image(file);
                }
            }
        }
    } else {
        for (var i = 0; i < event.dataTransfer.files.length; i++) {
            if (event.dataTransfer.items[i].kind === "file") {
                if (event.dataTransfer.files[i]) {
                    compress_image(event.dataTransfer.files[i]);
                }
            }
        }
    }
}

function dragoverImage(event) {
    event.preventDefault();

    console.log("Dragging Over here");
}

function removeImageFile() {
    img_data_url = "";
    document.getElementById("image-preview").src = "";

    var image_drop_frame = document.getElementById("image-drop-frame");
    image_drop_frame.style.display = "inline-block";
    image_drop_frame.style.width = "61%";
    image_drop_frame.style.margin = "1% 0 1% 0";

    var image_drop = document.getElementById("image-drop");
    image_drop.style.textAlign = "center";
    image_drop.style.width = "100%";

    var message_frame = document.getElementById("upload-message");
    message_frame.style.display = "inline-block";

    document.querySelectorAll("div#image-drop *").forEach((item) => {
        item.style.display = "inline-block";
    });

    document.getElementById("image-file-input").style.display = "none";
    document.getElementById("upload-message").style.display = "none";
    document.getElementById("image-preview").style.display = "none";
    document.getElementById("submit-btn").disabled = true;
}

function previewImage() {
    var image_drop_frame = document.getElementById("image-drop-frame");
    image_drop_frame.style.display = "block";
    image_drop_frame.style.width = "100%";
    image_drop_frame.style.margin = "0 0 0 0";

    var image_drop = document.getElementById("image-drop");
    image_drop.style.textAlign = "left";
    image_drop.style.width = "61%";

    var message_frame = document.getElementById("upload-message");
    message_frame.style.display = "inline-block";

    document.querySelectorAll("div#image-drop *").forEach((item) => {
        item.style.display = "none";
    });

    document.getElementById("image-preview").style.display = "inline-block";

    var image_input = document.getElementById("image-file-input");
    if (image_input.files[0]) {
        compress_image(image_input.files[0]);
    }

    setTimeout(() => {
        console.log(img_data_url);
    }, 5000);
}

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

        var button = document.createElement("button");
        button.onclick = updateMenuItem.bind(event, menu_item_list[index].menuItemID);
        button.innerHTML = "Update";
        button.type = "button";

        btnCol.appendChild(button);
        row.appendChild(btnCol);

        list_frame.appendChild(row);
    }
};

var menu_item_list = {};
$.ajax({
    async: true,
    "url": "/getMenuItemList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        menu_item_list = data.responseJSON;
        display_list(data.responseJSON);
        hide_loader();
    }
});

function updateMenuItem(recordID) {
    document.getElementById("search-frame").style.display = "none";
    document.getElementById("sort-frame").style.display = "none";

    var row = document.getElementById(recordID);

    var childs = row.childNodes;

    document.getElementById("table").style.display = "none";
    document.getElementById("form").style.display = "inline-block";

    document.getElementById("id-input").value = childs[0].textContent;

    document.getElementById("name").value = childs[1].textContent;
    document.getElementById("type").value = childs[2].textContent;
    document.getElementById("price").value = childs[3].textContent.replaceAll(/[$\s]*/g, "");
    document.getElementById("status").value = childs[4].textContent;

    for (index in menu_item_list) {
        if (menu_item_list[index].menuItemID == childs[0].textContent) {
            document.getElementById("desc").value = menu_item_list[index].descriptions;
            document.getElementById("hidden-image-data-url").value = menu_item_list[index].imageDataURL;
            document.getElementById("image-preview").src = menu_item_list[index].imageDataURL;
            previewImage();
        }
    }
}