import DataManagement.DatabaseTransferObject.Report;

/**
 * Created by will on 10/21/17.
 */
public class AdminPanel {

    public void makeAdmin(String username) {
        //TODO update user table
    }

    public Report[] getReports() {
        //TODO get reports from report table;

        Report[] r = new Report[1];
        return r;
    }

    public void resolveReport(Report r) {
        return;
        //r.resolve();
    }

    public int addRestaurant(String name,
                             String address,
                             String category,
                             String website,
                             boolean visible) {
        //TODO add to restaurant table, get ID
        return 1;
    }

    public void setVisible(int RestaurantID) {
        //TODO update restaurant table
    }

}
