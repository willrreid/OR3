/**
 * Created by will on 10/21/17.
 */
class Client {
    private static User user;
    private static DAO dao;
    private static Authenticator authenticator;

    Client() {
        dao = new DAO();
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
