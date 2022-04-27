
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

var role_list = $.ajax({
    async: false,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json"
}).responseJSON;

var select = document.getElementById("role-list");
for (index in role_list) {
    var option = document.createElement("option");
    option.value = role_list[index].roleID;
    option.innerText = role_list[index].name;
    select.appendChild(option);
}