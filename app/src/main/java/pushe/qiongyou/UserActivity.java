package pushe.qiongyou;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class UserActivity extends ActionBarActivity {

    private ListView userlistview;


    private int imagedata[]={R.drawable.ic_user_detail_trip,R.drawable.ic_user_detail_jn
            ,R.drawable.ic_user_detail_deal,R.drawable.ic_user_detail_plan};
    private String textdata[]={"我的帖子","我的收藏","我的折扣","我的行程"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        userlistview = (ListView) findViewById(R.id.user_listview);
        userlistview.setAdapter(new MyAdapter());



    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            switch (position){
                case 0:
                    View view0 =getLayoutInflater().inflate(R.layout.user_listview_itemimage,null);
                    ImageView image0 = (ImageView) view0.findViewById(R.id.user_item_image);
                    image0.setImageResource(R.drawable.bg_dest_tab_worldmap);
                    return view0;
                case 1:
                    View view = getLayoutInflater().inflate(R.layout.user_istview_item0, null);
                   ImageView image = (ImageView) view.findViewById(R.id.item_imageview);
                   TextView textview = (TextView) view.findViewById(R.id.item_textview);
                    textview.setText("去过" + "\n" + "....");
                    image.setImageResource(R.drawable.ic_public_been_normal);
                    return view;
                case 2:
                    View view2 = getLayoutInflater().inflate(R.layout.user_istview_item0, null);
                    ImageView image2 = (ImageView) view2.findViewById(R.id.item_imageview);
                    TextView textview2 = (TextView) view2.findViewById(R.id.item_textview);
                    textview2.setText("没去过" + "\n" + "....");
                    image2.setImageResource(R.drawable.ic_wantto_light);
                    return view2;
                case 3:
                case 4:
                case 5:
                case 6:
                    convertView = getLayoutInflater().inflate(R.layout.user_listview_item1, null);
                    ImageView image6 = (ImageView) convertView.findViewById(R.id.item1_image);
                    TextView textview6 = (TextView) convertView.findViewById(R.id.item_textview);
                    image6.setImageResource(imagedata[position-3]);
                    textview6.setText(textdata[position-3]);
                    return convertView;

            }

            return null;
        }
    }



}
