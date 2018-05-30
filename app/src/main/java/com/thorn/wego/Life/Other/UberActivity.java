package com.thorn.wego.Life.Other;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import com.thorn.wego.R;

public class UberActivity extends AppCompatActivity {
    private WebView webView;

    private static boolean isExit = false;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uber);

        webView = (WebView) findViewById(R.id.uber_webview);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, true);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }
        });
        webView.canGoBack();
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);

        webView.loadUrl(getResources().getString(R.string.uber_url));

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "Press back button again to exit the function", Toast.LENGTH_LONG).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            this.finish();
        }
    }

}
