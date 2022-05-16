function toggleSideMenu(ele) {
    ele.classList.toggle("open");
    var side_nav = document.getElementById("side-navigation");
    if (side_nav.style.width == "" || side_nav.style.width == "0px"){
        side_nav.style.width = "75%";
        document.body.style.background = "rgb(0, 0, 0, 1)";
        document.querySelectorAll("body>*:not(.no-fade)").forEach((item) => {
            item.style.opacity = "20%"
        });
    }
    else {
        side_nav.style.width = "0";
        document.body.style.background = "unset";
        document.querySelectorAll("body>*:not(.no-fade)").forEach((item) => {
            item.style.opacity = "unset"
        });
    }    
}