package AutoView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by aaa on 15-4-22.
 */
public class MySearchList0 extends ListView {


    public MySearchList0(Context context) {
        super(context);
    }

    public MySearchList0(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec,i);
    }
}
