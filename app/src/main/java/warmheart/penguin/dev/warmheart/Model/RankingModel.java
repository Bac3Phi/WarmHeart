package warmheart.penguin.dev.warmheart.Model;

/**
 * Created by Sky Nguyen on 26-Nov-17.
 */

public class RankingModel {
    private String url;
    private String Name;
    private String money;

    public RankingModel(String url, String name, String money) {
        this.url = url;
        Name = name;
        this.money = money;
    }

    public RankingModel() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
