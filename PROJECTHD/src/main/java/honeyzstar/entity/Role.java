package honeyzstar.entity;
import java.sql.*;
import java.util.ArrayList;

public class Role {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername = "root";
	private static final String dbpassword = "";
	private int roleID;
	private String name;
	private String descriptions;

	public Role() {
		this.roleID = 0;
		this.name = "";
		this.descriptions = "";
	}

	public Role(int roleID, String name, String descriptions) {
		this.roleID = roleID;
		this.name = name;
		this.descriptions = descriptions;
	}

	public Role(String name, String descriptions) {
		this.roleID = 0;
		this.name = name;
		this.descriptions = descriptions;
	}

	public Role(int roleID) {
		this.roleID = roleID;
		this.name = "";
		this.descriptions = "";
	}

	public Role(String roleName) {
		this.roleID = 0;
		this.name = roleName;
		this.descriptions = "";
	}

	public Role(Role role) {
		this.roleID = role.roleID;
		this.name = role.name;
		this.descriptions = role.descriptions;
	}

	public boolean createRole() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Role (Name, Descriptions) VALUES ( ?, ?)");

			stmt.setString(1, this.name);
			stmt.setString(2, this.descriptions);

			stmt.executeUpdate();

			System.out.println("Inserted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateRole() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE Role SET Name = ?, descriptions = ? WHERE RoleID = ?");

			stmt.setString(1, this.name);
			stmt.setString(2, this.descriptions);
			stmt.setInt(3, this.roleID);

			stmt.executeUpdate();

			System.out.println("Updated Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteRole() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Role WHERE RoleID = ? ");

			stmt.setInt(1, this.roleID);

			stmt.executeUpdate();

			System.out.println("Deleted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Role searchRole() {

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Role WHERE Name = ? ");

			stmt.setString(1, this.name);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.roleID = result.getInt("RoleID");
				this.name = result.getString("Name");
				this.descriptions = result.getString("Descriptions");
				return this;
			}

			System.out.println("Searched Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public Role getRole() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");

			stmt.setInt(1, this.roleID);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				this.roleID = result.getInt("RoleID");
				this.name = result.getString("Name");
				this.descriptions = result.getString("Descriptions");

				return this;
			}

			System.out.println("Viewed Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Role> getRolelist() {
		ArrayList<Role> returnRole = new ArrayList<Role>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Role");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("RoleID");
				String name = result.getString("Name");
				String descriptions = result.getString("Descriptions");

				returnRole.add(new Role(id, name, descriptions));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnRole;
	}

	public void setID (int roleID){
		this.roleID = roleID;
	}

	public void setName (String name){
		this.name = name;
	}

	public void setDesc (String descriptions){
		this.descriptions = descriptions;
	}

	public int getID() {
		return this.roleID;
	}

	public String getName() {
		return this.name;
	}

	public String getDescriptions() {
		return this.descriptions;
	}

	@Override
	public String toString() {
		return String.format("ID: %5d Name: %-20s Descriptions: %-50s", this.roleID, this.name, this.descriptions);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Role){
			Role compareRole = (Role) obj;
			if (this.roleID == compareRole.roleID) {
				if (this.name.equals(compareRole.name)) {
					if (this.descriptions.equals(compareRole.descriptions)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
