package com.example.liurui.palmhuaishi_client.ui.activity;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.adapter.ImagePickerAdapter;
import com.lzy.imagepicker.bean.ImageItem;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReleaseActivity extends AppCompatActivity {


    public static final int IMAGE_ITEM_ADD = -1;
    public static final int REQUEST_CODE_SELECT = 100;
    public static final int REQUEST_CODE_PREVIEW = 101;

    private ImagePickerAdapter adapter;
    private ArrayList<ImageItem> selImageList; //当前选择的所有图片
    private int maxImgCount = 9;               //允许选择图片最大数

    private ImageView imageView;
    private EditText title;
    private  EditText content;
    private Button button;

    private String mFrom;

    private List<File> mFiles;
    private List<String> mSmallUrls;
    private boolean isUploadPics;
    private int reqWidth = 0;
    private int reqHeight = 0;
    private Point point;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        updatePixel();
        bindView();


        imageView=findViewById(R.id.release_images);

        content=findViewById(R.id.release_content);
        button=findViewById(R.id.release_button);


        imageView.setImageResource(R.drawable.upload_images);
    }


    private void updatePixel() {
        point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        reqWidth = point.x ;
        reqHeight = point.y ;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mFiles != null){
            mFiles.clear();
            mFiles = null;
        }
        if (mSmallUrls != null){
            mSmallUrls.clear();
            mSmallUrls = null;
        }
    }

    private void bindView() {
        mFiles = new ArrayList<>();
        mSmallUrls = new ArrayList<>();

        mFrom = getIntent().getStringExtra("name");
        title =findViewById(R.id.release_title);
        //title.setLeftButtonAsFinish(this);



    }
}
