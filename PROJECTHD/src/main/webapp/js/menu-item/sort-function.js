function sort(select_id) {
    var sort_criteria = document.getElementById(select_id).value;


    if (sort_criteria == "id"){
        menu_item_list.sort((a, b) => {
            if (a.menuItemID < b.menuItemID){
                return -1;
            }
            else if (a.menuItemID > b.menuItemID){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "name"){
        // menu item list from the search-menu-item.js file
        menu_item_list.sort((a, b) => {
            if (a.name.toLowerCase() < b.name.toLowerCase()){
                return -1;
            }
            else if (a.name.toLowerCase() > b.name.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "type"){
        menu_item_list.sort((a, b) => {
            if (a.type.toLowerCase() < b.type.toLowerCase()){
                return -1;
            }
            else if (a.type.toLowerCase() > b.type.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "price"){
        menu_item_list.sort((a, b) => {
            if (a.price < b.price){
                return -1;
            }
            else if (a.price > b.price){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "status"){
        menu_item_list.sort((a, b) => {
            if (a.status.toLowerCase() < b.status.toLowerCase()){
                return -1;
            }
            else if (a.status.toLowerCase() > b.status.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "dateCreated"){
        menu_item_list.sort((a, b) => {
            if (a.createdAt.toLowerCase() < b.createdAt.toLowerCase()){
                return -1;
            }
            else if (a.createdAt.toLowerCase() > b.createdAt.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "lastUpdated"){
        menu_item_list.sort((a, b) => {
            if (a.updatedAt.toLowerCase() < b.updatedAt.toLowerCase()){
                return -1;
            }
            else if (a.updatedAt.toLowerCase() > b.updatedAt.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }

    var list_frame = document.getElementById("menu-item-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    display_list(menu_item_list);
}