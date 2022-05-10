package honeyzstar.restaurantmanager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson;

import honeyzstar.entity.Coupon;

public class RestaurantManagerSearchCouponC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // replacing the query string <space> encoded value if any
            String code = request.getQueryString().split("=")[1].replaceAll("%20", " ");

            Coupon resultCoupon = (new Coupon(code)).searchCoupon();

            if (resultCoupon == null) {
                out.println(new Gson().toJson(null));
            } else {
                out.println(new Gson().toJson(resultCoupon));
            }

        } finally {
            out.close();
        }

    }
}
