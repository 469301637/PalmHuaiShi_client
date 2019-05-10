package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.JsonUser;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class ChangeUserActivity extends AppCompatActivity {

    private EditText pwd;
    private EditText pwd1;
    private EditText getiphone;//获得输入的验证码
    private Button putiphone;//验证码按钮
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user);


        pwd = findViewById(R.id.change_user_password);
        pwd1 = findViewById(R.id.change_user_password_again);
        getiphone = findViewById(R.id.change_user_get_iphone);
        putiphone = findViewById(R.id.change_user_get_put_iphone);
        submit = findViewById(R.id.change_user_submit);

        //获取随机数作为验证码
        int x = 1000 + (int) (Math.random() * 500);
        final String random = x + "";

        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("data");
        //获取数据
        final String iphone = bundle.getString("iphone");

        putiphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取验证码的服务通信

                final String pass = pwd.getText().toString().trim();

                String url = "http://118.25.130.111/dashboard/message/qcloudsms_php-master/demo/simple/change_password.php";

                OkHttpUtils.post(url)
                        .params("iphone", iphone)
                        .params("random", random)
                        .params("password", pass)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                //Toast.makeText(getApplicationContext(), "修改密码成功！", Toast.LENGTH_SHORT).show();
                                //finish();
                            }
                        });
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message =getiphone.getText().toString().trim();
                String pas =pwd.getText().toString().trim();
                String username=AppService.getInstance().getCurrentUser().username;

                if (message.equals(random))
                {
                    String url1 = "http://118.25.130.111/dashboard/mydetail/change_information.php";
                    OkHttpUtils.post(url1)
                            .params("password", pas)
                            .params("username", username)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Toast.makeText(getApplicationContext(), "修改密码成功！", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            });
                }else {
                    Toast.makeText(getApplicationContext(), "您的验证码输入有误！", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
