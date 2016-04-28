package com.zufangwang.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.zufangwang.base.BaseActivity;
import com.zufangwang.base.DrawerBaseActivity;
import com.zufangwang.entity.HouseInfo;
import com.zufangwang.fragment.HouseDesFragment;
import com.zufangwang.francis.zufangwang.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Francis on 2016/4/23.
 */
public class HouseDesActivity extends DrawerBaseActivity{
    HouseDesFragment houseDesFragment=new HouseDesFragment();
    HouseInfo houseInfo;
    @Override
    protected Fragment getLayoutFragment() {
        return houseDesFragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_base_nevigation;
    }

    @Override
    protected void initData() {
        super.initData();
        houseInfo=(HouseInfo) getIntent().getSerializableExtra("house_info");
        houseDesFragment.setHouseInfo(houseInfo);
    }

    @Override
    protected void loadData() {

    }
    @Override
    protected void initToolBar() {
        super.initToolBar();
        getSupportActionBar().setTitle("详情");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.house_des_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.collect:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
