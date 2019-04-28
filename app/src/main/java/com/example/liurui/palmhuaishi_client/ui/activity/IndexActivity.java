package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.liurui.palmhuaishi_client.R;

public class IndexActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        imageView1=findViewById(R.id.indxe_1);
        imageView2=findViewById(R.id.index_2);
        imageView3=findViewById(R.id.index_3);
        imageView4=findViewById(R.id.index_4);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

//Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                intent.setAction("android.intent.action.VIEW");

                Uri content_url = Uri.parse("http://www.hytc.edu.cn/about/");

                intent.setData(content_url);

                startActivity(intent);

            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

//Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                intent.setAction("android.intent.action.VIEW");

                Uri content_url = Uri.parse("http://www.hytc.edu.cn/about/");

                intent.setData(content_url);

                startActivity(intent);

            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

//Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                intent.setAction("android.intent.action.VIEW");

                Uri content_url = Uri.parse("http://xxgk.hytc.edu.cn/");

                intent.setData(content_url);

                startActivity(intent);

            }
        });


        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

//Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                intent.setAction("android.intent.action.VIEW");

                Uri content_url = Uri.parse("http://www.hytc.edu.cn/scenery/");

                intent.setData(content_url);

                startActivity(intent);

            }
        });

    }
}
