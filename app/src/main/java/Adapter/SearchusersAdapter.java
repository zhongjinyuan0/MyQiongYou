package Adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import JavaBean.JsonToSearchUsers;
import Utils.ImageLoadUtils;
import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-24.
 */
public class SearchusersAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<JsonToSearchUsers> data;

    private final LayoutInflater inflater;


    public SearchusersAdapter(ArrayList<JsonToSearchUsers> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
            if (data==null){
                return 0;
            }

        return data.size();
    }

    @Override
    public JsonToSearchUsers getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler;
        if (convertView==null)
        {
            hodler = new ViewHodler();
            convertView=inflater.inflate(R.layout.item_search_user,null);
            hodler.imageView= (ImageView) convertView.findViewById(R.id.searchitem_user_image);
            hodler.textViewNane = (TextView) convertView.findViewById(R.id.searchitem_user_textname);
            hodler.textVieTitle = (TextView) convertView.findViewById(R.id.searchitem_user_texttitle);
            hodler.textViewContries = (TextView) convertView.findViewById(R.id.searchitem_user_textcontoy);
            hodler.textViewCity = (TextView) convertView.findViewById(R.id.searchitem_user_textcitys);
            convertView.setTag(hodler);
        }else {

            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.textViewNane.setText(data.get(position).getUsername());
        hodler.textVieTitle.setText(data.get(position).getTitle()+"|");
        hodler.textViewContries.setText("去过"+data.get(position).getCountries()+"个国家");
        hodler.textViewCity.setText(",去过"+data.get(position).getCities()+"个城市");
        BitmapUtils utils = ImageLoadUtils.imagedown(context);
        utils.display(hodler.imageView,data.get(position).getAvatar());


        return convertView;
    }
    class ViewHodler{
        ImageView imageView;
        TextView textViewNane;
        TextView textVieTitle;
        TextView textViewContries;
        TextView textViewCity;



    }
}
