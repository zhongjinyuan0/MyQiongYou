package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import JavaBean.JsonToSearchTieZi;
import MyFragment.MyTeiZiSearchFragment;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-23.
 */
public class SearchTieZiAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<JsonToSearchTieZi> list;

    private final LayoutInflater inflater;

    public SearchTieZiAdapter(ArrayList<JsonToSearchTieZi> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (list==null){
            return 0;
        }
        return list.size();
    }

    @Override
    public JsonToSearchTieZi getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
             holder = new ViewHolder();
            convertView=inflater.inflate(R.layout.item_search_tiezi,null);
            holder.tietextView = (TextView) convertView.findViewById(R.id.search_tiezi_tietextview);
            holder.usernametextView = (TextView) convertView.findViewById(R.id.search_tiezi_usertextview);
            holder.viewstextView = (TextView) convertView.findViewById(R.id.search_tiezi_viewstextview);
            holder.replystextView = (TextView) convertView.findViewById(R.id.search_tiezi_repleystreextview);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tietextView.setText(list.get(position).getTitle());
        holder.usernametextView.setText("用户名:"+list.get(position).getUsername());
        holder.viewstextView.setText(list.get(position).getViews());
        holder.replystextView.setText(list.get(position).getReplys());
        return convertView;
    }

    class ViewHolder {
        TextView tietextView;
        TextView usernametextView;
        TextView viewstextView;
        TextView replystextView;

    }
}
