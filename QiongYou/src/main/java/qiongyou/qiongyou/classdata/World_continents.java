package qiongyou.qiongyou.classdata;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-24.
 */
public class World_continents  {


    private ArrayList<World_hot_country> hotCountries;
    private ArrayList<World_country> countries;

    public World_continents(ArrayList<World_hot_country> hotCountries, ArrayList<World_country> countries) {

        this.hotCountries = hotCountries;
        this.countries = countries;
    }



    public ArrayList<World_hot_country> getHotCountries() {
        return hotCountries;
    }

    public void setHotCountries(ArrayList<World_hot_country> hotCountries) {
        this.hotCountries = hotCountries;
    }

    public ArrayList<World_country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<World_country> countries) {
        this.countries = countries;
    }
}
