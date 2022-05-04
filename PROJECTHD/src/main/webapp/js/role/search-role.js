var params = new URLSearchParams(window.location.search);
var status = params.get("status");
var alert_box = document.getElementById("alert-box");
var alert_box_msg = document.getElementById("alert-message");

function show_confrim_btn() {
  var hide_btn = document.getElementsByClassName("confirm-btn");
  for (index in hide_btn) {
      hide_btn.item(index).style.display = "inline-block";
  }
}

function alert_confirm() {
    alert_box.style.display = "none";
}

var role_list = $.ajax({
  async: false,
  "url": "/getRoleList",
  "type": "get",
  "dataType": "json"
}).responseJSON;

function displayRoleList(json_list) {
  var list_frame = document.getElementById("role-list");

  for (index in json_list) {
    var row = document.createElement("tr");
    row.id = "record-" + (parseInt(index) + 1);

    var column1 = document.createElement("td");
    column1.classList.add("mode-font-color");
    column1.classList.add("mode-border-color-1");
    column1.innerHTML = json_list[index].roleID;
    row.appendChild(column1);

    var column2 = document.createElement("td");
    column2.classList.add("mode-font-color");
    column2.classList.add("mode-border-color-1");
    column2.innerHTML = json_list[index].name;
    row.appendChild(column2);

    var column3 = document.createElement("td");
    column3.classList.add("mode-font-color");
    column3.classList.add("mode-border-color-1");
    column3.innerHTML = json_list[index].descriptions;
    row.appendChild(column3);

    list_frame.appendChild(row);
  }
}

function searchRole() {
  document.getElementById("back-btn-frame").style.display = "block";

  var roleName = document.getElementById("search-bar").value;

  var requested_json = $.ajax({
    async: false,
    "url": "/searchRole?name=" + roleName,
    "type": "get",
    "dataType": "json"
  }).responseJSON;

  var list_frame = document.getElementById("role-list");

  if (!requested_json) {
    show_confrim_btn();
    alert_box_msg.textContent = "Search Role Fail";
    alert_box.style.display = "inline-block";
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
  // current theme from the page-theme.js
  display_theme(current_theme);
}

// display all the role list
displayRoleList(role_list);

function back () {
  document.getElementById("back-btn-frame").style.display = "none";
  document.getElementById("search-bar").value = "";

  var list_frame = document.getElementById("role-list");
  // remove all the list first
  var firstChild = list_frame.firstElementChild;
  while (firstChild) {
      firstChild.remove();
      firstChild = list_frame.firstElementChild;
  }

  displayRoleList(role_list);
}