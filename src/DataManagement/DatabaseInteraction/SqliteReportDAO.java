package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.Report;
import UserAuthentication.Authenticator;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SqliteReportDAO extends SqliteDAO<Report> {
    protected String table_name = "report";

    protected Report extractFromResultSet(ResultSet rs) throws SQLException {
        Report report = new Report();
        report.setId( rs.getInt("id") );
        report.setReporting_user( rs.getInt("reporting_user") );
        report.setReview_id( rs.getInt("review_id"));
        report.setTime( rs.getInt("time"));
        report.setMessage( rs.getString("message") );
        return report;
    }

    public boolean save(Report report){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps;
            if (report.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO report VALUES (NULL, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE report SET reporting_user=?, " +
                        "review_id=?, time=?, message=?, WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(5, report.getId());
            }
            ps.setInt(1, report.getReporting_user());
            ps.setInt(2, report.getReview_id());
            ps.setInt(3, report.getTime());
            ps.setString(4, report.getMessage());
            int i = ps.executeUpdate();
            if(i == 1) {
                if (report.getId() == null){
                    report.setId(ps.getGeneratedKeys().getInt(1));
                }
                ps.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean wasReported(int reviewID) {
        if (Authenticator.loggedInUser() == null) {
            return false;
        }
        ResultSet rs;
        try (Connection connection = ConnectionFactory.getConnection()) {
            Set<Report> Result = new HashSet<Report>();
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM report WHERE reporting_user=? AND review_id=?"
            );
            ps.setInt(1, Authenticator.loggedInUser().getId());
            ps.setInt(2, reviewID);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    protected String getTableName() {
        return table_name;
    }
}
