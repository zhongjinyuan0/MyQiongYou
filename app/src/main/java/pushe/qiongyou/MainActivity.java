package pushe.qiongyou;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.HY_page_Adapter;


public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener {

    private ViewPager huangyingpage;
    private ArrayList<TextView> list;
    private RadioGroup rg;
    private ImageView iamge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到欢迎页第三页的button,设置点击事件
        View view = getLayoutInflater().inflate(R.layout.hypage4_layout, null);
        //设置首次安装欢迎页面
        getSupportActionBar().hide();
        huangyingpage = (ViewPager) findViewById(R.id.huanying_viewpager);
        //找到radiogroup组件和image
        iamge = (ImageView) findViewById(R.id.huanying_Image);
        rg = (RadioGroup) findViewById(R.id.huanying_group);
        //设置rbutton默认选项
        RadioButton b= (RadioButton) rg.getChildAt(0);
        b.setChecked(true);
        list = new ArrayList<>();
        addlist();
        //设置slpash
        SharedPreferences sp1 = getSharedPreferences("1", Context.MODE_PRIVATE);
        String result = sp1.getString("1", "no");
        //如果内部存储器没有,则适配
        if (result.equals("no")){
            iamge.setImageResource(R.drawable.bg_about_qyer_img1);
            huangyingpage.setAdapter(new HY_page_Adapter(list, MainActivity.this));
            huangyingpage.setOnPageChangeListener(this);

            SharedPreferences sp=getSharedPreferences("1", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("1","yes");
            edit.commit();
        }else {//找到slpash ,imageview组件
            Intent intent = new Intent(MainActivity.this,Slpash.class);
            startActivity(intent);
            finish();
        }


    }
    public void addlist(){
        for (int i = 0; i <3; i++) {
            TextView textView = new TextView(MainActivity.this);
            textView.setTextSize(22);
            textView.setPadding(0,20,0,0);
            textView.setTextColor(getResources().getColor(R.color.hytext));
            list.add(textView);

        }
        list.get(0).setText("人山人海" + "\n" + "边走边看"+"\n"+"陌生异国他处,相约不在独行");
        list.get(1).setText("千里寻他"+"\n"+"处处风光"+"\n"+"走走停停却不知回忆哪一段");
        list.get(2).setText("完美行程"+"\n"+"随时既出"+"\n"+"计划时那年如今一起的今天");

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton rbutton = (RadioButton) rg.getChildAt(position);
        rbutton.setChecked(true);
        if (position==0){
            iamge.setImageResource(R.drawable.bg_about_qyer_img1);
        }
        else  if (position==1){
            iamge.setImageResource(R.drawable.bg_about_qyer_img2);
        }else if (position==2){
            iamge.setImageResource(R.drawable.bg_about_qyer_img3);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
