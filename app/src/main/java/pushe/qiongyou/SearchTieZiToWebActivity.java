package pushe.qiongyou;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class SearchTieZiToWebActivity extends ActionBarActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tie_zi_to_web);
//        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        //找到uri
        //34435435yyyyy
        Intent intent = getIntent();
        url = intent.getStringExtra("view_url");
        final WebView webView= (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(true);//
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);  //加载url
        webView.requestFocus(); //获取焦点
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN){
                    if (keyCode==KeyEvent.KEYCODE_BACK&&webView.canGoBack()){
                        webView.goBack();
                        return true;
                    }


                }

                return false;
            }
        });

    }


}
