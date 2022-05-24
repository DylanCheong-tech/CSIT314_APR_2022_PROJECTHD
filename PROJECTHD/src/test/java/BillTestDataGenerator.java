import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import honeyzstar.entity.*;

public class BillTestDataGenerator {
	public static void main(String[] args) {
		final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		final String dbusername = "root";
		final String dbpassword = "";

		String email = "";
		String code = "Coupon";
		ArrayList<Integer> orderIDArray = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			
			Random rn = new Random();
			int randomOrderID = rn.nextInt(100) + 1 ;
			int randomCouponID = rn.nextInt(100) + 1 ;
			int randomCode = rn.nextInt(100) + 1 ;
			int randomValue = rn.nextInt(2);
			int randomEmail = rn.nextInt(2);
			
			if(!orderIDArray.contains(randomOrderID)) {
				orderIDArray.add(randomOrderID);
			}else {
				do {
					randomOrderID = rn.nextInt(100) + 1;
				}while(orderIDArray.contains(randomOrderID));
			}
			
			Order order = new Order();
			order.setOrderID(randomOrderID);
			order.getOrder();
			
			Coupon coupon = new Coupon();
			coupon.setCouponID(randomCouponID);
			
			Bill bill = new Bill();
			bill.setOrder(order);
			
			try (

	                Connection conn = DriverManager.getConnection(
	                        connStr, dbusername, dbpassword);

	        ) {

	            PreparedStatement stmt = conn.prepareStatement(
	                    "select auto_increment from information_schema.tables where table_name = 'Bill'");
	            ResultSet result = stmt.executeQuery();
	            if (result.next()) {
	                bill.setBillID(result.getInt("auto_increment"));
	            }

	            PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO BILL (OrderID, CreatedAt) VALUES (?, ?)");
	            stmt1.setInt(1, bill.getOrder().getOrderID());
	            stmt1.setString(2, order.getCreatedAt());

	            stmt1.executeUpdate();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

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