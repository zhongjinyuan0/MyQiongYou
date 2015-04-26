package qiongyou.qiongyou.classdata;

/**
 * Created by aaa on 15-4-21.
 */
public class Main_mguide {
    private String id;
    private String photo;
    private String title;
    private String user_id;
    private String username;
    private String avatar;
    private String description;
    private String count;

    public Main_mguide(String id, String photo, String title, String user_id, String username, String avatar, String description, String count) {
        this.id = id;
        this.photo = photo;
        this.title = title;
        this.user_id = user_id;
        this.username = username;
        this.avatar = avatar;
        this.description = description;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
