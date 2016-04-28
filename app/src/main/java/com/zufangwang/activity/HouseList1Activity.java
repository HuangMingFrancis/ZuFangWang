package com.zufangwang.activity;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zufangwang.base.Configs;
import com.zufangwang.base.DrawerBaseActivity;
import com.zufangwang.entity.HouseInfo;
import com.zufangwang.fragment.HouseDesFragment;
import com.zufangwang.fragment.HouseListFragment;
import com.zufangwang.francis.zufangwang.R;
import com.zufangwang.utils.OkHttpClientManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Francis on 2016/4/28.
 */
public class HouseList1Activity extends DrawerBaseActivity {
    HouseListFragment houseListFragment=new HouseListFragment();
    String house_condition,house_type;
    ArrayList<HouseInfo> houseInfos;
    @Override
    protected Fragment getLayoutFragment() {
        return houseListFragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_base_nevigation;
    }

    @Override
    protected void initData() {
        houseInfos=new ArrayList<>();
        house_condition=getIntent().getStringExtra("house_condition");
        house_type=getIntent().getStringExtra("house_type");
        getHouseInfo();
        super.initData();
    }

    private void getHouseInfo() {
        if (house_type.equals("")){
            OkHttpClientManager.getAsyn(Configs.QUERY_ALL_HOUSE, new OkHttpClientManager.ResultCallback<String>() {
                @Override
                public void onError(Request request, Exception e) {
                    Toast.makeText(mContext, Configs.URLERROR,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(String response) {
                    jsonToHouseList(response);
                    Log.i("ming","house   response:　　"+response);
                }
            });
        }

        else{
            OkHttpClientManager.postAsyn(Configs.QUERY_HOUSE_BY_CONDITION, new OkHttpClientManager.ResultCallback<String>() {
                @Override
                public void onError(Request request, Exception e) {
                    Toast.makeText(mContext, Configs.URLERROR,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(String response) {
                    jsonToHouseList(response);
                    Log.i("ming","house   response:　　"+response);
                }
            },new OkHttpClientManager.Param[]{
                    new OkHttpClientManager.Param("house_type",house_type),
                    new OkHttpClientManager.Param("house_condition",house_condition)
            });
        }
    }
    //将json数据转换为数组
    private void jsonToHouseList(String response)
    {
        try {
            JSONArray data=new JSONArray(response);
            for (int i=0;i<data.length();i++){
                HouseInfo houseInfo=new Gson().fromJson(data.getString(i),HouseInfo.class);
                houseInfos.add(houseInfo);
                Log.i("ming","house:  "+houseInfo.toString());
            }
            if (houseInfos.size()<=0){
                Toast.makeText(mContext,"暂时没有您要的数据",Toast.LENGTH_SHORT).show();
                return;
            }
            houseListFragment.setHouseInfos(houseInfos);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void loadData() {

    }
    @Override
    protected void initToolBar() {
        super.initToolBar();
        getSupportActionBar().setTitle("房源信息");
    }
}