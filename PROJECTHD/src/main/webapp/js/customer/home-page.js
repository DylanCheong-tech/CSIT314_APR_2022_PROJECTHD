var table_number;

function update_table_number() {
    var input = document.getElementById("table-num");

    if (input.validity.patternMismatch || input.value == "") {
        input.reportValidity();
        input.setCustomValidity("Please enter a valid table number !")
    }
    else {
        table_number = parseInt(input.value);
        document.querySelectorAll(".hide").forEach((item) => {
            item.style.display = "none";
        });
        document.querySelectorAll(".show").forEach((item) => {
            item.style.display = "inline-block";
        });
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
        }, 1000);
    });
}

fade_out_pic();
