package com.example.liurui.palmhuaishi_client.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.utils.AppService;

public class MyLuntanActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_luntan);

        //当前登录的用户名
        String username = AppService.getInstance().getCurrentUser().username;

        webView=findViewById(R.id.my_luntan);
        webView.loadUrl("http://118.25.130.111/dashboard/mydetail/my_luntan.php?username=" + username);
    }
}
