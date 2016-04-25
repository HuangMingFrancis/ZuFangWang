package com.zufangwang.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.zufangwang.base.BaseAdapter;
import com.zufangwang.francis.zufangwang.R;

import java.util.List;

import butterknife.InjectView;

/**
 * Created by Francis on 2016/4/22.
 */
public class HouseItemAdapter extends BaseAdapter<String> {
    @InjectView(R.id.iv_house)
    ImageView ivHouse;
    @InjectView(R.id.tv_house_des)
    TextView tvHouseDes;
    @InjectView(R.id.tv_house_location)
    TextView tvHouseLocation;
    @InjectView(R.id.tv_house_price)
    TextView tvHousePrice;
    @InjectView(R.id.tv_house)
    TextView tvHouse;

    public HouseItemAdapter(Context mContext, List<String> mDataList) {
        super(mContext, mDataList);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_house;
    }

    @Override
    protected void bindData(ViewHolder holder, int position, String item) {
//        tvHouseDes.setText(item);
    }
}
