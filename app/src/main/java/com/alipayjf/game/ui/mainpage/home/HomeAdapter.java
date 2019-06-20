package com.alipayjf.game.ui.mainpage.home;

import android.view.View;
import android.widget.TextView;

import com.alipayjf.game.R;
import com.alipayjf.game.entity.HomeBean;
import com.alipayjf.game.util.CalculationUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class HomeAdapter extends BaseQuickAdapter<HomeBean.ResultBean.ListBean,BaseViewHolder> {

    public HomeAdapter(){
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.ResultBean.ListBean item) {
        try {
            helper.setText(R.id.payMethod,getPayMethod(item.getPayType()))
                    .setText(R.id.payPrice, CalculationUtil.getPrice(item.getTotalFee()))
                    .setText(R.id.payDate,item.getCreatedTime())
                    .setText(R.id.payStatic,getStatus(item.getStatus()));

            TextView payStatusView = helper.getView(R.id.payStatic);
            TextView submitPrice = helper.getView(R.id.submitPrice);
            if(item.getStatus() == 1){
                payStatusView.setTextColor(0xff13B6A5);
                submitPrice.setVisibility(View.GONE);
                payStatusView.setVisibility(View.VISIBLE);
            }else if(item.getStatus() == 0){
                payStatusView.setVisibility(View.GONE);
                submitPrice.setVisibility(View.VISIBLE);
            }else{
                payStatusView.setTextColor(0xffffb400);
                submitPrice.setVisibility(View.GONE);
                payStatusView.setVisibility(View.VISIBLE);
            }
            helper.addOnClickListener(R.id.submitPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //支付方式
    private String getPayMethod(String payCode){
        if("wxpay".equals(payCode))return "微信";
        if("alipay".equals(payCode))return "支付宝";
        return "其他";
    }

    //状态
    private String getStatus(int status){
        if(status == 1)return "已收款";
        if(status == 2)return "已取消";
        return "未知状态";
    }
}
