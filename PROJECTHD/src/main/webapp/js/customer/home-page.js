var table_number;

function update_table_number() {
    var input = document.getElementById("table-num");

    if (!input.value.match(/[0-9]+/) || input.value == "") {
        input.setCustomValidity("Please enter a valid table number !");
        input.reportValidity();
    }
    else {
        input.setCustomValidity("");
        table_number = parseInt(input.value);
        document.querySelectorAll(".hide").forEach((item) => {
            item.style.display = "none";
        });
        document.querySelectorAll(".show").forEach((item) => {
            item.style.display = "inline-block";
        });
    }
}

function keypressed (event) {
    if (event.keyCode == 13){
        event.preventDefault();
        update_table_number();
    }
}

var promo_img_arr = ["/img/customer/BS30.png", "/img/customer/CF50.png", "/img/customer/MS40.png"];
var index = 0;

function fade_out_pic() {
    $("#promo-img").fadeOut(2000, function () {
        this.src = promo_img_arr[++index > 2 ? index = 0 : index];
        fade_in_pic();
    });
}

function fade_in_pic () {
    $("#promo-img").fadeIn(2000, function () {
        setTimeout(() => {
            fade_out_pic();
        }, 3000);
    });
}

setTimeout(() => {
    fade_out_pic();
}, 3000);