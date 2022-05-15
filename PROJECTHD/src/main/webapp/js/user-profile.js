var params = new URLSearchParams(window.location.search);
var userID = params.get("userID");
if (userID){
    window.localStorage.setItem("userID", userID);
}
    
$.ajax({
    async: true,
    "url": "/getAccount?accountID=" + window.localStorage.getItem("userID"),
    "type": "get",
    "dataType": "json",
    "complete": (data) => {
        var account = data.responseJSON;
        document.getElementById("user-name").textContent = ": " + account.name;
        document.getElementById("user-id").textContent = ": " + account.accountID;
        document.getElementById("user-login-id").textContent = ": " + account.username;
        document.getElementById("user-access-right").textContent = ": " + account.role.name;
    }
});