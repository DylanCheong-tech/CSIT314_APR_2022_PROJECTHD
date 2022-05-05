import java.util.ArrayList;
import java.util.Random;
import java.sql.*;

import honeyzstar.entity.MenuItem;
import honeyzstar.entity.MenuItemStatus;
import honeyzstar.entity.MenuItemType;

public class MenuItemTestDataGenerator {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername  = "root";
	private static final String dbpassword = "";
	
	public MenuItemTestDataGenerator() {
		
	}
	
	public static void main(String[] args) {
		ArrayList<MenuItemType> typeArray = new ArrayList<MenuItemType>();
		typeArray.add(MenuItemType.Beverage);
		typeArray.add(MenuItemType.SideDish);
		typeArray.add(MenuItemType.MainCourse);
		
		ArrayList<MenuItemStatus> statusArray = new ArrayList<MenuItemStatus>();
		statusArray.add(MenuItemStatus.Available);
		statusArray.add(MenuItemStatus.Unavailable);
		
		ArrayList<MenuItem> menuItemArray = new ArrayList<MenuItem>();
		
		String name = "Test Menu Item ";
		
		
		
		for(int i=0; i<100; i++) {
			Double min = 1.0;
	        Double max = 10.0;
	        double x = (Math.random() * ((max - min) + 1)) + min;
	        double xrounded = Math.round(x * 100.0) / 100.0; 
	        
			Random rn = new Random();
			int statusRandom = rn.nextInt(2);
			int typeRandom = rn.nextInt(3);
			String iString = String.valueOf(i + 1);
			
			MenuItem item = new MenuItem(name + iString, typeArray.get(typeRandom), xrounded, "this is a menu item " + iString, statusArray.get(statusRandom), "this is an image URL " + iString);
			menuItemArray.add(item);
			
		}
		
		for(MenuItem item : menuItemArray) {
			try (

					Connection conn = DriverManager.getConnection(
							connStr, dbusername, dbpassword);

			) {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO MenuItem (Name, Type, Price, Status, UpdatedAt, Descriptions, ImageDataURL) VALUES ( ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?)");

				stmt.setString(1, item.getName());
				stmt.setString(2, String.valueOf(item.getType()));
				stmt.setDouble(3,  item.getPrice());
				stmt.setString(4,  String.valueOf(item.getStatus()));
				stmt.setString(5, item.getDescriptions());
				stmt.setString(6,  item.getImageDataURL());

				stmt.executeUpdate();

				System.out.println("Inserted Successfully");

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
