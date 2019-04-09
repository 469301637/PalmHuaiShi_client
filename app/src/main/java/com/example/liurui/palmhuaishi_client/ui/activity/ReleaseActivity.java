package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.liurui.palmhuaishi_client.R;

import java.text.SimpleDateFormat;

public class ReleaseActivity extends AppCompatActivity {


    private ImageView imageView;
    private EditText title;
    private EditText content;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        imageView = findViewById(R.id.release_images);
        title = findViewById(R.id.release_title);
        content = findViewById(R.id.release_content);
        button = findViewById(R.id.release_button);
        //获取当前时间作为ID时间戳标记，与内容表一一对应！
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String time = tempDate.format(new java.util.Date());


        imageView.setImageResource(R.drawable.upload_images);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReleaseActivity.this, UploadimagesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("time", time);
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

    }

}
