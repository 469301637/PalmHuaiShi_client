package com.example.liurui.palmhuaishi_client.model.info;

import com.example.liurui.palmhuaishi_client.model.IJsonModel;

import java.io.Serializable;

/**
 * Created by liurui on 2019.4.3.
 */

public class PicModel implements Serializable,IJsonModel {
    /**
     * 图片id
     */
    public int picid;
    /**
     * 图片地址
     */
    public String imageUrl;

}
