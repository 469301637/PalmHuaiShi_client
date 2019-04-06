package com.example.liurui.palmhuaishi_client.net.okgo;

import java.io.Serializable;

/**
 * Created by liurui on 2019.3.27.
 */

public class SimpleResponse implements Serializable {

    public int code;
    public String msg;

    public LslResponse toResponse() {
        LslResponse LslResponse = new LslResponse();
        LslResponse.code = code;
        LslResponse.msg = msg;
        return LslResponse;
    }
}
