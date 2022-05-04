package honeyzstar.entity;

import java.sql.*;
import java.util.ArrayList;


public class MenuItem {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername = "root";
	private static final String dbpassword = "";
	private int menuItemID;
	private String name;
	private Type type;
	private double price;
	private String descriptions;
	private Status status;
	private String createdAt;
	private String UpdatedAt;
	private String imageDataURL;

	
	public MenuItem() {
		this.name = "";
		this.type = null;
		this.price = 0.0;
		this.descriptions = "";
		this.status = null;
		this.createdAt = null;
		this.UpdatedAt = null;
		this.imageDataURL = "";
	}
	
	public MenuItem(int id) {
		this.menuItemID = id;
	}
	
	public MenuItem(String name) {
		this.name = name;
	}
	
	public MenuItem(int id, String name, Type type, double price, String descriptions, Status status, String createdAt, String updatedAt, String imageDataURL) {
		this.menuItemID = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.UpdatedAt = updatedAt;
		this.imageDataURL = imageDataURL;
	}
	
	public MenuItem(String name, Type type, double price, String descriptions, Status status, String createdAt, String updatedAt, String imageDataURL) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.UpdatedAt = updatedAt;
		this.imageDataURL = imageDataURL;
	}
	
	public MenuItem(int id, String name, Type type, double price, String descriptions, Status status, String imageDataURL) {
		this.menuItemID = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.UpdatedAt = null;
		this.imageDataURL = imageDataURL;
	}
	
	public MenuItem(String name, Type type, double price, String descriptions, Status status, String createdAt, String imageDataURL) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.UpdatedAt = null;
		this.imageDataURL = imageDataURL;
	}
	
	public MenuItem(String name, Type type, double price, String descriptions, Status status, String imageDataURL) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.imageDataURL = imageDataURL;
	}
	
	public boolean createMenuItem() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO MenuItem (Name, Type, Price, Status, UpdatedAt, Descriptions, ImageDataURL) VALUES ( ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?)");

			stmt.setString(1, this.name);
			stmt.setString(2, String.valueOf(this.type));
			stmt.setDouble(3,  this.price);
			stmt.setString(4,  String.valueOf(this.status));
			stmt.setString(5, this.descriptions);
			stmt.setString(6,  this.imageDataURL);

			stmt.executeUpdate();

			System.out.println("Inserted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteMenuItem() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM MenuItem WHERE MenuItemID = ?");

			stmt.setInt(1, this.menuItemID);

			stmt.executeUpdate();

			System.out.println("Deleted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean updateMenuItem() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE MenuItem SET Name = ?, Type = ?, Price = ?, Descriptions = ?, Status = ?, UpdatedAt = CURRENT_TIMESTAMP, ImageDataURL = ? WHERE MenuItemID = ?");

			stmt.setString(1, this.name);
			stmt.setString(2, String.valueOf(this.type));
			stmt.setDouble(3, this.price);
			stmt.setString(4, String.valueOf(this.status));
			stmt.setString(5, this.descriptions);
			stmt.setString(6,  this.imageDataURL);
			stmt.setInt(7, this.menuItemID);

			stmt.executeUpdate();

			System.out.println("Updated Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public MenuItem searchMenuItem() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MenuItem WHERE Name = ? ");

			stmt.setString(1, this.name);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.setMenuItemID(result.getInt("MenuItemID"));
				this.setName(result.getString("Name"));
				this.setType(Type.valueOf(result.getString("Type")));
				this.setPrice(result.getDouble("Price"));
				this.setDescriptions(result.getString("Descriptions"));
				this.setStatus(Status.valueOf(result.getString("Status")));
				this.setCreatedAt(result.getString("CreatedAt"));
				this.setUpdatedAt(result.getString("UpdatedAt"));
				this.setImageDataURL(result.getString("ImageDataURL"));
				System.out.println("Searched Successfully");
			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return this;
	}
	
	public MenuItem getMenuItem() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MenuItem WHERE MenuItemID = ? ");

			stmt.setInt(1, this.menuItemID);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.setMenuItemID(result.getInt("MenuItemID"));
				this.setName(result.getString("Name"));
				this.setType(Type.valueOf(result.getString("Type")));
				this.setPrice(result.getDouble("Price"));
				this.setDescriptions(result.getString("Descriptions"));
				this.setStatus(Status.valueOf(result.getString("Status")));
				this.setCreatedAt(result.getString("CreatedAt"));
				this.setUpdatedAt(result.getString("UpdatedAt"));
				this.setImageDataURL(result.getString("ImageDataURL"));
				System.out.println("Searched Successfully");
			}
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return this;
	}

	public static ArrayList<MenuItem> getMenuItemList() {
		ArrayList<MenuItem> returnArray = new ArrayList<MenuItem>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MenuItem");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("MenuItemID");
				String name = result.getString("Name");
				String tempType = result.getString("Type");
				double price = result.getDouble("Price");
				String descriptions = result.getString("Descriptions");
				String status = result.getString("Status");
				String createdAt = result.getString("CreatedAt");
				String updatedAt = result.getString("UpdatedAt");
				String imageDataURL = result.getString("ImageDataURL");
				
				returnArray.add(new MenuItem(id, name, Type.valueOf(tempType), price, descriptions, Status.valueOf(status), createdAt, updatedAt, imageDataURL));
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}
	
	public int getMenuItemID() {
		return menuItemID;
	}

	public void setMenuItemID(int menuItemID) {
		this.menuItemID = menuItemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		UpdatedAt = updatedAt;
	}

	public String getImageDataURL() {
		return imageDataURL;
	}

	public void setImageDataURL(String imageDataURL) {
		this.imageDataURL = imageDataURL;
	}
	
	

}