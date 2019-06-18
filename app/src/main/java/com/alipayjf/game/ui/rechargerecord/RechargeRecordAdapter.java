package com.alipayjf.game.ui.rechargerecord;

import android.widget.TextView;

import com.alipayjf.game.R;
import com.alipayjf.game.entity.RechargeRecordBean;
import com.alipayjf.game.util.CalculationUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class RechargeRecordAdapter extends BaseQuickAdapter<RechargeRecordBean.ResultBean.ListBean, BaseViewHolder> {
    public RechargeRecordAdapter() {
        super(R.layout.item_recharge_record);
    }


    @Override
    protected void convert(BaseViewHolder helper, RechargeRecordBean.ResultBean.ListBean item) {
        try {
            helper.setText(R.id.orderNum,"订单号："+item.getId())
                    .setText(R.id.orderTime,item.getCreatedTime())
                    .setText(R.id.orderPrice, CalculationUtil.divide(item.getChargeFee()+"","100",2)+"元")
                    .setText(R.id.orderStatus,getStatus(item.getStatus()));

            TextView tv = helper.getView(R.id.orderStatus);
            if(item.getStatus() == 1){
                tv.setTextColor(0xff13B6A5);
            }else{
                tv.setTextColor(0xff000000);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String getStatus(int status){
        if(status == 0)return "未完成";
        if(status == 1)return "已完成";
        return "未知状态";
    }
}
