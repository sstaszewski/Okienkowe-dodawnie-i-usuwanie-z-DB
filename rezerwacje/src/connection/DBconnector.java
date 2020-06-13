package connection;

import java.sql.*;

public class DBconnector {
    private static DBconnector instance;
    private DBconnector() {
    }
    public static DBconnector getInstance() {
        if (instance == null) {
            instance = new DBconnector();
        }
        return instance;
    }
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String user = "java";
        String password = "java";
        Connection connection= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}