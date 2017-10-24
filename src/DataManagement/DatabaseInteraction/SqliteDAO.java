package DataManagement.DatabaseInteraction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public abstract class SqliteDAO<T> {
    abstract protected  String getTableName();
    abstract protected T extractFromResultSet(ResultSet rs) throws SQLException;
    abstract public boolean save(T DTO);
    public T getById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + getTableName() + " WHERE id=" + id);
            if(rs.next())
            {
                return extractFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Set<T> getAll(){
            Connection connection = ConnectionFactory.getConnection();
            Set<T> result = new HashSet<T>();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + getTableName());
                while (rs.next())
                {
                    result.add(extractFromResultSet(rs));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
    }

    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM " + getTableName() + " WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
