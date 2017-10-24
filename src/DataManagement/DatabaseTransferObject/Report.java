package DataManagement.DatabaseTransferObject;

/**
 * Created by will on 10/21/17.
 */
public class Report {
    //Database Fields
    private Integer id;
    private Integer reporting_user;
    private Integer reported_user;
    private Integer review_id;
    private Integer time;
    private String message;

    //Constructors
    public Report(){
    }

    public Report(Integer reporting_user, Integer reported_user, Integer review_id, Integer time, String message){
        setReporting_user(reporting_user);
        setReported_user(reported_user);
        setReview_id(review_id);
        setTime(time);
        setMessage(message);
    }

    public Report(Integer id, Integer reporting_user, Integer reported_user, Integer review_id, Integer time, String message){
        setId(id);
        setReporting_user(reporting_user);
        setReporting_user(reported_user);
        setReview_id(review_id);
        setTime(time);
        setMessage(message);
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReporting_user() {
        return reporting_user;
    }

    public void setReporting_user(Integer reporting_user) {
        this.reporting_user = reporting_user;
    }

    public Integer getReported_user() {
        return reported_user;
    }

    public void setReported_user(Integer reported_user) {
        this.reported_user = reported_user;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }
}
