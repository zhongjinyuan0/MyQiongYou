package qiongyou.qiongyou.classdata;

/**
 * Created by aaa on 15-4-21.
 */
public class Main_discount {
    private int id;
    private String title;
    private String price;
    private String priceoff;
    private String end_date;
    private String photo;

    public Main_discount(int id, String title, String price, String priceoff, String end_date, String photo) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.priceoff = priceoff;
        this.end_date = end_date;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceoff() {
        return priceoff;
    }

    public void setPriceoff(String priceoff) {
        this.priceoff = priceoff;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
