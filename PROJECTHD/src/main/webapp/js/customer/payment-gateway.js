function select_merchant(ele, vendor){
    document.querySelectorAll("span#vendor-icon>span").forEach((item) => {
        item.className = "";
    })
    ele.classList.add("vendor-selected");

    document.getElementById("payment-vendor").value = vendor;
}

$.ajax({
    async: true,
    "url": "/customerGetBill" ,
    "type": "get",
    "dataType": "json",
    "complete" :  (data) => {
        var bill = data.responseJSON;
        console.log(bill)
        document.getElementById("total-amount").textContent = "$ " + bill.payableAmount.toFixed(2);
    }
});