setInterval(() => {
    var currentDate = new Date();

    var month_str;

    switch (currentDate.getMonth() + 1) {
        case 1:
            month_str = "January";
            break;
        case 2:
            month_str = "February";
            break;
        case 3:
            month_str = "March";
            break;
        case 4:
            month_str = "April";
            break;
        case 5:
            month_str = "May";
            break;
        case 6:
            month_str = "June";
            break;
        case 7:
            month_str = "July";
            break;
        case 8:
            month_str = "August";
            break;
        case 9:
            month_str = "September";
            break;
        case 10:
            month_str = "October";
            break;
        case 11:
            month_str = "November";
            break;
        case 12:
            month_str = "December";
            break;
        default:
            break;
    }

    var hour = currentDate.getHours() + "";
    hour = hour.length < 2 ? "0" + hour : hour;

    var minutes = currentDate.getMinutes() + "";
    minutes = minutes.length < 2 ? "0" + minutes : minutes;

    var second = currentDate.getSeconds() + "";
    second = second.length < 2 ? "0" + second : second;

    var date = currentDate.getDate() + " "  + month_str + " " + currentDate.getFullYear();
    var time = hour + " : " + minutes + " : " + second;

    document.getElementById("header-date-time").innerHTML = date + "<br />" + time;
}, 1000);


function displayLogout() {
    window.confirm("Are you sure want to logout ? ");
}

function logout() {
    $.ajax({
        // username
        "url": "/logoutUser?username=dylan",
        "type": "get",
        "dataType": "json"
    });
}

var mode_font_color = document.getElementsByClassName("mode-font-color");
var mode_bg_color_2 = document.getElementsByClassName("mode-bg-color-2");
var mode_border_color = document.getElementsByClassName("mode-border-color");
var images = document.getElementsByClassName("action-logo");

var currentDate = new Date();
var hours = currentDate.getHours();
// var hours = 20;

var day_theme = {font_color : "#000000", bg_color_1 : "#FFFFFF" , bg_color_2 : "#FFD100", border : "2px #000000 solid", origin : "Light"};
var night_theme = {font_color : "#FFFFFF", bg_color_1 : "#000000" , bg_color_2 : "#000000", border : "2px #FFD100 solid", origin : "Dark"};

function display_theme (theme) {
    for (index in mode_font_color){
        mode_font_color.item(index).style.color = theme.font_color;
    }
    
    document.getElementsByTagName("body")[0].style.backgroundColor = theme.bg_color_1;    
    
    for (index in mode_bg_color_2){
        mode_bg_color_2.item(index).style.backgroundColor = theme.bg_color_2;
    }
    
    for (index in mode_border_color){
        mode_border_color.item(index).style.border = theme.border;
    }

    for (index in images){
        var invert = theme.origin == "Light" ? "Dark" : "Light";

        images.item(index).src = images.item(index).src.replace(invert, theme.origin);
    }
}

if (hours < 19){
    display_theme(day_theme);
}
else{
    display_theme(night_theme);
}