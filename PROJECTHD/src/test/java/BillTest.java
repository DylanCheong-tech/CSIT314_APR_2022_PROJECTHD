import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import honeyzstar.entity.Bill;
import honeyzstar.entity.BillStatus;
import honeyzstar.entity.Order;
import honeyzstar.entity.Coupon;

public class BillTest {
    private Bill testBill;

    @Before
    public void setup() throws Exception {
        this.testBill = new Bill();
    }

    @After
    public void tearDown() throws Exception {
        this.testBill = null;
    }

    @Test
    public void testCreateBill() {
        this.testBill.setOrder(new Order(3));
        assertTrue("Test Creating Bill", this.testBill.createBill());
    }

    @Test
    public void testApplyCoupon() {
        assertTrue("Test Applying Coupon", this.testBill.applyCoupon("Coupon6"));
        assertEquals("Inspecting the coupon attribute in the bill object", (new Coupon(6).getCoupon()),
                this.testBill.getCoupon());
    }

    @Test
    public void testGetBill() {
        this.testBill.setBillID(1);
        Bill expectedBill = new Bill(1, "2022-05-16 10:25:15", (new Order(3).getOrder()), "avccs@gmail.com", (new Coupon(2)).getCoupon(), 0.00, 0.00, 0.00, "2022-05-16 11:19:09", BillStatus.valueOf("Unpaid"));
        System.out.println(this.testBill.getBill());
        assertEquals("Test Get the Bill object", expectedBill, this.testBill.getBill());
    }

    @Test
    public void testMakePayment (){
        this.testBill.setBillID(1);
        this.testBill.getBill();
        assertTrue("Test Making Payment", this.testBill.makePayment("abc@gmail.com"));
    }
}