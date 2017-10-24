package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.Review;

import java.sql.*;

public class SqliteReviewDAO extends SqliteDAO<Review> {
    protected String table_name = "review";

    protected Review extractFromResultSet(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setId(rs.getInt("id"));
        review.setUser_id(rs.getInt("user_id"));
        review.setTime(rs.getInt("time"));
        review.setRating(rs.getInt("rating"));
        review.setBody(rs.getString("body"));
        return review;
    }

    public boolean save(Review review) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps;
            if (review.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO review VALUES (NULL, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE review SET user_id=?, time=?, rating=?, body=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(5, review.getId());
            }
            ps.setInt(1, review.getUser_id());
            ps.setInt(2, review.getTime());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getBody());
            int i = ps.executeUpdate();
            if (i == 1) {
                if (review.getId() == null) {
                    review.setId(ps.getGeneratedKeys().getInt(1));
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
