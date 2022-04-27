setInterval(() => {
  var currentDate = new Date();
  var date = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1) + '-' + currentDate.getDate();
  var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds();

  document.getElementById("header-date-time").innerHTML = date + "      " + time;
}, 1000);


function displayLogout() {
  window.confirm("Are you sure want to logout ? ");
}

let sample_data = [
  {roleID : 1, name: "json", descriptions : "abc"},
  {roleID : 1, name: "json", descriptions : "abc"},
  {roleID : 1, name: "json", descriptions : "abc"},
  {roleID : 1, name: "json", descriptions : "abc"},
  {roleID : 1, name: "json", descriptions : "abc"}
]


function displayRoleList(json_list) {
  var list_frame = document.getElementById("role-list");

  for (index in json_list) {
      var row = document.createElement("tr");
      row.id = "record-" + (parseInt(index) + 1);
  
      var column1 = document.createElement("td");
      column1.innerHTML = json_list[index].roleID;
      row.appendChild(column1);
  
      var column2 = document.createElement("td");
      column2.innerHTML = json_list[index].name;
      row.appendChild(column2);
  
      var column3 = document.createElement("td");
      column3.innerHTML = json_list[index].descriptions;
      row.appendChild(column3);
  
      list_frame.appendChild(row);
  }
}

function searchRole() {
  var roleName = document.getElementById("search-bar").value;

  var requested_json = $.ajax({
      async :false,
      "url": "/searchRole?name=" + roleName,
      "type": "get",
      "dataType": "json"
  }).responseJSON;

  var list_frame = document.getElementById("role-list");

  if (!requested_json){
      window.alert("Search Role Fail");
      return;
  }

  // remove all the list first
  var firstChild = list_frame.firstElementChild;
  while (firstChild) {
      firstChild.remove();
      firstChild = list_frame.firstElementChild;
  }

  let result_list = [requested_json];

  displayRoleList(result_list);
}

// demo purpose 
displayRoleList(sample_data);