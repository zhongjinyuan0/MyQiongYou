package MyFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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

import Adapter.Schlistview_Adapter;
import JavaBean.Json_Search_MuDi;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-23.
 */
public class MySearch_MuDi extends Fragment  {
    private String name;
    private int page=1;
    private String path;
    private ListView listview;
    private ArrayList<Json_Search_MuDi> arrays;
    private Schlistview_Adapter adapter;

    public static Fragment newInstance(String name){
        MySearch_MuDi fragment = new MySearch_MuDi();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        fragment.setArguments(bundle);

        return fragment;
    }

    public MySearch_MuDi() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         name =getArguments().getString("name");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchxqfragment_mudidi, container, false);
        //找到刷新组件,设置监听器

        listview = (ListView) view.findViewById(R.id.searche_mudidilistview);
        ProgressBar bar = (ProgressBar) view.findViewById(R.id.progress);
        listview.setEmptyView(bar);
        getlistdata(1);

        return  view;
    }


    public void getlistdata(int page){
        path = "http://open.qyer.com/qyer/search/index?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=5863963&track_deviceid=99000628714115&track_app_version=6.2&track_app_channel=wandoujia&track_device_info=cancro&track_os=Android4.4.4&app_installtime=1429441097905&lat=40.035195&lon=116.366717&type=place&keyword="+name+"&count=20&page="+page;
        HttpUtils http=new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                String json = objectResponseInfo.result;
                try {  arrays = new ArrayList<>();

                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject object = jsonObject.getJSONObject("data");
                    JSONArray jsonArray = object.getJSONArray("entry");
                    for (int i = 0; i <jsonArray.length() ; i++) {
                        JSONObject data = jsonArray.getJSONObject(i);
                        String id = data.getString("id");
                        String cnname = data.getString("cnname");
                        String enname = data.getString("enname");
                        String label = data.getString("label");
                        String parentname= data.getString("parentname");
                        String beenstr = data.getString("beenstr");
                        String photo = data.getString("photo");


                        arrays.add(new Json_Search_MuDi(cnname, enname,
                                label, parentname, beenstr,id, photo));

                    }
                    adapter = new Schlistview_Adapter(arrays,getActivity());
                    listview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }


}
