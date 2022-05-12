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
		this.status = null;
		this.totalAmount = 0.0;
		this.tableNum = 0;
		this.createdBy = null;
		
	}

	public Order(int orderID, String createdAt, String updatedAt, OrderStatus status, double totalAmount, int tableNum,
			Account createdBy) {
		this.orderID = orderID;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.totalAmount = totalAmount;
		this.tableNum = tableNum;
		this.createdBy = createdBy;
	}

	public Order(OrderStatus status, double totalAmount, int tableNum, Account createdBy) {
		this.orderID = 0;
		this.createdAt = "";
		this.updatedAt = "";
		this.status = status;
		this.totalAmount = totalAmount;
		this.tableNum = tableNum;
		this.createdBy = createdBy;
	}

	public Order(Order order) {
		this.orderID = order.orderID;
		this.createdAt = order.createdAt;
		this.updatedAt = order.updatedAt;
		this.status = order.status;
		this.totalAmount = order.totalAmount;
		this.tableNum = order.tableNum;
		this.createdBy = order.createdBy;
	}
	
	public boolean createOrder() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {

			PreparedStatement stmt = conn.prepareStatement(
					"select auto_increment from information_schema.tables where table_name = 'Orders'");
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				this.orderID = result.getInt("auto_increment");
			}

			PreparedStatement stmt1 = conn.prepareStatement(
					"INSERT INTO orders (Status, TotalAmount, TableNum, CreatedBy) VALUES ( ?, ?, ?, ?)");

			stmt1.setString(1, String.valueOf(OrderStatus.Created));
			stmt1.setDouble(2, 0.0);
			stmt1.setInt(3, this.tableNum);
			stmt1.setInt(4, this.createdBy.getID());

			stmt1.executeUpdate();

			for (int i : this.orderItems.keySet()) {
				PreparedStatement stmt2 = conn.prepareStatement(
						"INSERT INTO ordersmenuitem (OrderID, MenuItemID, Quantity) VALUES (?, ?, ?)");

				stmt2.setInt(1, this.orderID);
				stmt2.setInt(2, i);
				stmt2.setInt(3, this.orderItems.get(i));

				stmt2.executeUpdate();
			}

			PreparedStatement stmt3 = conn.prepareStatement(
					"update orders set totalAmount = (select sum(Quantity * (select price from MenuItem where menuitem.MenuItemID = OrdersMenuItem.MenuItemID)) as total from OrdersMenuItem group by OrdersMenuItem.OrderID having OrdersMenuItem.OrderID = ?) where OrderID = ?");

			stmt3.setInt(1, this.orderID);
			stmt3.setInt(2, this.orderID);
			stmt3.executeUpdate();

			System.out.println("Inserted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteOrder() {
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
					"UPDATE orders SET UpdatedAt = CURRENT_TIMESTAMP, TableNum = ? WHERE OrderID = ?");

			stmt.setInt(1, this.tableNum);
			stmt.setInt(2, this.orderID);

			stmt.executeUpdate();

			PreparedStatement stmt1 = conn.prepareStatement(
					"DELETE FROM ordersmenuitem WHERE OrderID = ? ");
			stmt1.setInt(1, this.orderID);

			stmt1.executeUpdate();

			for (int i : this.orderItems.keySet()) {
				PreparedStatement stmt2 = conn.prepareStatement(
						"INSERT INTO ordersmenuitem (OrderID, MenuItemID, Quantity) VALUES (?, ?, ?)");

				stmt2.setInt(1, this.orderID);
				stmt2.setInt(2, i);
				stmt2.setInt(3, this.orderItems.get(i));

				stmt2.executeUpdate();
			}

			PreparedStatement stmt3 = conn.prepareStatement("update orders set totalAmount = (select sum(Quantity * (select price from MenuItem where menuitem.MenuItemID = OrdersMenuItem.MenuItemID)) as total from OrdersMenuItem group by OrdersMenuItem.OrderID having OrdersMenuItem.OrderID = ?) where OrderID = ?");

			stmt3.setInt(1, this.orderID);
			stmt3.setInt(2, this.orderID);

			stmt3.executeUpdate();

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
				this.setOrderItems(this.getOrderMenuItemList());

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
				this.setOrderItems(this.getOrderMenuItemList());

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
				Order order = new Order(id, createdAt, updatedAt, status, totalAmount, tableNum, acc);

				order.setOrderItems(order.getOrderMenuItemList());

				returnArray.add(order);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}

	public HashMap<Integer, Integer> getOrderMenuItemList() {
		HashMap<Integer, Integer> returnArray = new HashMap<Integer, Integer>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ordersmenuitem WHERE OrderID = ?");

			stmt.setInt(1, this.orderID);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int menuItemID = result.getInt("MenuItemID");
				int quantity = result.getInt("Quantity");

				returnArray.put(menuItemID, quantity);
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