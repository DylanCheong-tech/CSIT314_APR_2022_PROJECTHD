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
    private String paidAt;
    private BillStatus status;

    public Bill() {
        this.billID = 0;
        this.createdAt = "";
        this.order = null;
        this.email = "";
        this.coupon = null;
        this.payableAmount = 0.0;
        this.paidAt = "";
        this.status = null;
    }

    public Bill(int billID, String createdAt, Order order, String email, Coupon coupon, double payableAmount,
            String paidAt, BillStatus status) {
        this.billID = billID;
        this.createdAt = createdAt;
        this.order = new Order(order);
        this.email = email;
        this.coupon = coupon == null ? null : new Coupon(coupon);
        this.payableAmount = payableAmount;
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
        this.paidAt = "";
        this.status = null;
    }

    public boolean createBill() {
        try (

                Connection conn = DriverManager.getConnection(
                        connStr, dbusername, dbpassword);

        ) {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO BILL (OrderID) VALUES (?)");
            stmt.setInt(1, this.order.getOrderID());

            stmt.executeUpdate();

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

            PreparedStatement stmt = conn.prepareStatement("SELECT * from Bill where BillID = ?");
            stmt.setInt(1, this.billID);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                this.createdAt = result.getString("CreatedAt");
                this.order = (new Order(result.getInt(result.getInt("OrderID"))).getOrder());
                this.email = result.getString("Email") == null ? "" : result.getString("Email");
                this.coupon = result.getInt("CouponID") == 0 ? new Coupon() : (new Coupon(result.getInt("CouponID"))).getCoupon();
                this.payableAmount = result.getDouble("Payable Amount");
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

        return false;
    }

    @Override
    public String toString(){
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
        str.append("Paid At :");
        str.append(this.paidAt + "\n");
        str.append("Status :");
        str.append(this.status + "\n");

        return str.toString();
    }
}