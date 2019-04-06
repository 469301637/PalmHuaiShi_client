package com.example.liurui.palmhuaishi_client.model;

import java.io.Serializable;

/**
 * Created by liurui on 2019.3.27.
 */

public class User implements IJsonModel, Serializable {
    /**
     * 用户名(学号/工号)
     */
    public String username;
    /**
     * 密码
     */
    public String password;
    /**
     * 昵称
     */
    public String nickname;
    /**
     * 类型（1.学生；2.管理员）
     */
    public int type;
    /**
     * 积分（用于上传/下载复习资料）
     */
    public int integral;
    /**
     * 用户头像地址
     */
    public String avatar;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", type='" + type + '\'' +
                ", integral='" + integral + '\'' +
                ", avatar=" + avatar + '\'' +
                '}';
    }
}