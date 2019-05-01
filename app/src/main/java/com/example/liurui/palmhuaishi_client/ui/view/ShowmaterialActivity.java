package com.example.liurui.palmhuaishi_client.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

public class ShowmaterialActivity extends AppCompatActivity {


    private static final String TAG = "ShowmaterialActivitys";
    //先测试一下，以后再改成intent数据传输过来的值
    private String type = "文学院";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmaterial);
        listView = findViewById(R.id.showmaterial);
        Show();
    }

    public void Show() {

        AppService.getInstance().getmaterial(type, new JsonCallback<LslResponse<Material>>() {
            @Override
            public void onSuccess(LslResponse<Material> materialLslResponse, Call call, Response response) {
                String json = null;
                try {
                     json = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
               Toast.makeText(ShowmaterialActivity.this,json,Toast.LENGTH_SHORT);
            }

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
        });

    }
}
