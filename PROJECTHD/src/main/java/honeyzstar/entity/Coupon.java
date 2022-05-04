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
	private Status status;
	private Date createdAt;
	private Date UpdatedAt;

	
	public Coupon() {
		this.name = "";
		this.code = "";
		this.discountType = null;
		this.discountAmount = 0.0;
		this.descriptions = "";
		this.status = null;
		this.createdAt = null;
		this.UpdatedAt = null;
	}
	
	public Coupon(String name, String code, DiscountType discountType, double discountAmount, String descriptions, Status status, Date updatedAt) {
		this.name = name;
		this.code = code;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
		this.UpdatedAt = updatedAt;
	}
	
	public Coupon(int id, String name, String code, DiscountType discountType, double discountAmount, String descriptions, Status status) {
		this.couponID = id;
		this.name = name;
		this.code = code;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
	}
	
	public Coupon(String name, String code, DiscountType discountType, double discountAmount, String descriptions, Status status) {
		this.name = name;
		this.code = code;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
	}
	
	public boolean createCoupon() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Coupon (Name, Code, DiscountType, discountAmount, Descriptions, Status, UpdatedAt) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)");

			stmt.setString(1, this.name);
			stmt.setString(2, this.code);
			stmt.setString(3,  String.valueOf(discountType));
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
			PreparedStatement stmt = conn.prepareStatement("UPDATE Coupon SET Name = ?, Code = ?, DiscountType = ?, discountAmount = ?, Descriptions = ?, Status = ?, UpdatedAt = CURRENT_TIMESTAMP WHERE CouponID = ?");

			stmt.setString(1, this.name);
			stmt.setString(2, this.code);
			stmt.setString(3,  String.valueOf(discountType));
			stmt.setDouble(4,  this.discountAmount);
			stmt.setString(5, this.descriptions);
			stmt.setString(6,  String.valueOf(this.status));

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
				System.out.println("Searched Successfully");
			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return this;
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
				System.out.println("Searched Successfully");
			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return this;
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
				String name = result.getString("Name");
				String code = result.getString("Code");
				String tempType = result.getString("DiscountType");
				double discountAmount = result.getDouble("DiscountAmount");
				String descriptions = result.getString("Descriptions");
				String status = result.getString("Status");
				
				returnArray.add(new Coupon(id, name, code, DiscountType.valueOf(tempType), discountAmount, descriptions, Status.valueOf(status)));
				
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}
}
