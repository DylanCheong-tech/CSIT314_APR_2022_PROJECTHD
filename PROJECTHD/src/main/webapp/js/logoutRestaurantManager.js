var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

function logout() {
    alert_box.style.display = "inline-block";
    alert_box_msg.innerText = "Are you sure want to logout?";

    var hide_btn = document.getElementsByClassName("logout-btn");
    for (index in hide_btn){
        hide_btn.item(index).style.display = "inline-block";
    }
}

function confirm_logout() {
    $.ajax({
        "url": "/logoutRestaurantManager",
        "type": "get",
        "complete": () => {
            window.location.href = "/login.html";
        }
    });
}

function cancel_logout() {
    alert_box.style.display = "none";
}

function redirect_page (page){
    window.location.href = page;
}