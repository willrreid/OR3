package GUI;

import DataManagement.DatabaseInteraction.SqliteUserDAO;
import DataManagement.DatabaseTransferObject.Review;

import javax.swing.*;
import java.awt.*;

/**
 * Created by will on 11/8/17.
 */
public class ReviewView extends JPanel {

    private Review review;
    private Boolean selected = false;

    public ReviewView(Review r){
        this.review = r;
        JLabel userID, rating, time;
        JTextField body;

        setSize(300,100);
        setMaximumSize(new Dimension(300, 300));

        JPanel infoPanel = new JPanel();

        userID = new JLabel(new SqliteUserDAO().getById(r.getUser_id()).getUsername());
        rating = new JLabel(r.getRating().toString());
        time = new JLabel(r.getTime().toString());

        infoPanel.setLayout(new GridLayout(3,2,0,0));
        infoPanel.add(new JLabel("Posted By:"));
        infoPanel.add(userID);
        infoPanel.add(new JLabel("Rating:"));
        infoPanel.add(rating);
        infoPanel.add(new JLabel("Time:"));
        infoPanel.add(time);

        setLayout(new BorderLayout());
        add(infoPanel, BorderLayout.NORTH);

        JTextArea reviewArea = new JTextArea();
        reviewArea.setLineWrap(true);
        reviewArea.setText(r.getBody());

        add(reviewArea, BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder("Review"));

    }

    public Review getRestaurant(){
        return this.review;
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

