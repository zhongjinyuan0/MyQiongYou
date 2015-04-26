package MyFragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;


import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapter.Main_discounts_Adapter;
import Adapter.Main_mguides_Adapter;
import Adapter.Main_trips_Adapter;
import Adapter.ViewPagerAdapter;
import classdata.Main_discount;
import classdata.Main_mguide;
import classdata.Main_trip;
import classdata.MyListView;
import classdata.MyView;
import classdata.ViewPagerData;
import pushe.qiongyou.R;


public class Main_Fragment extends Fragment implements ViewPager.OnPageChangeListener {

    PullToRefreshScrollView pulltorefresh;
    private ArrayList<ViewPagerData> list;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private RadioGroup radioGroup;
    private ArrayList<Main_mguide> mguides;
    private ArrayList<Main_discount> discounts;
    private ArrayList<Main_trip> trips;
    private Main_mguides_Adapter main_mguides_adapter;
    private Main_discounts_Adapter main_discounts_adapter;
    private Main_trips_Adapter main_trips_adapter;
    private int page=1;
    private ProgressBar progressBar;

    public Main_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_main_, container, false);
        pulltorefresh = (PullToRefreshScrollView) v.findViewById(R.id.pulltorefresh);


        viewPager= (ViewPager) v.findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) v.findViewById(R.id.viewPager_radioGroup11);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
        viewPager.setOnPageChangeListener(this);

        list = new ArrayList<ViewPagerData>();
        loadData(1);
        viewPagerAdapter = new ViewPagerAdapter(getActivity(), list);
        viewPager.setAdapter(viewPagerAdapter);


        mguides = new ArrayList<Main_mguide>();
        MyView gridView = (MyView) v.findViewById(R.id.gridView);
        main_mguides_adapter = new Main_mguides_Adapter(getActivity(), mguides);
        gridView.setAdapter(main_mguides_adapter);


        discounts = new ArrayList<Main_discount>();
        MyView gridView2 = (MyView)v.findViewById(R.id.gridView2);
        main_discounts_adapter = new Main_discounts_Adapter(getActivity(), discounts);
        gridView2.setAdapter(main_discounts_adapter);


        trips = new ArrayList<Main_trip>();
        MyListView listView = (MyListView) v.findViewById(R.id.listView);
        main_trips_adapter = new Main_trips_Adapter(getActivity(), trips);
        listView.setAdapter(main_trips_adapter);


        init();

        return v;
    }


    public void init(){

        final ILoadingLayout loadingLayoutProxy = pulltorefresh.getLoadingLayoutProxy();
        pulltorefresh.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pulltorefresh.setRefreshing(true);
                loadData(1);
                String time= DateUtils.formatDateTime(getActivity(),
                        System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_SHOW_TIME|DateUtils.FORMAT_ABBREV_ALL);
                loadingLayoutProxy.setLastUpdatedLabel(time);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pulltorefresh.onRefreshComplete();
                    }
                },3000);

            }
        });


    }




    public void loadData(final int page){
        String path="http://open.qyer.com/qyer/recommands/index?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=5863963&track_deviceid=99000628714115&track_app_version=6.2&track_app_channel=wandoujia&track_device_info=cancro&track_os=Android4.4.4&app_installtime=1429441097905&oauth_token=b54010c84449daa14673ad78a444e865";

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(com.lidroid.xutils.http.client.HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {

                String result = objectResponseInfo.result;

        //        String json = new String(result.getBytes());
        //        pulltorefresh.setRefreshing(false);
                if(page==1){
                    list.clear();
                    mguides.clear();
                    discounts.clear();
                    trips.clear();
                }

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject data = jsonObject.getJSONObject("data");
                    JSONArray slide = data.getJSONArray("slide");
                    for (int i = 0; i < slide.length(); i++) {
                        JSONObject object = slide.getJSONObject(i);
                        String url = object.getString("url");
                        String photo = object.getString("photo");
                        list.add(new ViewPagerData(url,photo));
                    }
                    Toast.makeText(getActivity(),list.get(0).getPhoto(),Toast.LENGTH_SHORT).show();
                    viewPagerAdapter.notifyDataSetChanged();


                    JSONArray mguide = data.getJSONArray("mguide");
                    for (int i = 0; i < mguide.length(); i++) {
                        JSONObject object = mguide.getJSONObject(i);
                        String id = object.getString("id");
                        String photo = object.getString("photo");
                        String title = object.getString("title");
                        String user_id = object.getString("user_id");
                        String username = object.getString("username");
                        String avatar = object.getString("avatar");
                        String description = object.getString("description");
                        String count = object.getString("count");
                        mguides.add(new Main_mguide(id,photo,title,user_id,username,avatar,description,count));
                    }
                    main_mguides_adapter.notifyDataSetChanged();



                    JSONArray discount = data.getJSONArray("discount");
                    for (int i = 0; i < discount.length(); i++) {
                        JSONObject object = discount.getJSONObject(i);
                        int id = object.getInt("id");
                        String title = object.getString("title");
                        String price = object.getString("price");
                        String priceoff = object.getString("priceoff");
                        String end_date = object.getString("end_date");
                        String photo = object.getString("photo");
                        discounts.add(new Main_discount(id,title,price,priceoff,end_date,photo));
                    }
                    main_discounts_adapter.notifyDataSetChanged();


                    JSONArray trip = data.getJSONArray("trip");
                    for (int i = 0; i < trip.length(); i++) {
                        JSONObject object = trip.getJSONObject(i);
                        int id = object.getInt("id");
                        String photo = object.getString("photo");
                        String title = object.getString("title");
                        String lastpost = object.getString("lastpost");
                        String user_id = object.getString("user_id");
                        String username = object.getString("username");
                        String avatar = object.getString("avatar");
                        String replys = object.getString("replys");
                        String likes = object.getString("likes");
                        String view_url = object.getString("view_url");
                        String view_author_url = object.getString("view_author_url");
                        String views = object.getString("views");
                        String digest_level = object.getString("digest_level");
                        trips.add(new Main_trip(id,photo,title,lastpost,user_id,username,
                                avatar,replys,likes,view_url,view_author_url,views,digest_level));
                    }
                    main_trips_adapter.notifyDataSetChanged();



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }



            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                super.onLoading(total, current, isUploading);

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
       /* RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
        radioButton.setChecked(true);*/
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



}
