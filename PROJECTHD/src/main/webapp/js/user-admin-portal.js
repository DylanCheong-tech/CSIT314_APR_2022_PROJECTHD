setInterval(() => {
    var currentDate = new Date();
    var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
    var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

    document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);


function displayLogout () {
    window.confirm("Are you sure want to logout ? ");
}

function logout () {
    $.ajax({
        "url": "/logoutUser?username=dylan",
        "type": "get",
        "dataType": "json"
    });
}