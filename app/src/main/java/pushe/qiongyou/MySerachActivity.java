package pushe.qiongyou;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import AutoView.MySearchList0;
import DB.HealperManger;



public class MySerachActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private String path1="http://open.qyer.com/qyer/recommands/index?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=5863963&track_deviceid=99000628714115&track_app_version=6.2&track_app_channel=wandoujia&track_device_info=cancro&track_os=Android4.4.4&app_installtime=1429441097905&oauth_token=b54010c84449daa14673ad78a444e865";

    private  MySearchList0 serachlistview2;
    private HealperManger manger;
    private   ArrayList<String> listdata;
    private String[] s;
    private MySearchList0 serachlistview1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_serach);

        //创建一个sqmanger对象
        manger = new HealperManger(MySerachActivity.this);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        bar.setTitle("");
        bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
        //找到两个listview
        serachlistview2 = (MySearchList0) findViewById(R.id.searchlistview2);
        serachlistview1 = (MySearchList0) findViewById(R.id.searchlistview1);


        ArrayAdapter<String> adapter = setdata();
        //搜索历史
//        serachlistview1.setAdapter(adapter);
        serachlistview2.setAdapter(adapter);
        serachlistview2.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my_serach,menu);
        MenuItem item = menu.findItem(R.id.searchview);
        final SearchView actionSearch = (SearchView) MenuItemCompat.getActionView(item);
        actionSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //当输入内容时进行搜索
                if (listdata!=null){
                    listdata.clear();
                }
                PopupWindow window = new PopupWindow();
                window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setWidth(400);
                window.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwincolor));
                window.setOutsideTouchable(true);
                //创建一个listview
                ListView listView = new ListView(MySerachActivity.this);
                listView.setVerticalScrollBarEnabled(false);
                if (!TextUtils.isEmpty(s)) {
                    listdata=manger.requer(s);

                    if (listdata!=null){
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MySerachActivity.this
                                ,android.R.layout.simple_list_item_1,listdata);
                        listView.setAdapter(adapter);
                        window.setContentView(listView);
                        window.showAsDropDown(actionSearch);

                    }
                }


                return true;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home){
            finish();
        }
        return true;
    }
    public ArrayAdapter<String> setdata(){//设置热点旅游的数据
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MySerachActivity.this,android.R.layout.simple_list_item_1);
        s = new String[]{"日本","台湾","土耳其","泰国","新加坡","意大利","冲绳","斯里兰卡","清迈","巴厘岛",
                "香港", "东京"};
        if (manger.requername("台湾")){
            for (int i = 0; i <12 ; i++) {
                manger.insert(s[i]);
            }
        } for (int i = 0; i <12 ; i++) {
            adapter.add(s[i]);
        }
        return adapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MySerachActivity.this,SearchDetailsActivity.class);
        intent.putExtra("name",s[position]);
        startActivity(intent);

    }
}
