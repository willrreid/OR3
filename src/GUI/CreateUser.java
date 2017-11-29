package GUI;

import DataManagement.DatabaseInteraction.SqliteUserDAO;
import DataManagement.DatabaseTransferObject.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by will on 11/29/17.
 */
public class CreateUser extends JDialog {
    private JLabel nameLabel = new JLabel("Username:");
    private JLabel passLabel = new JLabel("Password:");
    private JTextField nameField = new JTextField();
    private JPasswordField passField = new JPasswordField();
    private JButton createButton = new JButton("Create");
    private JButton cancelButton = new JButton("Cancel");

    CreateUser() {
        setupUI();
        setupListeners();
    }

    void setupUI() {
        this.setTitle("New User");
        this.setSize(400,250);
        this.setLayout(new GridLayout(3,2));

        this.add(nameLabel);
        this.add(nameField);
        this.add(passLabel);
        this.add(passField);
        this.add(createButton);
        this.add(cancelButton);
    }

    void setupListeners() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (new SqliteUserDAO().getByName(nameField.getText()) != null) {
                    JOptionPane.showMessageDialog(new Frame(), "Username taken.");
                } else {
                    User u = new User(nameField.getText(), String.valueOf(passField.getPassword()), 0, "", false);
                    new SqliteUserDAO().save(u);
                    JOptionPane.showMessageDialog(new Frame(), "Welcome to OR3, "+u.getUsername());
                    setVisible(false);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
    }
}
