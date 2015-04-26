package JavaBean;

/**
 * Created by aaa on 15-4-24.
 */
public class JsonToSearchUsers {
private String username;
private String title;
private String countries;
private String cities;
private String avatar;

    public JsonToSearchUsers() {
    }

    public JsonToSearchUsers(String username, String title, String countries, String cities, String avatar) {
        this.username = username;
        this.title = title;
        this.countries = countries;
        this.cities = cities;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "JsonToSearchUsers{" +
                "username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", countries='" + countries + '\'' +
                ", cities='" + cities + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
