package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;

import com.example.liurui.palmhuaishi_client.ui.view.MyDetailActivity;
import com.leon.lib.settingview.LSettingItem;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        //对一个控件进行点击事件
        LSettingItem one = (LSettingItem) findViewById(R.id.item_one);
        LSettingItem two = findViewById(R.id.item_two);
        //第一个：个人信息
        one.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                //Toast.makeText(MyActivity.this, "点击了钱包", Toast.LENGTH_SHORT).show();
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
            }
        });
    }
}
