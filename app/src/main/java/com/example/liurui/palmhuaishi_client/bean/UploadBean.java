package com.example.liurui.palmhuaishi_client.bean;

/**
 * Created by liurui on 2019.4.11.
 */

public class UploadBean {

    private int uploadProgress;// 上传进度

    private byte status;//0：默认 1：正在上传 2：上传完成 3：上传失败

    public UploadBean(int uploadProgress, byte status) {
        this.uploadProgress = uploadProgress;
        this.status = status;
    }

    public int getUploadProgress() {
        return uploadProgress;
    }

    public void setUploadProgress(int uploadProgress) {
        this.uploadProgress = uploadProgress;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
