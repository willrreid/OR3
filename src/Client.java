import DataManagement.DatabaseTransferObject.User;

/**
 * Created by will on 10/21/17.
 */
class Client {
    private static User user;
    private static Authenticator authenticator;

    Client() {
        authenticator = new Authenticator();

    }

    private static void login(String u, String p) {
        user = authenticator.getUser(u,p);
        if (user == null) {
            System.out.println("Authentication failed");
        }
    }

    private static void logout() {
        user = null;
    }




}
