package MyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import Adapter.SearchTieZiAdapter;
import JavaBean.JsonToSearchTieZi;
import pushe.qiongyou.R;
import pushe.qiongyou.SearchTieZiToWebActivity;

/**
 * Created by aaa on 15-4-23.
 */
public class MyTeiZiSearchFragment extends Fragment {

    private ListView listview;
    private String name;
    private int page=1;
    private ArrayList<JsonToSearchTieZi> datas;
    private SearchTieZiAdapter adapter;

    public static Fragment newInstance(String name){
        MyTeiZiSearchFragment fragment = new MyTeiZiSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchx1fragment_tiezi, container, false);
        listview = (ListView) view.findViewById(R.id.searche_mudidilistview11);
        ProgressBar bar = (ProgressBar) view.findViewById(R.id.progress11);
        listview.setEmptyView(bar);
        getlistdata();



        return  view;
    }

    public void getlistdata(){
        String path="http://open.qyer.com/qyer/search/index?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=5863963&track_deviceid=99000628714115&track_app_version=6.2&track_app_channel=wandoujia&track_device_info=cancro&track_os=Android4.4.4&app_installtime=1429441097905&lat=40.035195&lon=116.366717&type=thread&keyword="+name+"&count=20&page="+page;
        HttpUtils http=new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET,path,new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> objectResponseInfo) {
                String json = objectResponseInfo.result;
                try {
                    datas = new ArrayList<>();
                    JSONObject object = new JSONObject(json);
                    JSONObject data = object.getJSONObject("data");
                    JSONArray jsonArray = data.getJSONArray("entry");
                    for (int i = 0; i <jsonArray.length(); i++) {
                        JsonToSearchTieZi tieZi = new JsonToSearchTieZi();
                        JSONObject object1 = jsonArray.getJSONObject(i);
                        String title = object1.getString("title");
                        String username = object1.getString("username");
                        String views = object1.getString("views");
                        String replys = object1.getString("replys");
                        String view_url = object1.getString("view_url");
                        tieZi.setTitle(title);
                        tieZi.setUsername(username);
                        tieZi.setViews(views);
                        tieZi.setReplys(replys);
                        tieZi.setView_url(view_url);
                        datas.add(tieZi);

                    }
                    adapter = new SearchTieZiAdapter(datas,getActivity());
                    listview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), SearchTieZiToWebActivity.class);
                            JsonToSearchTieZi item = adapter.getItem(position);
                            String view_url = item.getView_url();
                            intent.putExtra("view_url",view_url);
                            startActivity(intent);
                        }
                    });

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
