package honeyzstar.staff;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import honeyzstar.entity.Order;

public class StaffGetOrderList extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Order> returnList = new ArrayList<Order>();

        try {
            returnList = Order.getOrderList();

            out.println(new Gson().toJson(returnList));

        } finally {
            out.close();
        }

    }
}
