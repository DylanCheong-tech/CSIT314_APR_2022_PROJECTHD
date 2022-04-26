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

	public static boolean deleteRole(int roleID) {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Role WHERE RoleID = ? ");

			stmt.setInt(1, roleId);

			stmt.executeUpdate();

			System.out.println("Deleted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static Role searchRole(String roleName) {

		Role returnRole = null;

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Role WHERE Name = ? ");

			stmt.setString(1, roleName);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				int id = result.getInt("RoleID");
				String name = result.getString("Name");
				String desc = result.getString("Descriptions");

				returnRole = new Role(id, name, desc);
			}

			System.out.println("Searched Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnRole;
	}

	public static Role viewRole(int roleID) {
		Role returnRole = null;

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");

			stmt.setInt(1, roleID);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				int id = result.getInt("RoleID");
				String name = result.getString("Name");
				String desc = result.getString("Descriptions");

				returnRole = new Role(id, name, desc);
			}

			System.out.println("Viewed Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnRole;
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
				String desc = result.getString("Descriptions");

				returnRole.add(new Role(id, name, desc));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnRole;
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

}
