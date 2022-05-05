package honeyzstar.restaurantmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import honeyzstar.entity.MenuItem;

public class RestaurantManagerDeleteMenuItemC extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int menuItemID = Integer.parseInt(request.getParameter("menuItemID"));
        MenuItem menuItem = new MenuItem(menuItemID);
        
        if(menuItem.deleteMenuItem()){
            response.sendRedirect("/delete-menu-item.html?status=success");
        }
        else{
            response.sendRedirect("/delete-menu-item.html?status=fail");
        }
    }
}
