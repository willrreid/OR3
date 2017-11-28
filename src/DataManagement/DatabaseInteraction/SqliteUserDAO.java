package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.User;

import java.sql.*;

public class SqliteUserDAO extends SqliteDAO<User>{
    protected String table_name = "user";

    protected User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId( rs.getInt("id"));
        user.setUsername( rs.getString("username"));
        user.setPassword( rs.getString("password"));
        user.setJoin_date( rs.getInt("join_date"));
        user.setBio( rs.getString("bio"));
        user.setAdmin( rs.getBoolean("admin"));
        return user;
    }

    public boolean save(User user) {
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps;
            if (user.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE user SET username=?, password=?, join_date=?, bio=?, admin=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(5, user.getId());
            }
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getJoin_date());
            ps.setString(4, user.getBio());
            ps.setBoolean(5, user.isAdmin());
            int i = ps.executeUpdate();
            if (i == 1) {
                if (user.getId() == null) {
                    user.setId(ps.getGeneratedKeys().getInt(1));
                }
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public User getByName(String name){
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + getTableName() + " WHERE username='" + name + "'");
            if(rs.next())
            {
                User returnValue = extractFromResultSet(rs);
                stmt.close();
                rs.close();
                return returnValue;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected String getTableName() {
        return table_name;
    }
}
