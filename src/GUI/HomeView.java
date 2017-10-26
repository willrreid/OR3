package GUI;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {

    HomeView() {
        setLayout(new BorderLayout());
        add(initTop(), BorderLayout.NORTH);
    }

    JTextField searchField = new JTextField(30);
    JButton searchButton = new JButton("Search");
    JButton loginButton = new JButton("Log In");
    JButton profileButton = new JButton("Profile");

    private JPanel initTop() {
        JPanel panel = new JPanel();
        JPanel searchPanel = new JPanel();
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel);
        panel.add(loginButton);
        return panel;
    }
}
