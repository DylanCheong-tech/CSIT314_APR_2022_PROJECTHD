let sample_data = [
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"},
    {id : 1, name: "json", desc : "abc"}
]

var list_frame = document.getElementById("role-list");

for (index in sample_data)
{
    var row = document.createElement("tr");
    var form = document.createElement("form");
    form.id = "form" + (index+1);

    for (item in sample_data[index])
    {
        var column = document.createElement("td");
        column.innerHTML = sample_data[index][item];

        row.appendChild(column);
    }

    var btnCol = document.createElement("td");
    var button = document.createElement("button");
    button.innerHTML = "Update";
    // function binding --> <function_name>.bind(event, <parameters if any>)

    button.onclick = () => {window.alert("Testing")};

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    row.appendChild(form);

    console.log(row);
    
    list_frame.appendChild(row);

    console.log(list_frame);
}

setInterval(() => {
    var currentDate = new Date();
    var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
    var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

    document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);

function redirectToPortal() {
    window.location.href = "./user-admin-portal.html";
    // window.location.assign("./user-admin-portal.html"); // works like above, not sure whats the difference
    //  window.location.replace("./user-admin-portal.html"); // no record in history so back button doesnt work
}

function displayLogout () {
    window.confirm("Are you sure want to logout ? ");
}

// need to scale updateRole()/submitUpdate()
var updateBtn = document.getElementById("update-btn");
var submitBtn = document.getElementById("submit-btn");

function updateRole() {
    updateBtn.style.display = 'none';
    submitBtn.style.display = 'inline';
    document.getElementById("id1").readOnly = false;
    document.getElementById("name1").readOnly = false;
    document.getElementById("desc1").readOnly = false;
}

var new_id;
var new_name;
var new_desc;

function submitUpdate() {
    new_id = document.getElementById("id1").value;
    new_name = document.getElementById("name1").value;
    new_desc = document.getElementById("desc1").value;
    console.log(new_id); // update db
    console.log(new_name); // update db
    console.log(new_desc); // update db
    document.getElementById("id1").readOnly = true;
    document.getElementById("name1").readOnly = true;
    document.getElementById("desc1").readOnly = true;
    submitBtn.style.display = 'none';
    updateBtn.style.display = 'inline';
}


