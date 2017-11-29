package GUI;
import GUI.AdminPanel.AdminPanel;
import UserAuthentication.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {

    private JFrame frame = new JFrame("OR3");
    private JButton homeButton = new JButton("Home");

    private JPanel topBar;
    private JPanel currentMainPanel;

    JComboBox searchType = new JComboBox();
    JTextField searchField = new JTextField(30);
    JButton searchButton = new JButton("Search");
    JButton loginButton = new JButton("Log In");
    JButton logoutButton = new JButton("Log Out");
    JButton adminPanelButton = new JButton("Admin Panel");

    public MainWindow() {

        searchType.addItem("Name");
        searchType.addItem("Average >=");
        searchType.addItem("Average <=");

        searchField.setActionCommand("updated");
        searchField.addActionListener(this);

        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);

        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);

        logoutButton.setActionCommand("logout");
        logoutButton.addActionListener(this);

        adminPanelButton.setActionCommand("adminPanel");
        adminPanelButton.addActionListener(this);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createOR3GUI();
            }
        });
    }

    private void createOR3GUI() {
        //set up the window.
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        currentMainPanel = new HomeView(this);
        frame.getContentPane().add(currentMainPanel, BorderLayout.CENTER);

        topBar = initTop();
        frame.getContentPane().add(topBar, BorderLayout.NORTH);

        homeButton.addActionListener(this);
        homeButton.setActionCommand("home");

        frame.getContentPane().add(homeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel initTop() {
        JPanel panel = new JPanel();

        panel.add(searchType);
        panel.add(searchField);
        panel.add(searchButton);
        if (Authenticator.loggedInUser() == null) {
            panel.add(loginButton);
        } else {
            panel.add(logoutButton);
        }
        if (Authenticator.loggedInUser() != null && Authenticator.loggedInUser().isAdmin()) {
            panel.add(adminPanelButton);
        }

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())  {
            case "search":
                frame.getContentPane().remove(currentMainPanel);
                if (searchType.getSelectedItem().equals("Name")) {
                    currentMainPanel = new SearchResultView(searchField.getText());
                } else if (searchType.getSelectedItem().equals("Average >=")) {
                    currentMainPanel = new SearchResultView(">=", searchField.getText());
                } else if (searchType.getSelectedItem().equals("Average <=")) {
                    currentMainPanel = new SearchResultView("<=", searchField.getText());
                }
                frame.getContentPane().add(currentMainPanel, BorderLayout.CENTER);
                frame.getContentPane().validate();
                frame.setVisible(true);
                break;

            case "updated":
                System.out.print(searchField.getText());
                break;

            case "login":
                Login login = new Login();
                login.setModal(true);
                login.setVisible(true);
                frame.remove(topBar);
                topBar = initTop();
                frame.add(topBar, BorderLayout.NORTH);
                topBar.revalidate();
                break;

            case "logout":
                JOptionPane.showMessageDialog(new Frame(), "Logged out.");
                Authenticator.logout();
                frame.remove(topBar);
                topBar = initTop();
                frame.add(topBar, BorderLayout.NORTH);
                topBar.revalidate();
                break;

            case "adminPanel":
                new AdminPanel();
                break;

            case "home":
                System.out.println("GO HOME");

                frame.remove(topBar);
                topBar = initTop();
                frame.add(topBar, BorderLayout.NORTH);

                frame.remove(currentMainPanel);
                currentMainPanel = new HomeView(this);
                frame.add(currentMainPanel, BorderLayout.CENTER);

                frame.getContentPane().validate();
                break;
        }
    }
}



