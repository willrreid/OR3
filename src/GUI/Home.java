package GUI;
import javax.swing.*;

public class Home {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createOR3GUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("OR3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Title
        JLabel label = new JLabel("OR3");
        frame.getContentPane().add(label);

        //List of Restaurants
        RestaurantLister rList = new RestaurantLister();
        frame.getContentPane().add(rList);

        //Selected Restaurant Info
        RestaurantInfo rInfo = new RestaurantInfo();
        frame.getContentPane().add(rInfo);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createOR3GUI();
            }
        });
    }
}
