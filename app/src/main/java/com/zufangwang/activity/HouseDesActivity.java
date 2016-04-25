package com.zufangwang.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.zufangwang.base.BaseActivity;
import com.zufangwang.francis.zufangwang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Francis on 2016/4/23.
 */
public class HouseDesActivity extends BaseActivity {


    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.llyt_title)
    LinearLayout llytTitle;
    @InjectView(R.id.vf_login)
    ViewFlipper vfLogin;
    @InjectView(R.id.tv_house_price)
    TextView tvHousePrice;
    @InjectView(R.id.tv_house_time)
    TextView tvHouseTime;
    @InjectView(R.id.tv_room)
    TextView tvRoom;
    @InjectView(R.id.tv_renovation)
    TextView tvRenovation;
    @InjectView(R.id.tv_floor)
    TextView tvFloor;
    @InjectView(R.id.tv_bedroom)
    TextView tvBedroom;
    @InjectView(R.id.tv_area)
    TextView tvArea;
    @InjectView(R.id.tv_survey)
    TextView tvSurvey;
    @InjectView(R.id.tv_orientation)
    TextView tvOrientation;
    @InjectView(R.id.tv_limit)
    TextView tvLimit;
    @InjectView(R.id.tv_house_location)
    TextView tvHouseLocation;
    @InjectView(R.id.tv_broadband)
    TextView tvBroadband;
    @InjectView(R.id.tv_television)
    TextView tvTelevision;
    @InjectView(R.id.tv_sofa)
    TextView tvSofa;
    @InjectView(R.id.tv_washing)
    TextView tvWashing;
    @InjectView(R.id.tv_bed)
    TextView tvBed;
    @InjectView(R.id.tv_refrigerator)
    TextView tvRefrigerator;
    @InjectView(R.id.tv_air)
    TextView tvAir;
    @InjectView(R.id.tv_heating)
    TextView tvHeating;
    @InjectView(R.id.tv_wardrobe)
    TextView tvWardrobe;
    @InjectView(R.id.tv_heater)
    TextView tvHeater;
    @InjectView(R.id.tv_house_des)
    TextView tvHouseDes;
    @InjectView(R.id.tv_house_publisher)
    TextView tvHousePublisher;
    @InjectView(R.id.tv_house_publisher_tel)
    TextView tvHousePublisherTel;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_house_des;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_house_publisher_tel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_house_publisher_tel:
                break;
        }
    }
}
