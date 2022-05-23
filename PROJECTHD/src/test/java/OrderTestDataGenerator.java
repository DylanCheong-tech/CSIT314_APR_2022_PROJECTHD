import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import java.util.Random;

import honeyzstar.entity.Order;
import honeyzstar.entity.OrderStatus;
import honeyzstar.entity.MenuItem;
import honeyzstar.entity.MenuItemStatus;
import honeyzstar.entity.Account;

public class OrderTestDataGenerator {
	
	
	private static long getRandomTimeBetweenTwoDates () {
		long beginTime = Timestamp.valueOf("2020-01-01 10:00:00").getTime();

		long endTime = Timestamp.valueOf("2022-12-31 20:59:59").getTime();

	    long diff = endTime - beginTime + 1;
	    return beginTime + (long) (Math.random() * diff);
	}
	
	public static void main(String[] args) {
		String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String dbusername = "root";
		String dbpassword = "";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for (int i = 0; i < 100; i++) {
			Date randomDate = new Date(getRandomTimeBetweenTwoDates());
			randomDate.getTime();
			String date = dateFormat.format(randomDate);
			
			
			
			Random rn = new Random();
			int randomNumberOfItems = rn.nextInt(14) + 2 ;
			int randomStaff = rn.nextInt(20) + 1 ;
			int randomTableNum = rn.nextInt(50) + 1 ;
			
			Account acc = new Account();
	    	acc.setID(randomStaff);
			
			Order orderObj = new Order();
			orderObj.setTableNum(randomTableNum);
			orderObj.setCreatedBy(acc);
			orderObj.setCreatedAt(date);
			
			HashMap<Integer, Integer> menuItems = new HashMap<Integer, Integer>();
			for(int j = 0; j < randomNumberOfItems; j++) {
				int randomQuantity = rn.nextInt(10) + 1 ;
				int randomMenuItemID = rn.nextInt(100) + 1 ;
				MenuItem item = new MenuItem(randomMenuItemID);
				item = item.getMenuItem();
				if(item.getStatus() == MenuItemStatus.Available) {
					menuItems.put(randomMenuItemID, randomQuantity);
				}else if(j == randomNumberOfItems - 1) {
					j--;
				}
			}
			
			orderObj.setMenuItems(menuItems);
			
			try (

					Connection conn = DriverManager.getConnection(
							connStr, dbusername, dbpassword);

			) {

				PreparedStatement stmt = conn.prepareStatement(
						"select auto_increment from information_schema.tables where table_name = 'Orders'");
				ResultSet result = stmt.executeQuery();
				if (result.next()) {
					orderObj.setOrderID(result.getInt("auto_increment"));
				}

				PreparedStatement stmt1 = conn.prepareStatement(
						"INSERT INTO orders (CreatedAt, Status, TotalAmount, TableNum, CreatedBy) VALUES ( ?, ?, ?, ?, ?)");

				stmt1.setString(1, date);
				stmt1.setString(2, String.valueOf(OrderStatus.Created));
				stmt1.setDouble(3, 0.0);
				stmt1.setInt(4, orderObj.getTableNum());
				if(orderObj.getCreatedBy() == null) {
					stmt1.setNull(5, Types.NULL);
				} else {
					stmt1.setInt(5, orderObj.getCreatedBy().getID());
				}

				stmt1.executeUpdate();

				if (!orderObj.getMenuItems().isEmpty()) {
					for (int k : orderObj.getMenuItems().keySet()) {
						PreparedStatement stmt2 = conn.prepareStatement(
								"INSERT INTO ordersmenuitem (OrderID, MenuItemID, Quantity) VALUES (?, ?, ?)");

						stmt2.setInt(1, orderObj.getOrderID());
						stmt2.setInt(2, i);
						stmt2.setInt(3, orderObj.getMenuItems().get(k));

						stmt2.executeUpdate();
					}

					PreparedStatement stmt3 = conn.prepareStatement(
							"update orders set totalAmount = (select sum(Quantity * (select price from MenuItem where menuitem.MenuItemID = OrdersMenuItem.MenuItemID)) as total from OrdersMenuItem group by OrdersMenuItem.OrderID having OrdersMenuItem.OrderID = ?) where OrderID = ?");

					stmt3.setInt(1, orderObj.getOrderID());
					stmt3.setInt(2, orderObj.getOrderID());
					stmt3.executeUpdate();
				}

				System.out.println("Inserted Successfully");

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
