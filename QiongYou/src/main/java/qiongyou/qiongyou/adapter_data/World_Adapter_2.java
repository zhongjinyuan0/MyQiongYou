package qiongyou.qiongyou.adapter_data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import qiongyou.qiongyou.classdata.World_country;
import qiongyou.qiongyou.tookbag.LoadImage;

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
        
        return convertView;
    }

    class ViewHolder{
        TextView cnname;
        TextView enname;
    }

}
