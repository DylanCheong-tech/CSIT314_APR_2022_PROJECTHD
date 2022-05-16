package honeyzstar.customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Order;

public class CustomerViewOrderC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());

        Order viewOrder = new Order(orderID);
        viewOrder.getOrder();

        try {
            out.println(new Gson().toJson(viewOrder));

        } finally {
            out.close();
        }

    }
}
