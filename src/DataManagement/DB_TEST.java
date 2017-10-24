package DataManagement;

import DataManagement.DatabaseInteraction.SqliteReportDAO;
import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseInteraction.SqliteReviewDAO;
import DataManagement.DatabaseInteraction.SqliteUserDAO;
import DataManagement.DatabaseTransferObject.Report;
import DataManagement.DatabaseTransferObject.Restaurant;
import DataManagement.DatabaseTransferObject.Review;
import DataManagement.DatabaseTransferObject.User;

public class DB_TEST {

    public static void main(String[] args) {
        SqliteReportDAO reportDAO = new SqliteReportDAO();
        SqliteRestaurantDAO restaurantDAO = new SqliteRestaurantDAO();
        SqliteReviewDAO reviewDAO = new SqliteReviewDAO();
        SqliteUserDAO userDAO = new SqliteUserDAO();

        User user1 = new User("Mason", 12345, "The best, around", true);
        User user2 = new User("Will", 54321, "Nothing's gonna ever bring him down", false);

        Restaurant restaurant1 = new Restaurant(true, "McDonald's", "1 McNugget Way", "Fast", "McDonalds.com");
        Restaurant restaurant2 = new Restaurant(true, "Subway", "1 Footlong Drive", "Fast", "subway.com");

        Review review1 = new Review(1, 100, 10, "Great food!");
        Review review2 = new Review(2, 200, 5, "Ok I guess.");

        Report report1 = new Report(1, 2, 1, 66, "Rude af");
        Report report2 = new Report(2, 1, 2, 77, "Bein mean");

        userDAO.save(user1);
        userDAO.save(user2);

        restaurantDAO.save(restaurant1);
        restaurantDAO.save(restaurant2);

        reviewDAO.save(review1);
        reviewDAO.save(review2);

        reportDAO.save(report1);
        reportDAO.save(report2);

        System.out.println(userDAO.getAll());
        System.out.println(restaurantDAO.getAll());
        System.out.println(reviewDAO.getAll());
        System.out.println(reportDAO.getAll());

        System.out.println(userDAO.getById(1));
        System.out.println(restaurantDAO.getById(1));
        System.out.println(reviewDAO.getById(1));
        System.out.println(reportDAO.getById(1));
    }
}
