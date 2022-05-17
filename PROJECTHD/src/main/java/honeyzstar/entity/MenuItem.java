package honeyzstar.entity;

import java.sql.*;
import java.util.ArrayList;

public class MenuItem {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername = "root";
	private static final String dbpassword = "";
	private int menuItemID;
	private String name;
	private MenuItemType type;
	private double price;
	private String descriptions;
	private MenuItemStatus status;
	private String createdAt;
	private String updatedAt;
	private String imageDataURL;

	public MenuItem() {
		this.menuItemID = 0;
		this.name = "";
		this.type = null;
		this.price = 0.0;
		this.descriptions = "";
		this.status = null;
		this.createdAt = "";
		this.updatedAt = "";
		this.imageDataURL = "";
	}

	public MenuItem(int id, String name, MenuItemType type, double price, String descriptions, MenuItemStatus status,
			String createdAt, String updatedAt, String imageDataURL) {
		this.menuItemID = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.imageDataURL = imageDataURL;
	}

	public MenuItem(String name, MenuItemType type, double price, String descriptions, MenuItemStatus status,
			String createdAt, String updatedAt, String imageDataURL) {
		this.menuItemID = 0;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.imageDataURL = imageDataURL;
	}

	public MenuItem(int id, String name, MenuItemType type, double price, String descriptions, MenuItemStatus status,
			String imageDataURL) {
		this.menuItemID = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = "";
		this.updatedAt = "";
		this.imageDataURL = imageDataURL;
	}

	public MenuItem(String name, MenuItemType type, double price, String descriptions, MenuItemStatus status,
			String createdAt, String imageDataURL) {
		this.menuItemID = 0;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = "";
		this.imageDataURL = imageDataURL;
	}

	public MenuItem(String name, MenuItemType type, double price, String descriptions, MenuItemStatus status,
			String imageDataURL) {
		this.menuItemID = 0;
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = "";
		this.updatedAt = "";
		this.imageDataURL = imageDataURL;
	}

	public MenuItem(int id) {
		this.menuItemID = 0;
		this.menuItemID = id;
		this.name = "";
		this.type = null;
		this.price = 0.0;
		this.descriptions = "";
		this.status = null;
		this.createdAt = "";
		this.updatedAt = "";
		this.imageDataURL = "";
	}

	public MenuItem(String name) {
		this.menuItemID = 0;
		this.name = name;
		this.type = null;
		this.price = 0.0;
		this.descriptions = "";
		this.status = null;
		this.createdAt = "";
		this.updatedAt = "";
		this.imageDataURL = "";
	}

	public MenuItem(MenuItem item) {
		this.menuItemID = item.menuItemID;
		this.name = item.name;
		this.type = item.type;
		this.price = item.price;
		this.descriptions = item.descriptions;
		this.status = item.status;
		this.createdAt = item.createdAt;
		this.updatedAt = item.updatedAt;
		this.imageDataURL = item.imageDataURL;
	}
	
	public boolean createMenuItem() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO MenuItem (Name, Type, Price, Status, Descriptions, ImageDataURL) VALUES ( ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, this.name);
			stmt.setString(2, String.valueOf(this.type));
			stmt.setDouble(3, this.price);
			stmt.setString(4, String.valueOf(this.status));
			stmt.setString(5, this.descriptions);
			stmt.setString(6, this.imageDataURL);

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
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE MenuItem SET Name = ?, Type = ?, Price = ?, Descriptions = ?, Status = ?, UpdatedAt = CURRENT_TIMESTAMP, ImageDataURL = ? WHERE MenuItemID = ?");

			stmt.setString(1, this.name);
			stmt.setString(2, String.valueOf(this.type));
			stmt.setDouble(3, this.price);
			stmt.setString(4, this.descriptions);
			stmt.setString(5, String.valueOf(this.status));
			stmt.setString(6, this.imageDataURL);
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
				this.setType(MenuItemType.valueOf(result.getString("Type")));
				this.setPrice(result.getDouble("Price"));
				this.setDescriptions(result.getString("Descriptions"));
				this.setStatus(MenuItemStatus.valueOf(result.getString("Status")));
				this.setCreatedAt(result.getString("CreatedAt"));
				this.setUpdatedAt(result.getString("UpdatedAt"));
				this.setImageDataURL(result.getString("ImageDataURL"));
				System.out.println("Searched Successfully");
				return this;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static ArrayList<MenuItem> searchMenuItem(String name) {
		ArrayList<MenuItem> returnList = new ArrayList<MenuItem>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);
		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MenuItem WHERE Name LIKE ? ");

			stmt.setString(1, "%" + name + "%");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				MenuItem item = new MenuItem();
				item.setMenuItemID(result.getInt("MenuItemID"));
				item.setName(result.getString("Name"));
				item.setType(MenuItemType.valueOf(result.getString("Type")));
				item.setPrice(result.getDouble("Price"));
				item.setDescriptions(result.getString("Descriptions"));
				item.setStatus(MenuItemStatus.valueOf(result.getString("Status")));
				item.setCreatedAt(result.getString("CreatedAt"));
				item.setUpdatedAt(result.getString("UpdatedAt"));
				item.setImageDataURL(result.getString("ImageDataURL"));

				returnList.add(item);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnList;
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
				this.setType(MenuItemType.valueOf(result.getString("Type")));
				this.setPrice(result.getDouble("Price"));
				this.setDescriptions(result.getString("Descriptions"));
				this.setStatus(MenuItemStatus.valueOf(result.getString("Status")));
				this.setCreatedAt(result.getString("CreatedAt"));
				this.setUpdatedAt(result.getString("UpdatedAt"));
				this.setImageDataURL(result.getString("ImageDataURL"));
				System.out.println("Searched Successfully");

				return this;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
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

				returnArray.add(new MenuItem(id, name, MenuItemType.valueOf(tempType), price, descriptions,
						MenuItemStatus.valueOf(status), createdAt, updatedAt, imageDataURL));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}

	public int getMenuItemID() {
		return this.menuItemID;
	}

	public void setMenuItemID(int menuItemID) {
		this.menuItemID = menuItemID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MenuItemType getType() {
		return this.type;
	}

	public void setType(MenuItemType type) {
		this.type = type;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public MenuItemStatus getStatus() {
		return this.status;
	}

	public void setStatus(MenuItemStatus status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getImageDataURL() {
		return this.imageDataURL;
	}

	public void setImageDataURL(String imageDataURL) {
		this.imageDataURL = imageDataURL;
	}

	@Override
	public boolean equals(Object obj) {
		MenuItem compareItem = null;
		if (obj instanceof MenuItem) {
			compareItem = (MenuItem) obj;
		} else {
			return false;
		}

		if (this.menuItemID == compareItem.menuItemID) {
			if (this.name.equals(compareItem.name)) {
				if (this.type.equals(compareItem.type)) {
					if (this.price == compareItem.price) {
						if (this.descriptions.equals(compareItem.descriptions)) {
							if (this.status.equals(compareItem.status)) {
								if (this.createdAt.equals(compareItem.createdAt)) {
									if (this.updatedAt.equals(compareItem.updatedAt)) {
										if (this.imageDataURL.equals(compareItem.imageDataURL)) {
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return false;
	}
}