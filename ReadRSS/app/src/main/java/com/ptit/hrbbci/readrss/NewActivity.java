package com.ptit.hrbbci.readrss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewActivity extends AppCompatActivity {

    WebView wvTinTuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        wvTinTuc = findViewById(R.id.wvTinTuc);

        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTinTuc");
        wvTinTuc.loadUrl(link);

        //Only App
        wvTinTuc.setWebViewClient(new WebViewClient());
    }
}
