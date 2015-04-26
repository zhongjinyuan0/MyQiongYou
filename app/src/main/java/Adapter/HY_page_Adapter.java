package Adapter;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import pushe.qiongyou.MainActivity;
import pushe.qiongyou.R;
import pushe.qiongyou.Slpash;

/**
 * Created by aaa on 15-4-20.
 */
public class HY_page_Adapter extends PagerAdapter{
    private ArrayList<TextView> data;
    private LayoutInflater inflater;
    private View view;
    private MainActivity context;

    public HY_page_Adapter(ArrayList<TextView> data,MainActivity context) {
        this.data = data;
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size()+1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if (position==3){
            container.removeView(view);
        }else {
            container.removeView(data.get(position));
        }
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        if (position==3){
            view = inflater.inflate(R.layout.hypage4_layout, null);
            container.addView(view);
            Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,Slpash.class);
                    context.startActivity(intent);
                    context.finish();
                }
            });

            return view;

        }
        TextView view = data.get(position);
        container.addView(view);
        return view;

    }


}
