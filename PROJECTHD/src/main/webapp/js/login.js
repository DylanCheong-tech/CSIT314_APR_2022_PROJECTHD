var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "fail"){
    var inputs = document.getElementsByTagName("input");

    for (index in inputs){
        inputs.item(index).classList.add("login-fail");
    }

    document.getElementById("login-fail-msg").innerHTML = "Login Fail !";
}

function remove_fail_alert(){
    var inputs = document.getElementsByTagName("input");

    for (index in inputs){
        inputs.item(index).classList.remove("login-fail");
    }

    document.getElementById("login-fail-msg").innerHTML = "";
}

$.ajax({
    async : true,
    "url": "/getRoleList",
    "type": "get",
    "dataType": "json",
    "complete" : (data) => {
        var role_list = data.responseJSON;
        var select = document.getElementById("role-list");
        for (index in role_list) {
            var option = document.createElement("option");
            option.value = role_list[index].roleID;
            option.innerText = role_list[index].name;
            select.appendChild(option);
        }
    }
});

function updateLoginAction () {
    var form = document.getElementById("login-form");
    var roleID = document.getElementById("role-list").value;

    if (roleID == 1){
        form.action = "/loginRestaurantManager";
    }
    else if (roleID == 2){
        form.action = "/loginStaff";
    }
    else if (roleID == 3){
        form.action = "/loginRestaurantOwner";
    }
    else if (roleID == 4){
        form.action = "/loginUserAdmin";
    }
}