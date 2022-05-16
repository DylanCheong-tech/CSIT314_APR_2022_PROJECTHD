package honeyzstar.customer;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import honeyzstar.entity.Bill;

public class CustomerApplyCouponC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String couponCode = request.getQueryString().split("=")[1];

        HttpSession session = request.getSession();
        int billID = Integer.parseInt(session.getAttribute("billID").toString());

        Bill bill = (new Bill(billID)).getBill();

        try {
            JsonObject returnObj = new JsonObject();
            if (bill.applyCoupon(couponCode)){
                returnObj.addProperty("status", "success");
            }else {
                returnObj.addProperty("status", "fail");
            }
            out.println((new Gson()).toJson(returnObj));
        } finally {
            out.close();
        }
       
    }
}
