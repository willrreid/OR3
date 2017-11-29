package GUI.AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by will on 10/21/17.
 */
public class AdminPanel extends JDialog {
    private JButton addRestaurant = new JButton("Add Restaurant");
    private JButton manageAdmins = new JButton("Manage Admins");
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
        this.add(manageAdmins);
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

        manageAdmins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { new ManageAdmins(); }
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
