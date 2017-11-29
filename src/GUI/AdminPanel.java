package GUI;

import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseTransferObject.Report;
import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by will on 10/21/17.
 */
public class AdminPanel extends JDialog {
    private JButton addRestaurant = new JButton("Add Restaurant");
    private JButton updateAdmins = new JButton("Update Admins");
    private JButton getStatistics = new JButton("Get Statistics");
    private JButton exitButton = new JButton("Exit");

    public AdminPanel() {
        setupUI();
        setUpListeners();
    }

    public void setupUI() {
        this.setTitle("Admin Panel");
        this.setSize(300,100);
        this.setLayout(new GridLayout(4,2));

        this.add(addRestaurant);
        this.add(updateAdmins);
        this.add(getStatistics);
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

        updateAdmins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        getStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
    }

}
