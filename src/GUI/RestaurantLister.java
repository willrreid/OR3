package GUI;

import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class RestaurantLister extends JPanel {

    private SearchResultView parent;
    private List<Restaurant>  restaurants = new ArrayList<>();
    private List<RestaurantView> restaurantViews = new ArrayList<>();
    private RestaurantView selected = null;

    public RestaurantLister(List<Restaurant> restaurants, SearchResultView parent) {
        this.parent = parent;
        this.restaurants = restaurants;

        for (Restaurant r : this.restaurants) {
            System.out.print("ADDING A RESTAURANT");
            restaurantViews.add(new RestaurantView(r));
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(pane);
        scrollPane.setPreferredSize(new Dimension(325,560));
        add(scrollPane);



        for (RestaurantView rv : this.restaurantViews){
            pane.add(rv);
            rv.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (getSelected() != null) {
                        getSelected().setSelected(false);
                    } else {
                        parent.displayNone();
                    }
                    if (getSelected() == rv){
                        setSelected(null);
                        rv.setSelected(false);
                    }
                    else {
                        setSelected(rv);
                        rv.setSelected(true);
                        parent.displayForRestaurant(rv.getRestaurant());
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        setBorder(BorderFactory.createTitledBorder("Restaurants"));

    }

    public RestaurantView getSelected() {
        return selected;
    }

    public void setSelected(RestaurantView selected) {
        this.selected = selected;
    }
}