import java.util.ArrayList;
import java.util.Random;
import java.sql.*;

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

public class AccountTestDataGenerator {
	private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String dbusername  = "root";
	private static final String dbpassword = "";
	
	public AccountTestDataGenerator() {
		
	}
	
	public static void main(String[] args) {
		Role role1 = new Role(1, "Restaurant Owner", "This is Rsstaurant Manager");
		Role role2 = new Role(2, "Staff", "This is Staff");
		Role role3 = new Role(3, "Restaurant Owner", "This is Restaurant Owner");
		
		ArrayList<Role> roleArray = new ArrayList<Role>();
		roleArray.add(role1);
		roleArray.add(role2);
		roleArray.add(role3);
		
		ArrayList<Account> accArray = new ArrayList<Account>();
		
		String name = "name";
		Date date = new Date(27, Month.April, 2022);
		String username = "username";
		String password = "password";
		
		for(int i=0; i<100; i++) {
			Random rn = new Random();
			int answer = rn.nextInt(3);
			String iString = String.valueOf(i + 1);
			
			Account acc = new Account(username + iString, password + iString, name + iString, roleArray.get(answer), date.toString());
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
