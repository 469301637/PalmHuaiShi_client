package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.liurui.palmhuaishi_client.R;

public class HTMLActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("data");
        //获取数据
        String url = bundle.getString("url");

        webView=findViewById(R.id.HTML);
        webView.loadUrl(url);
    }
}
