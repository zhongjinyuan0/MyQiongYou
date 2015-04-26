package Utils;


import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

import pushe.qiongyou.R;

/**
 * Created by aaa on 15-4-23.
 */
public  class ImageLoadUtils  {

    public static BitmapUtils imagedown(Context context){
        BitmapUtils b=new BitmapUtils(context);
        b.configDefaultLoadingImage(R.drawable.ic_launcher);
        b.configDefaultLoadFailedImage(R.drawable.ic_qyer_gray_60);
        b.configMemoryCacheEnabled(true);
        b.configThreadPoolSize(3);
        return b;
    }


}
