package GUI;

import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.*;
import java.awt.*;

public class RestaurantView extends JPanel {

    private Restaurant restaurant;
    private Boolean selected = false;
    private JLabel averageLabel;

    public RestaurantView(Restaurant r){
        this.restaurant = r;
        JLabel categoryLabel;
        JTextField addressField, websiteField;

        setMaximumSize(new Dimension(300, 100));

        addressField = new JTextField(r.getAddress());
        addressField.setEditable(false);
        categoryLabel = new JLabel(r.getCategory());
        websiteField = new JTextField(r.getWebsite());
        websiteField.setEditable(false);
        this.averageLabel = new JLabel(Float.toString(new SqliteRestaurantDAO().reviewAverageForRestaurantID(r.getId())));

        setLayout(new GridLayout(4,2,0,0));
        add(new JLabel("Address:"));
        add(addressField);
        add(new JLabel("Category:"));
        add(categoryLabel);
        add(new JLabel("Website:"));
        add(websiteField);
        add(new JLabel("Average Rating:"));
        add(this.averageLabel);

        setBorder(BorderFactory.createTitledBorder(r.getName()));

    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }
    public void updateAverage() {
        this.averageLabel.setText(Float.toString(new SqliteRestaurantDAO().reviewAverageForRestaurantID(this.restaurant.getId())));
    }

    public void setSelected(boolean selected){
        if (selected){
            setBackground(UIManager.getColor("Panel.background").darker());
        } else
            setBackground(UIManager.getColor("Panel.background"));
    }

    public boolean isSelected(){
        return this.selected;
    }
}
