package qiongyou.qiongyou.adapter_data;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

import qiongyou.qiongyou.R;
import qiongyou.qiongyou.classdata.ViewPagerData;
import qiongyou.qiongyou.tookbag.LoadImage;

/**
 * Created by aaa on 15-4-21.
 */
public class ViewPagerAdapter extends PagerAdapter{


        private Context context;
        private ArrayList<ViewPagerData> list;
        private ArrayList<View> views;
    private final BitmapUtils bitmapUtils;


    public ViewPagerAdapter(Context context, ArrayList<ViewPagerData> list) {
            this.context = context;
            this.list = list;
        bitmapUtils = LoadImage.getImage(context);
            init();

        }

        public void init(){
            views = new ArrayList<View>();
            views.clear();

            for (int i = 0; i < list.size(); i++) {
                View v = LayoutInflater.from(context).inflate(R.layout.viewpager_item, null);
                ImageView image = (ImageView) v.findViewById(R.id.imageView);

                ViewPagerData pagerData = list.get(i);
                bitmapUtils.display(image,pagerData.getPhoto());
                views.add(v);
            }

        }
        @Override
        public void notifyDataSetChanged() {
            init();
            super.notifyDataSetChanged();
        }



        @Override
        public int getCount() {

            return views.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            View view = views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(views.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


}
