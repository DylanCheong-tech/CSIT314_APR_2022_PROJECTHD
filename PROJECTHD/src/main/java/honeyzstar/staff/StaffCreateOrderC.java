package honeyzstar.staff;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.HashMap;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import honeyzstar.entity.Account;
import honeyzstar.entity.Order;

public class StaffCreateOrderC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int tableNum = Integer.parseInt(request.getParameter("tableNum"));
        String menuItemsJSON = request.getParameter("menuItems");

        Type menuItemType = new TypeToken<HashMap<Integer, Integer>>(){}.getType();

        HashMap<Integer, Integer> menuItems = (new Gson()).fromJson(menuItemsJSON, menuItemType);

        Account staff = Account.getAccount(3);
        Order newOrder = new Order(tableNum, staff, menuItems);

        if (newOrder.createOrder()) {
            response.sendRedirect("/staff-create-order.html?status=success");
        }else {
            response.sendRedirect("/staff-create-order.html?status=fail");
        }
    }
}
