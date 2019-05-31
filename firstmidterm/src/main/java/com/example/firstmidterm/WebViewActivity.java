package com.example.firstmidterm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
        initData();
    }

    private void initData() {
        String link = getIntent().getStringExtra("link");

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);

        mWebView.loadUrl(link);
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webView);
    }
}
