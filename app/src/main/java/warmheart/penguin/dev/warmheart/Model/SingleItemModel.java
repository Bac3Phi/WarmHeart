package warmheart.penguin.dev.warmheart.Model;

/**
 * Created by pratap.kesaboyina on 01-12-2015.
 */
public class SingleItemModel {


    private String name;
    private String url;
    private String description;
    private String location;
    private String time;

    public SingleItemModel() {
    }

    public SingleItemModel(String name, String url) {
        this.name = name;
        this.url = url;

    }
    public SingleItemModel(String name,String url,String description, String location,String time)
    {
        this.name = name;
        this.url = url;
        this.description = description;
        this.location = location;
        this.time = time;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
