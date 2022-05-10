package honeyzstar.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername = "root";
	private static final String dbpassword = "";
	private int orderID;
	private String createdAt;
	private String updatedAt;
	private OrderStatus status;
	private double totalAmount;
	private int tableNum;
	private HashMap<Integer, Integer> orderItems;
	private Account createdBy;
	
	public Order() {
		this.orderID = 0;
		this.createdAt = "";
		this.updatedAt = "";
		this.createdBy = null;
		this.status = null;
		this.totalAmount = 0.0;
		this.tableNum = 0;
	}
	
	public Order(int orderID, String createdAt, String updatedAt, OrderStatus status, double totalAmount, int tableNum, Account createdBy){
		this.orderID = orderID;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.totalAmount = totalAmount;
		this.tableNum = tableNum;
		this.createdBy = createdBy;
	}
	
	public Order(OrderStatus status, double totalAmount, int tableNum, Account createdBy){
		this.status = status;
		this.totalAmount = totalAmount;
		this.tableNum = tableNum;
		this.createdBy = createdBy;
	}
	
	public boolean createOrder(){
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO orders (Status, TotalAmount, TableNum, CreatedBy) VALUES ( ?, ?, ?, ?)");

			stmt.setString(1, String.valueOf(this.status));
			stmt.setDouble(2, this.totalAmount);
			stmt.setInt(3, this.tableNum);
			stmt.setInt(4, this.createdBy.getID());

			stmt.executeUpdate();

			for (int i : orderItems.keySet()) {
				PreparedStatement stmt1 = conn.prepareStatement(
						"INSERT INTO ordersmenuitem (OrderID, MenuItemID, Quantity) VALUES ( ?, ?, ?)");
					
				stmt1.setInt(1, this.orderID);
				stmt1.setInt(2, i);
				stmt1.setInt(3, orderItems.get(i));
				
				stmt1.executeUpdate();

			}
			
			
			System.out.println("Inserted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOrder(){
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Orders WHERE OrderID = ?");

			stmt.setInt(1, this.orderID);

			stmt.executeUpdate();

			System.out.println("Deleted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateOrder() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE orders SET UpdatedAt = CURRENT_TIMESTAMP, Status = ?, TotalAmount = ?, TableNum = ?, CreatedBy = ? WHERE OrderID = ?");

			stmt.setString(1, String.valueOf(this.status));
			stmt.setDouble(2, this.totalAmount);
			stmt.setInt(3, this.tableNum);
			stmt.setInt(4, this.createdBy.getID());
			stmt.setInt(5, this.orderID);

			stmt.executeUpdate();

			System.out.println("Updated Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Order searchOrder() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders WHERE TableNum = ? ");

			stmt.setInt(1, this.tableNum);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.setOrderID(result.getInt("OrderID"));
				this.setCreatedAt(result.getString("CreatedAt"));
				this.setUpdatedAt(result.getString("UpdatedAt"));
				this.setStatus(OrderStatus.valueOf(result.getString("Status")));
				this.setTotalAmount(result.getDouble("TotalAmount"));
				this.setTableNum(result.getInt("TableNum"));
				this.setCreatedBy(Account.getAccount(result.getInt("CreatedBy")));
							
				System.out.println("Searched Successfully");
				return this;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public Order getOrder() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders WHERE OrderID = ? ");

			stmt.setInt(1, this.orderID);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.setOrderID(result.getInt("OrderID"));
				this.setCreatedAt(result.getString("CreatedAt"));
				this.setUpdatedAt(result.getString("UpdatedAt"));
				this.setStatus(OrderStatus.valueOf(result.getString("Status")));
				this.setTotalAmount(result.getDouble("TotalAmount"));
				this.setTableNum(result.getInt("TableNum"));
				this.setCreatedBy(Account.getAccount(result.getInt("CreatedBy")));
				
				System.out.println("Searched Successfully");
				return this;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public static ArrayList<Order> getOrderList() {
		ArrayList<Order> returnArray = new ArrayList<Order>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("OrderID");
				String createdAt = result.getString("CreatedAt");
				String updatedAt = result.getString("UpdatedAt");
				OrderStatus status = OrderStatus.valueOf(result.getString("Status"));
				double totalAmount = result.getDouble("TotalAmount");
				int tableNum = result.getInt("TableNum");
				Account acc = Account.getAccount(result.getInt("CreatedBy"));

				returnArray.add(new Order(id, createdAt, updatedAt, status, totalAmount, tableNum, acc));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}

	public int getOrderID() {
		return orderID;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getTableNum() {
		return tableNum;
	}

	public HashMap<Integer, Integer> getOrderItems() {
		return orderItems;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public void setOrderItems(HashMap<Integer, Integer> orderItems) {
		this.orderItems = orderItems;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}
	
	@Override
	public boolean equals(Object obj) {
		Order compareItem = null;
		if (obj instanceof Order) {
			compareItem = (Order) obj;
		} else {
			return false;
		}

		if (this.orderID == compareItem.orderID) {
			if (this.createdAt.equals(compareItem.createdAt)) {
				if (this.updatedAt.equals(compareItem.updatedAt)) {
					if (this.status == compareItem.status) {
						if (this.totalAmount == compareItem.totalAmount) {
							if (this.tableNum == compareItem.tableNum) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}
	
}