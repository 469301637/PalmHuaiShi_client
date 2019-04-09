package com.example.liurui.palmhuaishi_client.utils;

import com.example.liurui.palmhuaishi_client.config.Consts;
import com.example.liurui.palmhuaishi_client.model.User;
import com.example.liurui.palmhuaishi_client.model.info.InfoModel;
import com.example.liurui.palmhuaishi_client.net.okgo.JsonCallback;
import com.example.liurui.palmhuaishi_client.net.okgo.LslResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.PostRequest;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liurui on 2019.3.27.
 */

public class AppService {

    private static final String TAG = "AppService";

    private static AppService instance;
    private User mCurrentUser;


    private AppService() {
    }

    public static AppService getInstance() {
        if (instance == null) {
            instance = new AppService();
        }
        return instance;
    }


    /**
     * 获取当前登录的用户
     *
     * @return 当前用户
     */
    public User getCurrentUser() {
        return mCurrentUser;
    }

    public void setCurrentUser(User user) {
        this.mCurrentUser = user;
    }

    /**
     * 异步用户登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @param callback 回调
     */
    public void loginHytc(String username, String password, JsonCallback<LslResponse<User>> callback) {
        String url = Consts.API_SERVICE_HOST + "/user/login.php";
        HashMap<String, String> postParams = new HashMap<>();
        postParams.put("username", username);
        postParams.put("password", password);
        OkGo.post(url).params(postParams).execute(callback);
    }


    /**
     * 用户注册
     *
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @param callback 回调
     */
    public void registerHytc(String username, String password, String nickname, JsonCallback<LslResponse<User>> callback) {
        String url = Consts.API_SERVICE_HOST + "/user/register.php";
        HashMap<String, String> postParams = new HashMap<>();
        postParams.put("username", username);
        postParams.put("password", password);
        postParams.put("nickname", nickname);
        OkGo.post(url).params(postParams).execute(callback);
    }


    /**
     * 异步发送消息给服务器
     *
     * @param username 发布人用户名
     * @param content  发布内容
     * @param picUrls  图片地址
     * @param date     发布时间
     * @param callback 回调
     */
    public void addMainInfoAsync(String username, String content, List<String> picUrls, boolean isVideo, String date, JsonCallback<LslResponse<InfoModel>> callback) {
        String url = Consts.API_SERVICE_HOST + "/info/add_main.php";
        HashMap<String, String> postParams = new HashMap<>();
        postParams.put("username", username);
        postParams.put("content", content);
        postParams.put("picCount", picUrls.size() + "");
        postParams.put("datetime", date);
        if (isVideo) {
            postParams.put("type", "video");
            postParams.put("picUrl0", "/info/video/" + picUrls.get(0));
            postParams.put("picUrl1", "/info/pic/" + picUrls.get(1));
        } else {
            postParams.put("type", "pic");
            for (int i = 0; i < picUrls.size(); i++) {
                postParams.put("picUrl" + i, "/info/pic/" + picUrls.get(i));
            }
        }
        OkGo.post(url).params(postParams).execute(callback);
    }

    /**
     * 附件上传
     *
     * @param files    文件集合
     * @param callback 回调
     */
        public void upLoadFileAsync(List<File> files, JsonCallback<LslResponse<User>> callback) {
            String url = Consts.API_SERVICE_HOST + "/attachment.php";
//        OkGo.post(url).params("size",files.size()).addFileParams("files",files).execute(callback);
//        String url = Consts.API_SERVICE_HOST + "/user/avatar.php";
            PostRequest postRequest = OkGo.post(url);
            for (int i = 0; i < files.size(); i++) {
                postRequest.params("file" + i, files.get(i), files.get(i).getName());
            }
            postRequest.params("size", files.size());
            postRequest.execute(callback);
    }


    /***************    信息系統 End      ******************/

}
