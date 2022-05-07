var alert_success_message = "Create Menu Item Successful";
var alert_fail_message = "Create Menu Item Fail";
var redirect_address = "create-menu-item.html";

var img_reader = new FileReader();
var img_data_url;

img_reader.addEventListener('load', () => {
    img_data_url = img_reader.result;
    console.log(img_data_url);
    document.getElementById("image-preview").src = img_data_url;
    document.getElementById("hidden-image-data-url").value = img_data_url;
    document.getElementById("submit-btn").disabled = false;
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

function dropImage (event){
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

    if (event.dataTransfer.items){
        for (var i = 0; i < event.dataTransfer.items.length; i++){
            if (event.dataTransfer.items[i].kind === "file"){
                var file = event.dataTransfer.items[i].getAsFile();
                console.log(event.dataTransfer.items[i]);

                if (file){
                    compress_image(file);                    
                }
            }
        }
    }else {
        for (var i = 0; i < event.dataTransfer.files.length; i++){
            if (event.dataTransfer.items[i].kind === "file"){
                if(event.dataTransfer.files[i]){
                    compress_image(event.dataTransfer.files[i]);
                }
            }
        }
    }
}

function dragoverImage (event){
    event.preventDefault();

    console.log("Dragging Over here");
}

function removeImageFile () {
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

function previewImage () {
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
    if (image_input.files[0]){
        compress_image(image_input.files[0]);
    }

    setTimeout(() => {
        console.log(img_data_url);
    }, 5000);
}

var menu_item_list = $.ajax({
    async: false,
    "url": "/getMenuItemList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

document.getElementById("id-input").value = parseInt(menu_item_list.length != 0 ? menu_item_list[menu_item_list.length - 1].menuItemID : 0) + 1;