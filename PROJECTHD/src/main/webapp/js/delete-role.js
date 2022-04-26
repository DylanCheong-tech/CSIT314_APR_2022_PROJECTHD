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
    button.innerHTML = "Delete";
    // function binding --> <function_name>.bind(event, <parameters if any>)

    button.onclick = () => {window.alert("Testing")};

    btnCol.appendChild(button);
    row.appendChild(btnCol);

    row.appendChild(form);

    console.log(row);
    
    list_frame.appendChild(row);

    console.log(list_frame);
}
