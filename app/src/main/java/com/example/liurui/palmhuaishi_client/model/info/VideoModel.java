package com.example.liurui.palmhuaishi_client.model.info;

import com.example.liurui.palmhuaishi_client.model.IJsonModel;

import java.io.Serializable;

/**
 * Created by liurui on 2019.4.3.
 */

public class VideoModel implements Serializable,IJsonModel {
    public int picid;       //缩略图id
    public int videoid;     //视频id
    public String videoUrl; //视频地址

    @Override
    public String toString() {
        return "VideoModel{" +
                "picid=" + picid +
                ", videoid=" + videoid +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
