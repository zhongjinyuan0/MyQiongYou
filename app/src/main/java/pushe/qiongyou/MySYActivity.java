package pushe.qiongyou;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import Adapter.Adapter_SYViewpage;
import AutoView.MyGridView;
import MyFragment.BlankFragment;
import MyFragment.Destination_Fragment;
import MyFragment.Main_Fragment;
import MyFragment.MySquFragment;


public class MySYActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener {

    private ViewPager syViewpage;
    private View hKview;
    private RadioGroup rdgroup;
    private ArrayList<Fragment> fragmentArrayList;
    private LinearLayout.LayoutParams lP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qy);
        getSupportActionBar().hide();
        //找到首页的各种组件id
        syViewpage = (ViewPager) findViewById(R.id.SY_viewpage);
        hKview =findViewById(R.id.huankuai_view);
        rdgroup = (RadioGroup) findViewById(R.id.SY_radiogroup);
        fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new Main_Fragment());
        fragmentArrayList.add(new Destination_Fragment());


        //设置每一个fragment
        syViewpage.setAdapter(new Adapter_SYViewpage(getSupportFragmentManager()
                ,fragmentArrayList));
        //设置viewpage的监听事件
        syViewpage.setOnPageChangeListener(this);
        lP = (LinearLayout.LayoutParams)
                hKview.getLayoutParams();


        //个人中心和搜索
        ImageView userImage = (ImageView) findViewById(R.id.sy_imageview);
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MySYActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
        //设置search的点击事件
        ImageView searchimage = (ImageView) findViewById(R.id.sy_search);
        searchimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MySYActivity.this,MySerachActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activityanima_in,R.anim.activityanima_out);
            }
        });


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lP.setMargins((int) (lP.width*(position+positionOffset)),0,0,0);
        hKview.setLayoutParams(lP);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rdbutton = (RadioButton) rdgroup.getChildAt(position);
        rdbutton.setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
