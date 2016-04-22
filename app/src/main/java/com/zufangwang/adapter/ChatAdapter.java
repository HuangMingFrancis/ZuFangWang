package com.zufangwang.adapter;

import android.content.Context;
import android.widget.TextView;

import com.zufangwang.base.BaseAdapter;
import com.zufangwang.entity.MessageInfo;
import com.zufangwang.francis.zufangwang.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by nan on 2016/3/21.
 */
public class ChatAdapter extends BaseAdapter<MessageInfo> {
    private String user;

    public void setUser(String user) {
        this.user = user;
    }

    public ChatAdapter(Context mContext, List mDataList) {
        super(mContext, mDataList);
    }

    @Override
    public int getItemViewType(int position) {
        MessageInfo messageInfo=mDataList.get(position);
        if (messageInfo.getSend_user_name().equals(user))
        return 1;
        else
            return 0;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public void addItem(int positon, MessageInfo item) {
        super.addItem(positon, item);
    }

    @Override
    public void deleteItem(int positon) {
        super.deleteItem(positon);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        if (viewType == 0) {
            return R.layout.item_chat_acceptor;
        } else {
            return R.layout.item_chat_receiver;
        }
    }

    @Override
    protected void bindData(ViewHolder holder, int position, MessageInfo item) {
        //初始化view
        CircleImageView UserImg;
        TextView text;
        if(getItemViewType(position)==0){
             UserImg= (CircleImageView) holder.getViewById(R.id.img_chat_acceptor_userIcon);
             text= (TextView) holder.getViewById(R.id.tv_chat_acceptor_text);
            text.setText(item.getMessage_content());
        }else{
            UserImg= (CircleImageView) holder.getViewById(R.id.img_chat_receiver_userIcon);
            text= (TextView) holder.getViewById(R.id.tv_chat_receiver_text);
            text.setText(item.getMessage_content());
        }

        //初始化view的值

    }


}
