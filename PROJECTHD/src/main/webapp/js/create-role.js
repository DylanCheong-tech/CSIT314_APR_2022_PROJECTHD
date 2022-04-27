var params = new URLSearchParams(window.location.search);
var status = params.get("status");

if (status == "success"){
    window.alert("Create Role Successfull");

    window.location.href = "/create-role.html";
}
else if (status == "fail"){
    window.alert("Create Role Fail");

    window.location.href = "/create-role.html";
}

function createRoles()
{
    var roleName = document.getElementById("roleID").value;
    window.alert("Create Roles Successful");
    //connect to database
    //add role to database
    //if success
    alert("Create Role Successful");
    //else
    //alert("Create Roles fail");
    

}

setInterval(() => 
{
    var currentDate = new Date();
    var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
    var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

    document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);

function userAdminPortal()
{
    window.location.href="/user-admin-portal.html";
}

function displayLogout () 
{
    window.confirm("Are you sure want to logout ? ");
}
