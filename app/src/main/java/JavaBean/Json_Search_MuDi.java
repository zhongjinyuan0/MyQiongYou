package JavaBean;

/**
 * Created by aaa on 15-4-23.
 */
public class Json_Search_MuDi {
private String cnname;
private String enname;
private String label;
private String parentname;
private String beenstr;
private String id;

    public String getBeenstr() {
        return beenstr;
    }

    public void setBeenstr(String beenstr) {
        this.beenstr = beenstr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private String photo;

    public Json_Search_MuDi() {
    }

    public Json_Search_MuDi(String cnname, String enname, String label, String parentname, String beenstr, String id, String photo) {
        this.cnname = cnname;
        this.enname = enname;
        this.label = label;
        this.parentname = parentname;
        this.beenstr = beenstr;
        this.id = id;
        this.photo = photo;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getBeennumber() {
        return beenstr;
    }

    public void setBeennumber(String beennumber) {
        this.beenstr = beennumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Json_Search_MuDi{" +
                "cnname='" + cnname + '\'' +
                ", enname='" + enname + '\'' +
                ", label='" + label + '\'' +
                ", parentname='" + parentname + '\'' +
                ", beennumber='" + beenstr + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
