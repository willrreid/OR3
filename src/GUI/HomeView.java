package GUI;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {

    HomeView(MainWindow w) {
        parent = w;
        this.setLayout(new GridLayout(3,2));
    }
    MainWindow parent;

}
