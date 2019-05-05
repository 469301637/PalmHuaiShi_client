package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.liurui.palmhuaishi_client.ui.view.*;
import com.example.liurui.palmhuaishi_client.R;

public class IndexActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

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

        imageView5 = findViewById(R.id.index_but1);
        imageView6 = findViewById(R.id.index_but2);
        imageView7 = findViewById(R.id.index_but3);
        imageView8 = findViewById(R.id.index_but4);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("url", "http://www.hytc.edu.cn/about/");
                // 将Bundle添加到Intent里面
                intent.putExtra("data", bundle);

                intent.setClass(IndexActivity.this,HTMLActivity.class);
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

                intent.setClass(IndexActivity.this,HTMLActivity.class);
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
                intent.setClass(IndexActivity.this,HTMLActivity.class);
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

                intent.setClass(IndexActivity.this,HTMLActivity.class);
                startActivity(intent);

            }
        });


        //底部导航栏第二个（资料）
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(IndexActivity.this,MaterialActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第三个（论坛）
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(IndexActivity.this,BBSIndexActivity.class);
                startActivity(intent);

            }
        });



        //底部导航栏第四个（我的）
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(IndexActivity.this,MyActivity.class);
                startActivity(intent);

            }
        });

    }
}
