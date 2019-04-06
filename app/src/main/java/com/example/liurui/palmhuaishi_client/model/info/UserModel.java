package com.example.liurui.palmhuaishi_client.model.info;

import com.example.liurui.palmhuaishi_client.model.IJsonModel;

import java.io.Serializable;

/**
 * Created by liurui on 2019.4.3.
 */

public class UserModel implements IJsonModel,Serializable {
    public String username;
    public String avatar;
    public String nickname;
}
