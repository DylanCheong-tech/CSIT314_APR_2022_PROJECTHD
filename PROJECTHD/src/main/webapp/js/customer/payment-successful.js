$.ajax({
    async: true,
    "url": "/customerGetBill",
    "type": "get",
    "dataType": "json",
    "complete": (data) => {
        var bill = data.responseJSON;
        document.getElementById("bill-id").textContent = bill.billID;
        document.getElementById("amount-paid").textContent = "$ " + bill.payableAmount.toFixed(2);

        var params = new URLSearchParams(window.location.search);
        var merchant = params.get("merchant");
        document.getElementById("merchant").textContent = merchant;
    }
});