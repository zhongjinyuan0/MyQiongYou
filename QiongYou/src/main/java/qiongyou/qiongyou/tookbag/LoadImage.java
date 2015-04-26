package qiongyou.qiongyou.tookbag;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

import qiongyou.qiongyou.R;

/**
 * Created by aaa on 15-4-21.
 */
public class LoadImage {

    private static BitmapUtils bitmapUtils;

    public static BitmapUtils getImage(Context context){
        if(bitmapUtils!=null){
            return bitmapUtils;
        }
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
        bitmapUtils.configMemoryCacheEnabled(true);
        bitmapUtils.configDiskCacheEnabled(true);
        bitmapUtils.configThreadPoolSize(4);

        return bitmapUtils;
    }


}
