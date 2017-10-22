import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URLClassLoader;


/**
 * Created by will on 10/21/17.
 */
public class DAO {
    Connection conn = null;
    DAO() {
        try {
            String url = "jdbc:sqlite:src/Database/test1.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
