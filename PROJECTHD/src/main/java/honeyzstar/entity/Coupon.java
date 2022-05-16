package honeyzstar.entity;

import java.sql.*;
import java.util.ArrayList;


public class Coupon {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername = "root";
	private static final String dbpassword = "";
	private int couponID;
	private String code;
	private String name;
	private DiscountType discountType;
	private double discountAmount;
	private String descriptions;
	private CouponStatus status;

	
	public Coupon() {
		this.couponID = 0;
		this.code = "";
		this.name = "";
		this.discountType = null;
		this.discountAmount = 0.0;
		this.descriptions = "";
		this.status = null;
	}

	public Coupon(int id, String code, String name, String descriptions, DiscountType discountType, double discountAmount,  CouponStatus status) {
		this.couponID = id;
		this.code = code;
		this.name = name;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
	}
	
	public Coupon(String code, String name, String descriptions, DiscountType discountType, double discountAmount, CouponStatus status) {
		this.couponID = 0;
		this.code = code;
		this.name = name;
		this.discountType = discountType;
		this.discountAmount = discountAmount;
		this.descriptions = descriptions;
		this.status = status;
	}
	

	public Coupon(int id) {
		this.couponID = id;
		this.code = "";
		this.name = "";
		this.discountType = null;
		this.discountAmount = 0.0;
		this.descriptions = "";
		this.status = null;
	}

	public Coupon(String code) {
		this.couponID = 0;
		this.name = "";
		this.code = code;
		this.discountType = null;
		this.discountAmount = 0.0;
		this.descriptions = "";
		this.status = null;
	}
	
	public Coupon(Coupon coupon) {
		this.couponID = coupon.couponID;
		this.name = coupon.name;
		this.code = coupon.code;
		this.discountType = coupon.discountType;
		this.discountAmount = coupon.discountAmount;
		this.descriptions = coupon.descriptions;
		this.status = coupon.status;
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Coupon WHERE Code = ? ");

			stmt.setString(1, this.code);

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

	@Override
	public boolean equals (Object obj){
		Coupon compareCoupon = null;
		if (obj instanceof Coupon){
			compareCoupon = (Coupon) obj;
		}else {
			return false;
		}

		if (this.couponID == compareCoupon.couponID){
			if (this.name.equals(compareCoupon.name)){
				if (this.code.equals(compareCoupon.code)){
					if (this.discountType.equals(compareCoupon.discountType)){
						if (this.discountAmount == compareCoupon.discountAmount){
							if (this.descriptions.equals(compareCoupon.descriptions)){
								if (this.status.equals(compareCoupon.status)){
									return true;
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();

		str.append("ID : ");
		str.append(this.couponID + "\n");
		str.append("Code : ");
		str.append(this.code + "\n");
		str.append("Name : ");
		str.append(this.name + "\n");
		str.append("Discount Type : ");
		str.append(this.discountType + "\n");
		str.append("Discount Amoount : ");
		str.append(this.discountAmount + "\n");
		str.append("Descriptions : ");
		str.append(this.descriptions + "\n");
		str.append("Status : ");
		str.append(this.status + "\n");

		return str.toString();
	}
}