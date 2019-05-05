package com.example.liurui.palmhuaishi_client.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.ui.activity.IndexActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.MyActivity;

public class BBSIndexActivity extends AppCompatActivity {

    private WebView webView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbsindex);

        webView = findViewById(R.id.BBS_index);

        webView.loadUrl("http://118.25.130.111/dashboard/bbs/main_show.php");

        imageView1 = findViewById(R.id.bbs_but1);
        imageView2 = findViewById(R.id.bbs_but2);
        imageView3 = findViewById(R.id.bbs_but3);
        imageView4 = findViewById(R.id.bbs_but4);

        //底部导航栏第一个（主页）
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(BBSIndexActivity.this,IndexActivity.class);
                startActivity(intent);

            }
        });

        //底部导航栏第二个（资料）
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(BBSIndexActivity.this,MaterialActivity.class);
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
                intent.setClass(BBSIndexActivity.this,MyActivity.class);
                startActivity(intent);

            }
        });


    }
}
