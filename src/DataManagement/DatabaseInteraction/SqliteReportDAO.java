package DataManagement.DatabaseInteraction;

import DataManagement.DatabaseTransferObject.Report;

import java.sql.*;

public class SqliteReportDAO extends SqliteDAO<Report> {
    protected String table_name = "report";

    protected Report extractFromResultSet(ResultSet rs) throws SQLException {
        Report report = new Report();
        report.setId( rs.getInt("id") );
        report.setReporting_user( rs.getInt("reporting_user") );
        report.setReported_user( rs.getInt("reported_user"));
        report.setReview_id( rs.getInt("review_id"));
        report.setTime( rs.getInt("time"));
        report.setMessage( rs.getString("message") );
        return report;
    }

    public boolean save(Report report){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement ps;
            if (report.getId() == null) {
                ps = connection.prepareStatement("INSERT INTO report VALUES (NULL, ?, ?, ?, ?, ?)");
            } else {
                ps = connection.prepareStatement("UPDATE report SET reporting_user=?, reported_user=?, " +
                        "review_id=?, time=?, message=?, WHERE id=?", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(6, report.getId());
            }
            ps.setInt(1, report.getReporting_user());
            ps.setInt(2, report.getReported_user());
            ps.setInt(3, report.getReview_id());
            ps.setInt(4, report.getTime());
            ps.setString(5, report.getMessage());
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

    @Override
    protected String getTableName() {
        return table_name;
    }
}
