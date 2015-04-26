package MyFragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
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

import Adapter.World_Adapter;
import Adapter.World_Adapter_2;
import classdata.MyView;
import classdata.World_country;
import classdata.World_hot_country;
import pushe.qiongyou.R;


public class Destination_Fragment extends Fragment {

    private String path="http://open.qyer.com/qyer/footprint/continent_list?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=5863963&track_deviceid=99000628714115&track_app_version=6.2&track_app_channel=wandoujia&track_device_info=cancro&track_os=Android4.4.4&app_installtime=1429441097905";

    private MyView destination_gridView;
    private RadioGroup radioGroup;
    private ArrayList<World_hot_country> hotCountries1;
    private ArrayList<World_country> countries1;
    private ArrayList<World_hot_country> hotCountries2;
    private ArrayList<World_country> countries2;
    private ArrayList<World_hot_country> hotCountries3;
    private ArrayList<World_country> countries3;
    private ArrayList<World_hot_country> hotCountries4;
    private ArrayList<World_country> countries4;
    private ArrayList<World_hot_country> hotCountries5;
    private ArrayList<World_country> countries5;
    private ArrayList<World_hot_country> hotCountries6;
    private ArrayList<World_country> countries6;
    private ArrayList<World_hot_country> hotCountries7;
    private World_Adapter world_adapter3;
    private TextView textView1;
    private MyView destination_gridView2;
    private TextView textView2;
    private World_Adapter world_adapter1;
    private World_Adapter_2 countryAdapter1;
    ScrollView scroview;



