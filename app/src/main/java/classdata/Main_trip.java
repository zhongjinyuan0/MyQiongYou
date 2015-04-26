package classdata;

/**
 * Created by aaa on 15-4-21.
 */
public class Main_trip {
    private int id;
    private String photo;
    private String title;
    private String lastpost;
    private String user_id;
    private String username;
    private String avatar;
    private String replys;
    private String likes;
    private String view_url;
    private String view_author_url;
    private String views;
    private String digest_level;

    public Main_trip(int id, String photo, String title, String lastpost, String user_id, String username, String avatar,
                     String replys, String likes, String view_url, String view_author_url, String views, String digest_level) {
        this.id = id;
        this.photo = photo;
        this.title = title;
        this.lastpost = lastpost;
        this.user_id = user_id;
        this.username = username;
        this.avatar = avatar;
        this.replys = replys;
        this.likes = likes;
        this.view_url = view_url;
        this.view_author_url = view_author_url;
        this.views = views;
        this.digest_level = digest_level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastpost() {
        return lastpost;
    }

    public void setLastpost(String lastpost) {
        this.lastpost = lastpost;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getReplys() {
        return replys;
    }

    public void setReplys(String replys) {
        this.replys = replys;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getView_url() {
        return view_url;
    }

    public void setView_url(String view_url) {
        this.view_url = view_url;
    }

    public String getView_author_url() {
        return view_author_url;
    }

    public void setView_author_url(String view_author_url) {
        this.view_author_url = view_author_url;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDigest_level() {
        return digest_level;
    }

    public void setDigest_level(String digest_level) {
        this.digest_level = digest_level;
    }
}
