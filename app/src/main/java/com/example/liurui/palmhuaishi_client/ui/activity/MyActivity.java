package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;

import com.example.liurui.palmhuaishi_client.model.Material;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.ui.view.BBSIndexActivity;
import com.example.liurui.palmhuaishi_client.ui.view.MaterialActivity;
import com.example.liurui.palmhuaishi_client.ui.view.MyDetailActivity;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.leon.lib.settingview.LSettingItem;

import okhttp3.Call;
import okhttp3.Response;

public class MyActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView textView;
    private int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        imageView1 = findViewById(R.id.my_but1);
        imageView2 = findViewById(R.id.my_but2);
        imageView3 = findViewById(R.id.my_but3);
        imageView4 = findViewById(R.id.my_but4);
        textView = findViewById(R.id.my_name);
        //当前登录的用户名
        final String username = AppService.getInstance().getCurrentUser().username;
        textView.setText(username);

        //底部导航栏第一个（主页）
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyActivity.this, IndexActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第二个（资料）
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyActivity.this, MaterialActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第三个（论坛）
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyActivity.this, BBSIndexActivity.class);
                startActivity(intent);
            }
        });


        //底部导航栏第四个（我的）
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /*    Intent intent = new Intent();
                intent.setClass(BBSIndexActivity.this,MyActivity.class);
                startActivity(intent);*/

            }
        });


        //对一个控件进行点击事件
        LSettingItem one = (LSettingItem) findViewById(R.id.item_one);
        LSettingItem two = findViewById(R.id.item_two);
        LSettingItem three = findViewById(R.id.item_three);
        LSettingItem four = findViewById(R.id.item_four);

        //第一个：个人信息
        one.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Intent intent = new Intent();
                //调用Intent的setClass方法
                intent.setClass(MyActivity.this, MyDetailActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
        //第二个：我的帖子
        two.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Toast.makeText(MyActivity.this, "点击了钱包", Toast.LENGTH_SHORT).show();
                //AppService.getInstance().message();
            }
        });

        //第三个：我的积分
        three.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                AppService.getInstance().get_integral(username, new JsonCallback<LslResponse<User>>() {
                    @Override
                    public void onSuccess(LslResponse<User> userLslResponse, Call call, Response response) {
                        //userLslResponse.code;

                        code=userLslResponse.code;
                        //Toast.makeText(MyActivity.this, "您的积分为："+ userLslResponse.code, Toast.LENGTH_SHORT).show();
                    }
                });
                Log.e("username",username);
                Log.e("inte",code+"");
                 Toast.makeText(MyActivity.this, "您的积分为:"+code, Toast.LENGTH_SHORT).show();
                //AppService.getInstance().message();
            }
        });

        //第四个：退出登录
        four.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Toast.makeText(MyActivity.this, "退出成功！", Toast.LENGTH_SHORT).show();
                //AppService.getInstance().message();
                Intent intent = new Intent();
                //调用Intent的setClass方法
                intent.setClass(MyActivity.this, LoginActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
    }
}
