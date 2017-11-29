package UserAuthentication;

import DataManagement.DatabaseInteraction.SqliteUserDAO;
import DataManagement.DatabaseTransferObject.User;

/**
 * Created by will on 10/21/17.
 */
public class Authenticator {

    private static User user = null;

    public static boolean authenticateLogin(String u, String p) {
        User potentialUser = new SqliteUserDAO().getByName(u);
        if (potentialUser == null || potentialUser.getPassword() == null){ user = null;}
        else if (potentialUser.getPassword().equals(p)){user = potentialUser; return true;}
        else user = null;
        return false;
    }

    public static User loggedInUser(){
        return user;
    }

    public static void logout() {
        user = null;
    }

}
