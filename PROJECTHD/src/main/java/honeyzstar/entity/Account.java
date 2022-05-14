package honeyzstar.entity;
import java.sql.*;

import java.util.ArrayList;

public class Account {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername  = "root";
	private static final String dbpassword = "";
	private int accountID;
	private String name;
	private Role role;
	private String dateJoined;
	private String username;
	private String password;
	private String status;

	public Account() {
		this.accountID = 0;
		this.name = "";
		this.role = null;
		this.dateJoined = "";
		this.username = "";
		this.password = "";
		this.status = "";
	}

	public Account(int accountID, String name, Role role, String dateJoined, String username, String password, String status) {
		this.accountID = accountID;
		this.name = name;
		this.role = role;
		this.dateJoined = dateJoined;
		this.username = username;
		this.password = password;
		this.status = "";
	}

	public Account(int accountID, String name, Role role, String dateJoined, String username, String password) {
		this.accountID = accountID;
		this.name = name;
		this.role = role;
		this.dateJoined = dateJoined;
		this.username = username;
		this.password = password;
		this.status = "";
	}

	public Account(String name, Role role, String dateJoined, String username, String password) {
		this.accountID = 0;
		this.name = name;
		this.role = role;
		this.dateJoined = "";
		this.username = username;
		this.password = password;
		this.status = "";
	}

	public Account(int accountID, String name, Role role, String username, String password) {
		this.accountID = accountID;
		this.name = name;
		this.role = role;
		this.dateJoined = "";
		this.username = username;
		this.password = password;
		this.status = "";
	}

	public Account(String username, String password, String name, Role role) {
		this.accountID = 0;
		this.name = name;
		this.role = role;
		this.dateJoined = "";
		this.username = username;
		this.password = password;
		this.status = "";
	}

	public Account(String username, String password, Role role) {
		this.accountID = 0;
		this.name = "";
		this.role = role;
		this.dateJoined = "";
		this.username = username;
		this.password = password;
		this.status = "";
	}

	public Account(Account account) {
		this.accountID = account.accountID;
		this.name = account.name;
		this.role = account.role;
		this.dateJoined = account.dateJoined;
		this.username = account.username;
		this.password = account.password;
		this.status = account.status;
	}

	public boolean login() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn.prepareStatement("SELECT Password FROM Account WHERE Username = ? AND RoleID = ? AND Status = 'Active'");

			stmt.setString(1, this.username);
			stmt.setInt(2, this.role.getID());

			ResultSet result = stmt.executeQuery();
			String password = "";

			if (result.next()) {
				password = result.getString("Password");
			}

			stmt = conn.prepareStatement("SELECT AccountID FROM Account WHERE Username = ?");
			stmt.setString(1, this.username);

			result = stmt.executeQuery();

			// write to the AccontLog database
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

	public static boolean logout(String username) {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

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

			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();

			return false;
		}
	}

	public boolean createAccount() {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

		) {
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO account (Name, RoleID, Username, Password) VALUES (?, ?, ?, ?)");

			stmt.setString(1, this.name);
			stmt.setInt(2, this.role.getID());
			stmt.setString(3, this.username);
			stmt.setString(4, this.password);

			stmt.executeUpdate();

			System.out.println("Inserted Successfully");
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean suspendAccount(int accountID) {
		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

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
						connStr, dbusername, dbpassword);

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
						connStr, dbusername, dbpassword);

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
				String status = result.getString("Status");
				Role role = Role.getRole(result.getInt(roleID));
						
				returnAcc = new Account(id, name, role, date, username, password, status);
						/*
				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");
				stmt2.setInt(1, roleID);

				ResultSet roleResult = stmt2.executeQuery();

				if (roleResult.next()) {
					String roleName = roleResult.getString("Name");
					String desc = roleResult.getString("Descriptions");

					returnAcc = new Account(id, username, password, name, new Role(roleID, roleName, desc), date, status);
				}
				*/
				
			}

			System.out.println("Searched Successfully");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnAcc;
	}

	public static Account getAccount(int accountID) {
		Account returnAcc = null;

		try (

				Connection conn = DriverManager.getConnection(
						connStr, dbusername, dbpassword);

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
				String status = result.getString("Status");
				
				Role role = Role.getRole(roleID);
						
				returnAcc = new Account(id, name, role, date, username, password, status);
				
				/*
				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");
				stmt2.setInt(1, roleID);

				ResultSet roleResult = stmt2.executeQuery();

				if (roleResult.next()) {
					String roleName = roleResult.getString("Name");
					String desc = roleResult.getString("Descriptions");

					returnAcc = new Account(id, username, password, name, new Role(roleID, roleName, desc), date, status);
				}
				*/

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
						connStr, dbusername, dbpassword);

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
				String status = result.getString("Status");

				Role role = Role.getRole(roleID);
						
				returnArray.add(new Account(id, name, role, date, username, password, status));
				
				/*
				PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Role WHERE RoleID = ? ");
				stmt2.setInt(1, roleID);

				ResultSet roleResult = stmt2.executeQuery();

				if (roleResult.next()) {
					String roleName = roleResult.getString("Name");
					String desc = roleResult.getString("Descriptions");

					returnArray.add(new Account(id, username, password, name, new Role(roleID, roleName, desc), date, status));
				}
				*/
				
			
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return returnArray;
	}

	public void setID (int accID){
		this.accountID = accID;
	}

	public void setName (String name){
		this.name = name;
	}

	public void setUsername (String username){
		this.username = username;
	}

	public void setPassword (String password){
		this.password = password;
	}

	public void setRole (Role otherRole){
		this.role = new Role(otherRole);
	}

	public void setDateJoined (String dateJoined){
		this.dateJoined = dateJoined;
	}

	public void setStatus (String status){
		this.status = status;
	}

	public int getID() {
		return this.accountID;
		
	}

	public String getName() {
		return this.name;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public Role getRole() {
		return this.role;
	}

	public String getDateJoined() {
		return this.dateJoined;
	}

	public String getStatus (){
		return this.status;
	}

	@Override
	public String toString() {
		return String.format("Account ID: %-5d Name : %10s Username: %10s Password : %10s Joined Date : %10s\n %-20s", this.accountID, this.name, this.username, this.password, this.dateJoined, this.role);
	}

	@Override 
	public boolean equals (Object obj){
		if (obj instanceof Account){
			Account compareAcc = (Account) obj;
			if (this.accountID == compareAcc.accountID){
				if (this.name.equals(compareAcc.name)){
					if (this.username.equals(compareAcc.username)){
						if(this.password.equals(compareAcc.password)){
							if (this.role.equals(compareAcc.role)){
								if (this.dateJoined.equals(compareAcc.dateJoined)){
									if (this.status.equals(compareAcc.status)){
										return true;
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