package honeyzstar.entity;

import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Report {
    private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String dbusername = "root";
    private static final String dbpassword = "";

    public Report (){

    }

    // Spending Report 

    public ArrayList<HashMap<String, Object>> getMonthlyAverageSpendingReport (int year){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(PaidAt), MONTH(PaidAt), AVG(PayableAmount) FROM Bill WHERE YEAR(PaidAt) = ? GROUP BY YEAR(PaidAt), MONTH(PaidAt)");
            stmt.setInt(1, year);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("MONTH(PaidAt)"));
                value_pair.put("value", result.getDouble("AVG(PayableAmount)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getWeeklyAverageSpendingReport (int year, int month){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(PaidAt), MONTH(PaidAt), WEEK(PaidAt), AVG(PayableAmount) FROM Bill WHERE YEAR(PaidAt) = ? AND MONTH(PaidAt) = ? GROUP BY YEAR(PaidAt), MONTH(PaidAt), WEEK(PaidAt)");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("WEEK(PaidAt)"));
                value_pair.put("value", result.getDouble("AVG(PayableAmount)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getDailyAverageSpendingReport (int year, int week){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(PaidAt), MONTH(PaidAt), WEEK(PaidAt), DAY(PaidAt), AVG(PayableAmount) FROM Bill WHERE YEAR(PaidAt) = ? AND WEEK(PaidAt) = ? GROUP BY YEAR(PaidAt), MONTH(PaidAt), WEEK(PaidAt), DAY(PaidAt)");
            stmt.setInt(1, year);
            stmt.setInt(2, week);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("DAY(PaidAt)"));
                value_pair.put("value", result.getDouble("AVG(PayableAmount)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getHourlyAverageSpendingReport (int year, int month, int day){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(PaidAt), MONTH(PaidAt), DAY(PaidAt), HOUR(PaidAt), AVG(PayableAmount) FROM Bill WHERE YEAR(PaidAt) = ? AND MONTH(PaidAt) = ? AND DAY(PaidAt) = ? GROUP BY YEAR(PaidAt), MONTH(PaidAt), DAY(PaidAt), HOUR(PaidAt)");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            stmt.setInt(3, day);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("HOUR(PaidAt)"));
                value_pair.put("value", result.getDouble("AVG(PayableAmount)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    // Visit Frequenct Report 

    public ArrayList<HashMap<String, Object>> getMonthlyVisitFrequencyReport (int year){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), COUNT(*) FROM Bill WHERE YEAR(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt)");
            stmt.setInt(1, year);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("MONTH(CreatedAt)"));
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getWeeklyVisitFrequencyReport (int year, int month){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), COUNT(*) FROM Bill WHERE YEAR(CreatedAt) = ? AND MONTH(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt)");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("WEEK(CreatedAt)"));
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getDailyVisitFrequencyReport (int year, int week){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), COUNT(*) FROM Bill WHERE YEAR(CreatedAt) = ? AND WEEK(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt)");
            stmt.setInt(1, year);
            stmt.setInt(2, week);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("WEEK(CreatedAt)"));
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getHourlyVisitFrequencyReport (int year, int month, int day){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), HOUR(CreatedAt), COUNT(*) FROM Bill WHERE YEAR(CreatedAt) = ? AND MONTH(CreatedAt) = ? AND DAY(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), HOUR(CreatedAt)");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            stmt.setInt(3, day);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", result.getInt("DAY(CreatedAt)"));
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    // Menu Preferences Report 
    public ArrayList<HashMap<String, Object>> getMonthlyMenuPreferencesReport (int year, int month){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), MenuItemID, COUNT(*) FROM Orders JOIN OrdersMenuItem on Orders.OrderID = OrdersMenuItem.Orderid WHERE YEAR(CreatedAt) = ? AND MONTH(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), MenuItemID");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", new MenuItem(result.getInt("MenuItemID")).getMenuItem().getName());
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getWeeklyMenuPreferencesReport (int year, int week){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), MenuItemID, COUNT(*) FROM Orders JOIN OrdersMenuItem on Orders.OrderID = OrdersMenuItem.OrderID WHERE YEAR(CreatedAt) = ? AND WEEK(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), MenuItemID");
            stmt.setInt(1, year);
            stmt.setInt(2, week);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", new MenuItem(result.getInt("MenuItemID")).getMenuItem().getName());
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getDailyMenuPreferencesReport (int year, int month, int day){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), MenuItemID, COUNT(*) FROM Orders JOIN OrdersMenuItem on Orders.OrderID = OrdersMenuItem.Orderid WHERE YEAR(CreatedAt) = ? AND MONTH(CreatedAt) = ? AND DAY(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), MenuItemID");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            stmt.setInt(3, day);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", new MenuItem(result.getInt("MenuItemID")).getMenuItem().getName());
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

    public ArrayList<HashMap<String, Object>> getHourlyMenuPreferencesReport (int year, int month, int day, int hour){
        ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
        
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("SELECT YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), HOUR(CreatedAt), MenuItemID, COUNT(*) FROM Orders JOIN OrdersMenuItem on Orders.OrderID = OrdersMenuItem.Orderid WHERE YEAR(CreatedAt) = ? AND MONTH(CreatedAt) = ? AND DAY(CreatedAt) = ? AND HOUR(CreatedAt) = ? GROUP BY YEAR(CreatedAt), MONTH(CreatedAt), WEEK(CreatedAt), DAY(CreatedAt), HOUR(CreatedAt), MenuItemID");
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            stmt.setInt(3, day);
            stmt.setInt(4, hour);
            ResultSet result = stmt.executeQuery();
            
            while (result.next()) {
                HashMap<String, Object> value_pair = new HashMap<String, Object>();
                value_pair.put("key", new MenuItem(result.getInt("MenuItemID")).getMenuItem().getName());
                value_pair.put("value", result.getInt("COUNT(*)"));
                returnArray.add(value_pair);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return returnArray;
    }

}