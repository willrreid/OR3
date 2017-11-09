package GUI;

import DataManagement.DatabaseInteraction.SqliteRestaurantDAO;
import DataManagement.DatabaseInteraction.SqliteReviewDAO;
import DataManagement.DatabaseTransferObject.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by will on 10/25/17.
 */
public class SearchResultView extends JPanel implements ActionListener {

    RestaurantLister resultList;
    JPanel infoView;
    JPanel writeView;

    JTextArea review;
    JButton submit;

    SearchResultView(String s) {
        review = new JTextArea();

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

        container.add(review, BorderLayout.CENTER);
        container.add(submit, BorderLayout.SOUTH);

        return container;

    }

    public void displayForRestaurant(Restaurant r) {
        remove(infoView);
        remove(writeView);
        infoView = info(r);
        writeView = addReview();
        add(infoView);
        add(infoView);
        validate();
    }

    public void actionPerformed(ActionEvent actionEvent) {

    }
}