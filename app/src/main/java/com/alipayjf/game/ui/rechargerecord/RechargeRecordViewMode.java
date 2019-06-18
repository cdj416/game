package com.alipayjf.game.ui.rechargerecord;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityRechargeRecordBinding;
import com.alipayjf.game.entity.RechargeRecordBean;
import com.luck.picture.lib.decoration.RecycleViewDivider;

import net.lemonsoft.lemonbubble.LemonBubble;

public class RechargeRecordViewMode extends CustomViewModel {
    private RechargeRecordAdapter adapter;
    private ActivityRechargeRecordBinding binding;

    public RechargeRecordViewMode(CustomActivity mActivity, ActivityRechargeRecordBinding binding) {
        super(mActivity);
        this.binding = binding;
        setView();
        getData();
    }

    /*
    * 初始化控件
    * */
    @SuppressLint("NewApi")
    private void setView(){
        binding.mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        binding.mRecyclerView.addItemDecoration(new RecycleViewDivider(
                mActivity, LinearLayoutManager.VERTICAL, 1, mActivity.getColor(R.color.color_F1F1F1)));
        adapter = new RechargeRecordAdapter();
        binding.mRecyclerView.setAdapter(adapter);
    }

    /*
    * 获取数据
    * */
    private void getData(){
        clearParams().setParams("userId",userSession.getUserId()+"");
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        Controller.postJsonData(Constants.PERSONSELECTPAGE,getParams(),getHeadParams(), RechargeRecordBean.class,this);
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof RechargeRecordBean){
            RechargeRecordBean bean = (RechargeRecordBean)data;
            if(bean.getCode() == 200){
                adapter.setNewData(bean.getResult().getList());
            }else{
                LemonBubble.showRight(mActivity,bean.getMessage(),2000);
            }
        }
    }
}
