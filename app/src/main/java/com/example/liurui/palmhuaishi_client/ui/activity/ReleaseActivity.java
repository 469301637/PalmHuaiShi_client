package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.Release;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.example.liurui.palmhuaishi_client.utils.AppService;

import java.text.SimpleDateFormat;

import okhttp3.Call;
import okhttp3.Response;

public class ReleaseActivity extends AppCompatActivity {

    //private static final String TAG = "ReleaseActivity";

    private ImageView imageView;
    private EditText title;
    private EditText content;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        //获取当前时间作为ID时间戳标记，与内容表一一对应！
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String time = tempDate.format(new java.util.Date());

        title = findViewById(R.id.release_title);
        content = findViewById(R.id.release_content);
        button = findViewById(R.id.release_button);
        imageView = findViewById(R.id.release_images);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = title.getText().toString().trim();
                String c = content.getText().toString().trim();
                //当前登录的用户名
                String username = AppService.getInstance().getCurrentUser().username;
                //  Log.e("username",username);
                release(time,username, t, c);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReleaseActivity.this, UploadimagesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("time", time);
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

    }

    private void release(String id,String name, String title, String content) {
        AppService.getInstance().releaseHytc(id,name, title, content, new JsonCallback<LslResponse<Release>>() {
            @Override
            public void onSuccess(LslResponse<Release> userLslResponse, Call call, Response response) {
                if (userLslResponse.code == LslResponse.RESPONSE_OK) {
                    // Log.e(TAG,avatarUrl);
                    Toast.makeText(getApplicationContext(), "发布成功！", Toast.LENGTH_SHORT).show();
                    //UIUtil.showToast("注册成功！");
                    ReleaseActivity.this.finish();
                }
                // stopLoading();
                else {
                    Toast.makeText(getApplicationContext(), "发布失败，请重新发布！", Toast.LENGTH_SHORT).show();
                    //UIUtil.showToast("注册失败" + userLslResponse.msg);
                    //stopLoading();
                }
            }
        });
    }

}
