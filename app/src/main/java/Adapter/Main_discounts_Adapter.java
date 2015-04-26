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
import classdata.Main_discount;
import pushe.qiongyou.R;


/**
 * Created by aaa on 15-4-22.
 */
public class Main_discounts_Adapter extends BaseAdapter {
    private  LayoutInflater inflater;
    private Context context;
    private ArrayList<Main_discount> discounts;
    private  BitmapUtils bitmapUtils;

    public Main_discounts_Adapter(Context context, ArrayList<Main_discount> discounts) {
        this.context = context;
        this.discounts = discounts;
        inflater = LayoutInflater.from(context);
        bitmapUtils = LoadImage.getImage(context);
    }
    @Override
    public int getCount() {
        if(discounts!=null){
            return discounts.size();
        }else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return discounts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.main_discount_item, null);
            holder=new ViewHolder();
            holder.photo = (ImageView) convertView.findViewById(R.id.imageView);
            holder.title = (TextView) convertView.findViewById(R.id.textView1);
            holder.price = (TextView) convertView.findViewById(R.id.textView2);
            holder.end_date = (TextView) convertView.findViewById(R.id.textView3);
            holder.priceoff = (TextView) convertView.findViewById(R.id.textView4);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }

        Main_discount main_discount = discounts.get(position);

        holder.photo.setTag(main_discount.getPhoto());
        holder.title.setText(main_discount.getTitle());
        holder.price.setText(main_discount.getPrice());
        holder.end_date.setText(main_discount.getEnd_date());
        holder.priceoff.setText(main_discount.getPriceoff());


        bitmapUtils.display(holder.photo,main_discount.getPhoto());

        return convertView;
    }

    class ViewHolder{
        ImageView photo;
        TextView  title;
        TextView  price;
        TextView  end_date;
        TextView  priceoff;
    }
}
