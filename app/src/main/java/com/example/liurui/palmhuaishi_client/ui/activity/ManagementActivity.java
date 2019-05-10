package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.utils.AppService;

import java.text.SimpleDateFormat;

import okhttp3.Call;
import okhttp3.Response;

public class ManagementActivity extends AppCompatActivity {


    private EditText top;
    private EditText gundong;
    private EditText detail;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        top=findViewById(R.id.management_top);
        gundong=findViewById(R.id.management_gundong);
        detail=findViewById(R.id.management_details);
        button=findViewById(R.id.management_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取当前时间作为ID时间戳标记，与内容表一一对应！
                SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final String time = tempDate.format(new java.util.Date());

                String showtop=top.getText().toString().trim();
                String showgundong=gundong.getText().toString().trim();
                String showdetail=detail.getText().toString().trim();
                AppService.getInstance().managementHytc(time,showtop,showgundong,showdetail, new JsonCallback<LslResponse<User>>() {
                    @Override
                    public void onSuccess(LslResponse<User> userLslResponse, Call call, Response response) {

                    }
                });
                Toast.makeText(getApplicationContext(), "发布成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(ManagementActivity.this, IndexActivity.class);
                //启动Activity
                startActivity(intent);
                ManagementActivity.this.finish();
            }
        });
    }
}
