function select_merchant(ele, vendor){
    document.querySelectorAll("span#vendor-icon>span").forEach((item) => {
        item.className = "";
    })
    ele.classList.add("vendor-selected");

    document.getElementById("payment-vendor").value = vendor;
}