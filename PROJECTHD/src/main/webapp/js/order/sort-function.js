function sort(select_id) {
    var sort_criteria = document.getElementById(select_id).value;

    if (sort_criteria == "id"){
        order_list.sort((a, b) => {
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
    else if (sort_criteria == "tableNumber"){
        order_list.sort((a, b) => {
            if (a.tableNum < b.tableNum){
                return -1;
            }
            else if (a.tableNum > b.tableNum){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "amount"){
        order_list.sort((a, b) => {
            if (a.totalAmount < b.totalAmount){
                return -1;
            }
            else if (a.totalAmount > b.totalAmount){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "createdBy"){
        order_list.sort((a, b) => {
            if (a.createdBy.name.toLowerCase() < b.createdBy.name.toLowerCase()){
                return -1;
            }
            else if (a.createdBy.name.toLowerCase() > b.createdBy.name.toLowerCase()){
                return 1;
            }
            else{
                return 0;
            }
        });
    }
    else if (sort_criteria == "status"){
        order_list.sort((a, b) => {
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

    var list_frame = document.getElementById("order-list");
    // remove all the list first
    var firstChild = list_frame.firstElementChild;
    while (firstChild) {
        firstChild.remove();
        firstChild = list_frame.firstElementChild;
    }

    display_list(order_list);

}