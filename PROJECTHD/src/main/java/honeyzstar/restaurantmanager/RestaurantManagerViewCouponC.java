package honeyzstar.restaurantmanager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Coupon;

public class RestaurantManagerViewCouponC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int couponID = Integer.parseInt(request.getQueryString().split("=")[1]);

        Coupon viewCoupon = (new Coupon(couponID)).getCoupon();

        try {
            out.println(new Gson().toJson(viewCoupon));

        } finally {
            out.close();
        }

    }
}
