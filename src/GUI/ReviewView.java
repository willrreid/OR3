package GUI;

import DataManagement.DatabaseInteraction.SqliteReportDAO;
import DataManagement.DatabaseInteraction.SqliteReviewDAO;
import DataManagement.DatabaseInteraction.SqliteUserDAO;
import DataManagement.DatabaseTransferObject.Report;
import DataManagement.DatabaseTransferObject.Review;
import DataManagement.DatabaseTransferObject.User;
import UserAuthentication.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by will on 11/8/17.
 */
public class ReviewView extends JPanel {

    private Review review;
    private Boolean selected = false;
    private JButton deleteButton;
    private ReviewLister parent;

    public ReviewView(Review r, ReviewLister parent){
        this.parent = parent;
        this.review = r;
        JLabel userID, rating, time;

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
        infoPanel.add(new JLabel("Date:"));
        infoPanel.add(time);

        setLayout(new BorderLayout());
        add(infoPanel, BorderLayout.NORTH);

        JTextArea reviewArea = new JTextArea();
        reviewArea.setLineWrap(true);
        reviewArea.setText(r.getBody());
        reviewArea.setEditable(false);

        add(reviewArea, BorderLayout.CENTER);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SqliteReviewDAO().delete(r.getId());
                parent.updateParent();
                removeMe();
            }
        });

        JButton reportButton = new JButton("Report as Inappropriate");
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Report report = new Report(UserAuthentication.Authenticator.loggedInUser().getId(), r.getId(), 1, "");
                new SqliteReportDAO().save(report);
                reportButton.setText("Flagged for Review");
                reportButton.setEnabled(false);
            }
        });

        if (Authenticator.loggedInUser() != null && Authenticator.loggedInUser().isAdmin()) {
            add(deleteButton, BorderLayout.SOUTH);
        } else if (Authenticator.loggedInUser() != null){
            add(reportButton, BorderLayout.SOUTH);
        }

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

    public JButton getDeleteButton(){
        return this.deleteButton;
    }

    public void removeMe(){
        parent.removeReviewView(this);
    }
}

