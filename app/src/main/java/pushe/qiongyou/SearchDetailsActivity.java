package pushe.qiongyou;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.SearchDetailsAdapter;
import MyFragment.MySearch_MuDi;
import MyFragment.MySearch_Users;
import MyFragment.MyTeiZiSearchFragment;


public class SearchDetailsActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener {

    private LinearLayout.LayoutParams ip;
    private RadioGroup radiogroup;
    private View hkview;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);

        //获得传过来的name
        name = getIntent().getStringExtra("name");
        Toast.makeText(SearchDetailsActivity.this, name,Toast.LENGTH_SHORT).show();
//        new MySearch_MuDi().setName(name);
        radiogroup = (RadioGroup) findViewById(R.id.searchdetails_radiogroup);
        RadioButton childAt = (RadioButton) radiogroup.getChildAt(0);
        childAt.setChecked(true);
        ViewPager viewpage = (ViewPager) findViewById(R.id.searchdetails_viewpage);
        hkview = findViewById(R.id.search_huakuai);
        ip = (LinearLayout.LayoutParams) hkview.getLayoutParams();
        ArrayList<Fragment> fragments = fragmentdata();
        SearchDetailsAdapter adapter = new SearchDetailsAdapter(getSupportFragmentManager(), name, fragments);
        viewpage.setAdapter(adapter);
        viewpage.setOnPageChangeListener(this);

    }
    public ArrayList<Fragment> fragmentdata(){
        ArrayList<Fragment> list = new ArrayList<>();
        Fragment fragment0 = MySearch_MuDi.newInstance(name);
        Fragment fragment1 = MySearch_Users.newInstance(name);
        Fragment fragment2 = MyTeiZiSearchFragment.newInstance(name);
        list.add(fragment0);
        list.add(fragment2);
        list.add(fragment1);
        return list;

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ip.setMargins((int) ((positionOffset+position)*ip.width),0,0,0);
        RadioButton view = (RadioButton) radiogroup.getChildAt(position);
        view.setChecked(true);
        hkview.setLayoutParams(ip);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
