import java.sql.*;

public class DBConnection {


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // ✅ Load the JDBC driver class
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("✅ JDBC Driver loaded!");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}


        String url = "jdbc:mysql://localhost:3306/employee_db";
        String user = "root";     // your MySQL username
        String password = "Meet@2004";     // your MySQL password

        return DriverManager.getConnection(url, user, password);
    }
}
