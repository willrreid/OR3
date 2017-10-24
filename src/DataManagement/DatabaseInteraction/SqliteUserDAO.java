package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.User;

import java.sql.*;

public class SqliteUserDAO extends SqliteDAO<User>{
    protected String table_name = "user";

    protected User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId( rs.getInt("id"));
        user.setUsername( rs.getString("username"));
        user.setJoin_date( rs.getInt("join_date"));
        user.setBio( rs.getString("bio"));
        user.setAdmin( rs.getBoolean("admin"));
        return user;
    }

    public boolean save(User user) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps;
            if (user.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE user SET username=?, join_date=?, bio=?, admin=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(5, user.getId());
            }
            ps.setString(1, user.getUsername());
            ps.setInt(2, user.getJoin_date());
            ps.setString(3, user.getBio());
            ps.setBoolean(4, user.isAdmin());
            int i = ps.executeUpdate();
            if (i == 1) {
                if (user.getId() == null) {
                    user.setId(ps.getGeneratedKeys().getInt(1));
                }
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    protected String getTableName() {
        return table_name;
    }
}
