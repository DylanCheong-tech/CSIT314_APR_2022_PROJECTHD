import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import honeyzstar.entity.*;

public class BillTestDataGenerator {
	public static void main(String[] args) {
		ArrayList<BillStatus> billStatus = new ArrayList<BillStatus>();
		billStatus.add(BillStatus.Paid);
		billStatus.add(BillStatus.Unpaid);
		
		String email = "This is my email ";
		String code = "Coupon";
		int count = 1;
		
		for (int i = 0; i < 100; i++) {
			Random rn = new Random();
			int randomOrderID = rn.nextInt(100) + 301 ;
			int randomCouponID = rn.nextInt(100) + 1 ;
			int randomCode = rn.nextInt(100) + 1 ;
			int randomBillStatus = rn.nextInt(2);
			int randomValue = rn.nextInt(2);
			int randomEmail = rn.nextInt(2);
			
			Order order = new Order();
			order.setOrderID(randomOrderID);
			
			Coupon coupon = new Coupon();
			coupon.setCouponID(randomCouponID);
			
			Bill bill = new Bill();
			bill.setOrder(order);
			
			bill.createBill();
			
			
			
			if(randomValue == 0) {
				bill.applyCoupon(code + String.valueOf(randomCode));
			}
			
			bill = bill.getBill();
			
			
			
			if(randomEmail == 1) {
				bill.setEmail(email + String.valueOf(i+1));
				bill.makePayment(bill.getEmail());
			}

			
			
			
		
		}
	}
}
