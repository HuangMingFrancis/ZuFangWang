package com.zufangwang.activity;

import android.support.v4.app.Fragment;

import com.zufangwang.base.DrawerBaseActivity;
import com.zufangwang.fragment.TAccountFragment;
import com.zufangwang.francis.zufangwang.R;

/**
 * Created by nan on 2016/3/21.
 */
public class AccountActivity extends DrawerBaseActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_base_nevigation;
    }

    @Override
    protected Fragment getLayoutFragment() {
        return new TAccountFragment();
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initToolBar() {
        super.initToolBar();
        getSupportActionBar().setTitle("个人信息");
    }
}
