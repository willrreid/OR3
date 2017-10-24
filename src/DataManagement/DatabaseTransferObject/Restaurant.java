package DataManagement.DatabaseTransferObject;

/**
 * Created by will on 10/21/17.
 */
public class Restaurant {
    //Database Fields
    private Integer id;
    private Boolean visible;
    private String name;
    private String address;
    private String category;
    private String website;

    //Constructors
    public Restaurant(){
    }

    public Restaurant(Boolean visible, String name, String address, String category, String website){
        setVisible(visible);
        setName(name);
        setAddress(address);
        setCategory(category);
        setWebsite(website);
    }

    public Restaurant(Integer id, Boolean visible, String name, String address, String category, String website){
        setId(id);
        setVisible(visible);
        setName(name);
        setAddress(address);
        setCategory(category);
        setWebsite(website);
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
