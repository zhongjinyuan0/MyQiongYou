package MyFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import AutoView.MyGridView;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-22.
 */
public class MySquFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mysqu_activity, container, false);
        MyGridView sqgr1 = (MyGridView) view.findViewById(R.id.sq_gridview1);
        MyGridView sqgr2 = (MyGridView) view.findViewById(R.id.sq_gridview2);
        ArrayList<HashMap<String,Object>> list=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name","name"+1);
            map.put("image",R.drawable.ic_launcher);
            list.add(map);
        }

        SimpleAdapter s=new SimpleAdapter(getActivity(),list,R.layout.gridview_ceshi,new String[]{"name","image"}
                ,new int[]{R.id.ceshi_textview,R.id.ceshi_imageview});
        sqgr1.setAdapter(s);
        sqgr2.setAdapter(s);

        return view;
    }
}
