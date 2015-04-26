package Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import JavaBean.Json_Search_MuDi;
import Utils.ImageLoadUtils;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-22.
 */
public class Schlistview_Adapter extends BaseAdapter{
    private ArrayList<Json_Search_MuDi> datas;
    private Context context;
    private final LayoutInflater inflater;

    public Schlistview_Adapter(ArrayList<Json_Search_MuDi> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (datas==null){
            return 0;
        }else {
        return datas.size();}
    }

    @Override
    public Json_Search_MuDi getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if (convertView==null){
              hodler = new ViewHodler();
            convertView = inflater.inflate(R.layout.item_search_mudidi_listview, null);
            hodler.imageView= (ImageView) convertView.findViewById(R.id.search_mudidi_item_imageview);
            hodler.textView1 = (TextView) convertView.findViewById(R.id.search_mudidi_item_textview1);
            hodler.textView2 = (TextView) convertView.findViewById(R.id.search_mudidi_item_textview2);
            hodler.textView3 = (TextView) convertView.findViewById(R.id.search_mudidi_item_textview3);
            hodler.textView4 = (TextView) convertView.findViewById(R.id.search_mudidi_item_textview4);
            hodler.textView5 = (TextView) convertView.findViewById(R.id.search_mudidi_item_textview5);
            convertView.setTag(hodler);

        }else {
            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.textView1.setText(datas.get(position).getCnname());
        hodler.textView2.setText(datas.get(position).getEnname());
        hodler.textView3.setText(datas.get(position).getLabel());
        hodler.textView4.setText(datas.get(position).getParentname());
        hodler.textView5.setText(datas.get(position).getBeenstr());
//

            ImageLoadUtils.imagedown(context).display(hodler.imageView,datas.get(position).getPhoto());






        return convertView;
    }

    class ViewHodler{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;

    }
}
