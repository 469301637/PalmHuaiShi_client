package com.example.liurui.palmhuaishi_client.ui.activity;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.example.liurui.palmhuaishi_client.utils.compress.UIUtil;

import java.util.Random;

import okhttp3.Call;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText nickname;//其实是手机号码，项目已经做好，就不太好改了QAQ
    private EditText nickname1;//接收的验证码
    private Button button;//注册按钮
    private Button button1;//获取验证码按钮
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);
        nickname = findViewById(R.id.register_nickname);
        button = findViewById(R.id.register_button);
        nickname1 = findViewById(R.id.register_nickname1);
        button1 = findViewById(R.id.register_message);
        webView=findViewById(R.id.register_web);
        ViewCompat.setAlpha(webView,0);//修改透明度为最低值

        //获取随机数作为验证码
        int x = 1000 + (int) (Math.random() * 500);
        final String random = x + "";


        //获取验证码的服务通信
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String iphone = nickname.getText().toString().trim();

                String url ="http://118.25.130.111/dashboard/message/qcloudsms_php-master/demo/simple/app.php?iphone="+iphone+"&random="+random;
                webView.loadUrl(url);
                // AppService.getInstance().message(random,iphone);
                //test
                Log.e("iphone",iphone);
                Log.e("random",random);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = username.getText().toString().trim();
                final String pass = password.getText().toString().trim();
                String nick = nickname.getText().toString().trim();
                String get_iphone= nickname1.getText().toString().trim();
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

                if (get_iphone.equals(random)) {
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

                else
                {

                    Toast.makeText(getApplicationContext(), "您的验证码有误！", Toast.LENGTH_SHORT).show();
                    // UIUtil.showToast("密码长度不能小于6！");
                    return;
                }

                }

        });
    }
}