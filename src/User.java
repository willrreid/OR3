
/**
 * Created by will on 10/21/17.
 */
public class User {
    private int userID;
    public String username;
    public int joinDate;
    public String bio;
    private boolean admin;

    public void updateUsername(String u) {
        //TODO check availability, update other occurrences;
        username = u;
    }

    public void updateBio(String b) {
        bio = b;
    }
}
