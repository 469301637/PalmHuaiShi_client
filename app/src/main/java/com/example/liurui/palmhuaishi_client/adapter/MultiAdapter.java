/*
package com.example.liurui.palmhuaishi_client.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.bean.UploadBean;

import java.util.List;

*/
/**
 * Created by liurui on 2019.4.11.
 *//*


public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UploadBean> mData;
    private Context mContext;
    private OnItemClickLitener mOnItemClickLitener;

    public MultiAdapter(Context context, List<UploadBean> mData) {
        this.mContext = context;
        this.mData = mData;
    }

    @Override
    public int getItemViewType(int position) {
        //防止滑动时图片混乱的问题
        return position;
    }

    */
/**
     * 设置
     * @param mData
     *//*

    public void setDatas(List<UploadBean> mData){
        this.mData = mData;
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        onBindViewHolder(holder, position);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        UploadBean dataListBean = mData.get(position);

        dealUploadText(((ViewHolder) holder).tv_present, dataListBean);

        //如果设置了回调，则设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickLitener != null) {
                    if(mData != null && mData.size() > 0){
                        mOnItemClickLitener.onItemClick(holder.itemView, position);
                    }
                }
            }
        });

    }

    */
/**
     * 处理进度条文本
     * @param tv_present
     * @param dataListBean
     *//*

    private void dealUploadText(TextView tv_present, UploadBean dataListBean){
        if(dataListBean == null){
            return;
        }
        if(dataListBean.getStatus() == 1){
            //如果正在上传中
            tv_present.setVisibility(View.VISIBLE);
            tv_present.setText("上传进度："+dataListBean.getUploadProgress() + "%");
        }else if(dataListBean.getStatus() == 2){
            tv_present.setVisibility(View.VISIBLE);
            tv_present.setText("上传完成");
        }else if(dataListBean.getStatus() == 3){
            tv_present.setVisibility(View.VISIBLE);
            tv_present.setText("上传失败");
        }else {
            tv_present.setVisibility(View.GONE);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.upload_item, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_present;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_present = itemView.findViewById(R.id.tv_present);
        }
    }


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


}*/
