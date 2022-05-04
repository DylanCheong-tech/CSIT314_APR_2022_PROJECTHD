import java.util.ArrayList;
import java.util.Random;
import java.sql.*;

import honeyzstar.entity.Coupon;
import honeyzstar.entity.Status;
import honeyzstar.entity.DiscountType;

public class CouponTestDataGenerator {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername  = "root";
	private static final String dbpassword = "";
	
	public CouponTestDataGenerator() {
		
	}
	
	public static void main(String[] args) {
		ArrayList<DiscountType> discountTypeArray = new ArrayList<DiscountType>();
		discountTypeArray.add(DiscountType.Percentage);
		discountTypeArray.add(DiscountType.Value);		
		discountTypeArray.add(DiscountType.OnetoOne);
		
		ArrayList<Status> statusArray = new ArrayList<Status>();
		statusArray.add(Status.Available);
		statusArray.add(Status.Unavailable);
		
		ArrayList<Coupon> couponArray = new ArrayList<Coupon>();
		
		String name = "Test Coupon ";
		String code = "Test Code ";
		
		
		
		for(int i=0; i<100; i++) {
			Double min = 1.0;
	        Double max = 10.0;
	        double x = (Math.random() * ((max - min) + 1)) + min;
	        double xrounded = Math.round(x * 100.0) / 100.0; 
	        
			Random rn = new Random();
			int statusRandom = rn.nextInt(2);
			int typeRandom = rn.nextInt(3);
			String iString = String.valueOf(i + 1);
			
			Coupon coupon = new Coupon(name + iString, code + iString, discountTypeArray.get(typeRandom), xrounded, "this is a Coupon " + iString, statusArray.get(statusRandom));
			couponArray.add(item);
			
		}
		
		for(Coupon coupon: couponArray) {
			try (

					Connection conn = DriverManager.getConnection(
							connStr, dbusername, dbpassword);

			) {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Coupon (Name, Code, DiscountType, discountAmount, Descriptions, Status, UpdatedAt) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)");

				stmt.setString(1, coupon.name);
				stmt.setString(2, coupon.code);
				stmt.setString(3,  String.valueOf(coupon.discountType));
				stmt.setDouble(4,  coupon.discountAmount);
				stmt.setString(5, coupon.descriptions);
				stmt.setString(6,  String.valueOf(coupon.status));

				stmt.executeUpdate();

				System.out.println("Inserted Successfully");

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
}
