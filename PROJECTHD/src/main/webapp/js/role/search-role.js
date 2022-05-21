function display_list(json_list) {
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

$.ajax({
  async: true,
  "url": "/getRoleList",
  "type": "get",
  "dataType": "json",
  "complete": (data) => {
    display_list(data.responseJSON);
    hide_loader();
  }
});