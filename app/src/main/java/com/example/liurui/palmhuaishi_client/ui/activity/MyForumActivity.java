package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.adapter.LuntanAdapter;
import com.example.liurui.palmhuaishi_client.model.JsonLuntan;
import com.example.liurui.palmhuaishi_client.model.Luntan;
import com.example.liurui.palmhuaishi_client.ui.view.BBSIndexActivity;
import com.example.liurui.palmhuaishi_client.ui.view.MaterialActivity;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MyForumActivity extends AppCompatActivity {

    private ListView listView;
    List<Luntan> userList;
    LuntanAdapter luntanAdapter;


    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private FloatingActionButton fab01Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_forum);
        fab01Add =findViewById(R.id.myforum_upload_final);
        listView=findViewById(R.id.myforum_list);
        Find_data();


        imageView1 = findViewById(R.id.bbs_but11);
        imageView2 = findViewById(R.id.bbs_but21);
        imageView3 = findViewById(R.id.bbs_but31);
        imageView4 = findViewById(R.id.bbs_but41);


        //上传按钮的监听

        fab01Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyForumActivity.this,ReleaseActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第一个（主页）
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyForumActivity.this, IndexActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("code", "0");
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);

                startActivity(intent);

            }
        });

        //底部导航栏第二个（资料）
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyForumActivity.this, MaterialActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第三个（论坛）
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  Intent intent = new Intent();
                intent.setClass(IndexActivity.this,BBSIndexActivity.class);
                startActivity(intent);
*/
            }
        });


        //底部导航栏第四个（我的）
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MyForumActivity.this, MyActivity.class);
                startActivity(intent);

            }
        });


    }

    private void Find_data() {


        OkHttpUtils.post("http://118.25.130.111/dashboard/bbs/get_main_show.php")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.e("information", s);
                        JsonLuntan jsonLuntan = new Gson().fromJson(s, JsonLuntan.class);

                         userList=new ArrayList<Luntan>();

                         userList = jsonLuntan.getData();

                        Log.e("BBS", userList.get(0).getTitle());
                        luntanAdapter=new LuntanAdapter(userList,getApplicationContext());
                        listView.setAdapter(luntanAdapter);
                        //当前登录的用户名
                        final String username = AppService.getInstance().getCurrentUser().username;
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                //跳转页面
                                Intent intent = new Intent(MyForumActivity.this, MyForumDetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("id", userList.get(i).getId());
                                bundle.putString("username", username);
                                // 将Bundle添加到Intent里面
                                intent.putExtra("data", bundle);
                                startActivity(intent);
                            }
                        });

                      /*  iphone_number=userList.get(0).getNickname();
                        password.setText(userList.get(0).getPassword());
                        iphone.setText(userList.get(0).getNickname());
                        integral.setText(userList.get(0).getIntegral() + "");*/
                        //integral.setText(userList.get(0).getIntegral());
                    }
                });

        //listView.setAdapter(luntanAdapter);
    }
}
