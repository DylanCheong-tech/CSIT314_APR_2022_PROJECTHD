var mode_font_color = document.getElementsByClassName("mode-font-color");
var mode_bg_color_2 = document.getElementsByClassName("mode-bg-color-2");
var mode_border_color_1 = document.getElementsByClassName("mode-border-color-1");
var mode_border_color_2 = document.getElementsByClassName("mode-border-color-2");
var mode_border_color_3 = document.getElementsByClassName("mode-border-color-3");
var mode_row_hover_color = document.querySelectorAll("body table tbody tr");
var login_page_bg = document.getElementById("image-frame");
// for admin portal page
var images = document.getElementsByClassName("action-logo");

var currentDate = new Date();
var hours = currentDate.getHours();

var day_theme = { font_color: "#000000", bg_color_1: "#FFFFFF", bg_color_2: "#FFD100", border_1: "2px #000000 solid", border_2: "2px #FFFFFF solid", hover: "#FFD100", origin: "Light" };
var night_theme = { font_color: "#FFFFFF", bg_color_1: "#000000", bg_color_2: "#000000", border_1: "2px #FFD100 solid", border_2: "2px #FFD100 solid", hover: "darkslategrey", origin: "Dark" };

function display_theme(theme) {
    for (index in mode_font_color) {
        if (mode_font_color.item(index))
            mode_font_color.item(index).style.color = theme.font_color;
    }

    document.getElementsByTagName("body")[0].style.backgroundColor = theme.bg_color_1;

    for (index in mode_bg_color_2) {
        if (mode_bg_color_2.item(index))
            mode_bg_color_2.item(index).style.backgroundColor = theme.bg_color_2;
    }

    for (index in mode_border_color_1) {
        if (mode_border_color_1.item(index))
            mode_border_color_1.item(index).style.border = theme.border_1;
    }

    for (index in mode_border_color_2) {
        if (mode_border_color_2.item(index)) {
            mode_border_color_2.item(index).style.borderBottom = theme.border_2;
            mode_border_color_2.item(index).style.borderTop = theme.border_2;
        }
    }

    for (index in mode_border_color_3) {
        if (mode_border_color_3.item(index))
            mode_border_color_3.item(index).style.borderBottom = theme.border_1;
    }

    mode_row_hover_color.forEach((item) => {
        item.addEventListener("mouseenter", (event) => {
            event.target.style.backgroundColor = theme.hover;
        });

        item.addEventListener("mouseleave", (event) => {
            event.target.style.backgroundColor = "transparent";
        });
    });

    for (index in images) {
        if (images.item(index)) {
            var invert = theme.origin == "Light" ? "Dark" : "Light";
            images.item(index).src = images.item(index).src.replace(invert, theme.origin);
        }
    }

    if (login_page_bg){
        login_page_bg.style.backgroundColor = theme.font_color;
    }
}

var current_theme;

if (hours < 19) {
    current_theme = day_theme;
}
else {
    current_theme = night_theme;
}

display_theme(current_theme);