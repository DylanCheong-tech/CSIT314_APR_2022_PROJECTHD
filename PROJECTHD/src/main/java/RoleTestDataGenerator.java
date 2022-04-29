
import java.sql.*;
import java.util.ArrayList;



public class RoleTestDataGenerator {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername  = "root";
	private static final String dbpassword = "";
	
	public static void main(String[] args) {
		Role role1 = new Role("Restaurant Manager", "This is Rsstaurant Manager");
		Role role2 = new Role("Staff", "This is Staff");
		Role role3 = new Role("Restaurant Owner", "This is Restaurant Owner");
		Role role4 = new Role("User Admin", "This is User Admin");
		ArrayList<Role> roleArray = new ArrayList<Role>();
		roleArray.add(role1);
		roleArray.add(role2);
		roleArray.add(role3);
		roleArray.add(role4);

		for(Role role : roleArray) {
		
			try (
	
					Connection conn = DriverManager.getConnection(
							connStr, dbusername, dbpassword);
	
			) {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO Role (Name, Descriptions) VALUES ( ?, ?)");
	
				stmt.setString(1, role.getName());
				stmt.setString(2, role.getDescriptions());
	
				stmt.executeUpdate();
	
	
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
