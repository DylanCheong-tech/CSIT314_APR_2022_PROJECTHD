import java.util.HashMap;
import java.util.Random;

import honeyzstar.entity.Order;
import honeyzstar.entity.Account;

public class OrderTestDataGenerator {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {

			Random rn = new Random();
			int randomNumberOfItems = rn.nextInt(14) + 2 ;
			int randomStaff = rn.nextInt(20) + 1 ;
			int randomTableNum = rn.nextInt(50) + 1 ;
			
			Account acc = new Account();
	    	acc.setID(randomStaff);
			
			Order order = new Order();
			order.setTableNum(randomTableNum);
			order.setCreatedBy(acc);
			
			HashMap<Integer, Integer> menuItems = new HashMap<Integer, Integer>();
			for(int j = 0; j < randomNumberOfItems; j++) {
				int randomQuantity = rn.nextInt(10) + 1 ;
				int randomMenuItemID = rn.nextInt(100) + 1 ;
				menuItems.put(randomMenuItemID, randomQuantity);
			}
			
			order.setOrderItems(menuItems);
			
			order.createOrder();
		}
	}
}
