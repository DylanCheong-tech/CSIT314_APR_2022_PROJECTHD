package honeyzstar.entity;

import java.sql.*;
import java.util.ArrayList;


enum Month {
    January(1),
    February(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    September(9),
    October(10),
    November(11),
    December(12);

    private int value;

    Month(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class Date {
	private final int year;
    private final Month month;
    private final int day;

    public Date(int day, Month month, int year){
    	this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear() {
    	return year;
    }

    public Month getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String toString(){
        return String.format("%d %s %d", day, String.valueOf(month), year);
    }
}

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
	private Date createdAt;
	private Date UpdatedAt;
	private String imageURL;

	
	public MenuItem() {
		this.name = "";
		this.type = null;
		this.price = 0.0;
		this.descriptions = "";
		this.status = null;
		this.createdAt = null;
		this.UpdatedAt = null;
		this.imageURL = "";
	}
	
	public MenuItem(String name, Type type, double price, String descriptions, Status status, Date createdAt, Date updatedAt, String imageURL) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.UpdatedAt = updatedAt;
		this.imageURL = imageURL;
	}
	
	public MenuItem(String name, Type type, double price, String descriptions, Status status, Date createdAt, String imageURL) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.createdAt = createdAt;
		this.UpdatedAt = null;
		this.imageURL = imageURL;
	}
	
	public MenuItem(String name, Type type, double price, String descriptions, Status status, String imageURL) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.descriptions = descriptions;
		this.status = status;
		this.imageURL = imageURL;
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
			stmt.setString(6,  this.imageURL);

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
			stmt.setString(6,  this.imageURL);
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
				String imageDataURL = result.getString("ImageDataURL");
				
				returnArray.add(new MenuItem(name, Type.valueOf(tempType), price, descriptions, Status.valueOf(status), imageDataURL));
				
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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	

}