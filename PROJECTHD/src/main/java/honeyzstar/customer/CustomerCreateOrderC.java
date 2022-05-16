package honeyzstar.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.HashMap;

import honeyzstar.entity.Order;
import honeyzstar.entity.Bill;

public class CustomerCreateOrderC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int tableNum = Integer.parseInt(request.getParameter("tableNum"));

        HashMap<Integer, Integer> menuItems = new HashMap<>();

        Order newOrder = new Order(tableNum, null, menuItems);

        HttpSession session = request.getSession();

        if (newOrder.createOrder()) {
            if (session.getAttribute("orderID") == null || Integer.parseInt(session.getAttribute("orderID").toString()) != newOrder.getOrderID()) {
                session.setAttribute("orderID", newOrder.getOrderID());
                session.setMaxInactiveInterval(60 * 60);
            }

            Bill newBill = new Bill(newOrder);
            if (newBill.createBill()){
                if (session.getAttribute("billID") == null || Integer.parseInt(session.getAttribute("billID").toString()) != newOrder.getOrderID()) {
                    session.setAttribute("billID", newBill.getBillID());
                    session.setMaxInactiveInterval(60 * 60);
                }
            }

            response.sendRedirect("/customer/main-menu-page.html");
        }else {
            response.sendRedirect("/customer/home-page.html?status=fail");
        }
    }
}
