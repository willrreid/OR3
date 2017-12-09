package GUI.AdminPanel;

import DataManagement.DatabaseInteraction.SqliteReportDAO;
import DataManagement.DatabaseInteraction.SqliteReviewDAO;
import DataManagement.DatabaseTransferObject.Report;
import DataManagement.DatabaseTransferObject.Review;
import GUI.ReviewLister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by will on 10/21/17.
 */
public class AdminPanel extends JDialog {
    private JButton addRestaurant = new JButton("Add Restaurant");
    private JButton manageAdmins = new JButton("Manage Admins");
    private JButton viewFlaggedReviews = new JButton("View Flagged Reviews");
    private JButton exitButton = new JButton("Exit");

    public AdminPanel() {
        setupUI();
        setUpListeners();
    }

    private void setupUI() {
        this.setTitle("Admin Panel");
        this.setSize(300,100);
        this.setLayout(new GridLayout(4,2));

        this.add(addRestaurant);
        this.add(manageAdmins);
        //this.add(getStatistics);
        this.add(viewFlaggedReviews);
        this.add(exitButton);

        this.setVisible(true);
    }

    private void setUpListeners(){
        addRestaurant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateRestaurant();
            }
        });

        manageAdmins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new ManageAdmins(); }
        });

        viewFlaggedReviews.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new ViewReported();}
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
    }

}
