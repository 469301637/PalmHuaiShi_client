package com.example.liurui.palmhuaishi_client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liurui.palmhuaishi_client.R;
import com.example.liurui.palmhuaishi_client.model.JsonLuntan;
import com.example.liurui.palmhuaishi_client.model.Luntan;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

/**
 * Created by liurui on 2019.5.10.
 */

public class LuntanAdapter  extends BaseAdapter {
    List<Luntan> userList;
    Context mcontext;

    public LuntanAdapter(List<Luntan> list, Context context){
        userList = list;
        mcontext = context;
    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    /**
     * 设定一组数据的展示形式
     *
     */
    public View getView(int i, View view, ViewGroup viewGroup) {
        //获取view对象
        view = LayoutInflater.from(mcontext).inflate(R.layout.list_luntan_index, null);

        TextView usernameView = view.findViewById(R.id.luntan_username);
        usernameView.setText(userList.get(i).getUsername());

        TextView titleView = view.findViewById(R.id.luntan_title);
        titleView.setText(userList.get(i).getTitle());

        TextView contentView = view.findViewById(R.id.luntan_content_content);
        contentView.setText(userList.get(i).getContent());

        TextView timeView = view.findViewById(R.id.luntan_time);
        timeView.setText(userList.get(i).getId());

        TextView countView = view.findViewById(R.id.luntan_mes);
        countView.setText(userList.get(i).getMes());
        //ImageView imageView = view.findViewById(R.id.iv_pic);
        //imageView.setImageResource(userList.get(i).getPic());
        return view;
    }
}
