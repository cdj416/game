package com.alipayjf.game.ui.reflectiverecord;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityReflectiveRecordBinding;
import com.alipayjf.game.entity.ReflectiveRecordBean;
import com.alipayjf.game.ui.reflectiverecord.reflectivercord_detail.ActivityRefectiverCordDetail;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luck.picture.lib.decoration.RecycleViewDivider;

import net.lemonsoft.lemonbubble.LemonBubble;

public class ReflectiveRecordViewModel extends CustomViewModel {
    private ActivityReflectiveRecordBinding binding;
    private ReflectiveRecordAdapter adapter;
    private ReflectiveRecordBean bean;
    public ReflectiveRecordViewModel(CustomActivity mActivity, ActivityReflectiveRecordBinding binding) {
        super(mActivity);
        this.binding = binding;
        initView();
        lazyLoad();
    }

    @SuppressLint("NewApi")
    @Override
    protected void initView() {
        binding.mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        binding.mRecyclerView.addItemDecoration(new RecycleViewDivider(
                mActivity, LinearLayoutManager.VERTICAL, 2, mActivity.getColor(R.color.color_FFD1D1D1)));
        adapter = new ReflectiveRecordAdapter();
        binding.mRecyclerView.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("orderId", bean.getResult().getList().get(position).getId());
                startActivity(ActivityRefectiverCordDetail.class,bundle);
            }
        });
    }

    @Override
    protected void onResume(){
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        setJsonParams("userId",userSession.getUserId()+"");
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        Controller.myRequest(Constants.PERSONREFLECTIVIE,getJsonParams().toString(),getHeadParams(), ReflectiveRecordBean.class,this);
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof ReflectiveRecordBean){
            bean = (ReflectiveRecordBean)data;
            if(bean.getCode() == 200){
                if(bean.getResult().getList() != null && bean.getResult().getList().size() > 0){
                    adapter.setNewData(bean.getResult().getList());
                    mActivity.setPromtView(CustomActivity.SHOW_DATA);
                }
                if(bean.getResult() == null || bean.getResult().getList() == null || bean.getResult().getList().size() <= 0){
                    mActivity.setPromtView(CustomActivity.SHOW_EMPTY);
                }
            }else{
                LemonBubble.showRight(mActivity,bean.getMessage(),2000);
                mActivity.setPromtView(CustomActivity.SHOW_ERR);
            }
        }
    }
}
