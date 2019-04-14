package com.example.liurui.palmhuaishi_client.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.adapter.fileAdapter;
import com.example.liurui.palmhuaishi_client.config.Data_huoqurenwuxiangqing;
import com.example.liurui.palmhuaishi_client.utils.AppService;
import com.example.liurui.palmhuaishi_client.utils.compress.FileUtils2;
import com.example.liurui.palmhuaishi_client.utils.compress.JsonUtil;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.OkHttpUtils;

import java.io.File;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class FileActivity extends AppCompatActivity {
    private RelativeLayout addattachment;//添加附件的RelativeLayout

    private ListView listView;
    private List<Data_huoqurenwuxiangqing.ListAccBean> listacc;
    //测试地址
    private String Sever = "http://118.25.130.111/dashboard/upload_file.php";
    //上传地址
    private String uploadfile = "http://118.25.130.111/dashboard/upload_file.php";
    //为了测试方便
    private String time = "02774bc536964386a68bd2b64145c910";
    private String taskid = "f92a591a37fe4677b7a239158c14fbca";

    private String filename;

    private fileAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        addattachment = (RelativeLayout) findViewById(R.id.addattachment);
        listView = (ListView) findViewById(R.id.filelist);

        initdata();

        upload();

    }

    //上传逻辑
    private void upload() {
        addattachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FileActivity.this, "添加附件", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);

                //startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), 1);
                //intent.setType(“image/*”);//选择图片
                //intent.setType(“audio/*”); //选择音频
                //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
                //intent.setType(“video/*;image/*”);//同时选择视频和图片
            }
        });

    }

    //上传成功后刷新
    private void initdata() {
        Intent intent = getIntent();
        //从intent取出bundle
        Bundle bundle = intent.getBundleExtra("data");
        //获取数据
        String first = bundle.getString("first");
        String second = bundle.getString("second");

        //当前登录的用户名
        String username = AppService.getInstance().getCurrentUser().username;
        //  Log.e("username",username);

        //打印一下看看
        Log.e("file_first",first);
        Log.e("file_second",second);

        OkHttpUtils.get(Sever)
                .params("time", time)
                .params("username", username)
                .params("filename", filename)
                .params("firstlevel", first)
                .params("secondlevel", second)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Data_huoqurenwuxiangqing data_huoqurenwuxiangqing =
                                JsonUtil.parseJsonToBean(s, Data_huoqurenwuxiangqing.class);

                        listacc = data_huoqurenwuxiangqing.getListAcc();

                        myAdapter = new fileAdapter(FileActivity.this, listacc);
                        listView.setAdapter(myAdapter);
                        myAdapter.notifyDataSetChanged();
                    }
                });
    }

    //文件路径
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
        try {
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            Log.e("文件路径--", uri + "");
            String url = FileUtils2.getPath(FileActivity.this, uri);
            String url2 = url.trim();
            UploadFile(url2);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            String[] proj = {MediaStore.Images.Media.DATA};
//            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
//            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            actualimagecursor.moveToFirst();
//            String img_path = actualimagecursor.getString(actual_image_column_index);
//            File file = new File(img_path);
//            Toast.makeText(Activity_Deatail.this, file.toString(), Toast.LENGTH_SHORT).show();
    }
    //  }

    //然后路径拿到了就访问服务器上传
    private void UploadFile(String url) {
        final File file = new File(url);
        OkHttpUtils.post(uploadfile)
                .params("time", time)
                .params("taskid", taskid)
                .params("assid", "")
                .params("file", file)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        initdata();//上传成功后刷新
                        Log.e("yes",file.getName());
                    }
                });
    }
}
