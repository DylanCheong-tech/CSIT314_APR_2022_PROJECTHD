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

    var date = currentDate.getDate() + " " + month_str + " " + currentDate.getFullYear();
    var time = hour + " : " + minutes + " : " + second;

    document.getElementById("header-date-time").innerHTML = date + "<br />" + time;
}, 1000);