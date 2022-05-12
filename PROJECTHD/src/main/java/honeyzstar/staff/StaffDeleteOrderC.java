package honeyzstar.staff;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import honeyzstar.entity.Order;

public class StaffDeleteOrderC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        
        Order order = new Order(orderID);

        if (order.deleteOrder()) {
            response.sendRedirect("/staff-delete-order.html?status=success");
        }else {
            response.sendRedirect("/staff-delete-order.html?status=fail");
        }
    }
}
