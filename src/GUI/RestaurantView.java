package GUI;

import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.*;
import java.awt.*;

public class RestaurantView extends JPanel {

    private Restaurant restaurant;
    private Boolean selected = false;

    public RestaurantView(Restaurant r){
        this.restaurant = r;
        JLabel addressLabel, categoryLabel, websiteLabel;

        setMaximumSize(new Dimension(300, 100));

        addressLabel = new JLabel(r.getAddress());
        categoryLabel = new JLabel(r.getCategory());
        websiteLabel = new JLabel(r.getWebsite());

        setLayout(new GridLayout(3,2,0,0));
        add(new JLabel("Address:"));
        add(addressLabel);
        add(new JLabel("Category:"));
        add(categoryLabel);
        add(new JLabel("Website:"));
        add(websiteLabel);

        setBorder(BorderFactory.createTitledBorder(r.getName()));

    }

    public Restaurant getRestaurant(){
        return this.restaurant;
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
