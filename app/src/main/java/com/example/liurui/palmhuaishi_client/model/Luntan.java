package com.example.liurui.palmhuaishi_client.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by liurui on 2019.5.11.
 */

public class Luntan implements Serializable {
    public  String username;
    public  String title;
    public String content;
    public String id;               //时间
    public String counts;           //回复数统计
    public String mes;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
