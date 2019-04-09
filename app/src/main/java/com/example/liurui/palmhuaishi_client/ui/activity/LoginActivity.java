package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences.Editor;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.config.Consts;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.utils.AppService;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText uid;
    private EditText pwd;
    private Button button;
    private Button button1;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uid = (EditText) findViewById(R.id.login_username);
        pwd = (EditText) findViewById(R.id.login_password);
        button = findViewById(R.id.login_login);
        button1 = findViewById(R.id.login_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uid.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                SendByHttpClient(username, password);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建Intent对象
                Intent intent = new Intent();
                //调用Intent的setClass方法
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
    }

    public void SendByHttpClient(final String username, final String password) {
      /* new Thread(new Runnable() {
        @Override
        public void run() {*/
        AppService.getInstance().loginHytc(username, password, new JsonCallback<LslResponse<User>>() {
            @Override
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
                    // loginXin(currentUsername,currentPassword);
                }
            }
        });
    }




    /**
     * 把信息存储起来
     * @param data
     */
    @SuppressWarnings("ConstantConditions")
    private void setUserInfo(User data) {
        if (!TextUtils.isEmpty(data.avatar)){
            data.avatar = Consts.API_SERVICE_HOST+data.avatar;
        }
        AppService.getInstance().setCurrentUser(data);

       /* Editor editor = sp.edit();
        editor.putString("username",data.username);
        editor.putString("password",data.password);
        editor.putString("nickname",data.nickname);
        editor.putInt("integral",data.integral);
        editor.apply();*/
    }

}
     /*   }).start();
        }

}
*/