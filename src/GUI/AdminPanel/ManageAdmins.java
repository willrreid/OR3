package GUI.AdminPanel;

import DataManagement.DatabaseInteraction.SqliteUserDAO;
import DataManagement.DatabaseTransferObject.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by will on 11/29/17.
 */
public class ManageAdmins extends JDialog {
    private JLabel nameLabel = new JLabel("Username: ");
    private JTextField nameField = new JTextField();
    private JButton makeAdminButton = new JButton("Make Admin");
    private JButton demoteAdminButton = new JButton("Demote Admin");
    private JButton cancelButton = new JButton("Cancel");

    ManageAdmins() {
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        this.setTitle("Manage Admins");

        this.setSize(300,100);
        this.setLayout(new GridLayout(3,2));

        this.add(nameLabel);
        this.add(nameField);
        this.add(makeAdminButton);
        this.add(demoteAdminButton);
        this.add(cancelButton);

        this.setVisible(true);
    }

    private void setupListeners() {
        makeAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                makeAdmin();
            }
        });

        demoteAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                demoteAdmin();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
    }

    void makeAdmin() {
        User u = new SqliteUserDAO().getByName(nameField.getText());
        if (u.isAdmin()) {
            JOptionPane.showMessageDialog(new Frame(), u.getUsername()+" is already an admin.");
        } else {
            u.setAdmin(true);
            new SqliteUserDAO().save(u);
            JOptionPane.showMessageDialog(new Frame(), u.getUsername()+" was promoted to admin.");
        }
    }

    void demoteAdmin() {
        User u = new SqliteUserDAO().getByName(nameField.getText());
        if (u.isAdmin()) {
            u.setAdmin(false);
            new SqliteUserDAO().save(u);
            JOptionPane.showMessageDialog(new Frame(), u.getUsername()+" was demoted from admin.");
        } else {
            JOptionPane.showMessageDialog(new Frame(), u.getUsername()+" is not an admin.");
        }
    }

}
