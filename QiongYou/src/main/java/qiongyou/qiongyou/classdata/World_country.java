package qiongyou.qiongyou.classdata;

/**
 * Created by aaa on 15-4-24.
 */
public class World_country {
    private String id;
    private String cnname;
    private String enname;
    private String photo;
    private String count;
    private String label;
    private int  flag;

    public World_country(String id, String cnname, String enname, String photo, String count, String label, int flag) {
        this.id = id;
        this.cnname = cnname;
        this.enname = enname;
        this.photo = photo;
        this.count = count;
        this.label = label;
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
