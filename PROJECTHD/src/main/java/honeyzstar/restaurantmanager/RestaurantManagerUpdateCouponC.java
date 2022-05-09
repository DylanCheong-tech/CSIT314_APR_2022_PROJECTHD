package honeyzstar.restaurantmanager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import honeyzstar.entity.DiscountType;
import honeyzstar.entity.CouponStatus;

import honeyzstar.entity.Coupon;

public class RestaurantManagerUpdateCouponC extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int couponID = Integer.parseInt(request.getParameter("couponID"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String discountType = request.getParameter("discountType");
        double discountAmount = Double.parseDouble(request.getParameter("discountAmount"));
        String status = request.getParameter("status");
        String desc = request.getParameter("descriptions");

        Coupon updateCoupon = new Coupon(couponID, code, name, desc,  DiscountType.valueOf(discountType), discountAmount, CouponStatus.valueOf(status));
        
        if(updateCoupon.updateCoupon()){
            response.sendRedirect("/update-coupon.html?status=success");
        }
        else{
            response.sendRedirect("/update-coupon.html?status=fail");
        }
    }
}
