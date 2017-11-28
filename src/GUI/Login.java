package GUI;

import DataManagement.DatabaseTransferObject.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel usernameLabel = new JLabel("Name:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JButton loginButton = new JButton("Login");
    private JButton cancelButton = new JButton("Cancel");
    public User user = null;

    public Login(){
        setupUI();
        setUpListeners();
    }

    public void setupUI(){
        this.setTitle("OR3 Login");

        this.setSize(500,200);
        this.setLayout(new GridLayout(3,2));

        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
        this.add(cancelButton);

        this.setVisible(true);
    }

    private void setUpListeners(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean status = UserAuthentication.Authenticator.authenticateLogin(usernameField.getText(), new String(passwordField.getPassword()));
                JOptionPane.showMessageDialog(new Frame(), "Login Status: " + (status ? "Success" : "Failure"));
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
