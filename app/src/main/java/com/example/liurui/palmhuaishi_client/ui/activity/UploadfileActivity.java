package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.utils.compress.UploadUtil;

public class UploadfileActivity extends AppCompatActivity {

    private Button file;
    private Button upload;
    private Spinner firstlevel;
    private Spinner secondlevel;
    String first;
    String second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadfile);

        firstlevel = findViewById(R.id.firstlevel);
        secondlevel = findViewById(R.id.secondlevel);
        firstlevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] languages = getResources().getStringArray(R.array.firstspinner);
                first = languages[pos];

                // Toast.makeText(UploadfileActivity.this, "你点击的是:"+languages[pos], 1000).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        secondlevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] language = getResources().getStringArray(R.array.secondspinner);
                second = language[pos];
                // Toast.makeText(UploadfileActivity.this, "你点击的是:"+languages[pos], 1000).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        file = findViewById(R.id.uploadfile_file);
        upload = findViewById(R.id.uploadfile_upload);
        file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //测试是否可以取值
                Log.e("first", first);
                Log.e("second", second);
                //开始跳转页面然后上传啦！
                Intent intent = new Intent(UploadfileActivity.this, FileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("first", first);
                bundle.putString("second",second);
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });

    }

}
