package classdata;

/**
 * Created by aaa on 15-4-21.
 */
public class ViewPagerData {
    private String url;
    private String photo;

    public ViewPagerData(String url, String photo) {
        this.url = url;
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
