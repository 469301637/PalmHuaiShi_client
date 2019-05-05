package com.example.liurui.palmhuaishi_client.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.utils.AppService;

import java.util.HashMap;
import java.util.Map;

public class MyDetailActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detail);

        webView = findViewById(R.id.my_detail);
        initWebView();
    }

    private void initWebView() {


        Map<String, String> map = new HashMap<>();

        //当前登录的用户名
        // String username = AppService.getInstance().getCurrentUser().username;
        String username = "2115110249";
        //先测试一下
        map.put("username", "2115110249");

        //测试
        // Log.e("1",map.get("username"));
        //加载一个网页：(有请求头)
        webView.loadUrl("http://118.25.130.111/dashboard/mydetail/my_imfornation.php?username=" + username);

        //走过很多弯路！！！这个地方带参数的传值花了我三个小时！！！fuck！基础不牢，地动山摇！
        //webView.postUrl("http://118.25.130.111/dashboard/mydetail/my_imfornation.php",username);
    }

}
