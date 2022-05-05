package honeyzstar.restaurantmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import honeyzstar.entity.DiscountType;
import honeyzstar.entity.CouponStatus;

import honeyzstar.entity.Coupon;

public class RestaurantManagerCreateCouponC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String discountType = request.getParameter("discountType");
        double discountAmount = Double.parseDouble(request.getParameter("discountAmount"));
        String status = request.getParameter("status");
        String desc = request.getParameter("descriptions");

        Coupon newCoupon = new Coupon(name, code, DiscountType.valueOf(discountType), discountAmount, desc, CouponStatus.valueOf(status));
        
        if(newCoupon.createCoupon()){
            response.sendRedirect("/create-coupon.html?status=success");
        }
        else{
            response.sendRedirect("/create-coupon.html?status=fail");
        }
    }
}
