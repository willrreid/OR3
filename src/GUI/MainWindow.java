package GUI;
import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow {

    private static void createOR3GUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("OR3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(new HomeView());
        frame.getContentPane().add(new JButton("HOME"));
        frame.setSize(600,400);

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



