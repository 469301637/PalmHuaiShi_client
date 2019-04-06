package com.example.liurui.palmhuaishi_client.model.info;

import com.example.liurui.palmhuaishi_client.model.IJsonModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liurui on 2019.4.3.
 */

public class InfoModel implements Serializable,IJsonModel {
    /**
     * 主贴id
     */
    public int mainid;
    /**
     * 用户名，用于获取用户资料信息
     */
    public String username;
    /**
     * 发起时间戳
     */
    public long time;
    /**
     * 信息内容
     */
    public String content;

    /**
     * 评论信息
     */
    public List<CommentInfoModel> commentInfo;
    /**
     * 最后获取的一条信息的id
     */
    public int lastid;

    /**
     * 社区图片Url组
     */
    public List<PicModel> picUrls;

    /**
     * 社区视频Url
     */
    public List<VideoModel> videoUrl;

}
