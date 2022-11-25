import java.sql.*;
import java.util.*;

public class CrudDelete {
    static final String DB_url = "jdbc:mysql://localhost:3306/cognizant";
    static final String user = "root";
    static final String pass = "1234567890";
    static final String Query = "select * from customers";
    static final String sql = "Delete from customers where cust_id=?";

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(DB_url, user, pass);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(Query)) {

            while (rs.next()) {
                System.out.println("customer Id=" + rs.getInt("cust_id"));
                System.out.println("customer First Name=" + rs.getString("cust_fname"));
                System.out.println("customer Last Name=" + rs.getString("cust_lname"));
                System.out.println("customer Age=" + rs.getInt("cust_age"));
                System.out.println("customer Address=" + rs.getString("cust_address"));
                System.out.println("customer Income=" + rs.getInt("cust_income"));
            }
            System.out.println("--------------------------------------");
            System.out.println("Enter customer Id");
            Scanner sc = new Scanner(System.in);
            int cid = sc.nextInt();

            ps.setInt(1, cid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}