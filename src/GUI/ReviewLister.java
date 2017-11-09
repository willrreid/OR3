package GUI;

import DataManagement.DatabaseTransferObject.Review;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by will on 11/8/17.
 */
public class ReviewLister extends JPanel {

    private SearchResultView parent;
    private List<Review> reviews = new ArrayList<>();
    private List<ReviewView> reviewViews = new ArrayList<>();
    private ReviewView selected = null;

    public ReviewLister(List<Review> reviews, SearchResultView parent) {
        this.parent = parent;
        this.reviews = reviews;

        for (Review r : this.reviews) {
            System.out.print("ADDING A REVIEW");
            reviewViews.add(new ReviewView(r));
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(pane);
        scrollPane.setPreferredSize(new Dimension(325,600));
        add(scrollPane);



        for (ReviewView rv : this.reviewViews){
            pane.add(rv);
            rv.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (getSelected() != null) {
                        getSelected().setSelected(false);
                    }
                    if (getSelected() == rv){
                        setSelected(null);
                        rv.setSelected(false);
                    }
                    else {
                        setSelected(rv);
                        rv.setSelected(true);
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

        setBorder(BorderFactory.createTitledBorder("Reviews"));

    }

    public ReviewView getSelected() {
        return selected;
    }

    public void setSelected(ReviewView selected) {
        this.selected = selected;
    }
}