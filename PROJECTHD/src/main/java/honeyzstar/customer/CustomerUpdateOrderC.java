package honeyzstar.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Order;

public class CustomerUpdateOrderC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int menuItemID = Integer.parseInt(request.getParameter("menuItemID"));
        int qty = Integer.parseInt(request.getParameter("qty"));

        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());

        Order order = (new Order(orderID)).getOrder();

        if (order.updateMenuItem(menuItemID, qty)) {
            response.sendRedirect("/customer/main-menu-page.html");
        }else {
            response.sendRedirect("/customer/home-page.html?status=fail");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] queryData = request.getQueryString().split("&");

        int menuItemID = Integer.parseInt(queryData[0].split("=")[1]);
        int qty = Integer.parseInt(queryData[1].split("=")[1]);

        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());

        Order order = (new Order(orderID)).getOrder();

        try {
            if (order.updateMenuItem(menuItemID, qty)) {
                out.println(new Gson().toJson("{'status' : 'success'}"));
            }else {
                out.println(new Gson().toJson("{'status' : 'fail'}"));
            }
        } finally {
            out.close();
        }
       
    }
}
