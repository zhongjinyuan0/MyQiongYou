package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import Utils.LoadImage;
import classdata.World_country;
import pushe.qiongyou.R;


/**
 * Created by aaa on 15-4-24.
 */
public class World_Adapter_2 extends BaseAdapter {

    private final LayoutInflater inflater;
    private final BitmapUtils bitmapUtils;
    private Context context;
    private ArrayList<World_country> countries;

    public World_Adapter_2(Context context, ArrayList<World_country> countries) {
        this.context = context;
        this.countries = countries;
        inflater = LayoutInflater.from(context);
        bitmapUtils = LoadImage.getImage(context);
    }

    @Override
    public int getCount() {
        if(countries!=null) {
            return countries.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.destination_item2,null);
            holder=new ViewHolder();
            holder.cnname= (TextView) convertView.findViewById(R.id.textView1);
            holder.enname= (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        World_country country = countries.get(position);
        holder.cnname.setText(country.getCnname());
        holder.enname.setText(country.getEnname());

        return convertView;
    }

    class ViewHolder{
        TextView cnname;
        TextView enname;
    }

}
