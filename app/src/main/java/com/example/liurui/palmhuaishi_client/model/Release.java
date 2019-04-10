package com.example.liurui.palmhuaishi_client.model;

import java.io.Serializable;

/**
 * Created by liurui on 2019.4.10.
 */

public class Release implements IJsonModel, Serializable {
    /**
     * 时间戳ID
     */
    public String id;
    /**
     * 当前登录用户的用户名
     */
    public String username;
    /**
     * 标题
     */
    public String title;
    /**
     * 内容
     */
    public int content;

    @Override
    public String toString() {
        return "Release{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
