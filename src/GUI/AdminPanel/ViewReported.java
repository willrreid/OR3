package GUI.AdminPanel;

import DataManagement.DatabaseInteraction.SqliteReportDAO;
import DataManagement.DatabaseInteraction.SqliteReviewDAO;
import DataManagement.DatabaseTransferObject.Report;
import DataManagement.DatabaseTransferObject.Review;
import GUI.ReviewLister;
import GUI.ReviewView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ViewReported extends JDialog{
    ReviewLister reviewLister;
    JButton dismissButton = new JButton("Dismiss Reports");

    ViewReported() {
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        this.setTitle("Reported Reviews");

        this.setSize(400,800);
        this.setLayout(new FlowLayout());

        addReported();

        this.add(dismissButton);

        this.setVisible(true);
    }

    private void setupListeners() {
        dismissButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dismiss();
            }
        });
    }

    private void dismiss(){
        Set<Report> reports = new SqliteReportDAO().getAll();
        for (Report r : reports){
            new SqliteReportDAO().delete(r.getId());
        }
        this.setVisible(false);
    }

    public void addReported(){
        if (reviewLister != null) this.remove(0);
        Set<Report> reports = new SqliteReportDAO().getAll();
        ArrayList<Review> reviews = new ArrayList<Review>();
        Set<Integer> reviewIds = new HashSet<Integer>();
        for (Report r: reports) {
            reviewIds.add(r.getReview_id());
        }
        for (Integer i: reviewIds){
            Review review = new SqliteReviewDAO().getById(i);
            if (review != null) reviews.add(review);
        }
        ReviewLister newReviewLister = new ReviewLister(reviews,null);
        this.add(newReviewLister,0);
        this.reviewLister = newReviewLister;
    }
}
