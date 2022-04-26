function searchRoles()
{

    //connect to database
    //query roleName
    //..code here..


    //go to another page.html [User story step 6-7]
    var roleName = document.getElementById("roleName").value;
    window.location.href="./webapp/search-results.html";
 
    
    //for each roleName create table row, display roleName
    //..code here..


    //create button for going back to search-roles.html
    let button = document.createElement("button");
    button.innerHTML = "Back";
    document.body.appendChild(button);
    button.onclick = function visitPage()
    {
        window.location.href=".\webapp\search-roles.html";
    }
    //else
    //alert("search Roles fail");
    

}