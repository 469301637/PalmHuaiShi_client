package com.example.liurui.palmhuaishi_client.model.info;

/**
 * Created by liurui on 2019.4.11.
 */

public interface OnThreadResultListener {
    void onProgressChange(int percent);//进度变化回调
    void onFinish();//线程完成时回调
    void onInterrupted();//线程被中断回调
}