import java.util.ArrayList;
import java.util.Random;
import java.sql.*;

import honeyzstar.entity.Coupon;
import honeyzstar.entity.CouponStatus;
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
		
		ArrayList<CouponStatus> statusArray = new ArrayList<CouponStatus>();
		statusArray.add(CouponStatus.Active);
		statusArray.add(CouponStatus.Expired);
		
		ArrayList<Coupon> couponArray = new ArrayList<Coupon>();
		
		String name = "Test Coupon ";
		String code = "Coupon";
		
		
		
		for(int i=0; i<100; i++) {
			Double min = 1.0;
	        Double max = 10.0;
	        double x = (Math.random() * ((max - min) + 1)) + min;
	        double xrounded = Math.round(x * 100.0) / 100.0; 
	        
			Random rn = new Random();
			int random = rn.nextInt(2);
			String iString = String.valueOf(i + 1);
			
			Coupon coupon = new Coupon(code + iString, name + iString, "this is a Coupon " + iString, discountTypeArray.get(random), xrounded,  statusArray.get(random));
			couponArray.add(coupon);
			
		}
		
		for(Coupon coupon: couponArray) {
			try (

					Connection conn = DriverManager.getConnection(
							connStr, dbusername, dbpassword);

			) {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Coupon (Name, Code, DiscountType, discountAmount, Descriptions, Status) VALUES (?, ?, ?, ?, ?, ?)");

				stmt.setString(1, coupon.getName());
				stmt.setString(2, coupon.getCode());
				stmt.setString(3,  String.valueOf(coupon.getDiscountType()));
				stmt.setDouble(4,  coupon.getDiscountAmount());
				stmt.setString(5, coupon.getDescriptions());
				stmt.setString(6,  String.valueOf(coupon.getStatus()));

				stmt.executeUpdate();

				System.out.println("Inserted Successfully");

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
}
