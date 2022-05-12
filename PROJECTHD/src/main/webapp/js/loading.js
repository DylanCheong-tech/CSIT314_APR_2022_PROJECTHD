function display_loader () {
    document.getElementById("loader").style.display = "inline-block";
    var body = document.querySelectorAll("body>*:not(#loader)");
    body.forEach((item) => {
        item.style.opacity = "20%";
    });
}

function hide_loader () {
    document.getElementById("loader").style.display = "none";
    var body = document.querySelectorAll("body>*:not(#loader)");
    body.forEach((item) => {
        item.style.opacity = "100%";
    });
}