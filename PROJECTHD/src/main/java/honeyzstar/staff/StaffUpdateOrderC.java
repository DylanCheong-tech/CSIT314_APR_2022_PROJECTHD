package honeyzstar.staff;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.HashMap;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import honeyzstar.entity.Order;

public class StaffUpdateOrderC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int tableNum = Integer.parseInt(request.getParameter("tableNum"));
        String menuItemsJSON = request.getParameter("menuItems");

        Type menuItemType = new TypeToken<HashMap<Integer, Integer>>(){}.getType();

        HashMap<Integer, Integer> menuItems = (new Gson()).fromJson(menuItemsJSON, menuItemType);

        Order updateOrder = new Order(orderID, tableNum, menuItems);

        if (updateOrder.updateOrder()) {
            response.sendRedirect("/staff/staff-update-order.html?status=success");
        }else {
            response.sendRedirect("/staff/staff-update-order.html?status=fail");
        }
    }
}
