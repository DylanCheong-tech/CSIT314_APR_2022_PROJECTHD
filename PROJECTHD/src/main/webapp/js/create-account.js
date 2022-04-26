
var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "success"){
    window.alert("Create Account Successfull");

    window.location.href = "/create-account.html";
}
else if (status == "fail"){
    window.alert("Create Account Fail");

    window.location.href = "/create-account.html";
}