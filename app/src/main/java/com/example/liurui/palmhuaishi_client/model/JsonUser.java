package com.example.liurui.palmhuaishi_client.model;

import java.util.List;

/**
 * Created by liurui on 2019.5.10.
 */

public class JsonUser {
    private int code;
    private String msg;
    private List<UserBean> data;
    public class UserBean{
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

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

    public List<UserBean> getData() {
        return data;
    }

    public void setData(List<UserBean> data) {
        this.data = data;
    }
}
