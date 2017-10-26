/**
 * OR3 Main Class
 */

public class Main {
    private static Client client;

    private static Client getClient() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public static void main(String[] args) {
        GUI.MainWindow.main(args);
    }
}
