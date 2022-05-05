package honeyzstar.restaurantmanager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import honeyzstar.entity.Coupon;

public class RestaurantManagerGetCouponListC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        ArrayList<Coupon> returnList = new ArrayList<Coupon>();

        try {

            returnList = Coupon.getCouponList();

            out.println(new Gson().toJson(returnList));

        } finally {
            out.close();
        }

    }
}
