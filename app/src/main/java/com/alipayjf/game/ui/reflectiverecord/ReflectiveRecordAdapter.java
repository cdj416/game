package com.alipayjf.game.ui.reflectiverecord;

import android.widget.TextView;

import com.alipayjf.game.R;
import com.alipayjf.game.entity.RechargeRecordBean;
import com.alipayjf.game.entity.ReflectiveRecordBean;
import com.alipayjf.game.util.CalculationUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class ReflectiveRecordAdapter extends BaseQuickAdapter<ReflectiveRecordBean.ResultBean.ListBean, BaseViewHolder> {
    public ReflectiveRecordAdapter() {
        super(R.layout.item_reflective_record);
    }


    @Override
    protected void convert(BaseViewHolder helper, ReflectiveRecordBean.ResultBean.ListBean item) {

            helper.setText(R.id.orderId, "" + item.getId())
                    .setText(R.id.orderTime, item.getCreatedTime())
                    .setText(R.id.orderPrice, CalculationUtil.getPrice(item.getTotalFee()) + "元")
                    .setText(R.id.orderStatus, getStatus(item.getStatus()));

            TextView tv = helper.getView(R.id.orderStatus);
            if (item.getStatus() == 1 || item.getStatus() == 2) {
                tv.setTextColor(0xff13B6A5);
            } else {
                tv.setTextColor(0xff000000);
            }
            helper.addOnClickListener(R.id.detail);
    }

    private String getStatus(int status){
        if(status == 0)return "审核中";
        if(status == 1)return "已完成";
        if(status == 2)return "提现中";
        return "未知状态";
    }
}
