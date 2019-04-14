package com.example.liurui.palmhuaishi_client.model.info;

/**
 * Created by liurui on 2019.4.11.
 */

public interface OnUploadListener {//主线程回调
    void onAllSuccess();
    void onAllFailed();
    void onThreadProgressChange(int position,int percent);
    void onThreadFinish(int position);
    void onThreadInterrupted(int position);
}