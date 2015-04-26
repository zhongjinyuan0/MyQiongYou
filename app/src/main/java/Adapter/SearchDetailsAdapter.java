package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

import MyFragment.MySearch_MuDi;
import MyFragment.MyTeiZiSearchFragment;

/**
 * Created by aaa on 15-4-23.
 */
public class SearchDetailsAdapter extends FragmentPagerAdapter {
    private String name;
    private ArrayList<Fragment> fragments;

    public SearchDetailsAdapter(FragmentManager fm,String name,ArrayList<Fragment> fragments) {
        super(fm);
        this.name=name;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments.get(position);
        return fragment;

    }



    @Override
    public int getCount() {
        return fragments.size();
    }

}
