import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import honeyzstar.entity.*;

public class BillTestDataGenerator {
	public static void main(String[] args) {
		final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		final String dbusername = "root";
		final String dbpassword = "";

		String emailStart = "email";
		String emailEnd = "@gmail.com";
		String code = "Coupon";
		ArrayList<Integer> orderIDArray = new ArrayList<Integer>();
		int[] paidTime = new int[3];
		paidTime[0] = 30;
		paidTime[1] = 40;
		paidTime[2] = 50;
		
		for (int i = 0; i < 100; i++) {
			
			Random rn = new Random();
			int randomOrderID = rn.nextInt(100) + 1 ;
			int randomCouponID = rn.nextInt(100) + 1 ;
			int randomCode = rn.nextInt(100) + 1 ;
			int randomValue = rn.nextInt(2);
			int randomPaidTime = rn.nextInt(3);
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(order.getCreatedAt(), formatter);
			dateTime = dateTime.plusMinutes(paidTime[randomPaidTime]);
			String stringDate = formatter.format(dateTime);
			
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

	            PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO BILL (OrderID, CreatedAt, PaidAt) VALUES (?, ?, ?)");
	            stmt1.setInt(1, bill.getOrder().getOrderID());
	            stmt1.setString(2, order.getCreatedAt());
	            stmt1.setString(3, stringDate); 

	            stmt1.executeUpdate();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

			if(randomValue == 0) {
				bill.applyCoupon(code + String.valueOf(randomCode));
			}
			
			bill = bill.getBill();
			
			
			bill.setEmail(emailStart + String.valueOf(i+1) + emailEnd);
			bill.makePayment(bill.getEmail());
		
		
			
		}
	}
}