import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import honeyzstar.entity.*;

public class CouponTest {
	private Coupon testCoupon;

    @Before 
    public void init () throws Exception {
        this.testCoupon = new Coupon();
    }

    @After 
    public void tearDown () throws Exception {
        this.testCoupon = null;
    }

    @Test
    public void testCreateCoupon(){
    	this.testCoupon.setCode("code431");
    	this.testCoupon.setName("name431");
    	this.testCoupon.setDescriptions("this is a coupon431");
    	this.testCoupon.setDiscountType(DiscountType.Value);
    	this.testCoupon.setDiscountAmount(54.4);
    	this.testCoupon.setStatus(CouponStatus.Active);
    	
    	
    	assertTrue("Test Restaurant Manager Create Coupon", this.testCoupon.createCoupon());
    }
    
    @Test
    public void testDeleteCoupon (){
    	this.testCoupon.setCouponID(14);
    	this.testCoupon.setName("name5");
    	this.testCoupon.setCode("code5");
    	this.testCoupon.setDiscountType(DiscountType.Value);
    	this.testCoupon.setDiscountAmount(5.4);
    	this.testCoupon.setDescriptions("this is a coupon");
    	this.testCoupon.setStatus(CouponStatus.Active);
    	
        assertTrue("Test Restaurant Manager Delete Coupon", this.testCoupon.deleteCoupon());
    }
    
    @Test
    public void testUpdateCoupon() {
    	this.testCoupon.setCouponID(20);
    	this.testCoupon.setName("name4");
    	this.testCoupon.setCode("code4");
    	this.testCoupon.setDiscountType(DiscountType.Percentage);
    	this.testCoupon.setDiscountAmount(8.4);
    	this.testCoupon.setDescriptions("this is a coupon");
    	this.testCoupon.setStatus(CouponStatus.Active);
    	
    	
    	assertTrue("Test Restaurant Manager Update Coupon", this.testCoupon.updateCoupon());
    }
    
    @Test 
    public void testSearchCoupon (){
    	this.testCoupon.setCode("Coupon62");

		Coupon expectedCoupon = new Coupon(62, "Coupon62", "Test Coupon 62", "this is a Coupon 62", DiscountType.Percentage, 10.42, CouponStatus.Active);

        assertEquals("Test Restaurant Manager Search Coupon", expectedCoupon, this.testCoupon.searchCoupon());
    }
    
    @Test 
    public void testGetCoupon (){
    	this.testCoupon.setCouponID(25);

		Coupon expectedCoupon = new Coupon(25, "Coupon25", "Test Coupon 25", "this is a Coupon 25", DiscountType.Percentage, 6.39, CouponStatus.Expired);

        assertEquals("Test Restaurant Manager View Menu Item", expectedCoupon, this.testCoupon.getCoupon());
    }
    
    @Test 
    public void testGetCouponList() {
        assertTrue("Test Restaurant Manager Get Coupon List", Coupon.getCouponList() instanceof ArrayList);
    }
}
