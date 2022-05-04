package honeyzstar.restaurantmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import honeyzstar.entity.Type;
import honeyzstar.entity.Status;

import honeyzstar.entity.MenuItem;

public class RestaurantManagerUpdateMenuItemC extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int menuItemID = Integer.parseInt(request.getParameter("menuItemID"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");
        String desc = request.getParameter("descriptions");
        String image = request.getParameter("imageDataURL");

        MenuItem newMenuItem = new MenuItem(menuItemID, name, Type.valueOf(type), price, desc, Status.valueOf(status) , image);
        
        if(newMenuItem.updateMenuItem()){
            response.sendRedirect("/update-menu-item.html?status=success");
        }
        else{
            response.sendRedirect("/update-menu-item.html?status=fail");
        }
    }
}
