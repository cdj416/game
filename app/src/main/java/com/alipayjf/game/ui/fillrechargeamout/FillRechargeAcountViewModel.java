package com.alipayjf.game.ui.fillrechargeamout;

import android.os.Bundle;

import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityFillRechargeAmountBinding;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.FillrechargeAcountBean;
import com.alipayjf.game.ui.recharge.RechargeActivity;
import com.alipayjf.game.ui.rechargerecord.RechargeRecordActivity;

import net.lemonsoft.lemonbubble.LemonBubble;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class FillRechargeAcountViewModel extends CustomViewModel {
    private ActivityFillRechargeAmountBinding binding;

    public FillRechargeAcountViewModel(CustomActivity mActivity, ActivityFillRechargeAmountBinding binding) {
        super(mActivity);
        this.binding = binding;
    }

    //登录点击事件
    public BindingCommand goNext = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if(isValue(binding.price.getText().toString())){
                savePrice();
            }else{
                LemonBubble.showError(mActivity,"请填写金额！",2000);
            }
        }
    });

    //保存充值金额
    private void savePrice(){
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        setJsonParams("userId",userSession.getUserId())
                .setJsonParams("chargeFee",binding.price.getText().toString());
        Controller.myRequest(Constants.SAVEPRICE,getJsonParams().toString(),getHeadParams(), FillrechargeAcountBean.class,this);
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof FillrechargeAcountBean){
            FillrechargeAcountBean bean = (FillrechargeAcountBean)data;
            if(bean.getCode() == 200){
                Bundle bundle = new Bundle();
                bundle.putInt("price", bean.getResult().getChargeFee());
                bundle.putInt("orderId", bean.getResult().getId());
                startActivity(RechargeActivity.class,bundle);
                mActivity.finish();
            }else{
                LemonBubble.showError(mActivity,bean.getMessage(),2000);
            }
        }
    }
}
