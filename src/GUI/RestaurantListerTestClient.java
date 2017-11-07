package GUI;
import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RestaurantListerTestClient {
    private static void createOR3GUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("OR3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.setPreferredSize(new Dimension(1000,700));

        //List of Restaurant
        frame.add(new RestaurantLister(new ArrayList<>(new SqliteRestaurantDAO().getAll())));


        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createOR3GUI();
            }
        });
    }
}
