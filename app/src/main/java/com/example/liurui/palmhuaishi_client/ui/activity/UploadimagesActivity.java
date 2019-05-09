package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.adapter.MyAdapter;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.scrat.app.selectorlibrary.ImageSelector;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import java.util.Date;

/**
 * Created by liurui on 2019.4.6.
 */

public class UploadimagesActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_SELECT_IMG = 1;  //请求码
    private static final int MAX_SELECT_COUNT = 9; //最多可选择9张图片
    private TextView mContentTv;//设置图片路径
    private Button btn;
    private File file;
    private TextView content;
    private GridView lv_grid; //三列gridView
    private List<String> path;//路径集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadimages);
        initView();
        //UploadimagesActivity.this.finish();
    }

    private void initView() {
        mContentTv = (TextView) findViewById(R.id.content);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        content = (TextView) findViewById(R.id.content);
        content.setOnClickListener(this);
        lv_grid = (GridView) findViewById(R.id.lv_grid);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_SELECT_IMG) {
            showImage(data); //设置图片 跟图片目录
            Log.e("TAG", Environment.getExternalStorageDirectory().getPath().toString());
            uploadImage(data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void uploadImage(Intent data) {

        if (data != null) {
            path = ImageSelector.getImagePaths(data);
            for (int i = 0; i < path.size(); i++) {
                        /**
                        * 从本地文件中读读取图片
                        * */
                String fileName = "";
                file = new File(path.get(i));
                if (file.getName() == null) {
                } else {
                    fileName = getFileName(path.get(i));
                }
                //当前登录的用户名
                String username = AppService.getInstance().getCurrentUser().username;
                //  Log.e("username",username);

             /*   //获取当前时间作为ID时间戳标记，与内容表一一对应！
                //Date d = new Date();
                SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = tempDate.format(new java.util.Date());
               // Log.e("time",time);*/

                Intent intent = getIntent();
                //从intent取出bundle
                Bundle bundle = intent.getBundleExtra("data");
                //获取数据
                String time = bundle.getString("time");

                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("time", time)
                        .addFormDataPart("username", username)
                        .addFormDataPart("file", fileName, RequestBody.create(MediaType.parse("image/jpg"), file))
                        .build();
                Request build = new Request.Builder()
                        .url("http://118.25.130.111/dashboard/uploadfile2.php") //PHP服务器
                        .post(requestBody)
                        .build();
                new OkHttpClient().newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(okhttp3.Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(okhttp3.Call call, Response response) throws IOException {

                        setResult(response.body().string(), true);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(UploadimagesActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
             /*   new OkHttpClient().newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        setResult(response.body().string(), true);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });*/
            }
        }
        MyAdapter adapter = new MyAdapter(path, UploadimagesActivity.this);
        lv_grid.setAdapter(adapter);
    }

    private void showImage(Intent data) {
        path = ImageSelector.getImagePaths(data); //集合获取path(这里的path是集合)
        mContentTv.setText(path.toString() + "\n"); //设置图片路径
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                ImageSelector.show(this, REQUEST_CODE_SELECT_IMG, MAX_SELECT_COUNT);
                break;
        }
    }

    public String getFileName(String pathandname) {
        int start = pathandname.lastIndexOf("/");
        if (start != -1) {
            return pathandname.substring(start + 1);
        } else {
            return null;
        }
    }

    private void setResult(String string, final boolean success) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (success) {
                    Toast.makeText(UploadimagesActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UploadimagesActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

