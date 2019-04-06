package com.example.liurui.palmhuaishi_client.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.example.liurui.palmhuaishi_client.utils.compress.UIUtil;

import okhttp3.Call;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText nickname;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);
        nickname = findViewById(R.id.register_nickname);
        button = findViewById(R.id.register_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = username.getText().toString().trim();
                final String pass = password.getText().toString().trim();
                String nick = nickname.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(nick)) {
                    Toast.makeText(getApplicationContext(), "请填写必要信息!", Toast.LENGTH_SHORT).show();
                    //UIUtil.showToast(this, "请填写必要信息！");
                    return;
                }
                if (pass.length() < 6) {
                    Toast.makeText(getApplicationContext(), "密码长度不能小于6!", Toast.LENGTH_SHORT).show();
                    // UIUtil.showToast("密码长度不能小于6！");
                    return;
                }
                //开始注册啦！


                AppService.getInstance().registerHytc(name, pass, nick, new JsonCallback<LslResponse<User>>() {
                    @Override
                    public void onSuccess(LslResponse<User> userLslResponse, Call call, Response response) {
                        if (userLslResponse.code == LslResponse.RESPONSE_OK) {
                            // Log.e(TAG,avatarUrl);
                            Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_SHORT).show();
                            //UIUtil.showToast("注册成功！");
                            RegisterActivity.this.finish();
                        }
                        // stopLoading();
                        else {
                            Toast.makeText(getApplicationContext(), "注册失败!请重新注册！", Toast.LENGTH_SHORT).show();
                            //UIUtil.showToast("注册失败" + userLslResponse.msg);
                            //stopLoading();
                        }
                    }
                });
            }
        });
    }
}