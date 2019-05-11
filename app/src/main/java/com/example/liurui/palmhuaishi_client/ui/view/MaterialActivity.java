package com.example.liurui.palmhuaishi_client.ui.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.ui.activity.IndexActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.MyActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.MyForumActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.ReleaseActivity;
import com.example.liurui.palmhuaishi_client.ui.activity.UploadfileActivity;

public class MaterialActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private SearchView searchView;

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private FloatingActionButton fab01Add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        imageView1 = findViewById(R.id.material_but1);
        imageView2 = findViewById(R.id.material_but2);
        imageView3 = findViewById(R.id.material_but3);
        imageView4 = findViewById(R.id.material_but4);

        //上传按钮的监听
        fab01Add=findViewById(R.id.material_upload);
        fab01Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MaterialActivity.this,UploadfileActivity.class);
                startActivity(intent);

            }
        });

        searchView=findViewById(R.id.material_search);
        /**
         * 默认情况下, search widget是"iconified“的，只是用一个图标 来表示它(一个放大镜),
         * 当用户按下它的时候才显示search box . 你可以调用setIconifiedByDefault(false)让search
         * box默认都被显示。 你也可以调用setIconified()让它以iconified“的形式显示。
         */
        searchView.setIconifiedByDefault(true);
        /**
         * 默认情况下是没提交搜索的按钮，所以用户必须在键盘上按下"enter"键来提交搜索.你可以同过setSubmitButtonEnabled(
         * true)来添加一个提交按钮（"submit" button)
         * 设置true后，右边会出现一个箭头按钮。如果用户没有输入，就不会触发提交（submit）事件
         */
        searchView.setSubmitButtonEnabled(true);
        /**
         * 初始是否已经是展开的状态
         * 写上此句后searchView初始展开的，也就是是可以点击输入的状态，如果不写，那么就需要点击下放大镜，才能展开出现输入框
         */
        searchView.onActionViewExpanded();
        // 设置search view的背景色
        searchView.setBackgroundColor(0x22ff00ff);
        /**
         * 默认情况下, search widget是"iconified“的，只是用一个图标 来表示它(一个放大镜),
         * 当用户按下它的时候才显示search box . 你可以调用setIconifiedByDefault(false)让search
         * box默认都被显示。 你也可以调用setIconified()让它以iconified“的形式显示。
         */

        // 为该SearchView组件设置事件监听器
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);
        // 设置该SearchView内默认显示的提示文本
        searchView.setQueryHint("查找");
        searchView.setIconifiedByDefault(true);

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });


        button1=findViewById(R.id.material_wxy);
        button2=findViewById(R.id.material_wgy);
        button3=findViewById(R.id.material_wd);
        button4=findViewById(R.id.material_sk);
        button5=findViewById(R.id.material_sm);
        button6=findViewById(R.id.material_jk);
        button7=findViewById(R.id.material_jy);
        button8=findViewById(R.id.material_hy);
        button9=findViewById(R.id.material_fl);
        button10=findViewById(R.id.material_cm);
        button11=findViewById(R.id.material_ch);
        button12=findViewById(R.id.material_ls);
        button13=findViewById(R.id.material_msxy);
        button14=findViewById(R.id.material_mkszy);
        button15=findViewById(R.id.material_tyxy);
        button16=findViewById(R.id.material_yyxy);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                //调用Intent的setClass方法
                Bundle bundle=new Bundle();
                bundle.putString("secondlevel","文学院");
                intent.putExtra("data",bundle);
                intent.setClass(MaterialActivity.this, ShowmaterialActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });

        //底部导航栏第一个（主页）
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MaterialActivity.this,IndexActivity.class);

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

               /* Intent intent = new Intent();
                intent.setClass(IndexActivity.this,MaterialActivity.class);
                startActivity(intent);*/

            }
        });

        //底部导航栏第三个（论坛）
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MaterialActivity.this,MyForumActivity.class);
                startActivity(intent);

            }
        });



        //底部导航栏第四个（我的）
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(MaterialActivity.this,MyActivity.class);
                startActivity(intent);

            }
        });


    }


    //搜索的监听
    @Override
    public boolean onQueryTextSubmit(String s) {

        Log.e("search",s);
        Intent intent = new Intent();
        //调用Intent的setClass方法
        Bundle bundle=new Bundle();
        bundle.putString("secondlevel",s);
        intent.putExtra("data",bundle);
        intent.setClass(MaterialActivity.this, ShowmaterialActivity.class);
        //启动Activity
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
