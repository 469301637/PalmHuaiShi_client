package com.example.liurui.palmhuaishi_client.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;

import com.example.liurui.palmhuaishi_client.model.JsonUser;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.ui.activity.ChangeUserActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.FileActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.ReleaseActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.UploadimagesActivity;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MyDetailActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView iphone;
    private TextView integral;
    private ImageView password1;
    private ImageView iphone1;
    private String iphone_number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_detail);

        username = findViewById(R.id.my_detail_username);
        password = findViewById(R.id.my_detail_password);
        iphone = findViewById(R.id.my_detail_iphone);
        integral = findViewById(R.id.my_detail_integral);


        password1 = findViewById(R.id.my_detail_password_img);
        iphone1 = findViewById(R.id.my_detail_iphone_img);

        ShowView();


        password1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyDetailActivity.this, ChangeUserActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("iphone", iphone_number);
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);
                startActivity(intent);

            }
        });

        iphone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyDetailActivity.this, ChangeUserActivity.class);
                startActivity(intent);

            }
        });

    }

    private void ShowView() {
        //当前登录的用户名
        String username1 = AppService.getInstance().getCurrentUser().username;

        username.setText(username1);

        OkHttpUtils.post("http://118.25.130.111/dashboard/mydetail/get_imgornation.php")
                .params("username", username1)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.e("information", s);
                        JsonUser jsonUser = new Gson().fromJson(s, JsonUser.class);
                        List<JsonUser.UserBean> userList = jsonUser.getData();
                        Log.e("password", userList.get(0).getPassword());

                        iphone_number=userList.get(0).getNickname();

                        password.setText(userList.get(0).getPassword());
                        iphone.setText(userList.get(0).getNickname());
                        integral.setText(userList.get(0).getIntegral() + "");
                        //integral.setText(userList.get(0).getIntegral());
                    }
                });
        /*AppService.getInstance().get_information(username1, new JsonCallback<LslResponse<User>>() {
            @Override
            public void onSuccess(LslResponse<User> userLslResponse, Call call, Response response) {
                if (userLslResponse.code != LslResponse.RESPONSE_OK) {
                    Toast.makeText(getApplicationContext(), "回调有误!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("get", String.valueOf(userLslResponse.data.getPassword()));
                    Log.e("no", String.valueOf(userLslResponse.data.password));
                    //Toast.makeText(getApplicationContext(), "您当前的积分为："+userLslResponse.data.integral, Toast.LENGTH_SHORT).show();
                    users=new ArrayList<>();
                    users.add(userLslResponse.data);
                    password.setText(users.get(0).getPassword());
                    Log.e("0", users.get(0).getPassword());
                    Log.e("1",users.get(1).getPassword());
                }
            }
        });*/

    }

    /*private List<User> parseJson(List<User> json) {
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse((JsonReader) json).getAsJsonArray();

        Gson gson = new Gson();
        jsonBeanArrayList = new ArrayList<>();

        //循环遍历json数组
        for (JsonElement json : jsonArray) {
            //使用GSON，转成Bean对象
            User jsonBean = gson.fromJson(json, User.class);
            jsonBeanArrayList.add(jsonBean);
        }
        return jsonBeanArrayList;
    }*/

}
