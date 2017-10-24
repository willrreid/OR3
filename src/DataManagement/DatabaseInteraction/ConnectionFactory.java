package DataManagement.DatabaseInteraction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection conn;
    private static final String URL = "jdbc:sqlite:src/Database/or3.db";

    public static Connection getConnection()
    {
        try {
            conn = DriverManager.getConnection(URL);
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    /**
     * Test Connection
     */
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
