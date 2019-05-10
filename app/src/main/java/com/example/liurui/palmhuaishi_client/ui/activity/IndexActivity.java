package com.example.liurui.palmhuaishi_client.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liurui.palmhuaishi_client.MainActivity;
import com.example.liurui.palmhuaishi_client.model.JsonUser;
import com.example.liurui.palmhuaishi_client.model.info.JsonMessage;
import com.example.liurui.palmhuaishi_client.ui.view.*;
import com.example.liurui.palmhuaishi_client.R;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class IndexActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    NotificationManager notificationManager;

    private TextView message;

    private String top = "";
    private String code = "0";
    //底部导航栏
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        imageView1 = findViewById(R.id.indxe_1);
        imageView2 = findViewById(R.id.index_2);
        imageView3 = findViewById(R.id.index_3);
        imageView4 = findViewById(R.id.index_4);

        message = findViewById(R.id.index_message);

        imageView5 = findViewById(R.id.index_but1);
        imageView6 = findViewById(R.id.index_but2);
        imageView7 = findViewById(R.id.index_but3);
        imageView8 = findViewById(R.id.index_but4);


        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("data");
        //获取数据
        code = bundle.getString("code");
        if (code.equals("0"))
        {
            OkHttpUtils.post("http://118.25.130.111/dashboard/user/get_message.php")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            JsonMessage jsonMessage = new Gson().fromJson(s, JsonMessage.class);
                            List<JsonMessage.MessageBean> messageList = jsonMessage.getData();
                            message.setText(messageList.get(0).getGundong());
                        }
                    });

        }else {
            OkHttpUtils.post("http://118.25.130.111/dashboard/user/get_message.php")
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            JsonMessage jsonMessage = new Gson().fromJson(s, JsonMessage.class);
                            List<JsonMessage.MessageBean> messageList = jsonMessage.getData();
                            message.setText(messageList.get(0).getGundong());
                            top = messageList.get(0).getTop();
                            Log.e("top", top);
                            sendMessage(top);
                        }
                    });

        }
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("url", "http://www.hytc.edu.cn/about/");
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);

                intent.setClass(IndexActivity.this, HTMLActivity.class);
                startActivity(intent);

            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("url", "http://www.hytc.edu.cn/about/");
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);

                intent.setClass(IndexActivity.this, HTMLActivity.class);
                startActivity(intent);
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://xxgk.hytc.edu.cn/");
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);
                intent.setClass(IndexActivity.this, HTMLActivity.class);
                startActivity(intent);

            }
        });


        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent();

//Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                intent.setAction("android.intent.action.VIEW");

                Uri content_url = Uri.parse("http://www.hytc.edu.cn/scenery/");

                intent.setData(content_url);

                startActivity(intent);*/
                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("url", "http://www.hytc.edu.cn/scenery/");
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);

                intent.setClass(IndexActivity.this, HTMLActivity.class);
                startActivity(intent);

            }
        });


        //底部导航栏第二个（资料）
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(IndexActivity.this, MaterialActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第三个（论坛）
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(IndexActivity.this, BBSIndexActivity.class);
                startActivity(intent);

            }
        });


        //底部导航栏第四个（我的）
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(IndexActivity.this, MyActivity.class);
                startActivity(intent);

            }
        });


    }

    //标题栏通知
    public void sendMessage(String top) {
        //创建notificationManager对象
        Log.e("test_top", top);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //点击通知栏跳转到相应的页面
        Intent intent = new Intent(IndexActivity.this, IndexActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(IndexActivity.this, 0, intent, 0);
        //实例化NotificationCompat.Builde并设置相关属性
        Notification notification = new Notification.Builder(this)
                //打开通知后，该通知消失
                .setAutoCancel(true)
                //设置通知要启动的intent
                .setContentIntent(pendingIntent)
                //设置小图标
                .setSmallIcon(R.drawable.hytc_icon_small)
                //设置通知标题
                .setContentTitle(top)
                //.setContentTitle("最简单的Notification")
                //设置通知内容
                //.setContentText(top)
                //设置通知时间，默认为系统发出通知的时间，通常不用设置
                .setWhen(System.currentTimeMillis())
                //通过builder.build()方法生成Notification对象,并发送通知,id=1
                .build();
        int current = 1;
        notificationManager.notify(current, notification);
        ++current;
    }
}
