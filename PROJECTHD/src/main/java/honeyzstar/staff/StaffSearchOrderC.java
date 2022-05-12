package honeyzstar.staff;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;
import java.util.ArrayList;

import honeyzstar.entity.Order;

public class StaffSearchOrderC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // replacing the query string <space> encoded value if any
            int tableNum = Integer.parseInt(request.getQueryString().split("=")[1].replaceAll("%20", " "));

            Order order = new Order();
            order.setTableNum(tableNum);
            ArrayList<Order> resultOrders = order.searchOrder();

            out.println(new Gson().toJson(resultOrders));

        } finally {
            out.close();
        }

    }
}
