package com.zufangwang.fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zufangwang.base.Configs;
import com.zufangwang.francis.zufangwang.R;
import com.zufangwang.listener.OnItemClickListener;
import com.zufangwang.utils.FileTools;
import com.zufangwang.utils.SelectHeadTools;
import com.zufangwang.view.GridViewForScrollView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Francis on 2016/4/25.
 */
public class HouseReleaseFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    @InjectView(R.id.house_address)
    Spinner houseAddress;
    @InjectView(R.id.house_address_detail)
    Spinner houseAddressDetail;
    @InjectView(R.id.et_house_address_detail)
    EditText etHouseAddressDetail;
    @InjectView(R.id.et_house_apartment_room)
    EditText etHouseApartmentRoom;
    @InjectView(R.id.et_house_apartment_office)
    EditText etHouseApartmentOffice;
    @InjectView(R.id.et_house_apartment_wei)
    EditText etHouseApartmentWei;
    @InjectView(R.id.et_house_floor)
    EditText etHouseFloor;
    @InjectView(R.id.et_house_all_floor)
    EditText etHouseAllFloor;
    @InjectView(R.id.et_house_are)
    EditText etHouseAre;
    @InjectView(R.id.et_house_price)
    EditText etHousePrice;
    @InjectView(R.id.et_house_title)
    EditText etHouseTitle;
    @InjectView(R.id.et_house_des)
    EditText etHouseDes;
    @InjectView(R.id.et_house_contacts)
    EditText etHouseContacts;
    @InjectView(R.id.et_house_contacts_tel)
    EditText etHouseContactsTel;
    @InjectView(R.id.tv_add_image)
    TextView tvAddImage;
    @InjectView(R.id.gv_img)
    GridViewForScrollView gvImg;
    @InjectView(R.id.btn_release)
    Button btnRelease;

    private String[] location_first,location_second;
    private Map<String,String[]> locationMap;
    private String address1,address2;
    private Uri photoUri = null;
    private BaseAdapter imgAdapter;
    private ArrayList<Bitmap> bitmapArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_house_release, null);
        ButterKnife.inject(this, view);
        initData();
        initListener();
        return view;
    }

    private void initData() {
        locationMap=new HashMap<>();
        location_first=getActivity().getResources().getStringArray(R.array.address_first);
        location_second=getActivity().getResources().getStringArray(R.array.location_siming);
        locationMap.put(location_first[0],getActivity().getResources().getStringArray(R.array.location_siming));
        locationMap.put(location_first[1],getActivity().getResources().getStringArray(R.array.location_huli));

        bitmapArrayList=new ArrayList<>();
        initImgAdapter();
        gvImg.setAdapter(imgAdapter);
    }
    //初始化照片adapter
    private void initImgAdapter() {
        imgAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return bitmapArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return bitmapArrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView==null){
                    convertView=new ImageView(getActivity());
                }
                ((ImageView)convertView).setImageBitmap(bitmapArrayList.get(position));
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(300,300));
                convertView.setLayoutParams(params);
                return convertView;
            }
        };
    }
    //在Activity中返回照片时调用
    public void setImageView(Bitmap bitmap){
        bitmapArrayList.add(bitmap);
        imgAdapter.notifyDataSetChanged();
    }
    private void initListener() {
        houseAddress.setOnItemSelectedListener(this);
        houseAddressDetail.setOnItemSelectedListener(this);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_add_image, R.id.btn_release})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add_image:
                showCamear();
                break;
            case R.id.btn_release:
                break;
        }
    }
    //获取图片
    private void showCamear() {
        if(!FileTools.hasSdcard()){
            Toast.makeText(getActivity(),"没有找到SD卡，请检查SD卡是否存在",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            photoUri = FileTools.getUriByFileDirAndFileName(Configs.SystemPicture.SAVE_DIRECTORY, Configs.SystemPicture.SAVE_PIC_NAME);
        } catch (IOException e) {
            Toast.makeText(getActivity(), "创建文件失败。", Toast.LENGTH_SHORT).show();
            return;
        }
        SelectHeadTools.openDialog(getActivity(),photoUri);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.house_address:
                address1=location_first[position];
                for (Map.Entry<String, String[]> entry : locationMap.entrySet()) {
                    if (entry.getKey().equals(location_first[position]))
                        location_second=entry.getValue();
                }
                setSecondSpin();
                break;
            case R.id.house_address_detail:
                address2=location_second[position];
                Log.i("ming","address:  "+address1+address2);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //设置第二个地址
    private void setSecondSpin() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, location_second);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        houseAddressDetail.setAdapter(adapter);
    }
}
