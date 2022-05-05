package honeyzstar.restaurantmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import honeyzstar.entity.MenuItemType;
import honeyzstar.entity.MenuItemStatus;

import honeyzstar.entity.MenuItem;

public class RestaurantManagerCreateMenuItemC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");
        String desc = request.getParameter("descriptions");
        String image = request.getParameter("imageDataURL");

        MenuItem newMenuItem = new MenuItem(name, MenuItemType.valueOf(type), price, desc, MenuItemStatus.valueOf(status) , image);
        
        if(newMenuItem.createMenuItem()){
            response.sendRedirect("/create-menu-item.html?status=success");
        }
        else{
            response.sendRedirect("/create-menu-item.html?status=fail");
        }
    }
}
