package com.zufangwang.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zufangwang.adapter.HouseItemAdapter;
import com.zufangwang.adapter.SearchTabPagerAdapter;
import com.zufangwang.base.BaseActivity;
import com.zufangwang.base.BaseAdapter;
import com.zufangwang.base.Configs;
import com.zufangwang.entity.GoodsInfo;
import com.zufangwang.entity.HouseInfo;
import com.zufangwang.listener.OnItemClickListener;
import com.zufangwang.francis.zufangwang.R;
import com.zufangwang.utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nan on 2016/3/12.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {

    //view
    private ImageView mBackBtn;
    private EditText mSearchText;
    private LinearLayout llyt_history;
    private RecyclerView recycle_search;
    private ArrayList<HouseInfo> houseInfos;
    private HouseItemAdapter houseItemAdapter;


    //adpter
    private SearchTabPagerAdapter mSearchTabsPagerAdapter;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        mBackBtn = (ImageView) findViewById(R.id.img_search_back);
        mSearchText = (EditText) findViewById(R.id.et_search_text);
        llyt_history=(LinearLayout)findViewById(R.id.llyt_history);
        recycle_search=(RecyclerView)findViewById(R.id.recycle_search);

        llyt_history.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        //监听输入框
        mSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!mSearchText.getText().toString().equals(""))
                searchGoods(mSearchText.getText().toString());
                else {
                    houseInfos.clear();
                    setGoodsList();
                }
            }
        });

    }

    @Override
    protected void initListener() {
        mBackBtn.setOnClickListener(this);
        llyt_history.setOnClickListener(this);
    }


    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_search_back:
                finish();
                break;
            case R.id.llyt_history:
                break;

            default:
                break;
        }
    }
    //输入搜索条件
    private void searchGoods(String data){
        houseInfos=new ArrayList<>();
        OkHttpClientManager.postAsyn(Configs.SEARCH_HOUSE, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                Toast.makeText(getApplication(), Configs.URLERROR,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response) {
                Log.i("ming","SEARCH_HOUSE  response:  "+response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject;
                    HouseInfo houseInfo;
                    for (int i=0;i<jsonArray.length();i++){
                        jsonObject=jsonArray.getJSONObject(i);
                        houseInfo=new Gson().fromJson(jsonObject.toString(),HouseInfo.class);
                        houseInfos.add(houseInfo);
                    }
                    setGoodsList();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new OkHttpClientManager.Param("data",data));
    }
    //显示查询后的商品列表
    private void setGoodsList(){
        houseItemAdapter=new HouseItemAdapter(this,houseInfos);
        recycle_search.setLayoutManager(new LinearLayoutManager(this));
        recycle_search.setAdapter(houseItemAdapter);
        houseItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getApplicationContext(), HouseDesActivity.class);
                intent.putExtra("house_info",houseInfos.get(position));
                startActivity(intent);
            }
        });
    }

}
