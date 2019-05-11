package com.example.liurui.palmhuaishi_client.ui.activity;

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

import java.security.spec.PSSParameterSpec;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class FindPasswordActivity extends AppCompatActivity {

    private EditText find_password_username;
    private EditText find_password_iphone;
    private EditText find_password_yanzhengma;
    private Button fasong_yanzhengma;
    private Button find_password_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);

        //获取随机数作为验证码
        int x = 1000 + (int) (Math.random() * 500);
        final String random = x + "";
        Log.e("random",random);

        find_password_username = findViewById(R.id.find_password_username);
        find_password_iphone = findViewById(R.id.find_password_iphone);
        find_password_yanzhengma = findViewById(R.id.find_password_yanzhengma);
        fasong_yanzhengma = findViewById(R.id.find_password_iphone_fasong_yanzhengma);
        find_password_submit = findViewById(R.id.find_password_submit);

        fasong_yanzhengma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = find_password_iphone.getText().toString().trim();

                //获取验证码的服务通信
                String url = "http://118.25.130.111/dashboard/message/qcloudsms_php-master/demo/simple/change_password.php";
                OkHttpUtils.post(url)
                        .params("iphone", phone)
                        .params("random", random)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                //Toast.makeText(getApplicationContext(), "修改密码成功！", Toast.LENGTH_SHORT).show();
                                //finish();
                            }
                        });
            }
        });

        find_password_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = find_password_username.getText().toString().trim();
                Log.e("username",username);
                if (find_password_yanzhengma.getText().toString().trim().equals(random + "")) {
                    OkHttpUtils.post("http://118.25.130.111/dashboard/user/find_password.php")
                            .params("username", username)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Log.e("information", s);
                                    JsonUser jsonUser = new Gson().fromJson(s, JsonUser.class);
                                    List<JsonUser.UserBean> userList = jsonUser.getData();
                                    if (jsonUser.getCode() == -1) {
                                        Toast.makeText(getApplicationContext(), "您的输入有误!请重新输入！", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Log.e("password", userList.get(0).getPassword());
                                    String password = userList.get(0).getPassword();
                                    Toast.makeText(getApplicationContext(), "您的密码为：" + password, Toast.LENGTH_LONG).show();
                                    FindPasswordActivity.this.finish();
                                    }
                                }
                            });

                } else {
                    Toast.makeText(getApplicationContext(), "您的输入有误!请重新输入！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
