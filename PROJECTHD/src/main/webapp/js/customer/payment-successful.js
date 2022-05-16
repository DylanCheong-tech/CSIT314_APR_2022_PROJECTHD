$.ajax({
    async: true,
    "url": "/customerGetBill" ,
    "type": "get",
    "dataType": "json",
    "complete" :  (data) => {
        var bill = data.responseJSON;
        document.getElementById("bill-id").textContent = bill.billID;
        document.getElementById("amount-paid").textContent = "$ " +  bill.payableAmount.toFixed(2);
        document.getElementById("merchant").textContent = "00";
    }
});