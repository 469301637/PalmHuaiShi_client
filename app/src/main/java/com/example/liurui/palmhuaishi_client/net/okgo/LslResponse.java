package com.example.liurui.palmhuaishi_client.net.okgo;

import java.io.Serializable;

/**
 * Created by liurui on 2019.3.27.
 */

public class LslResponse<T> implements Serializable {

    public int code;
    public String msg;
    public T data;

    /**
     * 请求编码返回正确
     */
    public final static int RESPONSE_OK = 0;


    /**
     * 请求编码返回错误
     */
    public final static int RESPONSE_ERROR = -1;

}