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
import classdata.Main_mguide;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-22.
 */
public class Main_mguides_Adapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private Context context;
    private ArrayList<Main_mguide> mguides;
    private final BitmapUtils bitmapUtils;

    public Main_mguides_Adapter(Context context, ArrayList<Main_mguide> mguides) {
        this.context = context;
        this.mguides = mguides;
        inflater = LayoutInflater.from(context);
        bitmapUtils = LoadImage.getImage(context);
    }

    @Override
    public int getCount() {
        if(mguides!=null){
            return mguides.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return mguides.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.main_gridview_item, null);
            holder=new ViewHolder();
            holder.photo = (ImageView) convertView.findViewById(R.id.imageView);
            holder.username = (TextView) convertView.findViewById(R.id.textView1);
            holder.title = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        Main_mguide main_mguide = mguides.get(position);
        holder.photo.setTag(main_mguide.getPhoto());
        holder.title.setText(main_mguide.getTitle());
        holder.username.setText(main_mguide.getUsername());
        bitmapUtils.display(holder.photo,main_mguide.getPhoto());

        return convertView;
    }

    class ViewHolder{
        ImageView photo;
        TextView  title;
        TextView  username;
    }
}
