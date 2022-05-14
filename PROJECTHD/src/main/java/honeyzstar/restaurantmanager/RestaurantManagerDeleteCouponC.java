package honeyzstar.restaurantmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import honeyzstar.entity.Coupon;

public class RestaurantManagerDeleteCouponC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int couponID = Integer.parseInt(request.getParameter("couponID"));

        Coupon coupon = new Coupon(couponID);
        
        if(coupon.deleteCoupon()){
            response.sendRedirect("/restaurantmanager/delete-coupon.html?status=success");
        }
        else{
            response.sendRedirect("/restaurantmanager/delete-coupon.html?status=fail");
        }
    }
}
