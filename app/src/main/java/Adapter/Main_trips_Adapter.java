package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import Utils.LoadImage;
import classdata.Main_trip;
import pushe.qiongyou.R;


/**
 * Created by aaa on 15-4-22.
 */
public class Main_trips_Adapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Main_trip> trips;
    private BitmapUtils bitmapUtils;

    public Main_trips_Adapter(Context context, ArrayList<Main_trip> trips) {
        this.context = context;
        this.trips = trips;
        inflater = LayoutInflater.from(context);
        bitmapUtils = LoadImage.getImage(context);
    }
    @Override
    public int getCount() {
        if(trips!=null){
            return trips.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return trips.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.main_list_item, null);
            holder=new ViewHolder();
            holder.photo = (ImageView) convertView.findViewById(R.id.imageView);
            holder.title = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        Main_trip main_trip = trips.get(position);
        holder.photo.setTag(main_trip.getPhoto());
        holder.title.setText(main_trip.getTitle());
        bitmapUtils.display(holder.photo,main_trip.getPhoto());
        return convertView;
    }

    class ViewHolder{
        ImageView photo;
        TextView  title;
    }
}
