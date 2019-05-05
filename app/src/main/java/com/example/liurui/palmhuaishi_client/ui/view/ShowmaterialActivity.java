package com.example.liurui.palmhuaishi_client.ui.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.MainActivity;
import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.Material;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.ui.activity.LoginActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.ReleaseActivity;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by liurui on 2019.4.10.
 * 真是一点都不想写代码！！！可是又不能偷懒~~~
 */
public class ShowmaterialActivity extends AppCompatActivity {


    /*  private static final String TAG = "ShowmaterialActivitys";
      //先测试一下，以后再改成intent数据传输过来的值
      private String type = "文学院";
      private ListView listView;*/
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmaterial);

        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("data");
        //获取数据
        String school = bundle.getString("secondlevel");

        webView = findViewById(R.id.show_web);
        initWebView(school);
    }

    private void initWebView(String text) {
        //加载一个网页：(没有请求头QAQ)
        webView.loadUrl("http://118.25.130.111/dashboard/files/all.php?firstlevel="+text);
    }
        /*Intent intent = new Intent();

//Intent intent = new Intent(Intent.ACTION_VIEW,uri);

        intent.setAction("android.intent.action.VIEW");

        Uri content_url = Uri.parse("http://118.25.130.111/dashboard/files/all.php");

        intent.setData(content_url);

        startActivity(intent);*/

}


   /* public void Show() {

        AppService.getInstance().getmaterial(type, new JsonCallback<LslResponse<Material>>() {
            @Override
            public void onSuccess(LslResponse<Material> materialLslResponse, Call call, Response response) {
               *//* String json = null;
                     json = materialLslResponse.data.toString();
                     Log.e(TAG,json);*//*

                Gson gson = new Gson();//创建Gson对象
                JsonParser jsonParser = new JsonParser();
                JsonArray jsonElements = null;
                     jsonElements = jsonParser.parse(response.body().toString()).getAsJsonArray();//获取JsonArray对象
                ArrayList<Material> beans = new ArrayList<>();
                for (JsonElement bean : jsonElements) {
                    Material bean1 = gson.fromJson(bean, Material.class);//解析
                    beans.add(bean1);
                }
                Toast.makeText(ShowmaterialActivity.this,beans.get(1).id,Toast.LENGTH_LONG);
                Log.e(TAG,beans.get(1).id);
            }*/

           /* @Override
            public void onSuccess(LslResponse<User> userLslResponse, Call call, Response response) {
                if (userLslResponse.code != LslResponse.RESPONSE_OK) {
                    Log.e(TAG, "用户名或密码错误!");
                    Toast.makeText(getApplicationContext(), "用户名或密码错误!", Toast.LENGTH_SHORT).show();
                    //UIUtil.showToast(TAG);
                    // stopLoading();
                } else {
                    //存储用户信息
                    setUserInfo(userLslResponse.data);

                    Log.e(TAG, "登陆服务器成功！");
                    //创建Intent对象
                    Intent intent = new Intent();
                    //调用Intent的setClass方法
                    intent.setClass(LoginActivity.this, ReleaseActivity.class);
                    //启动Activity
                    startActivity(intent);
                    LoginActivity.this.finish();
                    // loginXin(currentUsername,currentPassword);
                }
            }*/
     /*   });

    }
}*/
