package JavaBean;

/**
 * Created by aaa on 15-4-23.
 */
public class JsonToSearchTieZi {
    private String title;
    private String username;
    private String view_url;
    private String views;
    private String replys;

    public JsonToSearchTieZi() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getView_url() {
        return view_url;
    }

    public void setView_url(String view_url) {
        this.view_url = view_url;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getReplys() {
        return replys;
    }

    public void setReplys(String replys) {
        this.replys = replys;
    }

    @Override
    public String toString() {
        return "JsonToSearchTieZi{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", view_url='" + view_url + '\'' +
                ", views='" + views + '\'' +
                ", replys='" + replys + '\'' +
                '}';
    }
}
