package com.iteso.test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ActivityPrivacyPolicy extends AppCompatActivity {

    WebView mwebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        mwebView = (WebView) findViewById(R.id.webview);

        mwebView.loadUrl("file:///android_asset/PrivacyPolicy.html");

        WebSettings mwebSettings = mwebView.getSettings();
        mwebSettings.setJavaScriptEnabled(true);
        mwebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        mwebView.setWebViewClient(new mWebViewClient());

    }

    public class WebAppInterface{
        Context context;
        WebAppInterface(Context c){
            context = c;
        }
        @JavascriptInterface
        public void showToast(String toast){
            Toast.makeText(context,toast,Toast.LENGTH_SHORT).show();
        }
    }

    public class mWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading (WebView wv, String url){
            if(Uri.parse(url).getHost().equals("www.iteso.mx")){
                return false;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&& mwebView.canGoBack()){
            mwebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
