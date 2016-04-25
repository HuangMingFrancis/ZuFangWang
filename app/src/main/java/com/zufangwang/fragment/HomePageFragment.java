package com.zufangwang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zufangwang.activity.HouseDesActivity;
import com.zufangwang.activity.HouseListActivity;
import com.zufangwang.adapter.HouseItemAdapter;
import com.zufangwang.base.BaseFragment;
import com.zufangwang.francis.zufangwang.R;
import com.zufangwang.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 首页fragment
 * Created by Francis on 2016/4/22.
 */
public class HomePageFragment extends BaseFragment {
    @InjectView(R.id.recycle_house)
    RecyclerView recycleHouse;
    @InjectView(R.id.tv_more_house)
    TextView tvMoreHouse;
    @InjectView(R.id.tv_rental)
    TextView tvRental;
    @InjectView(R.id.tv_individual_housing)
    TextView tvIndividualHousing;
    @InjectView(R.id.tv_spacious_master_bedroom)
    TextView tvSpaciousMasterBedroom;
    @InjectView(R.id.tv_charge_one_to_pay)
    TextView tvChargeOneToPay;
    @InjectView(R.id.tv_easy_communication)
    TextView tvEasyCommunication;
    @InjectView(R.id.tv_quality_short_rent)
    TextView tvQualityShortRent;
    @InjectView(R.id.tv_single_apartment)
    TextView tvSingleApartment;
    @InjectView(R.id.tv_second_hand_housing)
    TextView tvSecondHandHousing;
    @InjectView(R.id.tv_price_listings)
    TextView tvPriceListings;
    @InjectView(R.id.tv_just_need_to_home)
    TextView tvJustNeedToHome;
    @InjectView(R.id.tv_school_district_housing)
    TextView tvSchoolDistrictHousing;
    @InjectView(R.id.tv_tax_exempt_listings)
    TextView tvTaxExemptListings;
    @InjectView(R.id.tv_improve_sanju)
    TextView tvImproveSanju;
    @InjectView(R.id.tv_improvement_room)
    TextView tvImprovementRoom;
    @InjectView(R.id.tv_new_house)
    TextView tvNewHouse;
    @InjectView(R.id.tv_quality_new_plate)
    TextView tvQualityNewPlate;
    @InjectView(R.id.tv_two_bedroom_houses)
    TextView tvTwoBedroomHouses;
    @InjectView(R.id.tv_three_bedroom_houses)
    TextView tvThreeBedroomHouses;
    @InjectView(R.id.tv_shops)
    TextView tvShops;
    @InjectView(R.id.tv_rental_shops)
    TextView tvRentalShops;
    @InjectView(R.id.tv_shop_for_sale)
    TextView tvShopForSale;
    @InjectView(R.id.tv_business_transfer)
    TextView tvBusinessTransfer;

    private HouseItemAdapter houseItemAdapter;
    private Intent intent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView() {
        Log.i("ming","initView");
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        Log.i("ming","onCreateView");
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleHouse.setLayoutManager(layoutManager);
        ArrayList<String> data=new ArrayList<>();
        data.add("今天天气很好");
        data.add("是假的");
        houseItemAdapter=new HouseItemAdapter(getActivity(),data);
        recycleHouse.setAdapter(houseItemAdapter);
        clickItem();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_more_house, R.id.tv_rental, R.id.tv_individual_housing, R.id.tv_spacious_master_bedroom, R.id.tv_charge_one_to_pay, R.id.tv_easy_communication, R.id.tv_quality_short_rent, R.id.tv_single_apartment, R.id.tv_second_hand_housing, R.id.tv_price_listings, R.id.tv_just_need_to_home, R.id.tv_school_district_housing, R.id.tv_tax_exempt_listings, R.id.tv_improve_sanju, R.id.tv_improvement_room, R.id.tv_new_house, R.id.tv_quality_new_plate, R.id.tv_two_bedroom_houses, R.id.tv_three_bedroom_houses, R.id.tv_shops, R.id.tv_rental_shops, R.id.tv_shop_for_sale, R.id.tv_business_transfer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_more_house:
                intent=new Intent(getActivity(), HouseListActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_rental:
                intent=new Intent(getActivity(), HouseListActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_individual_housing:
                break;
            case R.id.tv_spacious_master_bedroom:
                break;
            case R.id.tv_charge_one_to_pay:
                break;
            case R.id.tv_easy_communication:
                break;
            case R.id.tv_quality_short_rent:
                break;
            case R.id.tv_single_apartment:
                break;
            case R.id.tv_second_hand_housing:
                break;
            case R.id.tv_price_listings:
                break;
            case R.id.tv_just_need_to_home:
                break;
            case R.id.tv_school_district_housing:
                break;
            case R.id.tv_tax_exempt_listings:
                break;
            case R.id.tv_improve_sanju:
                break;
            case R.id.tv_improvement_room:
                break;
            case R.id.tv_new_house:
                break;
            case R.id.tv_quality_new_plate:
                break;
            case R.id.tv_two_bedroom_houses:
                break;
            case R.id.tv_three_bedroom_houses:
                break;
            case R.id.tv_shops:
                break;
            case R.id.tv_rental_shops:
                break;
            case R.id.tv_shop_for_sale:
                break;
            case R.id.tv_business_transfer:
                break;
        }
    }
    //点击房源item
    private void clickItem(){
        houseItemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(), HouseDesActivity.class);
                startActivity(intent);
            }
        });
    }
}
