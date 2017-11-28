package DataManagement.DatabaseTransferObject;


/**
 * Created by will on 10/21/17.
 */
public class User {
    //Database Fields
    private Integer id;
    private String username;
    private Integer join_date;
    private String bio;
    private Boolean admin;

    //Constructors
    public User(){
    }

    public User(String username, Integer join_date, String bio, Boolean admin){
        setUsername(username);
        setJoin_date(join_date);
        setBio(bio);
        setAdmin(admin);
    }

    public User(Integer id, String username, Integer join_date, String bio, Boolean admin){
        setId(id);
        setUsername(username);
        setJoin_date(join_date);
        setBio(bio);
        setAdmin(admin);
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Integer join_date) {
        this.join_date = join_date;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}