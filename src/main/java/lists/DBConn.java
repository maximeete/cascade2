package lists;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn {
    final static private String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    final static private String URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
    final static private String USERNAME = "root";
    final static private String PASSWORD = "963852";

    public DBConn() {
    }


    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
