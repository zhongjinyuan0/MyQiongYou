package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by aaa on 15-4-21.
 */
public class Adapter_SYViewpage extends FragmentPagerAdapter {
    private ArrayList<Fragment> f;

    public Adapter_SYViewpage(FragmentManager fm) {
        super(fm);
    }

    public Adapter_SYViewpage(FragmentManager fm, ArrayList<Fragment> f) {
        super(fm);
        this.f = f;
    }

    @Override
    public Fragment getItem(int position) {

        return f.get(position);
    }

    @Override
    public int getCount() {
        return f.size();
    }
}
