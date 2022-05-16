package honeyzstar.customer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Bill;

public class CustomerViewBillC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        int billID = Integer.parseInt(session.getAttribute("billID").toString());

        Bill viewBill = new Bill(billID);
        viewBill.getBill();

        try {
            out.println(new Gson().toJson(viewBill));

        } finally {
            out.close();
        }

    }
}
