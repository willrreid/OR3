package GUI;

import DataManagement.DatabaseTransferObject.Review;
import com.sun.org.apache.regexp.internal.RE;

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

        setMaximumSize(new Dimension(300, 100));

        userID = new JLabel(r.getUser_id().toString());
        rating = new JLabel(r.getRating().toString());
        time = new JLabel(r.getTime().toString());
        body = new JTextField(r.getBody());
        body.setEditable(false);

        setLayout(new GridLayout(3,2,0,0));
        add(new JLabel("Posted By:"));
        add(userID);
        add(new JLabel("Rating:"));
        add(rating);
        add(new JLabel("Time:"));
        add(time);
        add(new JLabel("Review:"));
        add(body);

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

