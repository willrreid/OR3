package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.Restaurant;
import DataManagement.DatabaseTransferObject.Review;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SqliteReviewDAO extends SqliteDAO<Review> {
    protected String table_name = "review";

    protected Review extractFromResultSet(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setId(rs.getInt("id"));
        review.setUser_id(rs.getInt("user_id"));
        review.setRestaurant_id(rs.getInt("restaurant_id"));
        review.setTime(rs.getString("time"));
        review.setRating(rs.getInt("rating"));
        review.setBody(rs.getString("body"));
        return review;
    }

    public boolean save(Review review) {
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps;
            if (review.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO review VALUES (NULL, ?, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE review SET user_id=?, restaurant_id=?, time=?, rating=?, body=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(6, review.getId());
            }
            ps.setInt(1, review.getUser_id());
            ps.setInt(2, review.getRestaurant_id());
            ps.setString(3, review.getTime());
            ps.setInt(4, review.getRating());
            ps.setString(5, review.getBody());
            int i = ps.executeUpdate();
            if (i == 1) {
                if (review.getId() == null) {
                    review.setId(ps.getGeneratedKeys().getInt(1));
                }
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Set<Review> getForRestaurantID(Integer i) {
        Connection connection = ConnectionFactory.getConnection();
        Set<Review> result = new HashSet<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM review WHERE restaurant_id = " + i.toString());
            while (rs.next()) {
                result.add(extractFromResultSet(rs));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    protected String getTableName() {
        return table_name;
    }
}
