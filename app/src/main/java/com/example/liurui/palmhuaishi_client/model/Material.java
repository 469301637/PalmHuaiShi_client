package com.example.liurui.palmhuaishi_client.model;

import java.io.Serializable;

/**
 * Created by liurui on 2019.4.29.
 */

public class Material  implements IJsonModel, Serializable {

    /**
     * 用户名(学号/工号)
     */
    public String username;
    /**
     * id
     */
    public String id;
    /**
     * 文件名
     */
    public String filename;
    /**
     * 二级学院
     */
    public String firstlevel;
    /**
     * 具体学科属性（专业必修课等）
     */
    public String secondlevel;

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", filename='" + filename + '\'' +
                ", firstlevel='" + firstlevel + '\'' +
                ", secondlevel='" + secondlevel + '\'' +
                '}';
    }
}