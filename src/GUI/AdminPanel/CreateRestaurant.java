package GUI.AdminPanel;

import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseTransferObject.Restaurant;
import DataManagement.DatabaseTransferObject.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRestaurant extends JDialog{
    private JTextField nameField = new JTextField();
    private JTextField addressField = new JTextField();
    private String[] categories = {"Fast Food","Thai","Fusion","Chinese","Indian","Japanese","Korean","BBQ","Italian","Diner","Drive-in","Dive"};
    private JComboBox categoryField = new JComboBox(categories);
    private JTextField websiteField = new JTextField();
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel addressLabel = new JLabel("Address:");
    private JLabel categoryLabel = new JLabel("Category:");
    private JLabel websiteLabel = new JLabel("Website:");
    private JButton submitButton = new JButton("Submit");
    private JButton cancelButton = new JButton("Cancel");
    public User user = null;

    public CreateRestaurant(){
        setupUI();
        setUpListeners();
    }

    public void setupUI(){
        this.setTitle("Add Restaurant");

        this.setSize(500,500);
        this.setLayout(new GridLayout(5,2));

        this.add(nameLabel);
        this.add(nameField);
        this.add(addressLabel);
        this.add(addressField);
        this.add(categoryLabel);
        this.add(categoryField);
        this.add(websiteLabel);
        this.add(websiteField);
        this.add(submitButton);
        this.add(cancelButton);

        this.setVisible(true);
    }

    private void setUpListeners(){
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean admin = (UserAuthentication.Authenticator.loggedInUser() != null && UserAuthentication.Authenticator.loggedInUser().isAdmin() == true);
                if (!admin) {
                    JOptionPane.showMessageDialog(new Frame(), "Only an admin can perform this action.");
                } else {
                    Restaurant restaurant = new Restaurant(true,nameField.getText(),addressField.getText(),categories[categoryField.getSelectedIndex()],websiteField.getText());
                    new SqliteRestaurantDAO().save(restaurant);
                }
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
