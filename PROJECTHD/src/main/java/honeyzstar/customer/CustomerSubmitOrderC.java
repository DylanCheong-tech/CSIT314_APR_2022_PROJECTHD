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
        boolean redirect = Boolean.parseBoolean(request.getParameter("redirect-to-bill"));

        Order order = (new Order(orderID)).getOrder();

        if (order.submitOrder()) {
            if (redirect){
                response.sendRedirect("/customer/bill-page.html");
            }else{
                response.sendRedirect("/customer/main-menu-page.html");
            }
        }else {
            response.sendRedirect("/customer/home-page.html?status=fail");
        }
    }
}

