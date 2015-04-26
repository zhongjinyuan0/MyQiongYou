package pushe.qiongyou;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class Slpash extends ActionBarActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slpash);
        //欢迎页imageviw
        getSupportActionBar().hide();
        image = (ImageView) findViewById(R.id.slpash_imageview);
        image.setImageResource(R.drawable.zbg_user_cover_def);
        //设置一个欢迎页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //导航页完成,跳转到myQyActivity进行首页代码
                Intent intent = new Intent(Slpash.this,MySYActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);


    }



}
