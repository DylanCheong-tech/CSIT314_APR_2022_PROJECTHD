import java.sql.*;
import java.util.ArrayList;

public class Account {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private int accountID;
	private String username;
	private String password;
	private String name;
	private Role role;
	private String dateJoined;

	public Account() {
		this.accountID = 0;
		this.username = "";
		this.password = "";
		this.name = "";
		this.role = null;
		this.dateJoined = "";
	}

	public Account(int accountID, String username, String password, String name, Role role, String dateJoined) {
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.dateJoined = dateJoined;
	}

	public Account(String username, String password, String name, Role role, String dateJoined) {
		this.accountID = 0;
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.dateJoined = dateJoined;
	}

	public Account(int accountID, String username, String password, String name, Role role) {
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.dateJoined = "";
	}

	public Account(String username, String password, String name, Role role) {
		this.accountID = 0;
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.dateJoined = "";
	}

	public Account(String username, String password) {
		this.accountID = 0;
		this.username = username;
		this.password = password;
		this.name = "";
		this.role = null;
		this.dateJoined = "";
	}

	public Account(Account account) {
		this.accountID = account.accountID;
		this.username = account.username;
		this.password = account.password;
		this.name = account.name;
		this.role = account.role;
		this.dateJoined = account.dateJoined;
	}

	public boolean login() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT Password FROM Account WHERE Username = ? ");

			stmt.setString(1, this.username);

			ResultSet result = stmt.executeQuery();
			String password = "";

			if (result.next()) {
				password = result.getString("Password");
			}

			stmt = conn.prepareStatement("SELECT AccountID FROM Account WHERE Username = ?");
			stmt.setString(1, this.username);

			result = stmt.executeQuery();

			if (result.next()) {
				this.accountID = result.getInt("AccountID");

				if (this.password.equals(password)) {
					stmt = conn.prepareStatement("INSERT INTO AccountLog (AccountID, OperationFlag) VALUES (?, 'Login')");
					stmt.setInt(1, this.accountID);
	
					stmt.executeUpdate();
					return true;
				}
				else{
					return false;
				}
			}else{
				return false;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static void logout(String username) {
		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT Password FROM Account WHERE Username = ? ");

			stmt = conn.prepareStatement("SELECT AccountID FROM Account WHERE Username = ?");
			stmt.setString(1, username);

			ResultSet result = stmt.executeQuery();
			int accountID;

			if (result.next()) {
				accountID = result.getInt("AccountID");
				stmt = conn.prepareStatement("INSERT INTO AccountLog (AccountID, OperationFlag) VALUES (?, 'Logout')");
				stmt.setInt(1, accountID);

				stmt.executeUpdate();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void createAccount() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO Account (Name, RoleID, Username, Password) VALUES (?, ?, ?, ?)");

			stmt.setString(1, this.name);
			stmt.setInt(2, this.role.getID());
			stmt.setString(3, this.username);
			stmt.setString(4, this.password);

			stmt.executeUpdate();

			System.out.println("Inserted Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static boolean suspendAccount(int accountID) {
		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE Account SET Status = 'Suspended' WHERE AccountID = ? ");

			stmt.setInt(1, accountID);

			stmt.executeUpdate();

			System.out.println("Suspended Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateAccount() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE Account SET Name = ?, RoleID = ?, Username = ?, Password = ? WHERE AccountID = ?");

			stmt.setString(1, this.name);
			stmt.setInt(2, this.role.getID());
			stmt.setString(3, this.username);
			stmt.setString(4, this.password);
			stmt.setInt(5, this.accountID);

			stmt.executeUpdate();

			System.out.println("Updated Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static Account searchAccount(String accountName) {
		Account returnAcc = null;

		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account WHERE Name = ? ");

			stmt.setString(1, accountName);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				int id = result.getInt("AccountID");
				String name = result.getString("Name");
				int roleID = result.getInt("RoleID");
				String date = result.getString("DateJoined");
				String username = result.getString("Username");
				String password = result.getString("Password");

				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");
				stmt2.setInt(1, roleID);

				ResultSet roleResult = stmt2.executeQuery();

				if (roleResult.next()) {
					String roleName = roleResult.getString("Name");
					String desc = roleResult.getString("Descriptions");

					returnAcc = new Account(id, username, password, name, new Role(roleID, roleName, desc), date);
				}

			}

			System.out.println("Searched Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnAcc;
	}

	public static Account viewRole(int accountID) {
		Account returnAcc = null;

		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account WHERE AccountID = ? ");

			stmt.setInt(1, accountID);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				int id = result.getInt("AccountID");
				String name = result.getString("Name");
				int roleID = result.getInt("RoleID");
				String date = result.getString("DateJoined");
				String username = result.getString("Username");
				String password = result.getString("Password");

				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");
				stmt2.setInt(1, roleID);

				ResultSet roleResult = stmt2.executeQuery();

				if (roleResult.next()) {
					String roleName = roleResult.getString("Name");
					String desc = roleResult.getString("Descriptions");

					returnAcc = new Account(id, username, password, name, new Role(roleID, roleName, desc), date);
				}

			}

			System.out.println("Searched Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnAcc;
	}

	public static ArrayList<Account> getAccountList() {
		ArrayList<Account> returnArray = new ArrayList<Account>();

		try (

				Connection conn = DriverManager.getConnection(
						connStr,
						"root", "");

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Account");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("AccountID");
				String name = result.getString("Name");
				int roleID = result.getInt("RoleID");
				String date = result.getString("DateJoined");
				String username = result.getString("Username");
				String password = result.getString("Password");

				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");
				stmt2.setInt(1, roleID);

				ResultSet roleResult = stmt2.executeQuery();

				if (roleResult.next()) {
					String roleName = roleResult.getString("Name");
					String desc = roleResult.getString("Descriptions");

					returnArray.add(new Account(id, username, password, name, new Role(roleID, roleName, desc), date));
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}

	@Override
	public String toString() {
		return String.format("Account ID: %-5d Name : %10s Username: %10s Password : %10s Joined Date : %10s\n %-20s", this.accountID, this.name, this.username, this.password, this.dateJoined, this.role);
	}
}