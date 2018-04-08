package com.rtlabs.srilankatoday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class NewsView extends AppCompatActivity {

    String URL;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);

        WebView browser = (WebView) findViewById(R.id.webview);
        webView = browser;
        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("title"));
        String url = intent.getStringExtra("url");
        URL = url;
        browser.getSettings().setAllowFileAccess(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setPluginState(WebSettings.PluginState.ON);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(url);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refreshmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh) {
            webView.loadUrl(URL);
        }

        return super.onOptionsItemSelected(item);
    }

}
