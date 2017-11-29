package GUI;

import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseInteraction.SqliteReviewDAO;
import DataManagement.DatabaseTransferObject.Restaurant;
import DataManagement.DatabaseTransferObject.Review;
import DataManagement.DatabaseTransferObject.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by will on 10/25/17.
 */
public class SearchResultView extends JPanel implements ActionListener {

    RestaurantLister resultList;
    JPanel infoView;
    JPanel writeView;

    JComboBox rating;
    JTextArea review;
    JButton submit;

    SearchResultView(String s) {

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setActionCommand("submit");

        add(resultPanel(s));
    }

    JPanel resultPanel(String s) {
        JPanel tablePanel = new JPanel();
        resultList = new RestaurantLister(new ArrayList<>(new SqliteRestaurantDAO().search(s)), this);
        tablePanel.add(resultList);
        return tablePanel;
    }

    JPanel info(Restaurant r) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        JPanel info = new JPanel();
        info.setLayout(new FlowLayout());
        info.add(new JLabel(r.getName()));
        info.add(new JLabel(r.getCategory()));
        info.add(new JLabel(r.getAddress()));
        info.add(new JLabel(r.getWebsite()));

        JPanel reviews = new ReviewLister(new ArrayList<>(new SqliteReviewDAO().getForRestaurantID(r.getId())), this);

        container.add(info);
        container.add(reviews);

        return container;
    }

    JPanel addReview() {
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());


        rating = new JComboBox();
        rating.addItem(1);
        rating.addItem(2);
        rating.addItem(3);
        rating.addItem(4);
        rating.addItem(5);
        review = new JTextArea(20,20);

        container.add(rating, BorderLayout.NORTH);
        container.add(review, BorderLayout.CENTER);
        container.add(submit, BorderLayout.SOUTH);

        return container;

    }

    public void displayForRestaurant(Restaurant r) {
        if (infoView != null) {
            remove(infoView);
        }
        if (writeView != null) {
            remove(writeView);
        }
        infoView = info(r);
        writeView = addReview();
        add(infoView);
        add(writeView);
        validate();
    }

    public void displayNone() {
        if (infoView != null) {
            remove(infoView);
        }
        if (writeView != null) {
            remove(writeView);
        }
        infoView = null;
        writeView = null;
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "submit":
                User user = UserAuthentication.Authenticator.loggedInUser();
                if (user == null){
                    JOptionPane.showMessageDialog(new Frame(), "Please log in before submitting a review.");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Review r = new Review(user.getId(),resultList.getSelected().getRestaurant().getId(), sdf.format(new Date()), rating.getSelectedIndex()+1, review.getText());
                r.setBody(review.getText());
                new SqliteReviewDAO().save(r);
        }
    }
}