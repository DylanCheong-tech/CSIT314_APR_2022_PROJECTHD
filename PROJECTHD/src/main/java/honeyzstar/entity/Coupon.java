package honeyzstar.entity;

import java.sql.*;
import java.util.ArrayList;


public class Coupon {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername = "root";
	private static final String dbpassword = "";
	private int couponID;
	private String name;
	private String code;
	private DiscountType discountType;
	private double discountAmount;
	private String descriptions;
	private CouponStatus status;

	
	public Coupon() {
		this.name = "";
		this.code = "";
		this.discountType = null;
		this.discountAmount = 0.0;
		this.descriptions = "";
		this.status = null;
	}

	public Coupon(int id, String code, String name, String descriptions, DiscountType discountType, double discountAmount, CouponStatus status) {
		this.couponID = id;
		this.name = name;
		this.code = code;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
	}
	
	public Coupon(String name, String code, DiscountType discountType, double discountAmount, String descriptions, CouponStatus status) {
		this.name = name;
		this.code = code;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
	}
	

	public Coupon(int id) {
		this.couponID = id;
	}

	public Coupon(String name) {
		this.name = name;
	}
	
	public boolean createCoupon() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Coupon (Code, Name, DiscountType, discountAmount, Descriptions, Status) VALUES (?, ?, ?, ?, ?, ?)");

			stmt.setString(1, this.code);
			stmt.setString(2, this.name);
			stmt.setString(3,  String.valueOf(this.discountType));
			stmt.setDouble(4,  this.discountAmount);
			stmt.setString(5, this.descriptions);
			stmt.setString(6,  String.valueOf(this.status));

			stmt.executeUpdate();

			System.out.println("Inserted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCoupon() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Coupon WHERE CouponID = ?");

			stmt.setInt(1, this.couponID);

			stmt.executeUpdate();

			System.out.println("Deleted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean updateCoupon() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE Coupon SET Code = ?, Name = ?, DiscountType = ?, discountAmount = ?, Descriptions = ?, Status = ? WHERE CouponID = ?");

			stmt.setString(1, this.code);
			stmt.setString(2, this.name);
			stmt.setString(3,  String.valueOf(discountType));
			stmt.setDouble(4,  this.discountAmount);
			stmt.setString(5, this.descriptions);
			stmt.setString(6,  String.valueOf(this.status));
			stmt.setInt(7, this.couponID);
			
			stmt.executeUpdate();

			System.out.println("Updated Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Coupon searchCoupon() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Coupon WHERE Name = ? ");

			stmt.setString(1, this.name);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.setCouponID(result.getInt("CouponID"));
				this.setCode(result.getString("Code"));
				this.setName(result.getString("Name"));
				this.setDescriptions(result.getString("Descriptions"));
				this.setDiscountType(DiscountType.valueOf(result.getString("DiscountType")));
				this.setDiscountAmount(result.getDouble("DiscountAmount"));
				this.setStatus(CouponStatus.valueOf(result.getString("Status")));
				System.out.println("Searched Successfully");
				return this;
			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Coupon getCoupon() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Coupon WHERE CouponID = ? ");

			stmt.setInt(1, this.couponID);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.setCouponID(result.getInt("CouponID"));
				this.setCode(result.getString("Code"));
				this.setName(result.getString("Name"));
				this.setDescriptions(result.getString("Descriptions"));
				this.setDiscountType(DiscountType.valueOf(result.getString("DiscountType")));
				this.setDiscountAmount(result.getDouble("DiscountAmount"));
				this.setStatus(CouponStatus.valueOf(result.getString("Status")));
				System.out.println("Searched Successfully");
				return this;
			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Coupon> getCouponList() {
		ArrayList<Coupon> returnArray = new ArrayList<Coupon>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Coupon");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("CouponID");
				String code = result.getString("Code");
				String name = result.getString("Name");
				String descriptions = result.getString("Descriptions");
				String discountType = result.getString("DiscountType");
				double discountAmount = result.getDouble("DiscountAmount");
				String status = result.getString("Status");
				
				returnArray.add(new Coupon(id, code, name, descriptions, DiscountType.valueOf(discountType), discountAmount, CouponStatus.valueOf(status)));
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}

	public int getCouponID() {
		return couponID;
	}

	public void setCouponID(int couponID) {
		this.couponID = couponID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public CouponStatus getStatus() {
		return status;
	}

	public void setStatus(CouponStatus status) {
		this.status = status;
	}
}
