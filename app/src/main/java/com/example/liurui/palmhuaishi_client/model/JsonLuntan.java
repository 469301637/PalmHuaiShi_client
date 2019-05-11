package com.example.liurui.palmhuaishi_client.model;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by liurui on 2019.5.11.
 */

public class JsonLuntan {
        private int code;
        private String msg;
        private List<Luntan> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Luntan> getData() {
        return data;
    }

    public void setData(List<Luntan> data) {
        this.data = data;
    }
}
