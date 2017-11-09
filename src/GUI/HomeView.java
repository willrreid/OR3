package GUI;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends JPanel {

    HomeView(MainWindow w) {
        parent = w;
        this.setLayout(new GridLayout(3,2));
    }
    MainWindow parent;

}
