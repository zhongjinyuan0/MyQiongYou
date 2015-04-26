package qiongyou.qiongyou.adapter_data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import qiongyou.qiongyou.R;
import qiongyou.qiongyou.classdata.World_continents;
import qiongyou.qiongyou.classdata.World_hot_country;
import qiongyou.qiongyou.tookbag.LoadImage;

/**
 * Created by aaa on 15-4-24.
 */
public class World_Adapter extends BaseAdapter {

    private final BitmapUtils bitmapUtils;
    private Context context;
    private ArrayList<World_hot_country> hot_countries;
    private final LayoutInflater inflater;

    public World_Adapter(Context context, ArrayList<World_hot_country> hot_countries) {
        this.context = context;
        this.hot_countries = hot_countries;
        inflater = LayoutInflater.from(context);
        bitmapUtils = LoadImage.getImage(context);
    }

    @Override
    public int getCount() {
        if(hot_countries!=null){
            return hot_countries.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return hot_countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.destination_item1,null);
            holder=new ViewHolder();
            holder.photo= (ImageView) convertView.findViewById(R.id.imageView);
            holder.count= (TextView) convertView.findViewById(R.id.textView1);
            holder.label= (TextView) convertView.findViewById(R.id.textView2);
            holder.cnname= (TextView) convertView.findViewById(R.id.textView3);
            holder.enname= (TextView) convertView.findViewById(R.id.textView4);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        World_hot_country hot_country = hot_countries.get(position);
        holder.count.setText(hot_country.getCount());
        holder.label.setText(hot_country.getLabel());
        holder.cnname.setText(hot_country.getCnname());
        holder.enname.setText(hot_country.getEnname());

        bitmapUtils.display(holder.photo,hot_country.getPhoto());

        return convertView;
    }

    class ViewHolder{
        ImageView photo;
        TextView count;
        TextView label;
        TextView cnname;
        TextView enname;
    }
}
