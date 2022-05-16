package honeyzstar.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import honeyzstar.entity.Bill;

public class CustomerMakePaymentC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        int billID = Integer.parseInt(session.getAttribute("billID").toString());

        String email = request.getParameter("email");

        Bill bill = (new Bill(billID)).getBill();

        if (bill.makePayment(email)) {

        }else {

        }
    }
}

