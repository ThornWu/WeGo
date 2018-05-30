package com.thorn.wego.Life.News;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thorn.wego.R;

import java.net.URL;

public class NewsDetailActivity extends AppCompatActivity {
    private WebView webView;
    private String newsDetailUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        newsDetailUrl =getIntent().getExtras().get("newsurl").toString();
        webView = (WebView) findViewById(R.id.news_content_webview);
        webView.canGoBack();
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webView.loadUrl(newsDetailUrl);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
