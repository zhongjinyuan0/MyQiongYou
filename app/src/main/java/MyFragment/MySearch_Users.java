package MyFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
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

import Adapter.SearchusersAdapter;
import JavaBean.JsonToSearchUsers;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-24.
 */
public class MySearch_Users extends Fragment {


    private ListView listview;
    private String name;
    private ArrayList<JsonToSearchUsers> datas;

    public static  Fragment newInstance(String name){
        MySearch_Users fragment = new MySearch_Users();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        Toast.makeText(getActivity(),name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(),"用户", Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.searchxqfragment_users, container, false);
        listview = (ListView) view.findViewById(R.id.searche_userlistview);
        ProgressBar bar = (ProgressBar) view.findViewById(R.id.userprogress);
        //设置空视图
        listview.setEmptyView(bar);

        getlistdata();

        return view;
    }
    public void getlistdata(){
        String path="http://open.qyer.com/qyer/search/index?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=5863963&track_deviceid=99000628714115&track_app_version=6.2&track_app_channel=wandoujia&track_device_info=cancro&track_os=Android4.4.4&app_installtime=1429441097905&lat=40.035195&lon=116.366717&type=user&keyword="+name+"&count=20&page=1";
        HttpUtils http=new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {

                String json = objectResponseInfo.result;
                datas=new ArrayList<JsonToSearchUsers>();
                try {
                    JSONObject object = new JSONObject(json);
                    JSONObject data = object.getJSONObject("data");
                    JSONArray entry = data.getJSONArray("entry");
                    for (int i = 0; i <entry.length() ; i++) {
                        JsonToSearchUsers users = new JsonToSearchUsers();
                        JSONObject jsonObject = entry.getJSONObject(i);
                        String username = jsonObject.getString("username");
                        String tiele = jsonObject.getString("title");
                        String countries = jsonObject.getString("countries");
                        String cities = jsonObject.getString("cities");
                        String avatar = jsonObject.getString("avatar");
                        users.setUsername(username);
                        users.setTitle(tiele);
                        users.setCountries(countries);
                        users.setCities(cities);
                        users.setAvatar(avatar);
                        datas.add(users);
                    }
                    SearchusersAdapter adapter=new SearchusersAdapter(datas,getActivity());
                    listview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();



                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),"错了", Toast.LENGTH_SHORT).show();
                }




            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }
}
