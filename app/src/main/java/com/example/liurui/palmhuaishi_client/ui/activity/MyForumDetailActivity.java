package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.JsonUser;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MyForumDetailActivity extends AppCompatActivity {

    private WebView webView;
    private EditText message;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_forum_detail);

        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("data");
        //获取数据
        final String id = bundle.getString("id");
        final String username = bundle.getString("username");

        //获取当前时间作为ID时间戳标记，与内容表一一对应！
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String time = tempDate.format(new java.util.Date());

        webView=findViewById(R.id.myforum_detail);
        webView.loadUrl("http://118.25.130.111/dashboard/bbs/detail.php?id=" + id+"&username="+username);

        message=findViewById(R.id.my_forum_detail_message);
        submit=findViewById(R.id.my_forum_detail_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=message.getText().toString().trim();

                OkHttpUtils.post("http://118.25.130.111/dashboard/bbs/submit_comment.php")
                        .params("username", username)
                        .params("id", id)
                        .params("time", time)
                        .params("content", content)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Toast.makeText(getApplicationContext(), "回帖成功！", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}
