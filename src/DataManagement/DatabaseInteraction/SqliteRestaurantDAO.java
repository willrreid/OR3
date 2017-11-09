package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.Restaurant;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SqliteRestaurantDAO extends SqliteDAO<Restaurant>{
    protected String table_name = "restaurant";

    protected Restaurant extractFromResultSet(ResultSet rs) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setId( rs.getInt("id"));
        restaurant.setVisible( rs.getBoolean("visible"));
        restaurant.setName( rs.getString("name"));
        restaurant.setAddress( rs.getString("address"));
        restaurant.setCategory( rs.getString("category"));
        restaurant.setWebsite( rs.getString("website"));
        return restaurant;
    }

    public boolean save(Restaurant restaurant){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps;
            if (restaurant.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO restaurant VALUES (NULL, ?, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE restaurant SET visible=?, name=?, address=?," +
                        " category=?, website=?, WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(6, restaurant.getId());
            }
            ps.setBoolean(1, restaurant.isVisible());
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getAddress());
            ps.setString(4, restaurant.getCategory());
            ps.setString(5, restaurant.getWebsite());
            int i = ps.executeUpdate();
            if(i == 1) {
                if (restaurant.getId() == null){
                    restaurant.setId(ps.getGeneratedKeys().getInt(1));
                }
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Set<Restaurant> search(String s){
        Connection connection = ConnectionFactory.getConnection();
        Set<Restaurant> result = new HashSet<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurant WHERE name LIKE \"%" + s +"%\"");
            while (rs.next()) {
                System.out.println("A RESULT");
                result.add(extractFromResultSet(rs));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.print(result);
        return result;
    }

    @Override
    protected String getTableName() {
        return table_name;
    }
}
