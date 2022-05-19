import java.util.ArrayList;
import java.util.Random;

import honeyzstar.entity.Account;
import honeyzstar.entity.Role;

import java.sql.*;


public class AccountTestDataGenerator {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername  = "root";
	private static final String dbpassword = "";
	
	public AccountTestDataGenerator() {
		
	}
	
	public static void main(String[] args) {
		Role role1 = new Role(1, "Restaurant Manager", "This is Restaurant Manager");
		Role role2 = new Role(2, "Staff", "This is Staff");
		Role role3 = new Role(3, "Restaurant Owner", "This is Restaurant Owner");
		Role role4 = new Role(4, "User Admin", "This is User Admin");
		
		ArrayList<Role> roleArray = new ArrayList<Role>();
		roleArray.add(role1);
		roleArray.add(role2);
		roleArray.add(role3);
		roleArray.add(role4);
		
		ArrayList<Account> accArray = new ArrayList<Account>();
		
		String name = "Test Account ";
		String username = "username";
		String password = "password";
		
		for(int i=0; i<100; i++) {
			Random rn = new Random();
			int answer = rn.nextInt(4);
			String iString = String.valueOf(i + 1);
			
			Account acc = new Account(username + iString, password + iString, name + iString, roleArray.get(answer));
			accArray.add(acc);
			
		}
		
		for(Account acc : accArray) {
			try (

					Connection conn = DriverManager.getConnection(
							connStr, dbusername, dbpassword);

			) {
				PreparedStatement stmt = conn
						.prepareStatement("INSERT INTO Account (Name, RoleID, Username, Password) VALUES (?, ?, ?, ?)");

				stmt.setString(1, acc.getName());
				stmt.setInt(2, acc.getRole().getID());
				stmt.setString(3, acc.getUsername());
				stmt.setString(4, acc.getPassword());

				stmt.executeUpdate();

				System.out.println("Inserted Successfully");

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
}
