import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

import honeyzstar.entity.*;

public class BillTestDataGenerator {
	private static long getRandomTimeBetweenTwoDates () {
		long beginTime = Timestamp.valueOf("2020-01-01 10:00:00").getTime();

		long endTime = Timestamp.valueOf("2022-12-31 20:59:59").getTime();

	    long diff = endTime - beginTime + 1;
	    return beginTime + (long) (Math.random() * diff);
	}
	
	public static void main(String[] args) {
		final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	    final String dbusername = "root";
	    final String dbpassword = "";
		
		String email = "This is my email ";
		String code = "Coupon";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		for (int i = 0; i < 100; i++) {
			Date randomDate = new Date(getRandomTimeBetweenTwoDates());
			String date = dateFormat.format(randomDate);
			randomDate.getTime();
			
			
			
			Random rn = new Random();
			int randomOrderID = rn.nextInt(100) + 1 ;
			int randomCouponID = rn.nextInt(100) + 1 ;
			int randomCode = rn.nextInt(100) + 1 ;
			int randomValue = rn.nextInt(2);
			int randomEmail = rn.nextInt(2);
			
			Order order = new Order();
			order.setOrderID(randomOrderID);
			
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
	            stmt1.setString(2, date);

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