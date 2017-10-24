package GUI;
import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;

import javax.swing.*;
import java.util.ArrayList;

public class Home {
    private static void createOR3GUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("OR3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title
        JLabel label = new JLabel("OR3");
        frame.getContentPane().add(label);

        //List of Restaurants
        JScrollPane jScrollPane = new JScrollPane();
        JTable rTable = new JTable();
        rTable.setModel(new RestaurantLister(new ArrayList<>(new SqliteRestaurantDAO().getAll())));
        jScrollPane.setViewportView(rTable);
        frame.getContentPane().add(jScrollPane);

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
