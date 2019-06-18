package com.alipayjf.game.ui.reflectiverecord.reflectivercord_detail;

import android.os.Bundle;
import android.view.View;

import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityReflectiveDetailBinding;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.ReflectiverCordDectilBean;
import com.alipayjf.game.ui.mainpage.MainActivity;
import com.alipayjf.game.util.CalculationUtil;

import net.lemonsoft.lemonbubble.LemonBubble;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class ReflectiverCordDectailViewModel extends CustomViewModel {

    private ActivityReflectiveDetailBinding binding;
    private ReflectiverCordDectilBean bean;
    private Bundle bundle;

    public ReflectiverCordDectailViewModel(CustomActivity mActivity, ActivityReflectiveDetailBinding binding) {
        super(mActivity);
        this.binding = binding;
        initView();
        lazyLoad();
    }

    @Override
    protected void initView() {
        bundle = mActivity.getIntent().getBundleExtra("bundle");
    }

    @Override
    protected void lazyLoad() {
        clearParams().setParams("id",bundle.getInt("orderId")+"");
        clearHeadParams().setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.SELECTONE,getParams(),getHeadParams(), ReflectiverCordDectilBean.class,this);
    }


    //提现按钮的回调
    public BindingCommand onceSumbit = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            onceLoad();
        }
    });

    //提现按钮的回调
    public BindingCommand goHome = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(MainActivity.class,null);
        }
    });

    //重新提现
    private void onceLoad(){
        setJsonParams("id",bundle.getInt("orderId")+"")
        .setJsonParams("status","2");
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        Controller.myRequest(Constants.LISTCASHOUT,getJsonParams().toString(),getHeadParams(), BaseBean.class,this);

    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof ReflectiverCordDectilBean){
            bean = (ReflectiverCordDectilBean)data;
            if(bean.getCode() == 200){
                binding.orderId.setText(bean.getResult().getId()+"");
                binding.orderPrice.setText(CalculationUtil.getPrice(bean.getResult().getTotalFee()));
                binding.orderTime.setText(bean.getResult().getCreatedTime());
                binding.orderStatus.setText(getStatus(bean.getResult().getStatus()));

                if (bean.getResult().getStatus() == 1 || bean.getResult().getStatus() == 2) {
                    binding.orderStatus.setTextColor(0xff13B6A5);
                } else {
                    binding.orderStatus.setTextColor(0xff000000);
                }
                if(bean.getResult().getStatus() != 1){
                    binding.onceSubmit.setVisibility(View.VISIBLE);
                }else{
                    binding.onceSubmit.setVisibility(View.GONE);
                }
            }
        }
        if(data instanceof BaseBean){
            BaseBean bean = (BaseBean)data;
            if(bean.getCode() == 200){
                mActivity.finish();
            }else{
                LemonBubble.showRight(mActivity,bean.getMessage(),2000);
            }
        }
    }

    private String getStatus(int status){
        if(status == 0)return "未完成";
        if(status == 1)return "已完成";
        if(status == 2)return "提现中";
        return "未知状态";
    }
}
