package DataManagement.DatabaseTransferObject;

/**
 * Created by will on 10/21/17.
 */
public class Review {
    //Database Fields
    private Integer id;
    private Integer user_id;
    private Integer restaurant_id;
    private String time;
    private Integer rating;
    private String body;

    //Constructors
    public Review(){
    }

    public Review(Integer user_id, Integer restaurant_id, String time, Integer rating, String body){
        setUser_id(user_id);
        setRestaurant_id(restaurant_id);
        setTime(time);
        setRating(rating);
        setBody(body);
    }

    public Review(Integer id, Integer user_id, Integer restaurant_id, String time, Integer rating, String body){
        setId(id);
        setUser_id(user_id);
        setRestaurant_id(restaurant_id);
        setTime(time);
        setRating(rating);
        setBody(body);
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRestaurant_id() { return restaurant_id; }

    public void setRestaurant_id(Integer restaurant_id) { this.restaurant_id = restaurant_id; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
