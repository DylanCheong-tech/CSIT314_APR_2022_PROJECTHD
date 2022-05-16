package honeyzstar.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import honeyzstar.entity.Order;

public class CustomerSubmitOrderC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());

        Order order = (new Order(orderID)).getOrder();

        if (order.submitOrder()) {
            response.sendRedirect("/customer/main-menu-page.html");
        }else {
            response.sendRedirect("/customer/home-page.html?status=fail");
        }
    }
}

