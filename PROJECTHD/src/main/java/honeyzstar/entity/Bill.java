package honeyzstar.entity;

import java.sql.*;

public class Bill {
    private static final String connStr = "jdbc:mysql://localhost:3306/csit314_apr_2022_projecthd?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String dbusername = "root";
    private static final String dbpassword = "";
    private int billID;
    private String createdAt;
    private Order order;
    private String email;
    private Coupon coupon;
    private double payableAmount;
    private double GST;
    private String paidAt;
    private BillStatus status;

    public Bill() {
        this.billID = 0;
        this.createdAt = "";
        this.order = null;
        this.email = "";
        this.coupon = null;
        this.payableAmount = 0.0;
        this.GST = 0.0;
        this.paidAt = "";
        this.status = null;
    }

    public Bill(int billID, String createdAt, Order order, String email, Coupon coupon, double payableAmount,
            double GST,
            String paidAt, BillStatus status) {
        this.billID = billID;
        this.createdAt = createdAt;
        this.order = new Order(order);
        this.email = email;
        this.coupon = coupon == null ? null : new Coupon(coupon);
        this.payableAmount = payableAmount;
        this.GST = GST;
        this.paidAt = paidAt;
        this.status = status;
    }

    public Bill(Bill otherBill) {
        this.billID = otherBill.billID;
        this.createdAt = otherBill.createdAt;
        this.order = new Order(otherBill.order);
        this.email = otherBill.email;
        this.coupon = otherBill.coupon == null ? null : new Coupon(coupon);
        this.payableAmount = otherBill.payableAmount;
        this.GST = otherBill.GST;
        this.paidAt = otherBill.paidAt;
        this.status = otherBill.status;
    }

    public Bill(int billID) {
        this.billID = billID;
        this.createdAt = "";
        this.order = null;
        this.email = "";
        this.coupon = null;
        this.payableAmount = 0.0;
        this.GST = 0.0;
        this.paidAt = "";
        this.status = null;
    }

    public Bill(Order order) {
        this.billID = 0;
        this.createdAt = "";
        this.order = new Order(order);
        this.email = "";
        this.coupon = null;
        this.payableAmount = 0.0;
        this.GST = 0.0;
        this.paidAt = "";
        this.status = null;
    }

    public boolean createBill() {
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement(
                    "select auto_increment from information_schema.tables where table_name = 'Bill'");
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                this.billID = result.getInt("auto_increment");
            }

            PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO BILL (OrderID) VALUES (?)");
            stmt1.setInt(1, this.order.getOrderID());

            stmt1.executeUpdate();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean applyCoupon(String couponCode) {
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn
                    .prepareStatement("SELECT CouponID from Coupon where Code = ? and Status = 'Active'");
            stmt.setString(1, couponCode);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                this.coupon = (new Coupon(result.getInt("CouponID"))).getCoupon();

                stmt = conn.prepareStatement("UPDATE Bill SET CouponID = ? WHERE BillID = ?");
                stmt.setInt(1, result.getInt("CouponID"));
                stmt.setInt(2, this.billID);
                stmt.executeUpdate();

                return true;
            }

            return false;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Bill getBill() {
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("UPDATE Bill SET GST = (select (totalAmount * 0.07) from Bill JOIN Orders on Bill.OrderID = Orders.OrderID where BillID = ?) WHERE BillID = ?");
            stmt.setInt(1, this.billID);
            stmt.setInt(2, this.billID);
            stmt.executeUpdate();

            stmt = conn.prepareStatement("UPDATE Bill SET PayableAmount = (SELECT (totalAmount + GST) from Bill JOIN Orders on Bill.OrderID = Orders.OrderID where BillID = ?) WHERE BillID = ?");
            stmt.setInt(1, this.billID);
            stmt.setInt(2, this.billID);
            stmt.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement("SELECT * from Bill where BillID = ?");
            stmt2.setInt(1, this.billID);

            ResultSet result = stmt2.executeQuery();

            if (result.next()) {
                this.createdAt = result.getString("CreatedAt");
                this.order = (new Order(result.getInt("OrderID")).getOrder());
                this.email = result.getString("Email") == null ? "" : result.getString("Email");
                this.coupon = result.getInt("CouponID") == 0 ? null
                        : (new Coupon(result.getInt("CouponID"))).getCoupon();
                this.payableAmount = result.getDouble("PayableAmount");
                this.GST = result.getDouble("GST");
                this.paidAt = result.getString("PaidAt") == null ? "" : result.getString("PaidAt");
                this.status = BillStatus.valueOf(result.getString("Status"));

                return this;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public int getBillID() {
        return this.billID;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public Order getOrder() {
        return this.order;
    }

    public String getEmail() {
        return this.email;
    }

    public Coupon getCoupon() {
        return this.coupon;
    }

    public double getPayableAmount() {
        return this.payableAmount;
    }

    public double getGST() {
        return this.GST;
    }

    public String getPaidAt() {
        return this.paidAt;
    }

    public BillStatus getStatus() {
        return this.status;
    }

    public void setBillID(int id) {
        this.billID = id;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setOrder(Order order) {
        this.order = new Order(order);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = new Coupon(coupon);
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public void setGST(double GST) {
        this.GST = GST;
    }

    public void setPaidAt(String paidAt) {
        this.paidAt = paidAt;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        Bill bill = null;
        if (obj instanceof Bill) {
            bill = (Bill) obj;
        } else {
            return false;
        }

        if (this.billID == bill.billID) {
            if (this.createdAt.equals(bill.createdAt)) {
                if (this.order.equals(bill.order)) {
                    if (this.email.equals(bill.email)) {
                        if (this.coupon.equals(bill.coupon)) {
                            if (this.payableAmount == bill.payableAmount) {
                                if (this.GST == bill.GST) {
                                    if (this.paidAt.equals(bill.paidAt)) {
                                        if (this.status.equals(bill.status)) {
                                            return true;
                                        }
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ID :");
        str.append(this.billID + "\n");
        str.append("Created At :");
        str.append(this.createdAt + "\n");
        str.append("Order :");
        str.append(this.order + "\n");
        str.append("Email :");
        str.append(this.email + "\n");
        str.append("Coupon :");
        str.append(this.coupon + "\n");
        str.append("Payable Amount :");
        str.append(this.payableAmount + "\n");
        str.append("GST :");
        str.append(this.GST + "\n");
        str.append("Paid At :");
        str.append(this.paidAt + "\n");
        str.append("Status :");
        str.append(this.status + "\n");

        return str.toString();
    }
}