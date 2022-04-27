// function searchRoles()
// {

//     //connect to database
//     //query roleName
//     //..code here..


//     //go to another page.html [User story step 6-7]
//     var roleName = document.getElementById("roleName").value;
//     window.location.href="./webapp/search-results.html";
 
    
//     //for each roleName create table row, display roleName
//     //..code here..


//     //create button for going back to search-roles.html
//     let button = document.createElement("button");
//     button.innerHTML = "Back";
//     document.body.appendChild(button);
//     button.onclick = function visitPage()
//     {
//         window.location.href=".\webapp\search-roles.html";
//     }
//     //else
//     //alert("search Roles fail");
    

// }


function searchRoles() 
{
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchTextbox");
    filter = input.value.toUpperCase();
    table = document.getElementById("searchTable");
    tr = table.getElementsByTagName("tr");
  
    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
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