    public Handler handler;
    public Destination_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_destination_, container, false);

        scroview= (ScrollView) v.findViewById(R.id.scrollview);

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                scroview.fullScroll(ScrollView.FOCUS_UP);
            }
        };

        handler.post(new Runnable() {
            @Override
            public void run() {
                scroview.fullScroll(ScrollView.FOCUS_UP);
            }
        });

        destination_gridView = (MyView) v.findViewById(R.id.destination_gridView1);
        textView1 = (TextView) v.findViewById(R.id.textView1);
        destination_gridView2 = (MyView) v.findViewById(R.id.destination_gridView2);
        textView2 = (TextView) v.findViewById(R.id.textView2);
        radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup);

        getJsonData();

        init();
        ((RadioButton)radioGroup.getChildAt(5)).setChecked(true);

        return v;
    }




    public void getAsia(){
        textView1.setText("亚洲热门目的地");

        world_adapter1 = new World_Adapter(getActivity(), hotCountries1);
        destination_gridView.setAdapter(world_adapter1);

        textView2.setText("亚洲其他目的地");
        countryAdapter1 = new World_Adapter_2(getActivity(), countries1);
        destination_gridView2.setAdapter(countryAdapter1);
    }

    public void init(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                        textView1.setText("北美洲热门目的地");
                        world_adapter3 = new World_Adapter(getActivity(), hotCountries3);
                        destination_gridView.setAdapter(world_adapter3);

                        textView2.setText("北美洲其他目的地");
                        World_Adapter_2 countryAdapter3 = new World_Adapter_2(getActivity(), countries3);
                        destination_gridView2.setAdapter(countryAdapter3);
                        break;
                    case R.id.radioButton2:
                        textView1.setText("南美洲热门目的地");
                        World_Adapter world_adapter4 = new World_Adapter(getActivity(), hotCountries4);
                        destination_gridView.setAdapter(world_adapter4);

                        textView2.setText("南美洲其他目的地");
                        World_Adapter_2 countryAdapter4 = new World_Adapter_2(getActivity(), countries4);
                        destination_gridView2.setAdapter(countryAdapter4);
                        break;
                    case R.id.radioButton3:
                        textView1.setText("非洲热门目的地");
                        World_Adapter world_adapter6 = new World_Adapter(getActivity(), hotCountries6);
                        destination_gridView.setAdapter(world_adapter6);

                        textView2.setText("非洲其他目的地");
                        World_Adapter_2 countryAdapter6 = new World_Adapter_2(getActivity(), countries6);
                        destination_gridView2.setAdapter(countryAdapter6);
                        break;
                    case R.id.radioButton4:
                        textView1.setText("欧洲热门目的地");
                        World_Adapter world_adapter2 = new World_Adapter(getActivity(), hotCountries2);
                        destination_gridView.setAdapter(world_adapter2);

                        textView2.setText("欧洲其他目的地");
                        World_Adapter_2 countryAdapter2 = new World_Adapter_2(getActivity(), countries2);
                        destination_gridView2.setAdapter(countryAdapter2);
                        break;
                    case R.id.radioButton5:
                        textView1.setText("南极洲热门目的地");
                        World_Adapter world_adapter7 = new World_Adapter(getActivity(), hotCountries7);
                        destination_gridView.setAdapter(world_adapter7);

                        break;
                    case R.id.radioButton6:
                        getAsia();
                        break;
                    case R.id.radioButton7:
                        textView1.setText("大洋洲热门目的地");
                        World_Adapter world_adapter5 = new World_Adapter(getActivity(), hotCountries5);
                        destination_gridView.setAdapter(world_adapter5);

                        textView2.setText("大洋洲其他目的地");
                        World_Adapter_2 countryAdapter5 = new World_Adapter_2(getActivity(), countries5);
                        destination_gridView2.setAdapter(countryAdapter5);
                        break;
                }
            }
        });
    }


    public void getJsonData(){
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                String result = objectResponseInfo.result;
                Toast.makeText(getActivity(),result,Toast.LENGTH_SHORT).show();
                jsonData(result);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getActivity(),"加载失败",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void jsonData(String result){
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray data = jsonObject.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject object = data.getJSONObject(i);
                int id = object.getInt("id");
                String cnname = object.getString("cnname");
                if(cnname.equals("亚洲")){

                    hotCountries1 = new ArrayList<World_hot_country>();
                    countries1 = new ArrayList<>();
                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries1.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    JSONArray country = object.getJSONArray("country");
                    for (int j = 0; j < country.length(); j++) {
                        JSONObject object1 = country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        countries1.add(new World_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    world_adapter1.notifyDataSetChanged();
                    getAsia();
                    Toast.makeText(getActivity(),hotCountries1.get(0).getCnname(),Toast.LENGTH_SHORT).show();
                }

                if(cnname.equals("欧洲")){

                    hotCountries2 = new ArrayList<World_hot_country>();
                    countries2 = new ArrayList<>();
                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries2.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    JSONArray country = object.getJSONArray("country");
                    for (int j = 0; j < country.length(); j++) {
                        JSONObject object1 = country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        countries2.add(new World_country(id1, cnname1,enname,photo, count, label, flag));
                    }
                    Toast.makeText(getActivity(),hotCountries2.get(0).getCnname(),Toast.LENGTH_SHORT).show();
                }

                if(cnname.equals("北美洲")){

                    hotCountries3 = new ArrayList<World_hot_country>();
                    countries3 = new ArrayList<>();
                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries3.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    JSONArray country = object.getJSONArray("country");
                    for (int j = 0; j < country.length(); j++) {
                        JSONObject object1 = country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        countries3.add(new World_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    Toast.makeText(getActivity(),hotCountries3.get(0).getCnname(),Toast.LENGTH_SHORT).show();
                    if(world_adapter3!=null) {
                        world_adapter3.notifyDataSetChanged();
                    }
                }

                if(cnname.equals("南美洲")){

                    hotCountries4 = new ArrayList<World_hot_country>();
                    countries4 = new ArrayList<>();
                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries4.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    JSONArray country = object.getJSONArray("country");
                    for (int j = 0; j < country.length(); j++) {
                        JSONObject object1 = country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        countries4.add(new World_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    Toast.makeText(getActivity(),hotCountries4.get(0).getCnname(),Toast.LENGTH_SHORT).show();
                }

                if(cnname.equals("大洋洲")){

                    hotCountries5 = new ArrayList<World_hot_country>();
                    countries5 = new ArrayList<>();
                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries5.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    JSONArray country = object.getJSONArray("country");
                    for (int j = 0; j < country.length(); j++) {
                        JSONObject object1 = country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        countries5.add(new World_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    Toast.makeText(getActivity(),hotCountries5.get(0).getCnname(),Toast.LENGTH_SHORT).show();
                }

                if(cnname.equals("非洲")){

                    hotCountries6 = new ArrayList<World_hot_country>();
                    countries6 = new ArrayList<>();
                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries6.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    JSONArray country = object.getJSONArray("country");
                    for (int j = 0; j < country.length(); j++) {
                        JSONObject object1 = country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        countries6.add(new World_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    Toast.makeText(getActivity(),hotCountries6.get(0).getCnname(),Toast.LENGTH_SHORT).show();
                }

                if(cnname.equals("南极洲")){

                    hotCountries7 = new ArrayList<World_hot_country>();

                    JSONArray hot_country = object.getJSONArray("hot_country");
                    for (int j = 0; j < hot_country.length(); j++) {
                        JSONObject object1 = hot_country.getJSONObject(j);
                        String id1 = object1.getString("id");
                        String cnname1 = object1.getString("cnname");
                        String enname = object1.getString("enname");
                        String photo = object1.getString("photo");
                        String count = object1.getString("count");
                        String label = object1.getString("label");
                        int flag = object1.getInt("flag");
                        hotCountries7.add(new World_hot_country(id1, cnname1, enname, photo, count, label, flag));
                    }
                    Toast.makeText(getActivity(),hotCountries7.get(0).getCnname(),Toast.LENGTH_SHORT).show();

                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
