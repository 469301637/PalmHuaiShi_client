package com.example.liurui.palmhuaishi_client.model.info;

import com.example.liurui.palmhuaishi_client.model.JsonUser;

import java.util.List;

/**
 * Created by liurui on 2019.5.10.
 */

public class JsonMessage {
    private int code;
    private String msg;
    private List<JsonMessage.MessageBean> data;
    public class MessageBean{

        public  String top;
        public  String gundong;
        public  String detail;

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getGundong() {
            return gundong;
        }

        public void setGundong(String gundong) {
            this.gundong = gundong;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

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

    public List<JsonMessage.MessageBean> getData() {
        return data;
    }

    public void setData(List<JsonMessage.MessageBean> data) {
        this.data = data;
    }
}

